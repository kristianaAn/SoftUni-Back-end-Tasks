package opinionPoll_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++) {
            String eachPerson = scanner.nextLine();
            String name = eachPerson.split(" ")[0];
            int age = Integer.parseInt(eachPerson.split(" ")[1]);

            if (age > 30) {
                Person person = new Person(name, age);
                System.out.println(person.getName() + " - " + person.getAge());
            }
        }
    }
}
