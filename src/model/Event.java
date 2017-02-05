package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * This class includes all information about events.
 * Created by Nataliia Kozoriz on 15/11/2016.
 */
@Entity
@Table(name = "event")
public class Event implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    int id;

    @Column(name = "title")
    String title;

    @Column(name = "startDate")
    Date startDate;

    @Column(name = "endDate")
    Date endDate;

    @Column(name = "place")
    String place;

    @Column(name = "organizer")
    String organizer;

    @Column(name = "participants")
    String participants;

    @Column(name = "description")
    String description;

    public Event() {
    }

    public Event(String title, Date startDate, Date endDate, String place, String organizer, String participants, String description) {
        this.title = title;
        this.organizer = organizer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.participants = participants;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_event) {
        this.id = id_event;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
