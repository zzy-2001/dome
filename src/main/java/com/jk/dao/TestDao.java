package com.jk.dao;

import com.jk.pojo.OrderBean;
import com.jk.pojo.GameBean;
import com.jk.pojo.TeaBean;
import jdk.nashorn.internal.ir.annotations.Reference;
import com.jk.pojo.StuBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestDao {

    void StuDel(Integer id);

    void StuSave(StuBean stu);

    void StuUpdate(StuBean stu);

    void orderdel(Integer id);

    void orderadd(OrderBean orderBean);

    OrderBean findorderByid(Integer id);

    void uporder(Integer id);


    void addGame(GameBean bean);

    void delete1(Integer id);

    GameBean findById(Integer id);

    void teaadd(TeaBean tea);

    void teaupdate(TeaBean tea);

    void teadel(Integer id);
}
