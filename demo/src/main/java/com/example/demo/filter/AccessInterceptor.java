package com.example.demo.filter;


import com.alibaba.fastjson.JSON;
import com.example.demo.constant.UserConstant;
import com.example.demo.result.CodeMsg;
import com.example.demo.result.Result;
import com.example.demo.service.AuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * Create by zhuenbang on 2018/12/3 11:08
 */
@Service
public class AccessInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    AuthTokenService authTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            Secured secured = hm.getMethodAnnotation(Secured.class);
            if (secured != null) {
                String authToken = request.getHeader(UserConstant.USER_TOKEN);
                if (StringUtils.isEmpty(authToken)) {
                    render(response, CodeMsg.REQUEST_ILLEGAL);
                    return false;
                }
                String userId = authTokenService.checkToken(authToken);
                if (StringUtils.isEmpty(userId)) {
                    render(response, CodeMsg.LOGIN_FAILURE);
                    return false;
                }
            }
            return true;
        }
        return true;
    }


    private void render(HttpServletResponse response, CodeMsg cm) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str = JSON.toJSONString(Result.error(cm));
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }
}
