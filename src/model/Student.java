package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * This class includes all information about students.
 * Created by Nataliia Kozoriz on 04/02/2017.
 */
@Entity
@Table(name = "student")
public class Student extends Person {

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "university")
    University university;

    @Column(name = "faculty")
    String faculty;

    @Column(name = "speciality")
    String speciality;

    @Column(name = "year")
    String year;

    public Student() {
    }

    public Student(String email, String name, String country, String info, String picture, Date birthDate,
                   University university, String faculty, String speciality, String year) {
        super(email, name, country, info, picture, birthDate);
        this.university = university;
        this.faculty = faculty;
        this.speciality = speciality;
        this.year = year;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPicture() {
        return "../img/teacher/" + picture + ".jpg";
    }
}
