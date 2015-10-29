package service;

import dao.PersonDAO;
import entities.Announcement;
import entities.Person;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Andrii on 10/29/2015.
 */
@Service
public class PersonService implements PersonServiceInt {

    private PersonDAO personDAO;

    public void setPersonDAO(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        this.personDAO.addPerson(person);
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        this.personDAO.deletePerson(person);
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        this.personDAO.updatePerson(person);
    }

    @Override
    @Transactional
    public List<Announcement> getAnnouncements(Person person) {
        return this.personDAO.getAnnouncements(person);
    }

    @Override
    @Transactional
    public Person getPersonByLogin(String login) {
        return this.personDAO.getPersonByLogin(login);
    }
}
