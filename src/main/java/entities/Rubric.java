package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * Created by Andrii on 10/23/2015.
 */

//Maybe I should do this class as enum
@Entity
@Table(name = "Rubric")
public class Rubric {
    @Id
    @GeneratedValue
    @Column(name = "id_rubric")
    private int Id;
    @Column(name = "type_of_rubric")
    private String typeOfRubric;

    public Rubric(String typeOfRubric) {
        this.typeOfRubric = typeOfRubric;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTypeOfRubric() {
        return typeOfRubric;
    }

    public void setTypeOfRubric(String typeOfRubric) {
        this.typeOfRubric = typeOfRubric;
    }
}
