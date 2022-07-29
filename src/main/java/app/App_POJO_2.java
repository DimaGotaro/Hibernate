package app;

import app.POJO_2.Location;
import app.POJO_2.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

public class App_POJO_2 {
    public static void main(String[] args) {

        Location location = new Location();
        location.setLoc("Minsk2");

        Persona persona = new Persona();
        persona.setName("Maik2");
        persona.setAge(35);

        persona.setLocation(location);
        location.setPersona(persona);

//        Configuration configuration = new Configuration()
//                .configure()
//                .addAnnotatedClass(Location.class)
//                .addAnnotatedClass(Persona.class);
//        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration.buildSessionFactory(registryBuilder.build());
        Session session = HibConf.inner(new ArrayList<>(Arrays.asList(Location.class, Persona.class)))
                .openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(location);
        session.persist(persona);

        transaction.commit();
        session.close();
        HibConf.inner(new ArrayList<>(Arrays.asList(Location.class, Persona.class))).close();
    }
}
