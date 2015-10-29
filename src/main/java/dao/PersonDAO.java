package dao;

import entities.Announcement;
import entities.Person;
import org.hibernate.Session;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Andrii on 10/29/2015.
 */
public class PersonDAO extends DAO implements PersonDAOInt {

    private static final Logger LOGGER = Logger.getLogger("Info logging");

    @Override
    public void addPerson(Person person) {
        Session session = super.sessionFactory.getCurrentSession();
        session.persist(person);
        LOGGER.info("Person was saved successfully");
    }

    @Override
    public void deletePerson(Person person) {
        Session session = super.sessionFactory.getCurrentSession();
        session.delete(person);
        LOGGER.info("Person was deleted successfully");
    }

    @Override
    public void updatePerson(Person person) {
        Session session = super.sessionFactory.getCurrentSession();
        session.update(person);
        LOGGER.info("Person was updated successfully");
    }

    @Override
    public List<Announcement> getAnnouncements(Person person) {
        Session session = super.sessionFactory.getCurrentSession();
        List<Announcement> announcementList = session.createQuery("from Person").list();
        return announcementList;
    }

    @Override
    public Person getPersonByLogin(String login) {
        Session session = super.sessionFactory.getCurrentSession();
        Person person = (Person) session.get(Person.class, login);
        return person;
    }
}
