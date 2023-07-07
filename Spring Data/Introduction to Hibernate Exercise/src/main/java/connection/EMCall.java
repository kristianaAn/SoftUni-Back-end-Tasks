package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMCall {

    public static EntityManager callEM() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("soft_uni");

        return emf.createEntityManager();
    }
}

