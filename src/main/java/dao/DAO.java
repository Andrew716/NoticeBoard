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

    private final static Logger LOGGER = Logger.getLogger("Info logging");
    private static Connection connection;
    protected static SessionFactory sessionFactory;

    static {
        LOGGER.info("Configuration is in process");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
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
}
