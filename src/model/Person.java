package model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Date;

/**
 * This class is abstract. Used for Student and Teacher.
 * Created by Nataliia Kozoriz on 04/02/2017.
 */
@MappedSuperclass
public class Person extends Member {

    @Column(name = "birthDate")
    Date birthDate;

    public Person() {
    }

    public Person(String email, String name, String country, String info, String picture, Date birthDate) {
        super(email, name, country, info, picture);
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date date) {
        this.birthDate = date;
    }
}
