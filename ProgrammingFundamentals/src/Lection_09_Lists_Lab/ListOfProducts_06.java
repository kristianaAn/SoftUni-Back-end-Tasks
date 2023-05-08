package Lection_09_Lists_Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> productsList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String product = scanner.nextLine();
            productsList.add(product);
        }

        Collections.sort(productsList);

        for (int i = 0; i < productsList.size(); i++) {
            System.out.print(i + 1 + ".");
            System.out.println(productsList.get(i));
        }
    }
}
