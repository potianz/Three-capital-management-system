package com.sxlg.service;

import com.sxlg.bean.User;

public interface UserService {
    User login(String name,String password);
    int register(User user);
}
