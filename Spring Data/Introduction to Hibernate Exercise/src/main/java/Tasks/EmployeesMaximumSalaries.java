package Tasks;

import connection.EMCall;
import javax.persistence.EntityManager;

public class EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManager em = EMCall.callEM();

        em.getTransaction().begin();

        em.createQuery("SELECT department.name, MAX(salary) FROM Employee " +
                        "GROUP BY department.name HAVING MAX(salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                        .forEach(objects -> System.out.println(objects[0] + " " + objects[1]));

        em.getTransaction().commit();
        em.close();
    }
}
