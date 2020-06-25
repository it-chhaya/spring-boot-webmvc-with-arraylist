package com.chhaya.pojomodel.repository;

import com.chhaya.pojomodel.model.Article;

import java.util.List;

public interface ArticleRepository {

    boolean insert(Article article);
    List<Article> select();

    // selectById, deleteById, updateById

}
