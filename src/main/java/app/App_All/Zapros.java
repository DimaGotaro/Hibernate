package app.App_All;

import app.Config.HibConf;
import app.POJO_2.Persona;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Zapros {
    public static void main(String[] args) {
        Session session = HibConf.inner().openSession();
        Transaction transaction = session.beginTransaction();

        Object human = session.get(Persona.class, 2);
        System.out.println(human.toString());

        List list = session.createNativeQuery("select * from persona", Persona.class).list();
        for (Object t :
                list) {
            System.out.println(t.toString());
        }

        transaction.commit();
        session.close();
        HibConf.shutdown();
    }
}
