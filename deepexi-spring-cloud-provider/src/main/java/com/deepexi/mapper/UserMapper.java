package com.deepexi.mapper;

import com.deepexi.domain.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getAllUser();//查所有
    @Select("select * from user where id = #{id}")
    User getById(Integer id);//查
    @Insert("insert into user(age,name,gmtCreate,gmtModified) values(#{age},#{name},#{gmtCreate},#{gmtModified})")
    int insert(User user);//增
    @Delete("delete from user where id = #{id}")
    int deleteById(Integer id);//删
    @Update("update user set age = #{age}, name = #{name}, gmtModified = #{gmtModified} where id = #{id}")
    int update(User user);//改
    @Select("select count(1) from user where id = #{id}")
    int countById(Integer id);
    @Select("select max(id) from user ")
    int getLastId();//用于用户刚创建时返回id
}
