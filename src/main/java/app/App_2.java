package app;

import app.POJO.Adress;
import app.POJO.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
        adress.setAdress("ул. Свиридова");
        session.persist(adress);
        Adress adres2 = new Adress();
        adres2.setAdress("ул. Мильча");
        session.persist(adres2);

        Student student = new Student();
        student.setName("Karl");
        student.setAge(48);
        student.getAdress().add(adress);
        student.getAdress().add(adres2);
        session.persist(student);

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
//        session.close(); // закрыть транзакцию
//        HibernateUtil.shutdown(Dog.class);
    }

}
