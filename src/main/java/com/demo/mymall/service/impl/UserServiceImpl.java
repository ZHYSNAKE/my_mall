package com.demo.mymall.service.impl;


import com.demo.mymall.entity.User;
import com.demo.mymall.mapper.UserMapper;
import com.demo.mymall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password){
        User user = userMapper.findByUsername(username);

        if(user != null) {
            if(user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    };//登入

    @Override
    public boolean register(User user) {
        User existingUser = userMapper.findByUsername(user.getUsername());
        if (existingUser != null) {
            return false; // 用户名已存在，注册失败
        }

        // 执行插入，返回受影响的行数
        int rows = userMapper.insertUser(user);

        // 如果影响行数大于0，说明插入成功
        return rows > 0;
    }
}
