package com.jk.dao;

import com.jk.pojo.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BfhDaoEs extends ElasticsearchRepository <Users,Integer>{
}
