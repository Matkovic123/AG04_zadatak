package feeddit.repositories;

import feeddit.entities.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Matkovic on 7.3.2017..
 */
public interface ArticleRepository extends CrudRepository<Article,Long>{
}
