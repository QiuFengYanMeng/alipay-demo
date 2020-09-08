package com.course.java.alipay.service;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePayResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.course.java.alipay.bo.PaymentBO;
import com.course.java.alipay.util.OrderUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 *  支付宝支付，业务实现
 *
 * @author wangziyang
 * @date 2020-09-08
 * */
@Service
public class PayService {

    //支付成功后要跳转的页面
    @Value("${alipay.returnUrl}")
    private String returnUrl;

    /**
     *  下单支付
     * */
    public Object pay (PaymentBO bo) throws Exception {

        //从存储介质(如MySQL、Redis)查询商品信息、总金额等敏感信息

        //…………省略相关代码，这里直接赋值…………

        bo.setSubject("测试商品");
        bo.setTotal(new BigDecimal(10.00));

        //调用sdk，发起支付
        AlipayTradePagePayResponse response = Factory.Payment
                //选择网页支付平台
                .Page()
                //调用支付方法，设置订单名称、我们自己系统中的订单号、金额、回调页面
                .pay(bo.getSubject() , OrderUtil.getOrderNo(), bo.getTotal().toString() , returnUrl);

        //这里的response.body，就是一个可以直接加载的html片段，
        // 这里为了简单我直接返回这个片段，前端直接
        return response.body;
    }
}
