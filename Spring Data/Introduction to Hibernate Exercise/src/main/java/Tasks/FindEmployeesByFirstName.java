package Tasks;

import connection.EMCall;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class FindEmployeesByFirstName {
    public static void main(String[] args) {
        EntityManager em = EMCall.callEM();
        Scanner scanner = new Scanner(System.in);

        String inputPattern = scanner.nextLine();

        em.getTransaction().begin();

        List<Employee> resultList = em.createQuery("FROM Employee WHERE firstName LIKE CONCAT(:pattern, '%') ", Employee.class)
                .setParameter("pattern", inputPattern)
                .getResultList();

        resultList.forEach(Employee::printEmployeeData);

        em.getTransaction().commit();
        em.close();
    }
}
