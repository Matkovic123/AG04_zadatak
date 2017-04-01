package feeddit.repositories;

import feeddit.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by Matkovic on 7.3.2017..
 */
public interface ArticleRepository extends CrudRepository<Article,Long> {
    Page<Article> findAll(Pageable pageable);
}
