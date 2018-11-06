package com.example.demo.api;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

/**
 * @author zhuenbang
 * @description 微信网页授权
 * @date 2018/8/11 14:07
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {
    private Logger logger = Logger.getLogger(getClass());
    @Autowired
    private WxMpService wxMpService;

    /**
     * @Description: 微信授权
     * @Param: [returnUrl]
     * @returns: java.lang.String
     * @Author: zhuenbang
     * @Date: 2018/8/11 15:08
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        String url = "http://cc9ca84a.ngrok.io/api/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        logger.infov("【微信网页授权】获取code,redirectUrl={}", redirectUrl);
        return "redirect:" + redirectUrl;
    }

    /**
     * @Description: 微信授权回调用户信息
     * @Param: [code, returnUrl]
     * @returns: java.lang.String
     * @Author: zhuenbang
     * @Date: 2018/8/11 15:08
     */
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            logger.debugv("【微信网页授权获】获取用户信息：{}", wxMpUser);
        } catch (WxErrorException e) {
            e.printStackTrace();
            logger.errorv("【微信网页授权】{}", e);
        }
        return "redirect:" + returnUrl;
    }
}
