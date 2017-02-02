package service;

import model.Member;
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
@Service("memberService")
@Transactional
public class MemberService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public MemberService() {
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
     * Retrieves all members
     *
     * @return a list of members
     */
    public List<Member> getAll() {

        // Retrieve session from Hibernate
        Session session = sessionFactory.openSession(); //.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Member");

        // Retrieve all
        return query.list();
    }

    /**
     * Retrieves a single member
     */
    public Member get(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Member member = (Member) session.get(Member.class, id);

        return member;
    }

    /**
     * Adds a new member
     */
    public void add(Member member) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        Transaction trans = session.beginTransaction();

        // Save
        session.save(member);

        trans.commit();
    }

    /**
     * Deletes an existing member
     *
     * @param id the id of the existing member
     */
    public void delete(Integer id) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Member member = (Member) session.get(Member.class, id);

        // Delete
        session.delete(member);
    }

    /**
     * Edits an existing person
     */
    public void edit(Member member) {
        //logger.debug("Editing existing member"); !!!!!!!!!!!!!!!!!

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing member via id
        Member existingMember = (Member) session.get(Member.class, member.getEmail());

        // Assign updated values to this member
        existingMember.setName(member.getName());
        existingMember.setPhone(member.getPhone());
        existingMember.setCountry(member.getCountry());

        // Save updates
        session.save(existingMember);
    }
}
