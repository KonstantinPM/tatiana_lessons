package homework24.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "students")
public class Students {

    @Id
    @Column(name = "id_student", nullable = false)
    private int idStudent;
    @Basic
    @Column(name = "name_surname", nullable = true, length = 255)
    private String nameSurname;

    public Students() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return idStudent == students.idStudent && Objects.equals(nameSurname, students.nameSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, nameSurname);
    }
}
