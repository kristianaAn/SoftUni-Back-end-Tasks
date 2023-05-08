package lection_18_RegularExpressions_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalIncome = 0;

        String regex = "%(?<customer>[A-Z][a-z]*)%([^|$%.]*)<(?<product>\\w+)>([^|$%.]*)\\|(?<count>\\d+)\\|([^|$%.]*?)(?<price>\\d+.?\\d+)\\$";
        Pattern pattern = Pattern.compile(regex);

        while (!input.equals("end of shift")) {
            double totalProductPrice = 0;
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String customerName = matcher.group("customer");
                String productType = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                totalProductPrice = count * price;
                totalIncome += totalProductPrice;

                System.out.printf("%s: %s - %.2f%n", customerName, productType, totalProductPrice);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
