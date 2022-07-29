package app.POJO_3;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass // id будет передано наследуемым entity
@Data
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
}
