package Tasks;

import connection.EMCall;
import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class AddingAddressUpdatingEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastNameInput = scanner.nextLine();
        EntityManager em = EMCall.callEM();

        em.getTransaction().begin();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        em.persist(newAddress);

        List<Employee> resultList = em.createQuery("FROM Employee WHERE lastName = :lName ", Employee.class)
                .setParameter("lName", lastNameInput)
                .getResultList();

        resultList.forEach(employee -> employee.setAddress(newAddress));

        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
