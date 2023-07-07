package Tasks;

import connection.EMCall;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class GetEmployeesWithProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = EMCall.callEM();

        int inputId = Integer.parseInt(scanner.nextLine());

        em.getTransaction().begin();

        em.createQuery("FROM Employee WHERE id = :input", Employee.class)
                .setParameter("input", inputId)
                .getSingleResult().printEmployeesWithProjects();

        em.getTransaction().commit();
        em.close();
    }
}
