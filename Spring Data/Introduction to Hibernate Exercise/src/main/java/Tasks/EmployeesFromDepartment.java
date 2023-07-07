package Tasks;

import connection.EMCall;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManager em = EMCall.callEM();

        List<Employee> resultList = em.createQuery("FROM Employee WHERE department.name = :depName ORDER BY salary ASC, id ASC", Employee.class)
                .setParameter("depName", "Research and Development").getResultList();

        resultList.forEach(employee -> System.out.printf("%s %s from %s - $%.2f%n",
                employee.getFirstName(), employee.getLastName(), employee.getDepartment().getName(), employee.getSalary()));

        em.close();
    }
}
