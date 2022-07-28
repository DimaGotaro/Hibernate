package app;

import app.POJO.Adress;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {

        Session session2 = HibernateUtil.getSessionFactory().openSession();

        session2.getTransaction().begin();

        extracted(session2, "ул. Спортивная");

        session2.getTransaction().commit();

        session2.close();
        HibernateUtil.shutdown();
    }

    private static void extracted(Session session2, String d) {
        Adress adress = new Adress();
        adress.setAdress(d);

        session2.persist(adress);
    }
}
