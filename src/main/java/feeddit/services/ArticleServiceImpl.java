package feeddit.services;

import feeddit.entities.Article;
import feeddit.repositories.ArticleRepository;
import feeddit.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by Matkovic on 9.3.2017.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Iterable<Article> listAllArticles(){
        return
                articleRepository.findAll();
    }


    @Override
    public Article getArticleById(Long id){
        return articleRepository.findOne(id);
    }

    @Override
    public Boolean checkIfArticleExists(Long id) {
        return articleRepository.exists(id);
    }

    @Override
    public Article saveArticle (Article article){
        article.setByUser(SecurityContextHolder.getContext().getAuthentication().getName().toString() );
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id){
        articleRepository.delete(id);
    }
}
