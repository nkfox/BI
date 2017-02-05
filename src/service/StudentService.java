package service;

import model.Student;
import model.University;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Hibernate connection to teacher table.
 * Created by Nataliia Kozoriz on 04/02/2017.
 */
@Service("studentService")
@Transactional
public class StudentService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(StudentService.class);

    public StudentService() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("ExceptionInInitializerError", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retrieves all students
     *
     * @return a list of students
     */
    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Student");
        return query.list();
    }

    /**
     * Retrieves students of given university
     *
     * @return a list of students
     */
    public List<Student> getByUniversity(String email) {
        Session session = sessionFactory.openSession();
        University university = (University) session.get(University.class, email);
        Query query = session.createQuery("FROM Student WHERE university = :university").setParameter("university", university);
        return query.list();
    }

    /**
     * Retrieves a single teacher
     */
    public Student get(String id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        transaction.commit();
        return student;
    }

    /**
     * Adds a new teacher
     */
    public void add(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    /**
     * Deletes an existing teacher
     *
     * @param id the id of the existing teacher
     */
    public void delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
    }

    /**
     * Edits an existing person
     */
    public void edit(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student existingStudent = (Student) session.get(Student.class, student.getEmail());
        Transaction transaction = session.beginTransaction();

        existingStudent.setName(student.getName());
        existingStudent.setCountry(student.getCountry());
        existingStudent.setInfo(student.getInfo());
        existingStudent.setPicture(student.getPicture());
        existingStudent.setUniversity(student.getUniversity());
        existingStudent.setFaculty(student.getFaculty());
        existingStudent.setBirthDate(student.getBirthDate());
        existingStudent.setSpeciality(student.getSpeciality());
        existingStudent.setYear(student.getYear());

        session.save(existingStudent);
        transaction.commit();
    }
}
