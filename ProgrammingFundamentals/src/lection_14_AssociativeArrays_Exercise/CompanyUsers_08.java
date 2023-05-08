package lection_14_AssociativeArrays_Exercise;

import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputCommand = scanner.nextLine();

        Map<String, List<String>> employeesAndIDs = new LinkedHashMap<>();
        while (!inputCommand.equals("End")) {
            String companyName = inputCommand.split(" -> ")[0];
            String employeeID = inputCommand.split(" -> ")[1];

            if (!employeesAndIDs.containsKey(companyName)) {
                employeesAndIDs.put(companyName, new ArrayList<>());
                employeesAndIDs.get(companyName).add(employeeID);
            } else {
                if (!employeesAndIDs.get(companyName).contains(employeeID)) {
                    employeesAndIDs.get(companyName).add(employeeID);
                }
            }
            inputCommand = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : employeesAndIDs.entrySet()) {
            System.out.println(entry.getKey());
            for (String ID : entry.getValue()) {
                System.out.printf("-- %s%n", ID);
            }
        }

    }
}
