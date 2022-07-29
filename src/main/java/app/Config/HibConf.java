package app.Config;

import app.POJO_2.Location;
import app.POJO_2.Persona;
import app.POJO_3.Client;
import app.POJO_3.Human;
import app.POJO_3.Usr;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibConf {
    private static final SessionFactory sessionFactory = initSessionFactory();

    public static SessionFactory initSessionFactory() {
        try {
            Configuration configuration = new Configuration()
                    .configure()
                    .addAnnotatedClass(Human.class)
                    .addAnnotatedClass(Usr.class)
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(Location.class)
                    .addAnnotatedClass(Persona.class);
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            return configuration.buildSessionFactory(registryBuilder.build());
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public static SessionFactory inner() {
        if (sessionFactory == null) {
            return initSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown() {
        initSessionFactory().close();
    }
}
