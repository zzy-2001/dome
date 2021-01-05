package com.jk.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Document(indexName = "game",type = "15")
public class GameBean implements Serializable {
    private static final long serialVersionUID = -4300605540026524784L;
    @Id
    private Integer game_id;
    private String game_name;
    private Integer game_type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date game_date;

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public Integer getGame_type() {
        return game_type;
    }

    public void setGame_type(Integer game_type) {
        this.game_type = game_type;
    }

    public Date getGame_date() {
        return game_date;
    }

    public void setGame_date(Date game_date) {
        this.game_date = game_date;
    }
}
