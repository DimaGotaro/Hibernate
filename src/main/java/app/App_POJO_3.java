package app;

import app.POJO_3.Client;
import app.POJO_3.Human;
import app.POJO_3.Usr;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App_POJO_3 {
    public static void main(String[] args) {

        Human human = new Human("Mark", 47);
        Usr usr = new Usr("Tom", 39, "bakkardi");
        Client client = new Client("Bob", 26, 2000);

        Session session = HibConf.inner(new ArrayList<>(Arrays.asList(Human.class, Usr.class, Client.class)))
                .openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(human);
        session.persist(usr);
        session.persist(client);

        transaction.commit();
        session.close();
        HibConf.inner(new ArrayList<>(Arrays.asList(Human.class, Usr.class, Client.class))).close();
    }
    public static List<Object> addClass() {
        return new ArrayList<>(Arrays.asList(Human.class, Usr.class, Client.class));
    }
}
