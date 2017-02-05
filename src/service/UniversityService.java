package service;

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
 * Hibernate connection to university table.
 * Created by Nataliia Kozoriz on 04/02/2017.
 */
@Service("universityService")
@Transactional
public class UniversityService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(UniversityService.class);

    public UniversityService() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("ExceptionInInitializerError", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retrieves all universities
     *
     * @return a list of universities
     */
    public List<University> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM University");
        return query.list();
    }

    /**
     * Retrieves a single university
     */
    public University get(String id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        University university = (University) session.get(University.class, id);
        transaction.commit();
        return university;
    }

    /**
     * Adds a new university
     */
    public void add(University university) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(university);
        transaction.commit();
    }

    /**
     * Deletes an existing university
     *
     * @param id the id of the existing university
     */
    public void delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        University university = (University) session.get(University.class, id);
        session.delete(university);
        transaction.commit();
    }

    /**
     * Edits an existing person
     */
    public void edit(University university) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        University existingUniversity = (University) session.get(University.class, university.getEmail());

        existingUniversity.setName(university.getName());
        existingUniversity.setCountry(university.getCountry());
        existingUniversity.setInfo(university.getInfo());
        existingUniversity.setPicture(university.getPicture());
        existingUniversity.setCity(university.getCity());

        session.save(existingUniversity);
        transaction.commit();
    }
}
