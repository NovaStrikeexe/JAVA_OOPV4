package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static EntityManagerFactory factory;

    private EntityManagerFactoryUtil() {}

    public static EntityManager geteEntityManager() {
        if (factory == null)
            factory = Persistence.createEntityManagerFactory("Wepons" );
        return factory.createEntityManager();
    }
}

