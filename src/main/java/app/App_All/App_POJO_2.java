package app.App_All;

import app.Config.HibConf;
import app.POJO_2.Location;
import app.POJO_2.Persona;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App_POJO_2 {
    public static void main(String[] args) {

        Location location = new Location();
        location.setLoc("Minsk2");

        Persona persona = new Persona();
        persona.setName("Maik2");
        persona.setAge(35);

        persona.setLocation(location);
        location.setPersona(persona);

        Session session = HibConf.inner().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(location);
        session.persist(persona);

        transaction.commit();
        session.close();
        HibConf.shutdown();
    }
}
