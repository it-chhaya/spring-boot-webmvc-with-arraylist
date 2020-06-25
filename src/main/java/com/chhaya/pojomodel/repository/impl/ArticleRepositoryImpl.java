package com.chhaya.pojomodel.repository.impl;

import com.chhaya.pojomodel.model.Article;
import com.chhaya.pojomodel.repository.ArticleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    private List<Article> data;

    public ArticleRepositoryImpl() {
        data = new ArrayList<>();
        data.add(new Article(UUID.randomUUID().toString(), "Spring", "Java Framework"));
        data.add(new Article(UUID.randomUUID().toString(), "Java", "Programming"));
        data.add(new Article(UUID.randomUUID().toString(), "PostgreSQL", "Database Server"));
    }

    @Override
    public List<Article> select() {
        return data;
    }

    @Override
    public boolean insert(Article article) {
        return data.add(article);
    }

}
