package lection_11_DefiningClasses_lab_CarConstructors_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String brand = input[0];
            Car car = null;

            if (input.length > 1) {
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);
                car = new Car(brand, model, horsePower);
            } else {
                car = new Car(brand);

            }
            carList.add(car);
        }

        carList.forEach(car -> System.out.println(car.toString()));
    }
}
