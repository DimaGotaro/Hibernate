package app;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibConf2 {

    public static SessionFactory inner(List<Object> list) {
        Configuration configuration = new Configuration()
                .configure();
        for (Object o :
                list) {
            configuration.addAnnotatedClass((Class) o);
        }
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(registryBuilder.build());
    }
}
