package com.chhaya.pojomodel.repository.impl;

import com.chhaya.pojomodel.model.Article;
import com.chhaya.pojomodel.repository.ArticleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    private List<Article> data;

    public void init() {
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
    public void deleteById(String id) {
        for (Article article : data) {
            if (article.getId().equals(id)) {
                data.remove(article);
                return;
            }
        }
    }

    @Override
    public boolean insert(Article article) {
        return data.add(article);
    }

    @Override
    public Article selectById(String id) {
        for (Article article : data) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }

    @Override
    public void updateById(Article newArticle) {
        for (Article article : data) {
            if (article.getId().equals(newArticle.getId())) {
                BeanUtils.copyProperties(newArticle, article);
                return;
            }
        }
    }

    @Override
    public List<Article> searchByTitle(String title) {
        return data.stream()
                .filter(article -> article.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
}
