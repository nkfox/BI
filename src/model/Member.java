package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * This class includes all information about members.
 * Created by Nataliia Kozoriz on 15.11.2016.
 */
@Entity
@Table(name = "member")
public class Member implements Serializable {
    @Id
    @Column(name = "email")
    String email;

    @Column(name = "name")
    String name;

    @Column(name = "country")
    String country;

    @Column(name = "phone")
    String phone;

    public Member() {
    }

    public Member(String email, String name, String country, String phone) {
        this.email = email;
        this.name = name;
        this.country = country;
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
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

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
