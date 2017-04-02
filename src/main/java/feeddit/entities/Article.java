package feeddit.entities;

import org.hibernate.validator.constraints.URL;
import javax.persistence.*;
import javax.validation.constraints.Size;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Matkovic on 7.3.2017..
 */

@Entity
@Table
public class Article{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String byUser;
    @Column
    private String headline;
    @Size(min = 2,message = "Uneseni link nije ispravan.")
    @URL(message = "Uneseni link ne postoji.")
    @Column
    private String link;
    @Size(min = 2,message = "Molimo unesite ime autora.")
    @Column
    private String author;
    @Column
    private Integer votes;
    @Column
    private String entryDate;

    public Article(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        this.entryDate = df.format(today);
        this.votes = 0;
        this.byUser = null;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
