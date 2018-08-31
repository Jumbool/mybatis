package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
//持久层使用二级缓存
@CacheNamespace(blocking = true)
public interface IAccountDao {
    /**
     * 查询所有
     */
    @Select(value = "select * from account")
    @Results(id ="accountMap" ,
            value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money")
            } )
    List<Account> findAll();

//    ,
//    @Result(property = "user",column = "uid",one = @One(
//            select = "com.itheima.dao.IUserDao.findById",
//            fetchType = FetchType.LAZY))
}
