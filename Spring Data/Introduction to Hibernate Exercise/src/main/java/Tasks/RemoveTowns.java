package Tasks;

import connection.EMCall;
import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveTowns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = EMCall.callEM();

        em.getTransaction().begin();

        String inputTownToDelete = scanner.nextLine();

        Town town = em.createQuery("FROM Town WHERE name = :townName", Town.class)
                .setParameter("townName", inputTownToDelete)
                .getSingleResult();
        Integer townToDeleteID = town.getId();

        List<Address> deletedAddress = em.createQuery("FROM Address WHERE town.id = :townID", Address.class)
                .setParameter("townID", townToDeleteID)
                .getResultList();

        final List<Integer> addressIDsToDelete = deletedAddress.stream().map(Address::getId).collect(Collectors.toList());

        List<Employee> employeeAddressesToDelete = em.createQuery("FROM Employee WHERE address.id IN :addressIdsList", Employee.class)
                .setParameter("addressIdsList", addressIDsToDelete)
                .getResultList();

        deletedAddress.forEach(em::remove);
        employeeAddressesToDelete.forEach(employee -> employee.setAddress(null));
        em.remove(town);
        em.getTransaction().commit();

        if (deletedAddress.size() <= 1) {
            System.out.printf("%d address in %s deleted%n", deletedAddress.size(), inputTownToDelete);
        } else {
            System.out.printf("%d addresses in %s deleted%n", deletedAddress.size(), inputTownToDelete);
        }

        em.close();
        scanner.close();
    }
}
