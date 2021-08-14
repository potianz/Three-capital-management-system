package com.sxlg.controller;

import com.sxlg.bean.User;
import com.sxlg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/countryside")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")

    public String login(String name, String password, HttpServletResponse response){
        if(userService.login(name,password)!=null){
            Cookie cookie = new Cookie("isLogin","yes");
            cookie.setMaxAge(60*5);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "administration";
        }
        return "index";
    }
    @GetMapping
    public String toLogin(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("isLogin")){
                    return "administration";
                }
            }
        }
        return "index";
    }
    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @PostMapping("/register")
    public String register(String name,String password1,String password2){
        User user = new User();
        int i =  0 ;
        if(password1.equals(password2) && name!=null&&password1!=null){
            user.setName(name);
            user.setPassword(password1);
            System.out.println(user);
            i = userService.register(user);
        }
        if(i==1){
            return "administration";
        }
        return  "register";
    }

    @PostMapping("/exit")
    public String exit(HttpServletRequest request, HttpServletResponse response, HttpSession session){
       Cookie[] cookies = request.getCookies();
       if(cookies!=null)
       {
          for(Cookie cookie: cookies){
              //将cookie.setMaxAge(0)表示删除cookie.
              cookie.setMaxAge(0);
              cookie.setPath("/");
              response.addCookie(cookie);
          }
       }
       session.invalidate();
        return "index";
    }
}
