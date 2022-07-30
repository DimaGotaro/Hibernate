package app.App_All;

import app.Config.HibConf;
import app.POJO.Adress;
import app.POJO.Student;
import app.POJO_2.Location;
import app.POJO_2.Persona;
import app.POJO_3.Human;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class Zapros {
    public static void main(String[] args) {
        Session session = HibConf.inner().openSession();
        Transaction transaction = session.beginTransaction();

        Object human = session.get(Persona.class, 2);
        System.out.println(human.toString());

        List<Location> list = session.createNativeQuery("select * from location", Location.class).list();
        for (Object t :
                list) {
            System.out.println(t.toString());
        }

        List<Student> list2 = session.createNativeQuery("select * from student", Student.class).list();
        for (Student t :
                list2) {
            System.out.println(t.toString());
            for (Adress r :
                    t.getAdress()) {
                System.out.println(r.toString());
            }
        }

        List<Human> list3 = session.createNativeQuery("select * from human", Human.class).list();
        for (Human t :
                list3) {
            System.out.println(t.toString());
        }

        List<Location> list4 = session.createNativeQuery("select * from location", Location.class)
                .list();
        for (Iterator iterator = list4.iterator(); iterator.hasNext();) {
            Location location = (Location) iterator.next();
            System.out.println(location.toString());
        }

        transaction.commit();
        session.close();
        HibConf.shutdown();
    }
}
