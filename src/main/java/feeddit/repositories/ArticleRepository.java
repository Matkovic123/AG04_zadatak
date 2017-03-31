package feeddit.repositories;

import feeddit.entities.Article;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by Matkovic on 7.3.2017..
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article,Long> {

}
