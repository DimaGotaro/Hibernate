package app.POJO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int age;
    @OneToMany
    @JoinTable(name = "CATALOG_2", joinColumns = @JoinColumn(name = "ID_STUDENT"),
            inverseJoinColumns = @JoinColumn(name = "ID_ADRESS"))
    private List<Adress> adress = new ArrayList<Adress>();

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
