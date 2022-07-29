package app.POJO_3;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
//@DiscriminatorValue(value = "CLIENT_TYPE")
public class Client  extends Human {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    @Column
    private BigDecimal balance;
    public Client(String name, int age, BigDecimal balance) {
        super(name, age);
        this.balance = balance;
    }
}
