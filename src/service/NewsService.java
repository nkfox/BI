package service;

import model.News;
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
 * Created by Nataliia Kozoriz on 22/01/2017.
 */
@Service("newsService")
@Transactional
public class NewsService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public NewsService() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retrieves all news
     *
     * @return a list of news
     */
    public List<News> getAll() {

        // Retrieve session from Hibernate
        Session session = sessionFactory.openSession(); //.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM News");

        //session.close();
        // Retrieve all
        return query.list();
    }

    /**
     * Retrieves a single news
     */
    public News get(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        News news = (News) session.get(News.class, id);

        return news;
    }

    /**
     * Adds a new news
     */
    public void add(News news) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        Transaction trans = session.beginTransaction();

        // Save
        session.save(news);

        trans.commit();
    }

    /**
     * Deletes an existing news
     *
     * @param id the id of the existing news
     */
    public void delete(Integer id) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        News news = (News) session.get(News.class, id);

        // Delete
        session.delete(news);
    }

    /**
     * Edits an existing person
     */
    public void edit(News news) {
        //logger.debug("Editing existing news"); !!!!!!!!!!!!!!!!!

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing news via id
        News existingNews = (News) session.get(News.class, news.getId());

        // Assign updated values to this news
        existingNews.setTitle(news.getTitle());
        existingNews.setAuthor(news.getAuthor());
        existingNews.setDate(news.getDate());
        existingNews.setDescription(news.getDescription());

        // Save updates
        session.save(existingNews);
    }
}
