package app.POJO_3;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // стратегия наследования
// SINGLE_TABLE - создаёт одну таблицу с родительским классом и наследниками
// TABLE_PER_CLASS - создаёт отдельные таблицы для всех классов соединяя поля родительских классов и наследников,
// при создании таблицы класса наследника
// JOINED - создаёт отдельные таблицы для всех классов
// для наследников - с полями только самого класса, без полей род класса
// для род класса - с полями род класса и значениями, которые были переданы в поля род класса классами наследниками
//@DiscriminatorColumn(
//        name = "HUMAN_TYPE", // имя DTYPE в таблице human(названия классов наследников)
//        discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue(value = "HUMAN_TYPE") // название класса в колонке DTYPE
public class Human extends Model {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // при TABLE_PER_CLASS GenerationType не должен быть IDENTITY,
    // способ генерации id распространяется на классы наследники
    // наследникам не нужно прописывать id
//    private int id;
    @Column
    private String name;
    @Column
    private int age;
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
