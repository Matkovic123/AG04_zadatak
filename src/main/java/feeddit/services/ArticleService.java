package feeddit.services;

import feeddit.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Matkovic on 8.3.2017..
 * Used for coding to an interface. Implementation of these methods can be found in ArticleServiceImpl.
 */
public interface ArticleService {
    Iterable<Article> listAllArticles();

    Article getArticleById(Long id);

    Boolean checkIfArticleExists(Long id);

    Article saveArticle(Article article);

    void deleteArticle (Long id);

    Page<Article> findAll(Pageable pageable);

}
