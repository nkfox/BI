package model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * This class is abstract. Used for University and Person.
 * Created by Nataliia Kozoriz on 15/11/2016.
 */
@MappedSuperclass
public class Member implements Serializable {

    @Id
    @Column(name = "email")
    String email;

    @Column(name = "name")
    String name;

    @Column(name = "country")
    String country;

    @Column(name = "info")
    String info;

    @Column(name = "picture")
    String picture;

    public Member() {
    }

    public Member(String email, String name, String country, String info, String picture) {
        this.email = email;
        this.name = name;
        this.country = country;
        this.info = info;
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
