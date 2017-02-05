package service;

import model.Project;
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
 * Hibernate connection to project table.
 * Created by Nataliia Kozoriz on 22/01/2017.
 */
@Service("projectService")
@Transactional
public class ProjectService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(ProjectService.class);

    public ProjectService() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("ExceptionInInitializerError", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retrieves all projects
     *
     * @return a list of projects
     */
    public List<Project> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Project");
        return query.list();
    }

    /**
     * Retrieves a single project
     */
    public Project get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Project project = (Project) session.get(Project.class, id);
        transaction.commit();
        return project;
    }

    /**
     * Adds a new project
     */
    public void add(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(project);
        transaction.commit();
    }

    /**
     * Deletes an existing project
     *
     * @param id the id of the existing project
     */
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Project project = (Project) session.get(Project.class, id);
        session.delete(project);
        transaction.commit();
    }

    /**
     * Edits an existing person
     */
    public void edit(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Project existingProject = (Project) session.get(Project.class, project.getId());

        // Assign updated values to this project
        existingProject.setName(project.getName());
        existingProject.setCategory(project.getCategory());
        existingProject.setStartDate(project.getStartDate());
        existingProject.setEndDate(project.getEndDate());
        existingProject.setOrganizer(project.getOrganizer());
        existingProject.setDescription(project.getDescription());

        session.save(existingProject);
        transaction.commit();
    }
}
