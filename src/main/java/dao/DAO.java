package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import entities.Announcement;
import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Andrii on 10/23/2015.
 */
public class DAO {

    private static Logger LOGGER = Logger.getLogger("Info logging");
    private SessionFactory sessionFactory;

    public static Connection getConnection(){
        Connection connection = null;
        try {
            InitialContext initialContext = new InitialContext();
            DataSource source = (DataSource) initialContext.lookup("java:/comp/env/NoticeBoardDB");
            connection = source.getConnection();
        }catch (NamingException e){
            LOGGER.info(e.getExplanation());
        }
        catch (SQLException e){
            LOGGER.info(e.getMessage());
        }
        LOGGER.info("DataSource has been created");
        return connection;
    }

    //TODO
    public void createAnnouncement(){
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("INSERT INTO Announcement(VALUES()) ");
    }

    public void deleteAnnouncement(Announcement announcement){
        Session session = sessionFactory.getCurrentSession();
        session.delete(announcement);
    }

    public void updateAnnouncement(Announcement announcement){
        Session session = sessionFactory.getCurrentSession();
        session.update(announcement);
    }

    public List<Announcement> getAnnoucement(Person person){
        return person.getAnnouncements();
    }
    //TODO
}
