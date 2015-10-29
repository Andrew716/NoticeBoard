package service;

import entities.Announcement;
import entities.Person;

import java.util.List;

/**
 * Created by Andrii on 10/29/2015.
 */
public interface PersonServiceInt {
    public void addPerson(Person person);
    public void deletePerson(Person person);
    public void updatePerson(Person person);
    public List<Announcement> getAnnouncements(Person person);
    public Person getPersonByLogin(String login);
}
