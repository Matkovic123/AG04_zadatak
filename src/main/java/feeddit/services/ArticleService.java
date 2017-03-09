package feeddit.services;

import feeddit.entities.Article;

/**
 * Created by Matkovic on 8.3.2017..
 * Used for coding to an interface. Implementation of these methods canbe found in ArticleServiceImpl.
 */
public interface ArticleService {
    Iterable<Article> listAllArticles();

    Article getArticleById(Integer id);

    Article saveArticle(Article article);

    void deleteArticle (Integer id);
}
