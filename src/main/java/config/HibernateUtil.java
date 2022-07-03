package config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

// класс для инициализации
public class HibernateUtil {

    // создание сессии
    private static final SessionFactory sessionFactory = initSessionFactory();

    // статическая иниц, статич переменная вызывает статич метод, до начала работы main
    private static SessionFactory initSessionFactory() {
        try {
            return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new ExceptionInInitializerError(throwable);
        }
    }

    // вызываем сессию
    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) { // если вдруг пустой
            initSessionFactory();
        }

        return sessionFactory;
    }

    // закрываем сессию
    public static void shutdown() {
        getSessionFactory().close();
    }
}
