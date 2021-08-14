package com.sxlg.service.Impl;

import com.sxlg.bean.User;
import com.sxlg.mapper.UserMapper;
import com.sxlg.service.UserService;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BasicTextEncryptor basicTextEncryptor;
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String name,String password) {
        User user = userMapper.selectUser(name);
        if(user!=null&&password!=null){
            System.out.println(user);
            user.setPassword(basicTextEncryptor.decrypt(user.getPassword()));
            if(user.getPassword().equals(password)){
                //说明登录成功
                return user;
            }
        }
        return user;
    }

    public int register(User user){
        //对密码进行加密
//        user.setName(basicTextEncryptor.encrypt(user.getName()));
        user.setPassword(basicTextEncryptor.encrypt(user.getPassword()));
       return userMapper.insert(user);
    }

}
