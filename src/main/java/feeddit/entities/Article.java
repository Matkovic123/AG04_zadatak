package feeddit.entities;

import javax.persistence.*;


/**
 * Created by Matkovic on 7.3.2017..
 */
@Entity
public class Article{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @Version
//    private Integer version;
    private Integer votes;
    private String byUser;
    private String headline;
    private String link;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getByUser() {
        return byUser;
    }

    public void setByUser(String byUser) {
        this.byUser = byUser;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
