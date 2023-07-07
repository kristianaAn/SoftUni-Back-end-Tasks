package Tasks;

import connection.EMCall;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {

        EntityManager em = EMCall.callEM();
        em.getTransaction().begin();
        List<Town> allTowns = getTowns(em);

        for (Town currentTown : allTowns) {
            if (currentTown.getName().length() > 5) {
                em.detach(currentTown);
            } else {
                currentTown.setName(currentTown.getName().toUpperCase());
                em.persist(currentTown);
            }
        }

        em.getTransaction().commit();

        em.close();

    }

    private static List<Town> getTowns(EntityManager em) {
        return em.createQuery("FROM Town ", Town.class).getResultList();
    }
}

