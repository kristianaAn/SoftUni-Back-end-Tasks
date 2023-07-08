package Tasks;

import connection.EMCall;
import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    public final static List<Integer> DEPARTMENTS_TO_INCREASE_SALARIES = List.of(1, 2, 4, 11);

    public static void main(String[] args) {
        EntityManager em = EMCall.callEM();

        em.getTransaction().begin();

        List<Employee> resultList = em.createQuery("FROM Employee WHERE department.id IN (:departments)", Employee.class)
                .setParameter("departments", DEPARTMENTS_TO_INCREASE_SALARIES)
                .getResultList();

        resultList
                .forEach(employee -> employee
                        .setSalary(employee.getSalary()
                                .multiply(BigDecimal.valueOf(1.12))));

        em.flush();
        em.getTransaction().commit();
        em.close();

        resultList.forEach(Employee::printEmployeeWithIncreasedSalary);
    }
}
