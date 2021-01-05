package com.jk.dao;

import com.jk.pojo.StuBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsDao extends ElasticsearchRepository<StuBean,Integer> {
}
