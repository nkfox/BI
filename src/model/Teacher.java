package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * This class includes all information about teachers.
 * Created by Nataliia Kozoriz on 05/02/2017.
 */
@Entity
@Table(name = "teacher")
public class Teacher extends Person {

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "university")
    University university;

    @Column(name = "post")
    String post;

    @Column(name = "degree")
    String degree;

    public Teacher() {
    }

    public Teacher(String email, String name, String country, String info, String picture, Date birthDate,
                   University university, String post, String degree) {
        super(email, name, country, info, picture, birthDate);
        this.university = university;
        this.post = post;
        this.degree = degree;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPicture() {
        return "../img/teacher/" + picture + ".jpg";
    }
}
