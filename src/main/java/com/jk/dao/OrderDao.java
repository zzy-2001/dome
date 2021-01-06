package com.jk.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.jk.pojo.OrderBean;

public interface OrderDao extends ElasticsearchRepository<OrderBean,Integer> {
}
