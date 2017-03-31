package feeddit.comparators;

import feeddit.entities.Article;

import java.util.Comparator;

/**
 * Created by Matkovic on 31.3.2017..
 */
public class ArticleIdComparator implements Comparator<Article> {

    @Override
    public int compare(Article o1, Article o2) {
        return o2.getId().compareTo(o1.getId());
    }
}
