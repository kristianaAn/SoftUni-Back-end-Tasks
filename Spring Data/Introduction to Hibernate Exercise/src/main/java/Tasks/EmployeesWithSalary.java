package Tasks;

import connection.EMCall;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeesWithSalary {
    public static void main(String[] args) {
        EntityManager em = EMCall.callEM();

        em.getTransaction().begin();

        List<Employee> resultList = em.createQuery("FROM Employee WHERE salary > 50000", Employee.class).getResultList();

        resultList.forEach(employee -> System.out.println(employee.getFirstName()));

        em.getTransaction().commit();
        em.close();
    }
}
