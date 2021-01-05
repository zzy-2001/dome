package com.jk.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(indexName = "jiuye",type = "202113")
public class Ees {
    @Id
    private Integer id;
    private String name;
    private Integer classid;
    private String info;
    private Integer age;
    private Integer price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jydate;
    private String jyname;
    private String cname;

    private String ronghe;
    private Integer ryi;
    private Integer rer;

    public String getRonghe() {
        return ronghe;
    }

    public void setRonghe(String ronghe) {
        this.ronghe = ronghe;
    }

    public Integer getRyi() {
        return ryi;
    }

    public void setRyi(Integer ryi) {
        this.ryi = ryi;
    }

    public Integer getRer() {
        return rer;
    }

    public void setRer(Integer rer) {
        this.rer = rer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getJydate() {
        return jydate;
    }

    public void setJydate(Date jydate) {
        this.jydate = jydate;
    }

    public String getJyname() {
        return jyname;
    }

    public void setJyname(String jyname) {
        this.jyname = jyname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
