package feeddit.controllers;


import feeddit.entities.Article;
import feeddit.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


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
    public String list(Model model,Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Page<Article> articlePage = articleService.findAll(pageable);
        List<Article> newArticleList = new ArrayList<>();
        PageWrapper<Article> page = new PageWrapper<>(articlePage, "/user");


        for(Article article : articlePage){
            if(article.getByUser().toString().equals(username))
                newArticleList.add(article);
        }
        model.addAttribute("articles", page.getContent());
        model.addAttribute("page",page);
        return "user";
    }
}
