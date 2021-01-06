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
    /* *
      * @Author: 张自强
      * @Description: 学生表查询
      * @Date: 2021/1/6 9:29
      * @param page
     * @param rows
      * @Return: java.util.HashMap<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("StuSelect")
    @ResponseBody
    public HashMap<String,Object> StuSelect(Integer page,Integer rows){
        return eservice.select(page,rows);
    }
    /* *
      * @Author: 张自强
      * @Description: 学生表删除
      * @Date: 2021/1/6 9:30
      * @param id
      * @Return: void
     **/
    @RequestMapping("StuDel")
    @ResponseBody
    public void StuDel(Integer id){
        eservice.StuDel(id);
    }
    /* *
      * @Author: 张自强
      * @Description: 学生表回显
      * @Date: 2021/1/6 9:30
      * @param id
      * @Return: com.jk.pojo.StuBean
     **/
    @RequestMapping("findStuById")
    @ResponseBody
    public StuBean findStuById(Integer id){
        return eservice.findStuById(id);
    }
    /* *
      * @Author: 张自强
      * @Description: 学生表新增修改
      * @Date: 2021/1/6 9:30
      * @param stu
      * @Return: void
     **/
    @RequestMapping("StuSave")
    @ResponseBody
    public void StuSave(StuBean stu){
        eservice.StuSave(stu);
    }
    /* *
      * @Author: 张自强
      * @Description: 跳转新增页面
      * @Date: 2021/1/6 9:30
      * @param
      * @Return: java.lang.String
     **/
    @RequestMapping("toStuadd")
    public String toStuadd(){
        return "stuadd";
    }
    /**
     2 * @Author: lxg
     3 * @Description: 查询
     4 * @Date: 2021/1/5 21:49
     5  * @param id
     6 * @Return: com.jk.pojo.OrderBean
     7 **/
    @RequestMapping("teasel")
    @ResponseBody
    public HashMap<String,Object> teasel(Integer page,Integer rows){
        return eservice.teasel(page,rows);
    }
    /**
     2 * @Author: lxg
     3 * @Description: 删除
     4 * @Date: 2021/1/5 21:49
     5  * @param id
     6 * @Return: com.jk.pojo.OrderBean
     7 **/
    @RequestMapping("teadel")
    @ResponseBody
    public void teadel(Integer id){
        eservice.teadel(id);
    }
    /**
     2 * @Author: lxg
     3 * @Description: 回显
     4 * @Date: 2021/1/5 21:49
     5  * @param id
     6 * @Return: com.jk.pojo.OrderBean
     7 **/
    @RequestMapping("teahuixian")
    @ResponseBody
    public TeaBean teahuixian(Integer id){
        return eservice.teahuixian(id);
    }
    /**
     2 * @Author: lxg
     3 * @Description: 新增
     4 * @Date: 2021/1/5 21:49
     5  * @param id
     6 * @Return: com.jk.pojo.OrderBean
     7 **/
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

    /**
     2 * @Author: ghx
     3 * @Description: 订单查询
     4 * @Date: 2021/1/5 20:58
     5  * @param page
     * @param rows
     * @param orderBean
    6 * @Return: java.util.HashMap<java.lang.String,java.lang.Object>
    7 **/
    @RequestMapping("findorder")
    @ResponseBody
    public HashMap<String,Object> findorder(Integer page, Integer rows, OrderBean orderBean){
        return eservice.findorder(page,rows,orderBean);
    }
    /**
     2 * @Author: ghx
     3 * @Description: 删除订单
     4 * @Date: 2021/1/5 21:44
     5  * @param id
     6 * @Return: void
     7 **/
    @RequestMapping("orderdel")
    @ResponseBody
    public void orderdel(Integer id){
        eservice.orderdel(id);
    }
    /**
     2 * @Author: ghx
     3 * @Description: 新增
     4 * @Date: 2021/1/5 21:44
     5  * @param orderBean
     6 * @Return: void
     7 **/
    @RequestMapping("savesorder")
    @ResponseBody
    public void savesorder(OrderBean orderBean){
        eservice.savesorder(orderBean);
    }

    /**
     2 * @Author: ghx
     3 * @Description: 修改回显
     4 * @Date: 2021/1/5 21:49
     5  * @param id
     6 * @Return: com.jk.pojo.OrderBean
     7 **/
    @RequestMapping("findorderByid")
    @ResponseBody
    public OrderBean findorderByid(Integer id){
        return eservice.findorderByid(id);
    }

}
