package app.POJO_3;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
//@DiscriminatorValue(value = "USER_TYPE")
public class Usr extends Human {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    @Column
    private String firstname;

    public Usr(String name, int age, String firstname) {
        super(name, age);
        this.firstname = firstname;
    }
}
