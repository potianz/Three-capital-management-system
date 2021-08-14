package com.sxlg.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginInterceptor implements HandlerInterceptor {
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if(request.getRequestURI().contains("/countryside/toLogin")||request.getRequestURI().contains("/countryside/login")||request.getRequestURI().contains("/countryside/register")||request.getRequestURI().contains("/countryside/toRegister")){
            return true;
        }
        if(cookies==null){
            System.out.println("用户未登录，第一次访问！");

        }else{
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("isLogin")){
//                    System.out.println("name--->"+cookie.getName()+"\tpassword----->"+cookie.getName());
//                    可以跳转到主页面，个性化设置。通过id查询
                    return true;
                }
            }
        }
        response.sendRedirect("/countryside");
        return false;
    }

    public  void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public  void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
