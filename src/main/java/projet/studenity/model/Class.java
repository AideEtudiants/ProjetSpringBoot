package projet.studenity.model;

import javax.persistence.*;

@Entity
@Table(name="CLASS")
public class Class {
    @Id
    @Column(name="ID_CLASS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @Column(name="start_date")
    private String startDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return startDate;
    }

    public void setDate(String startDate) {
        this.startDate = startDate;
    }
}
