package com.chhaya.pojomodel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui")
public class ArticleDetailController {

    @GetMapping("articles")
    public String viewArticles() {
        return "article";
    }

    @GetMapping("articles/add")
    public String addArticleView() {
        return "article-add";
    }

}
