package feeddit.services;

import feeddit.entities.Article;
import feeddit.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Matkovic on 9.3.2017.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Iterable<Article> listAllArticles(){
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long id){
        return articleRepository.findOne(id);
    }

    @Override
    public Article saveArticle (Article article){

        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id){
        articleRepository.delete(id);
    }
}
