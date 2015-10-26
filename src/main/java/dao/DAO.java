package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.Announcement;
import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Andrii on 10/23/2015.
 */
public class DAO {

    private static Logger LOGGER = Logger.getLogger("Info logging");
    private static Connection connection;
    private static SessionFactory sessionFactory;
    private Session currentSession;
    private Transaction currentTransaction;

    static {
        LOGGER.info("Configuration is in process");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        //StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        sessionFactory = configuration.buildSessionFactory();
    }

    static {
        try {
            InitialContext initialContext = new InitialContext();
            DataSource source = (DataSource) initialContext.lookup("java:/comp/env/NoticeBoard");
            LOGGER.info("source was initialised");
            connection = source.getConnection();
        }catch (NamingException e){
            LOGGER.log(Level.SEVERE, "Connection failed", e);
        }
        catch (SQLException e){
            LOGGER.log(Level.SEVERE, "Connection failed", e);
        }
        LOGGER.info("DataSource has been created");
    }

    public Session openCurrentSession(){
        this.currentSession = sessionFactory.openSession();
        return currentSession;
    }

    public Transaction openCurrentSessionWithTransactional(){
        this.currentSession = sessionFactory.openSession();
        this.currentTransaction = currentSession.beginTransaction();
        return currentTransaction;
    }

    public void closeCurrentSession(){
        currentSession.close();
    }

    public void closeCurrentSessionWithTransactional(){
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Person person){
        getCurrentSession().persist(person);
    }

    public void persist(Announcement announcement){
        getCurrentSession().persist(announcement);
    }

    public void update(Person person){
        getCurrentSession().update(person);
    }

    public void update(Announcement announcement){
        getCurrentSession().update(announcement);
    }

    public void delete(Person person){
        getCurrentSession().delete(person);
    }

    public void delete(Announcement announcement){
        getCurrentSession().delete(announcement);
    }

    public Person findByLogin(String login){
        Person person = (Person) getCurrentSession().get(Person.class, login);
        return person;
    }

    public Announcement findById(int id){
        Announcement announcement = (Announcement) getCurrentSession().get(Announcement.class, id);
        return announcement;
    }

    public List<Announcement> findAllAnnoucement(Person person){
        return person.getAnnouncements();
    }

    public void deleteAllAnnouncement(Person person){
        List<Announcement> announcements = findAllAnnoucement(person);
        for (Announcement announcement : announcements){
            delete(announcement);
        }
    }
}
