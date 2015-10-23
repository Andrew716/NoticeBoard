package service;

import dao.DAO;
import entities.Announcement;
import entities.Person;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Andrii on 10/24/2015.
 */
public class ModelService {

    private DAO dao;

    @Transactional
    public void deleteAnnouncement(Announcement announcement){
        this.dao.deleteAnnouncement(announcement);
    }

    @Transactional
    public void updateAnnouncement(Announcement announcement){
        this.dao.updateAnnouncement(announcement);
    }

    @Transactional
    public List<Announcement> getAnnouncement(Person person){
        return this.dao.getAnnoucement(person);
    }
    //TODO
}
