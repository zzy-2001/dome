package com.jk.dao;

import com.jk.pojo.GameBean;
import jdk.nashorn.internal.ir.annotations.Reference;
import com.jk.pojo.StuBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@Reference
public interface TestDao {
    void StuDel(Integer id);

    void StuSave(StuBean stu);

    void StuUpdate(StuBean stu);
    void addGame(GameBean bean);

    void delete1(Integer id);

    GameBean findById(Integer id);
}
