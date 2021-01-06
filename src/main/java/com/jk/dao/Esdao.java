package com.jk.dao;

import com.jk.pojo.GameBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface Esdao extends ElasticsearchRepository<GameBean,Integer> {
}
