package feeddit.entities;

import ch.qos.logback.core.net.SyslogOutputStream;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Matkovic on 7.3.2017..
 */
@Entity
@Table(name="article")
public class Article{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long byUser;
    private String headline;
    private String link;
    private String author;
    private Date entryDate;
    private Integer votes;

    public Article(){
        System.out.println("Inside default article constructor");
        this.entryDate = Calendar.getInstance().getTime();
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

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

}
