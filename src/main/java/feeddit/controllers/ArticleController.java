package feeddit.controllers;

import feeddit.entities.Article;
import feeddit.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Matkovic on 8.3.2017..
 * Consists mainly of simple CRUD operations.
 */
@Controller
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService){
        this.articleService = articleService;
    }

    @RequestMapping("article/new")
    public String newArticle(Model model){
        model.addAttribute("article", new Article());
        return "articleform";
    }

    @RequestMapping(value="article", method= RequestMethod.POST)
    public String saveArticle(Article article)
    {
        articleService.saveArticle(article);
        return "redirect:/article/" + article.getId();
    }

    //tu si stal. Crveni se jer u services nisi složio interface, za sad je prazan.


}
