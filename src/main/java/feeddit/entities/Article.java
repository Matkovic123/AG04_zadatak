package feeddit.entities;


import javax.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private String entryDate;


    public Article(){
        System.out.println("Inside default article constructor");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        this.entryDate = df.format(today);
        this.votes = 0;
        //Ovo makni kad središ user bazu
        this.byUser = new Long (12);
    }


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

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

}
