package feeddit.controllers;

import feeddit.entities.Article;
import feeddit.entities.Users;
import feeddit.entities.Vote;
import feeddit.services.ArticleService;
import feeddit.services.UserService;
import feeddit.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Matkovic on 31.3.2017..
 */
@Controller
public class VoteController {

    @Autowired
    VoteService voteService;

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @RequestMapping("upvote/{id}")
    public String upvote(@PathVariable Long id, Model model){
        Long articleId = id;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //get all users to fecth the right ones ID
        String currentUsername = authentication.getName();
        //fetch active users id trough name
        Long user_id=null;
        ArrayList<Users> allUsers = new ArrayList<Users>((Collection<? extends Users>) userService.getAllUsers());
        for(Users user : allUsers){
            if(user.getUsername().equals(currentUsername)){
                user_id=user.getId();
            }
        }

        //check if user has already upvoted
        ArrayList<Vote> allVotes = new ArrayList<Vote>((Collection<? extends Vote>) voteService.getAllVotes());
        for(Vote vote : allVotes){
            if(vote.getArticleId().equals(articleId) && vote.getUserId().equals(user_id) && vote.getVote().equals(1))
            {
                //ignore adding new vote if user-vote match is found
                return "redirect:/articles";
            }
        }
        //add new vote if checkpoins have been passed

        //delete opposite vote if exists
        for(Vote vote : allVotes){
            if(vote.getArticleId().equals(articleId) && vote.getUserId().equals(user_id) && vote.getVote().equals(-1))
            {
                voteService.deleteVote(vote.getId());

                //add new vote that overwrites the old one
                Vote newVote = new Vote(1,user_id,articleId );
                voteService.saveVote(newVote);
                Article article = articleService.getArticleById(id);
                article.setVotes(article.getVotes()+2);
                articleService.saveArticle(article);
                model.addAttribute("upvoteSuccessful",true);
                return "voteconfirmation";
            }
        }
        //add new vote if checkpoins have been passed
        Vote newVote = new Vote(1,user_id,articleId );
        voteService.saveVote(newVote);
        Article article = articleService.getArticleById(id);
        article.setVotes(article.getVotes()+1);
        articleService.saveArticle(article);
        model.addAttribute("upvoteSuccessful", true);

        return "voteconfirmation";
    }

    @RequestMapping("downvote/{id}")
    public String downvote(@PathVariable Long id, Model model){
        Long articleId = id;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //get all users to fecth the right ones ID
        String currentUsername = authentication.getName();
        //fetch active users id trough name
        Long user_id=null;
        ArrayList<Users> allUsers = new ArrayList<Users>((Collection<? extends Users>) userService.getAllUsers());
        for(Users user : allUsers){
            if(user.getUsername().equals(currentUsername)){
                user_id=user.getId();
            }
        }

        //check if user has already downvoted
        ArrayList<Vote> allVotes = new ArrayList<Vote>((Collection<? extends Vote>) voteService.getAllVotes());

        for(Vote vote : allVotes){
            if(vote.getArticleId().equals(articleId) && vote.getUserId().equals(user_id) && vote.getVote().equals(-1))
            {
                //ignore adding new vote if user-vote match is found

                return "redirect:/articles";
            }
        }
        //delete opposite vote if exists
        for(Vote vote : allVotes){
            if(vote.getArticleId().equals(articleId) && vote.getUserId().equals(user_id) && vote.getVote().equals(1))
            {
                voteService.deleteVote(vote.getId());
                //add new vote if checkpoins have been passed
                Vote newVote = new Vote(-1,user_id,articleId );
                voteService.saveVote(newVote);
                Article article = articleService.getArticleById(id);
                article.setVotes(article.getVotes()-2);
                articleService.saveArticle(article);
                model.addAttribute("downvoteSuccessful", true);
                return "voteconfirmation";
            }
        }
        //add new vote if checkpoins have been passed
        Vote newVote = new Vote(-1,user_id,articleId );
        voteService.saveVote(newVote);
        Article article = articleService.getArticleById(id);
        article.setVotes(article.getVotes()-1);
        articleService.saveArticle(article);
        model.addAttribute("downvoteSuccessful", true);

        return "voteconfirmation";
    }


}
