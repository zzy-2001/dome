package com.jk.service;


import com.jk.pojo.GameBean;

import java.util.HashMap;

public interface TestService {

    HashMap<String, Object> selectPage(GameBean bean, Integer page, Integer rows);

    void addGame(GameBean bean);

    void delete1(Integer integer);

    GameBean findById(Integer id);
}
