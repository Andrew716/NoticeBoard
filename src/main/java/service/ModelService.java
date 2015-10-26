package service;

import dao.DAO;
import entities.Announcement;
import entities.Person;
import java.util.List;

/**
 * Created by Andrii on 10/24/2015.
 */
public class ModelService {

    private DAO dao;

    public void persist(Person person){
        getDao().openCurrentSessionWithTransactional();
        getDao().persist(person);
        getDao().closeCurrentSessionWithTransactional();
    }

    public void persist(Announcement announcement){
        getDao().openCurrentSessionWithTransactional();
        getDao().persist(announcement);
        getDao().closeCurrentSessionWithTransactional();
    }

    public void update(Person person){
        getDao().openCurrentSessionWithTransactional();
        getDao().update(person);
        getDao().closeCurrentSessionWithTransactional();
    }

    public void update(Announcement announcement){
        getDao().openCurrentSessionWithTransactional();
        getDao().update(announcement);
        getDao().closeCurrentSessionWithTransactional();
    }

    public void delete(Person person){
        getDao().openCurrentSessionWithTransactional();
        getDao().delete(person);
        getDao().closeCurrentSessionWithTransactional();
    }

    public void delete(Announcement announcement){
        getDao().openCurrentSessionWithTransactional();
        getDao().delete(announcement);
        getDao().closeCurrentSessionWithTransactional();
    }

    public Person findByLogin(String login){
        getDao().openCurrentSessionWithTransactional();
        Person person = getDao().findByLogin(login);
        getDao().closeCurrentSessionWithTransactional();
        return person;
    }

    public List<Announcement> findAnnouncement(Person person){
        getDao().openCurrentSessionWithTransactional();
        List<Announcement> announcementList = getDao().findAllAnnoucement(person);
        getDao().closeCurrentSessionWithTransactional();
        return announcementList;
    }

    public void deleteAllAnnouncement(Person person){
        getDao().openCurrentSessionWithTransactional();
        List<Announcement> announcementList = findAnnouncement(person);
        for (Announcement announcement: announcementList){
            delete(announcement);
        }
    }

    public DAO getDao(){
        return dao;
    }
}
