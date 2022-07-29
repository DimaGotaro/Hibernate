package app;

import app.POJO.Adress;
import app.POJO.Adress2;
import app.POJO.Student;
import app.POJO.Student2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App_2 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Adress.class);

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        SessionFactory sessionFactory = configuration.buildSessionFactory(registryBuilder.build());

        // Сессия
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Adress adress = new Adress();
        Adress adress2 = new Adress();
        adress.setStrit("ул. Свиридова2");
        adress2.setStrit("ул. Мильча2");
//        Adress adress = session.get(Adress.class, 1);
//        Adress adress2 = session.get(Adress.class, 2);

        Student student = new Student();
        student.setName("Karl4");
        student.setAge(12);

//        student.getAdress().add(adress);
//        student.getAdress().add(adress2);

//        student.setAdress(new ArrayList<>(Arrays.asList(adress, adress2)));
        adress.setStudent(student);
        adress2.setStudent(student);

        session.persist(student);
        session.persist(adress2);
        session.persist(adress);

        transaction.commit();
        session.close();
        sessionFactory.close();

        // через аннотации
//        Session session = HibernateUtil.initSessionFactory(Dog.class).openSession();
//
//        // открываем транзакцию
//        session.getTransaction().begin();
//
//        Dog dog = new Dog();
//        dog.setAnimal(new Animal("Varcs", "Maryupol"));
//        session.persist(dog);
//
////        Student student = new Student();
////        student.setName("Tom");
////        student.setAge(66);
//
//        session.getTransaction().commit(); // сохранить изменения
//
//        session.close(); // закрыть сессию
//        HibernateUtil.shutdown(Dog.class);
    }
}
class App_3 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure()
                .addAnnotatedClass(Student2.class)
                .addAnnotatedClass(Adress2.class);

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        SessionFactory sessionFactory = configuration.buildSessionFactory(registryBuilder.build());

        // Сессия
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Adress2 adress = new Adress2();
        adress.setStrit("ул. Свиридова2");
        Adress2 adres2 = new Adress2();
        adres2.setStrit("ул. Мильча2");
        Adress2 adres3 = new Adress2();
        adres3.setStrit("ул. Борисенко2");

        Student2 student = new Student2();
        student.setName("Karl3");
        student.setAge(23);
//        student.getAdress2().add(session.get(Adress2.class, 1));
//        student.getAdress2().add(session.get(Adress2.class, 2));

        Student2 student2 = new Student2();
        student2.setName("Bad");
        student2.setAge(45);
//        student.getAdress2().add(session.get(Adress2.class, 1));
//        student.getAdress2().add(session.get(Adress2.class, 2));

        student.setAdress2(new ArrayList<>(Arrays.asList(adress, adres2)));
        student2.setAdress2(new ArrayList<>(Arrays.asList(adres3, adres2)));
//        adress.setStudent2(new ArrayList<>(List.of(student)));
//        adres2.setStudent2(new ArrayList<>(Arrays.asList(student, student2)));
//        adres3.setStudent2(new ArrayList<>(List.of(student2)));

        session.persist(adress);
        session.persist(adres2);
        session.persist(adres3);
        session.persist(student);
        session.persist(student2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
