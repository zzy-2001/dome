package com.jk.dao;

import com.jk.pojo.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BfhDao {

    @Select("select * from t_users ")
    List<Users> findUser();

   // @Insert("insert into t_users (username,money) values (#{username},#{money}) ")
    void addUser(Users users);

    @Delete("delete from t_users where id = #{id} ")
    void delUser(Integer id);

    @Select("select * from  t_users where id = #{id}")
    Users updateUserById(Integer id);

    @Update("update t_users set username=#{username},money=#{money}  where id = #{id} ")
    void updateUser(Users users);
}
