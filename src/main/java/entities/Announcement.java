package entities;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import java.util.Date;
/**
 * Created by Andrii on 10/23/2015.
 */
@Entity
@Table(name = "Announcement")
public class Announcement {
    @Id
    @GeneratedValue
    @Column(name = "id_announcement")
    private int IdAnnouncement;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author")
    private Person announcements;
    @Column(name = "date_of_publication")
    private Date dateOfPublication;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubric")
    private Rubric rubric;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;

    public Announcement(String text, String title, Date dateOfPublication) {
        this.text = text;
        this.title = title;
        this.dateOfPublication = dateOfPublication;
    }

    public int getIdAnnouncement() {
        return IdAnnouncement;
    }

    public void setIdAnnouncement(int idAnnouncement) {
        IdAnnouncement = idAnnouncement;
    }

    public Person getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Person announcements) {
        this.announcements = announcements;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public Rubric getRubric() {
        return rubric;
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
