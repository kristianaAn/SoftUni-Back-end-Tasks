import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory em = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em1 = em.createEntityManager();
    }
}

