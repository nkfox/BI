package service;

import model.News;
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
 * Hibernate connection to news table.
 * Created by Nataliia Kozoriz on 22/01/2017.
 */
@Service("newsService")
@Transactional
public class NewsService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(NewsService.class);

    public NewsService() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("ExceptionInInitializerError", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retrieves all news
     *
     * @return a list of news
     */
    public List<News> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM News");
        return query.list();
    }

    /**
     * Retrieves a single news
     */
    public News get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        News news = (News) session.get(News.class, id);
        transaction.commit();
        return news;
    }

    /**
     * Adds a new news
     */
    public void add(News news) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(news);
        transaction.commit();
    }

    /**
     * Deletes an existing news
     *
     * @param id the id of the existing news
     */
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        News news = (News) session.get(News.class, id);
        session.delete(news);
        transaction.commit();
    }

    /**
     * Edits an existing person
     */
    public void edit(News news) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        News existingNews = (News) session.get(News.class, news.getId());

        existingNews.setTitle(news.getTitle());
        existingNews.setAuthor(news.getAuthor());
        existingNews.setDate(news.getDate());
        existingNews.setDescription(news.getDescription());

        session.save(existingNews);
        transaction.commit();
    }
}
