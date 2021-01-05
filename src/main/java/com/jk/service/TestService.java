package com.jk.service;


import com.jk.pojo.StuBean;

import java.util.HashMap;

public interface TestService {

    HashMap<String, Object> select(Integer page, Integer rows);

    void StuDel(Integer id);

    StuBean findStuById(Integer id);

    void StuSave(StuBean stu);
}
