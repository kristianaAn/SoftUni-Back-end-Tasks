package lection_04_Encapsulation_Exercise.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] people = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");

        Map<String, Person> peopleList = new LinkedHashMap<>();
        Map<String, Product> productsList = new LinkedHashMap<>();

        if (extractingPeopleList(people, peopleList)) return;
        if (extractingProductsList(products, productsList)) return;

        String commands = scanner.nextLine();
        while (!commands.equals("END")) {
            String personName = commands.split("\\s+")[0];
            String product = commands.split("\\s+")[1];

            Person buyer = peopleList.get(personName);
            Product currentProduct = productsList.get(product);

            try {
                buyer.buyProduct(currentProduct);
                System.out.printf("%s bought %s%n", buyer.getName(), currentProduct.getName());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            commands = scanner.nextLine();
        }

        for (Person person : peopleList.values()) {
            if (person.getProducts().size() == 0) {
                System.out.printf("%s - Nothing bought%n", person.getName());
            } else {
                System.out.println(person.toString());
            }
        }

    }

    private static boolean extractingProductsList(String[] products, Map<String, Product> productsList) {
        for (int i = 0; i < products.length; i++) {
            String[] productData = products[i].split("=");
            String productName = productData[0];
            double cost = Double.parseDouble(productData[1]);

            try {
                Product product = new Product(productName, cost);
                productsList.put(productName, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }

        }
        return false;
    }

    private static boolean extractingPeopleList(String[] people, Map<String, Person> peopleList) {
        for (int i = 0; i < people.length; i++) {
            String[] personData = people[i].split("=");
            String personName = personData[0];
            double personMoney = Double.parseDouble(personData[1]);
            try {
                Person person = new Person(personName, personMoney);
                peopleList.put(personName, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }
}
