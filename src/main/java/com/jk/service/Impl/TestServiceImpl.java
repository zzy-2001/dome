package com.jk.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.OrderDao;
import com.jk.dao.Esdao;
import com.jk.dao.TestDao;
import com.jk.dao.zzq;
import com.jk.pojo.GameBean;
import com.jk.pojo.StuBean;
import com.jk.pojo.OrderBean;
import com.jk.service.TestService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;

import org.elasticsearch.index.query.QueryBuilders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao dao;

    @Autowired
    private Esdao es;

    @Autowired
    private ElasticsearchTemplate esTemlpate;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private zzq esDao;
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





    @Override
    public HashMap<String, Object> findorder(Integer page, Integer rows, OrderBean orderBean) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<OrderBean> list = new ArrayList<>();
        Client client = template.getClient();
        SearchRequestBuilder search = client.prepareSearch("order").setTypes("test");
        BoolQueryBuilder bool = new BoolQueryBuilder();
        if (!StringUtils.isEmpty(orderBean.getName())) {
            bool.should(QueryBuilders.matchQuery("name", orderBean.getName()));
        }
        search.setQuery(bool);
        search.setFrom((page - 1) * rows);//开始位置
        search.setSize(rows);//没有条数
        SearchResponse searchResponse = search.get();
        SearchHits hits = searchResponse.getHits();
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()) {
            SearchHit next = iterator.next();
            String order = next.getSourceAsString();
            //把字符串转换成javabean对象
            OrderBean stuBean = JSONObject.parseObject(order, OrderBean.class);
            list.add(stuBean);
        }
        //获取总条数：
        long total = hits.getTotalHits();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }


    @Override
    public HashMap<String, Object> selectPage(GameBean bean, Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        List<GameBean> list = new ArrayList<>();
        Client client = esTemlpate.getClient();
        SearchRequestBuilder search = client.prepareSearch("game").setTypes("15");
        BoolQueryBuilder bool = new BoolQueryBuilder();
        search.setQuery(bool);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color=\"red\">");//前缀
        highlightBuilder.postTags("</font>");//后缀
        search.highlighter(highlightBuilder);
        search.setFrom((page-1)*rows);//开始位置
        search.setSize(rows);//没有条数
        SearchResponse searchResponse = search.get();
        SearchHits hits = searchResponse.getHits();
        Iterator<SearchHit> iterator = hits.iterator();
        while(iterator.hasNext()){
            SearchHit next = iterator.next();
            String str = next.getSourceAsString();
            GameBean Ees = JSONObject.parseObject(str, GameBean.class);
            Map<String, HighlightField> highlightFields = next.getHighlightFields();
            list.add(Ees);
        }
        long total = hits.getTotalHits();

        map.put("total",total);
        map.put("rows",list);

        return map;
    }

    @Override
    public void addGame(GameBean bean) {
        if (bean.getGame_id()==null){
            dao.addGame(bean);
        }
        es.save(bean);
    }

    @Override
    public void delete1(Integer id) {
        dao.delete1(id);
        es.deleteById(id);
    }

    @Override
    public GameBean findById(Integer id) {
        return dao.findById(id);
    }

    public void orderdel(Integer id) {
        dao.orderdel(id);
        orderDao.deleteById(id);
    }

    @Override
    public void savesorder(OrderBean orderBean) {
        OrderBean order = dao.findorderByid(orderBean.getId());
        orderBean.setDate(new Date());
        if (orderBean.getId() != null) {
            dao.uporder(orderBean.getId());
        } else {
            dao.orderadd(orderBean);
        }
        orderDao.save(orderBean);
    }

    @Override
    public OrderBean findorderByid(Integer id) {
        Optional<OrderBean> byId = orderDao.findById(id);
        OrderBean orderBean = byId.get();
        return orderBean;
    }

}