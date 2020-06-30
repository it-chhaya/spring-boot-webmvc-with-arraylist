package com.chhaya.pojomodel.restcontroller;

import com.chhaya.pojomodel.model.Article;
import com.chhaya.pojomodel.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/articles")
public class ArticleRestController {

    private ArticleServiceImpl articleService;

    @Autowired
    ArticleRestController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getArticle() {
        return articleService.select();
    }

    @PostMapping
    public Article insertArticle(@RequestBody Article article) {

        System.out.println(article);

        article.setId(UUID.randomUUID().toString());

        return articleService.insert(article);
    }

    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable String id) {
        articleService.deleteById(id);

        return "Article has been deleted..!";
    }

    @PutMapping
    public String updateArticle(@RequestBody Article article) {

        articleService.updateById(article);

        return "Article has been updated..!";
    }


}
