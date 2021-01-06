package com.jk.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "users" , type = "200606")
public class Users  implements Serializable {

    private static final long serialVersionUID = 2087582601382175639L;
    @Id
    private Integer id;
    private String username;
    private String money;

}
