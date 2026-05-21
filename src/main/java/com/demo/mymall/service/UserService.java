package com.demo.mymall.service;


import com.demo.mymall.entity.User;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    //@Param把方法参数的名字告诉MyBatis，让它在SQL里能找到这个参数
    User login(@Param("username") String username, @Param("password") String password , HttpSession session);//登入

    boolean register(User user);//注册
    //boolean 来告诉前端是否注册成功

}
