package service;

import entities.Announcement;
import entities.Rubric;
import java.util.List;

/**
 * Created by Andrii on 10/29/2015.
 */
public interface AnnouncementServiceInt {
    public void addAnnouncement(Announcement announcement);
    public void updateAnnouncement(Announcement announcement);
    public void deleteAnnouncement(Announcement announcement);
    public List<Announcement> getAnnouncementsByRubric(Rubric rubric);
}
