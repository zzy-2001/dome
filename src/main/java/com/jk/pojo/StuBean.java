package com.jk.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "stu",type = "20065")
public class StuBean {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private Integer sex;
}
