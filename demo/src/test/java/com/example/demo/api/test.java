package com.example.demo.api;

import java.text.MessageFormat;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/30 9:34
 */
public class test {

    public static void main(String[] args) {
        System.out.println(formatMessage("122", new String[]{"aaa", "bbb"}));
    }

    public static String formatMessage(String code,String... args){
        String str = "您的订单{0}已支付成功，我们将会尽快为您处理，如有需要请到我的订单查看相关详情。{1}" ;
        return  MessageFormat.format(str,args);
    }
}
