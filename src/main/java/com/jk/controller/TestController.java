package com.jk.controller;

import com.jk.pojo.GameBean;
import com.jk.pojo.StuBean;
import com.jk.pojo.TeaBean;
import com.jk.pojo.OrderBean;
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
    @RequestMapping("StuSelect")
    @ResponseBody
    public HashMap<String,Object> StuSelect(Integer page,Integer rows){
        return eservice.select(page,rows);
    }
    @RequestMapping("StuDel")
    @ResponseBody
    public void StuDel(Integer id){
        eservice.StuDel(id);
    }
    @RequestMapping("findStuById")
    @ResponseBody
    public StuBean findStuById(Integer id){
        return eservice.findStuById(id);
    }
    @RequestMapping("StuSave")
    @ResponseBody
    public void StuSave(StuBean stu){
        eservice.StuSave(stu);
    }
    @RequestMapping("toStuadd")
    public String toStuadd(){
        return "stuadd";
    }
    @RequestMapping("teasel")
    @ResponseBody
    public HashMap<String,Object> teasel(Integer page,Integer rows){
        return eservice.teasel(page,rows);
    }
    @RequestMapping("teadel")
    @ResponseBody
    public void teadel(Integer id){
        eservice.teadel(id);
    }
    @RequestMapping("teahuixian")
    @ResponseBody
    public TeaBean teahuixian(Integer id){
        return eservice.teahuixian(id);
    }
    @RequestMapping("teaadd")
    @ResponseBody
    public void teaadd(TeaBean tea){
        eservice.teaadd(tea);
    }


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
