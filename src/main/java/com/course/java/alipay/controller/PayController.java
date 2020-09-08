package com.course.java.alipay.controller;

import com.course.java.alipay.bo.PaymentBO;
import com.course.java.alipay.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *  支付宝支付，控制器
 *
 * @author wangziyang
 * */
@RestController
@RequestMapping(value = "/pay")
@AllArgsConstructor
public class PayController {

    private PayService payService;

    /**
     *  下单支付
     * */
    @GetMapping(value = "/confirm" , produces = {"text/html;charset=UTF-8"})
    public Object pay (@RequestParam(required = false) PaymentBO bo) throws Exception {
        bo = new PaymentBO();
        return payService.pay(bo);
    }

    /**
     *  支付成功的回调
     * */
    @PostMapping(value = "/fallback")
    public Object fallback (HttpServletRequest request) {
        Map map = request.getParameterMap();
        System.out.println("进入了回调");
        return null;
    }
}
