package service;

import model.Project;
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
@Service("projectService")
@Transactional
public class ProjectService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public ProjectService() {
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
     * Retrieves all projects
     *
     * @return a list of projects
     */
    public List<Project> getAll() {

        // Retrieve session from Hibernate
        Session session = sessionFactory.openSession(); //.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Project");

        // Retrieve all
        return query.list();
    }

    /**
     * Retrieves a single project
     */
    public Project get(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Project project = (Project) session.get(Project.class, id);

        return project;
    }

    /**
     * Adds a new project
     */
    public void add(Project project) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        Transaction trans = session.beginTransaction();

        // Save
        session.save(project);

        trans.commit();
    }

    /**
     * Deletes an existing project
     *
     * @param id the id of the existing project
     */
    public void delete(Integer id) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Project project = (Project) session.get(Project.class, id);

        // Delete
        session.delete(project);
    }

    /**
     * Edits an existing person
     */
    public void edit(Project project) {
        //logger.debug("Editing existing project"); !!!!!!!!!!!!!!!!!

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing project via id
        Project existingProject = (Project) session.get(Project.class, project.getId());

        // Assign updated values to this project
        existingProject.setName(project.getName());
        existingProject.setCategory(project.getCategory());
        existingProject.setStartDate(project.getStartDate());
        existingProject.setEndDate(project.getEndDate());
        existingProject.setOrganizer(project.getOrganizer());
        existingProject.setDescription(project.getDescription());

        // Save updates
        session.save(existingProject);
    }
}
