package feeddit.bootstrap;

/**
 * Created by Matkovic on 7.3.2017..
 */
import feeddit.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Matkovic on 7.3.2017..
 */
@Component
public class ArticleLoader {
    @Autowired
    private ArticleRepository articleRepository;


}
