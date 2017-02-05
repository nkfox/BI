package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class includes all information about universities.
 * Created by Nataliia Kozoriz on 04/02/2017.
 */
@Entity
@Table(name = "university")
public class University extends Member {

    @Column(name = "city")
    String city;

    public University() {
    }

    public University(String email, String name, String country, String info, String picture, String city) {
        super(email, name, country, info, picture);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPicture() {
        return "../img/university/" + picture + ".jpg";
    }
}
