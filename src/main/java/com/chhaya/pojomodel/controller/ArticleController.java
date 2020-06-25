package com.chhaya.pojomodel.controller;

import com.chhaya.pojomodel.model.Article;
import com.chhaya.pojomodel.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class ArticleController {

    private ArticleServiceImpl articleService;

    @Autowired
    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles/add")
    public String addArticle() {
        return "article-add";
    }

    @GetMapping("/articles")
    public String index(ModelMap map) {

        Article article = new Article();
        article.setId(UUID.randomUUID().toString());
        article.setTitle("IntelliJ");
        article.setDetails("Java Enterprise IDE");

        // Insert data
        articleService.insert(article);

        List<Article> articles = articleService.select();

        map.addAttribute("articles", articles);

        return "article";
    }

}
