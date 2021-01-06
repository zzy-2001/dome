package com.jk.dao;

import com.jk.pojo.TeaBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface teadao extends ElasticsearchRepository<TeaBean,Integer> {
}
