package service;

import model.Event;
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
 * Hibernate connection to event table.
 * Created by Nataliia Kozoriz on 22/01/2017.
 */
@Service("eventsService")
@Transactional
public class EventService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(EventService.class);

    public EventService() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("ExceptionInInitializerError", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retrieves all events
     *
     * @return a list of events
     */
    public List<Event> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Event");
        return query.list();
    }

    /**
     * Retrieves a single event
     */
    public Event get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Event event = (Event) session.get(Event.class, id);
        transaction.commit();
        return event;
    }

    /**
     * Adds a new event
     */
    public void add(Event event) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(event);
        transaction.commit();
    }

    /**
     * Deletes an existing event
     *
     * @param id the id of the existing event
     */
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Event event = (Event) session.get(Event.class, id);
        session.delete(event);
        transaction.commit();
    }

    /**
     * Edits an existing person
     */
    public void edit(Event event) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Event existingEvent = (Event) session.get(Event.class, event.getId());

        existingEvent.setTitle(event.getTitle());
        existingEvent.setOrganizer(event.getOrganizer());
        existingEvent.setStartDate(event.getStartDate());
        existingEvent.setEndDate(event.getEndDate());
        existingEvent.setPlace(event.getPlace());
        existingEvent.setParticipants(event.getParticipants());
        existingEvent.setDescription(event.getDescription());

        session.save(existingEvent);
        transaction.commit();
    }
}
