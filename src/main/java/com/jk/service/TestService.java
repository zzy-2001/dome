package com.jk.service;


import com.jk.pojo.StuBean;
import com.jk.pojo.Users;

import java.util.HashMap;
import java.util.List;

public interface TestService {

    HashMap<String, Object> select(Integer page, Integer rows);

    void StuDel(Integer id);

    StuBean findStuById(Integer id);

    void StuSave(StuBean stu);

    //用户查询
    List<Users> findUser();
    //用户新增
    void addUser(Users users);
    //用户删除
    void delUser(Integer id);
    //用户回显
    Users updateUserById(Integer id);
}
