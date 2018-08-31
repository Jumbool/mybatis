package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address")
    })
    List<User> findAll();

    @Select("select count(*) from user")
    int findTotal();

    /**
     *查询一个byId
     */
    @Select("select * from user where id=#{uid}")
    @ResultMap("userMap")
    User findById(@Param(value = "uid") Integer uid);
}
