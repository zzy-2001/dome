package com.jk.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Data
@Document(indexName = "tea",type = "20065")
public class TeaBean {
        @Id
        private Integer id;
        private String name;
        private Integer sex;
}
