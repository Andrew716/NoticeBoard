package service;

import dao.AnnouncementDAO;
import entities.Announcement;
import entities.Rubric;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrii on 10/29/2015.
 */
@Service
public class AnnouncementService implements AnnouncementServiceInt {

    private AnnouncementDAO announcementDAO;

    public void setAnnouncementDAO(AnnouncementDAO announcementDAO){
        this.announcementDAO = announcementDAO;
    }

    @Override
    @Transactional
    public void addAnnouncement(Announcement announcement) {
        this.announcementDAO.addAnnouncement(announcement);
    }

    @Override
    @Transactional
    public void updateAnnouncement(Announcement announcement) {
        this.announcementDAO.updateAnnouncement(announcement);
    }

    @Override
    @Transactional
    public void deleteAnnouncement(Announcement announcement) {
        this.announcementDAO.deleteAnnouncement(announcement);
    }

    @Override
    @Transactional
    public List<Announcement> getAnnouncementsByRubric(Rubric rubric) {
        return this.announcementDAO.getAnnouncementsByRubric(rubric);
    }
}
