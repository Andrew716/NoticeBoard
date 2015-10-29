package dao;

import entities.Announcement;
import entities.Rubric;
import org.hibernate.Session;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Andrii on 10/29/2015.
 */
public class AnnouncementDAO extends DAO implements AnnouncementDAOInt {

    private static final Logger LOGGER = Logger.getLogger("Info logging");

    @Override
    public void addAnnouncement(Announcement announcement) {
        Session session = super.sessionFactory.getCurrentSession();
        session.persist(announcement);
        LOGGER.info("Announcement was saved successfully");
    }

    @Override
    public void updateAnnouncement(Announcement announcement) {
        Session session = super.sessionFactory.getCurrentSession();
        session.update(announcement);
        LOGGER.info("Announcement was updated successfully");
    }

    @Override
    public void deleteAnnouncement(Announcement announcement) {
        Session session = super.sessionFactory.getCurrentSession();
        session.delete(announcement);
        LOGGER.info("Announcement was deleted successfully");
    }

    @Override
    public List<Announcement> getAnnouncementsByRubric(Rubric rubric) {
        Session session = super.sessionFactory.getCurrentSession();
        List<Announcement> announcementList = session.createQuery("from Rubric ").list();
        return announcementList;
    }
}
