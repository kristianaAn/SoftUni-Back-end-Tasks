package lection_11_DefiningClasses_lab_CarInfo_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String brand = input[0];
            String model = input[1];
            int horsePower = Integer.parseInt(input[2]);

            Car car = new Car(brand, model, horsePower);

            carsList.add(car);
        }

        carsList.forEach(car -> System.out.println(car.carInfo()));

    }
}
