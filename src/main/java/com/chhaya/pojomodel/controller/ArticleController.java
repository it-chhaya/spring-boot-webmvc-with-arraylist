package com.chhaya.pojomodel.controller;

import com.chhaya.pojomodel.model.Article;
import com.chhaya.pojomodel.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Controller
public class ArticleController {

    private ArticleServiceImpl articleService;

    @Autowired
    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/articles/delete/{id}")
    public String deleteArticle(@PathVariable String id) {

        articleService.deleteById(id);

        return "redirect:/articles";
    }

    @GetMapping("/articles/add")
    public String insertArticleView(ModelMap map) {

        map.addAttribute("article", new Article());

        return "article-add";
    }

    @GetMapping("/articles/update/{id}")
    public String updateArticleView(ModelMap map, @PathVariable String id) {

        System.out.println(id);

        Article article = articleService.selectById(id);

        map.addAttribute("article", article);
        map.addAttribute("isUpdate", true);

        return "article-add";

    }

    @PostMapping("/articles/update")
    public String updateArticle(@ModelAttribute Article article) {

        articleService.updateById(article);

        return "redirect:/articles";

    }

    @PostMapping("articles/add")
    public String insertArticle(@ModelAttribute Article article) {

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

    @GetMapping("/articles/search")
    public String search(@RequestParam String title, ModelMap map) {

        System.out.println(title);

        System.out.println(articleService.searchByTitle(title));

        map.addAttribute("articles", articleService.searchByTitle(title));

        return "article";
    }

}
