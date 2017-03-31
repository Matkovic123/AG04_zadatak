package feeddit.comparators;

import feeddit.entities.Article;

import java.util.Comparator;

/**
 * Created by Matkovic on 31.3.2017..
 */
public class ArticleVotesComparator implements Comparator<Article> {

    @Override
    public int compare(Article o1, Article o2) {
        return o2.getVotes().compareTo(o1.getVotes());
    }
}
