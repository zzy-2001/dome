package com.jk.service;


import com.jk.pojo.GameBean;

import java.util.HashMap;

import com.jk.pojo.StuBean;
import com.jk.pojo.OrderBean;

import java.util.HashMap;

public interface TestService {

    HashMap<String, Object> selectPage(GameBean bean, Integer page, Integer rows);

    void addGame(GameBean bean);

    void delete1(Integer integer);

    GameBean findById(Integer id);
    HashMap<String, Object> select(Integer page, Integer rows);

    void StuDel(Integer id);

    StuBean findStuById(Integer id);

    void StuSave(StuBean stu);

    HashMap<String, Object> findorder(Integer page, Integer rows, OrderBean orderBean);

    void orderdel(Integer id);

    void savesorder(OrderBean orderBean);

    OrderBean findorderByid(Integer id);
}
