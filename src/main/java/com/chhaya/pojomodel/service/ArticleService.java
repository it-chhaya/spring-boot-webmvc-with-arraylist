package com.chhaya.pojomodel.service;

import com.chhaya.pojomodel.model.Article;

import java.util.List;

public interface ArticleService {

    Article insert(Article article);

    List<Article> select();

    Article selectById(String id);

    void updateById(Article newArticle);

    List<Article> searchByTitle(String title);

    void deleteById(String id);

}
