package Tasks;

import connection.EMCall;
import entities.Address;

import javax.persistence.EntityManager;

public class AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManager em = EMCall.callEM();

        em.getTransaction().begin();

        em.createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10).getResultList().forEach(address -> System.out.println(address.townDataToString()));

        em.getTransaction().commit();
        em.close();
    }
}
