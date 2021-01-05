package com.jk.dao;

import com.jk.pojo.StuBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestDao {
    void StuDel(Integer id);

    void StuSave(StuBean stu);

    void StuUpdate(StuBean stu);
}
