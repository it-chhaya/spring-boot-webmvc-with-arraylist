package com.chhaya.pojomodel.service;

import com.chhaya.pojomodel.model.Article;

import java.util.List;

public interface ArticleService {

    Article insert(Article article);

    List<Article> select();

    void deleteById(String id);

    Article selectById(String id);

    void updateById(Article article);

    List<Article> searchByTitle(String title);

}
