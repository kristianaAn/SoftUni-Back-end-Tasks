package additionalExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String regex = "(?<barcode>(@[#]+)([A-Z][A-Za-z0-9]{4,}[A-Z])\\2)";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 1; i <= n; i++) {
            String inputBarcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(inputBarcode);
            boolean isAMatch = false;

            StringBuilder productGroup = new StringBuilder();

            while (matcher.find()) {
                String barcode = matcher.group("barcode");
                isAMatch = true;

                for (int j = 0; j < barcode.length(); j++) {
                    char currentSymbol = barcode.charAt(j);
                    if (Character.isDigit(currentSymbol)) {
                        productGroup.append(currentSymbol);
                    }
                }

                if (productGroup.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + productGroup);
                }

            }

            if (!isAMatch) {
                System.out.println("Invalid barcode");
            }
        }
    }
}
