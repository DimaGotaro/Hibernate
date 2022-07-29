package app.App_All;

import app.Config.HibernateUtil;
import app.entity.Animal;
import app.entity.Dog;
import app.entity.UserData;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // получаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();

        // открываем транзакцию
        session.getTransaction().begin();

        UserData userData = new UserData();
        userData.setUsername("Jonson1");
        userData.setEmail("jon2@tut,by");
        userData.setPassword("ksjfbg2");

        session.persist(userData); // фиксирует изменения(транзакция завершается)

        session.getTransaction().commit(); // сохранить изменения

        session.close(); // закрыть транзакцию
        HibernateUtil.shutdown();
    }
}
class Update {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // открываем транзакцию
        session.getTransaction().begin();

        UserData userData2 = session.get(UserData.class, 2);
        userData2.setPassword("vagabund2");
        session.merge(userData2);


        session.getTransaction().commit(); // сохранить изменения

        session.close(); // закрыть транзакцию
        HibernateUtil.shutdown();
    }
}
class Delete {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // открываем транзакцию
        session.getTransaction().begin();

        UserData userData2 = session.get(UserData.class, 4);
        session.remove(userData2);

        session.getTransaction().commit(); // сохранить изменения

        session.close(); // закрыть транзакцию
        HibernateUtil.shutdown();
    }
}
class All {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // открываем транзакцию
        session.getTransaction().begin();

        List<UserData> userDatalist = session.createQuery("select p from UserData p", UserData.class)
                .getResultList();
        for (UserData f :
                userDatalist) {
            System.out.println(f.getUsername());
        }

        session.getTransaction().commit(); // сохранить изменения

        session.close(); // закрыть транзакцию
        HibernateUtil.shutdown();
    }
}
class All_dog {
    public static void main(String[] args) {
        Session session = HibernateUtil.initSessionFactory().openSession();

        // открываем транзакцию
        session.getTransaction().begin();

        Dog dog = new Dog();
        dog.setAnimal(new Animal("Lary", "Minsk"));
        session.persist(dog);

        session.getTransaction().commit(); // сохранить изменения

        session.close(); // закрыть транзакцию
        HibernateUtil.shutdown();
    }
}
