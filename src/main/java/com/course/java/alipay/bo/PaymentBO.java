package com.course.java.alipay.bo;

import lombok.Data;

import java.math.BigDecimal;

/**
 *  发起支付时的参数
 * */
@Data
public class PaymentBO {
    //省略其他的业务参数，如商品id、购买数量等

    //商品名称
    private String subject;

    //总金额
    private BigDecimal total = BigDecimal.ZERO;
}
