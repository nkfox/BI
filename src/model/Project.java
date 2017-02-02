package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * This class includes all information about projects.
 * Created by Nataliia Kozoriz on 15.11.2016.
 */
@Entity
@Table(name = "project")
public class Project implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "category")
    String category;

    @Column(name = "startDate")
    Date startDate;

    @Column(name = "endDate")
    Date endDate;

    @Column(name = "organizer")
    String organizer;

    @Column(name = "description")
    String description;

    public Project() {
    }

    public Project(String name, String category, Date startDate, Date endDate, String organizer, String description) {
        this.name = name;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.organizer = organizer;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
