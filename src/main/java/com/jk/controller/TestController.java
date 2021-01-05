package com.jk.controller;

import com.jk.pojo.StuBean;
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
}
