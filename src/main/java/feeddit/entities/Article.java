package feeddit.entities;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Matkovic on 7.3.2017..
 */
@Entity
public class Article{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long byUser;
    private String headline;
    private String link;
    private String author;
    private Integer votes;
    private Date entryDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getByUser() {
        return byUser;
    }

    public void setByUser(Long byUser) {
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

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
