package service;

import model.Teacher;
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
 * Created by Nataliia Kozoriz on 05/02/2017.
 */
@Service("teacherService")
@Transactional
public class TeacherService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(TeacherService.class);

    public TeacherService() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("ExceptionInInitializerError", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retrieves all teachers
     *
     * @return a list of teachers
     */
    public List<Teacher> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Teacher");
        return query.list();
    }

    /**
     * Retrieves teachers of given university
     *
     * @return a list of teachers
     */
    public List<Teacher> getByUniversity(String email) {
        Session session = sessionFactory.openSession();
        University university = (University) session.get(University.class, email);
        Query query = session.createQuery("FROM Teacher WHERE university = :university").setParameter("university", university);
        return query.list();
    }

    /**
     * Retrieves a single teacher
     */
    public Teacher get(String id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Teacher teacher = (Teacher) session.get(Teacher.class, id);
        transaction.commit();
        return teacher;
    }

    /**
     * Adds a new teacher
     */
    public void add(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(teacher);
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
        Teacher teacher = (Teacher) session.get(Teacher.class, id);
        session.delete(teacher);
        transaction.commit();
    }

    /**
     * Edits an existing person
     */
    public void edit(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher existingTeacher = (Teacher) session.get(Teacher.class, teacher.getEmail());
        Transaction transaction = session.beginTransaction();

        existingTeacher.setName(teacher.getName());
        existingTeacher.setCountry(teacher.getCountry());
        existingTeacher.setInfo(teacher.getInfo());
        existingTeacher.setPicture(teacher.getPicture());
        existingTeacher.setBirthDate(teacher.getBirthDate());
        existingTeacher.setUniversity(teacher.getUniversity());
        existingTeacher.setPost(teacher.getPost());
        existingTeacher.setDegree(teacher.getDegree());

        session.save(existingTeacher);
        transaction.commit();
    }
}
