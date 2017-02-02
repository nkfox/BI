package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * This class includes all information about news.
 * Created by Nataliia Kozoriz on 15.11.2016.
 */
@Entity
@Table(name = "news")
public class News implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue
    int id;

    @Column(name = "title")
    String title;

    @Column(name = "author")
    String author;

    @Column(name = "date")
    Date date;

    @Column(name = "description")
    String description;

    public News() {
    }

    public News(String title, String author, Date date, String description) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
