package feeddit.controllers;

import feeddit.entities.Article;
import feeddit.entities.Vote;
import feeddit.services.ArticleService;
import feeddit.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Matkovic on 31.3.2017..
 */
@Controller
public class VoteController {

    @Autowired
    VoteService voteService;

    @Autowired
    ArticleService articleService;

    @RequestMapping("upvote/{id}")
    public String upvote(@PathVariable Long id,ModelAndView mav){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Vote vote = new Vote(1,username,id );


        voteService.saveVote(vote);

        Article article = articleService.getArticleById(id);
        article.setVotes(article.getVotes()+1);
        articleService.saveArticle(article);


        return "redirect:/articles";
    }

    @RequestMapping("downvote/{id}")
    public String downvote(@PathVariable Long id,ModelAndView mav){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Vote vote = new Vote(-1,username,id );
        voteService.saveVote(vote);

        Article article = articleService.getArticleById(id);
        article.setVotes(article.getVotes()-1);
        articleService.saveArticle(article);

        return "redirect:/articles";
    }

}
