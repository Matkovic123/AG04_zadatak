package feeddit.controllers;


import feeddit.entities.Article;
import feeddit.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.StreamSupport;


/**
 * Created by Matkovic on 30.3.2017..
 */
@Controller
public class UserController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/user")
    public String index() {
        return "redirect:/user";
    }

    @GetMapping("user")
    public String list(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        ArrayList<Article> articleList = new ArrayList<Article>((Collection<? extends Article>) articleService.listAllArticles());
        List<Article> newArticleList = new ArrayList<>();
        for(Article article : articleList){
            if(article.getByUser().toString().equals(username))
                newArticleList.add(article);
        }
        model.addAttribute("articles",newArticleList);
        return "user";
    }



}
