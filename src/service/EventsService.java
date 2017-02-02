package service;

import model.Event;
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
@Service("eventsService")
@Transactional
public class EventsService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public EventsService() {
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
     * Retrieves all events
     *
     * @return a list of events
     */
    public List<Event> getAll() {

        // Retrieve session from Hibernate
        Session session = sessionFactory.openSession(); //.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Event");

        //session.close();
        // Retrieve all
        return query.list();
    }

    /**
     * Retrieves a single event
     */
    public Event get(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Event event = (Event) session.get(Event.class, id);

        return event;
    }

    /**
     * Adds a new event
     */
    public void add(Event event) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        // Save
        session.save(event);
        trans.commit();
    }

    /**
     * Deletes an existing event
     *
     * @param id the id of the existing event
     */
    public void delete(Integer id) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Event event = (Event) session.get(Event.class, id);

        // Delete
        session.delete(event);
    }

    /**
     * Edits an existing person
     */
    public void edit(Event event) {
        //logger.debug("Editing existing event"); !!!!!!!!!!!!!!!!!

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing event via id
        Event existingEvent = (Event) session.get(Event.class, event.getId());

        // Assign updated values to this event
        existingEvent.setTitle(event.getTitle());
        existingEvent.setOrganizer(event.getOrganizer());
        existingEvent.setStartDate(event.getStartDate());
        existingEvent.setEndDate(event.getEndDate());
        existingEvent.setPlace(event.getPlace());
        existingEvent.setParticipants(event.getParticipants());
        existingEvent.setDescription(event.getDescription());

        // Save updates
        session.save(existingEvent);
    }
}
