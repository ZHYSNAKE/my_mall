package com.demo.mymall.mapper;


import org.apache.ibatis.annotations.Mapper;
import com.demo.mymall.entity.User;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    //@Param把方法参数的名字告诉MyBatis，让它在SQL里能找到这个参数
    User findByUsername(@Param("username") String username);//查找用户

    int insertUser(User user);//注册
    //int 告诉影响了数据库多少行
}
