package com.chhaya.pojomodel.controller;

import com.chhaya.pojomodel.model.Article;
import com.chhaya.pojomodel.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public String addArticleView(ModelMap map) {

        map.addAttribute("article", new Article());

        return "article-add";
    }

    @PostMapping("/articles/add")
    public String addArticle(@ModelAttribute Article article) {

        article.setId(UUID.randomUUID().toString());
        articleService.insert(article);

        return "redirect:/articles";
    }

    @GetMapping("/articles")
    public String index(ModelMap map) {

        List<Article> articles = articleService.select();

        map.addAttribute("articles", articles);

        return "article";
    }

    @GetMapping("/articles/update/{id}")
    public String editArticleView(ModelMap map, @PathVariable String id) {

        map.addAttribute("article", articleService.selectById(id));
        map.addAttribute("isUpdate", true);

        return "article-add";
    }

    @PostMapping("/articles/update")
    public String editArticle(@ModelAttribute Article article) {

        articleService.updateById(article);

        return "redirect:/articles";
    }

    @GetMapping("/articles/search")
    public String searchArticles(
            @RequestParam("title") String title,
            ModelMap map) {

        map.addAttribute("articles", articleService.searchByTitle(title));

        return "article";
    }

    @GetMapping("/articles/delete/{id}")
    public String deleteArticle(@PathVariable String id) {

        articleService.deleteById(id);

        return "redirect:/articles";
    }

}
