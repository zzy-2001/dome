package com.jk.dao;

import com.jk.pojo.GameBean;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Reference
public interface TestDao {
    void addGame(GameBean bean);

    void delete1(Integer id);

    GameBean findById(Integer id);
}
