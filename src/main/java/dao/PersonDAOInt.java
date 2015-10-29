package dao;

import entities.Person;
import entities.Announcement;

import java.util.List;

/**
 * Created by Andrii on 10/29/2015.
 */
public interface PersonDAOInt {
    public void addPerson(Person person);
    public void deletePerson(Person person);
    public void updatePerson(Person person);
    public List<Announcement> getAnnouncements(Person person);
    public Person getPersonByLogin(String login);
}
