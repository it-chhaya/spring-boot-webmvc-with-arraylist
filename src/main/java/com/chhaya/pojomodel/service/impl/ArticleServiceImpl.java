package com.chhaya.pojomodel.service.impl;

import com.chhaya.pojomodel.model.Article;
import com.chhaya.pojomodel.repository.impl.ArticleRepositoryImpl;
import com.chhaya.pojomodel.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepositoryImpl articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepositoryImpl articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> select() {
        return articleRepository.select();
    }

    @Override
    public Article insert(Article article) {
        // if (articleRepository.insert(article))
        //return article;
        // else
        // return null;

        // Ternary Operator
        return articleRepository.insert(article) ? article : null;
    }

    @Override
    public Article selectById(String id) {
        return articleRepository.selectById(id);
    }

    @Override
    public void updateById(Article newArticle) {
        articleRepository.updateById(newArticle);
    }

    @Override
    public List<Article> searchByTitle(String title) {
        return articleRepository.searchByTitle(title);
    }

    @Override
    public void deleteById(String id) {
        articleRepository.deleteById(id);
    }
}