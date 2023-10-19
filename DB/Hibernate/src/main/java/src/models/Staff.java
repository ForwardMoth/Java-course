package src.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private Integer salary;

    @Override
    public String toString() {
        return "id: " + id + ", firstName: " + firstName + ", secondName: " + secondName + ", lastName: " + lastName +
                ", position: " + position + ", salary: " + salary;
    }
}
