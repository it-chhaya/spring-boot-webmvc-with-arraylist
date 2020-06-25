package com.chhaya.pojomodel.repository;

import com.chhaya.pojomodel.model.Article;

import java.util.List;

public interface ArticleRepository {

    boolean insert(Article article);

    List<Article> select();

    void deleteById(String id);

    Article selectById(String id);

    void updateById(Article newArticle);

    List<Article> searchByTitle(String title);

}
