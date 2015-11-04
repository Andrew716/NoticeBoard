package com.noticeBoard.service;

import com.noticeBoard.dao.DAO;
import com.noticeBoard.entities.Announcement;
import com.noticeBoard.entities.Person;
import com.noticeBoard.entities.Rubric;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrii on 11/2/2015.
 */
@Service
public class ModelService {

    private DAO dao;

    public void setDao(DAO dao){
        this.dao = dao;
    }

    @Transactional
    public void addAnnouncement(Announcement announcement) {
        this.dao.addAnnouncement(announcement);
    }

    @Transactional
    public void updateAnnouncement(Announcement announcement) {
        this.dao.updateAnnouncement(announcement);
    }

    @Transactional
    public void deleteAnnouncement(Announcement announcement) {
        this.dao.deleteAnnouncement(announcement);
    }

    @Transactional
    public List<Announcement> getAnnouncementsByRubric(Rubric rubric) {
        return this.dao.getAnnouncementsByRubric(rubric);
    }

    @Transactional
    public void addPerson(Person person) {
        this.dao.addPerson(person);
    }

    @Transactional
    public void deletePerson(int id) {
        this.dao.deletePerson(id);
    }

    @Transactional
    public void updatePerson(Person person) {
        this.dao.updatePerson(person);
    }

    @Transactional
    public List<Announcement> getAnnouncements(Person person) {
        return this.dao.getAnnouncements(person);
    }

    @Transactional
    public Person getPersonByLogin(String login) {
        return this.dao.getPersonByLogin(login);
    }

    @Transactional
    public Person getPersonById(int id){
        return this.dao.getPersonbyId(id);
    }
}
