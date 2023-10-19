package src;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import src.models.Staff;

public class HibernateUtil {

    @Getter
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Staff.class)
                .buildSessionFactory();
    }

    public static void close() {
       sessionFactory.close();
    }
}
