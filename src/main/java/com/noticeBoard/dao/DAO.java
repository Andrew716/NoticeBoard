package com.noticeBoard.dao;

import java.util.List;
import java.util.logging.Logger;
import com.noticeBoard.entities.Announcement;
import com.noticeBoard.entities.Person;
import com.noticeBoard.entities.Rubric;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

/**
 * Created by Andrii on 10/23/2015.
 */
@Repository("com.noticeBoard.dao")
public class DAO {

    private final static Logger LOGGER = Logger.getLogger("Info logging");
    @Resource
    protected static SessionFactory sessionFactory;

    public void addAnnouncement(Announcement announcement) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(announcement);
        LOGGER.info("Announcement was saved successfully");
    }

    public void updateAnnouncement(Announcement announcement) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(announcement);
        LOGGER.info("Announcement was updated successfully");
    }

    public void deleteAnnouncement(Announcement announcement) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(announcement);
        LOGGER.info("Announcement was deleted successfully");
    }

    public List<Announcement> getAnnouncementsByRubric(Rubric rubric) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Announcement> announcementList = session.createQuery("from Rubric ").list();
        return announcementList;
    }

    public void addPerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
        LOGGER.info("Person was saved successfully");
    }

    public void deletePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(id);
        LOGGER.info("Person was deleted successfully");
    }

    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
        LOGGER.info("Person was updated successfully");
    }

    public List<Announcement> getAnnouncements(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Announcement> announcementList = session.createQuery("from Person").list();
        return announcementList;
    }

    public Person getPersonByLogin(String login) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.get(Person.class, login);
        return person;
    }

    public Person getPersonbyId(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.get(Person.class, id);
        return person;
    }
}
