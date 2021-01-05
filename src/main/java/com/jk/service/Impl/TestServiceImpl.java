package com.jk.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.EsDao;
import com.jk.dao.TestDao;
import com.jk.pojo.StuBean;
import com.jk.service.TestService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao dao;
    @Autowired
    private EsDao esDao;
    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public HashMap<String, Object> select(Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<StuBean> list = new ArrayList<>();
        Client client = template.getClient();
        SearchRequestBuilder search  = client.prepareSearch("stu").setTypes("20065");
        //分页
        search.setFrom((page-1)*rows);//开始位置
        search.setSize(rows);//没有条数
        SearchResponse searchResponse = search.get();
        SearchHits hits = searchResponse.getHits();
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            String str = next.getSourceAsString();
            //把字符串转换成javabean对象
            StuBean stuBean = JSONObject.parseObject(str, StuBean.class);
            list.add(stuBean);
        }
        //获取总条数：
        long total = hits.getTotalHits();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

    @Override
    public void StuDel(Integer id) {
        dao.StuDel(id);
        esDao.deleteById(id);
    }

    @Override
    public StuBean findStuById(Integer id) {
        Optional<StuBean> byId = esDao.findById(id);
        return byId.get();
    }

    @Override
    public void StuSave(StuBean stu) {
        if(stu.getId()==null){
            dao.StuSave(stu);
        }else{
            dao.StuUpdate(stu);
        }
        esDao.save(stu);
    }
}
