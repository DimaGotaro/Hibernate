package app.App_All;

import app.Config.HibConf;
import app.POJO_3.Client;
import app.POJO_3.Human;
import app.POJO_3.Usr;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class App_POJO_3 {
    public static void main(String[] args) {
        Human human = new Human("Mark", 47);
        Usr usr = new Usr("Tom", 39, "bakkardi");
        Client client = new Client("Bob", 26, BigDecimal.valueOf(2000));

        Session session = HibConf.inner().openSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.persist(human);
            session.persist(usr);
            session.persist(client);

            transaction.commit();
        }
        catch (Exception f) {
            session.getTransaction().rollback();
            f.printStackTrace();
        }
        finally {
            session.close();
            HibConf.shutdown();
        }
    }
}
