package Tasks;

import connection.EMCall;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = EMCall.callEM();

        em.getTransaction().begin();

        String inputNameToSearch = scanner.nextLine();
        List<Employee> employeeList = em.createQuery("FROM Employee ", Employee.class).getResultList();

        boolean match = employeeList.stream()
                .anyMatch(employee -> (employee.getFirstName() + " " + employee.getLastName()).equals(inputNameToSearch));

        em.getTransaction().commit();
        System.out.println(match);

        em.close();
    }
}
