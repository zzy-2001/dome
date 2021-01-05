package com.jk.controller;

import com.jk.pojo.GameBean;
import com.jk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService eservice;

    /**
     * 查询
     * @param bean
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("selectPage")
    @ResponseBody
    public HashMap<String,Object> findAll2(GameBean bean, Integer page, Integer rows){
        return eservice.selectPage(bean,page,rows);
    }
    /**
     * 新增跳转
     * @param
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "insert";
    }

    /**
     * 新增游戏
     * @param bean
     */
    @RequestMapping("addGame")
    @ResponseBody
    public void addGame(GameBean bean){
        eservice.addGame(bean);
    }


    @RequestMapping("delete1")
    @ResponseBody
    public void delete1(Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            eservice.delete1(arr[i]);
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public GameBean findById(Integer id){
        return eservice.findById(id);
    }



}
