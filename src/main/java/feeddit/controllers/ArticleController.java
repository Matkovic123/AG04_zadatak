package feeddit.controllers;

import feeddit.entities.Article;
import feeddit.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Matkovic on 8.3.2017..
 * Consists mainly of simple CRUD operations.
 */
@Controller
public class ArticleController {


    @RequestMapping("/")
    public String index() {
        return "redirect:/articles";
    }

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("articles", articleService.listAllArticles());
        return "articles";
    }

    @RequestMapping("article/{id}")
    public String showArticle(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "articleshow";
    }

    @RequestMapping("articleform")
    public String newArticle(Model model) {
        model.addAttribute("article", new Article());
        return "articleform";
    }

    @RequestMapping(value = "article", method = RequestMethod.POST)
    public String saveArticle(@Valid Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "articleform";
        }
        articleService.saveArticle(article);
        return "redirect:/article/" + article.getId();
    }

    @RequestMapping("article/delete/{id}")
    public String delete(@PathVariable Long id){
        articleService.deleteArticle(id);
        return "redirect:/articles";
    }




}
