package app.POJO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String strit;
//    @ManyToOne
//    @JoinTable(name = "CATALOG", joinColumns = @JoinColumn(name = "ID_ADRESS"),
//            inverseJoinColumns = @JoinColumn(name = "ID_STUDENT"))
//    private Student student;

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", strit='" + strit + '\'' +
                '}';
    }
}