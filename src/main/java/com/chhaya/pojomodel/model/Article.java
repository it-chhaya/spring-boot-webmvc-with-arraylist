package com.chhaya.pojomodel.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Article implements Serializable {

    @NotNull
    private String id;

    @NotNull
    @Size(min = 5, max = 50)
    private String title;
    
    @NotNull
    private String details;

    public Article() {}

    public Article(String id, String title, String details) {
        this.id = id;
        this.title = title;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

}
