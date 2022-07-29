package app.App_All;

import app.HibernateUtil;
import app.POJO.Adress;
import app.POJO.Student;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {

        Session session2 = HibernateUtil.getSessionFactory().openSession();

        session2.getTransaction().begin();

        Adress adress = new Adress();
        adress.setStrit("ул. Спортивная");

        Adress adress2 = new Adress();
        adress2.setStrit("ул. Спортивная2");

        Student student =new Student();
        student.setName("Nona");
        student.setAge(55);
//        student.getAdress().add(adress);
//        student.getAdress().add(adress2);

        session2.persist(adress);
        session2.persist(adress2);
        session2.persist(student);

        session2.getTransaction().commit();

        session2.close();
        HibernateUtil.shutdown();
    }
}
