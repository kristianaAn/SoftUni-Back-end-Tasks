package lection_12_DefiningClasses_Exercise_CarSalesman_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        List<Car> carsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            //{Model} {Power} {Displacement} {Efficiency}

            String[] engineInput = scanner.nextLine().split("\\s+");
            String model = engineInput[0];
            int power = Integer.parseInt(engineInput[1]);
            Engine engine = null;

            if (engineInput.length == 2) {
                engine = new Engine(model, power, "n/a", "n/a");

            } else if (engineInput.length == 3) {
                String input2 = engineInput[2];

                if (Character.isUpperCase(input2.charAt(0))) {           //check to see if it is a letter for Efficiency
                    engine = new Engine(model, power, "n/a", input2);
                } else {
                    engine = new Engine(model, power, input2, "n/a");
                }

            } else if (engineInput.length == 4) {
                String displacement = engineInput[2];
                String efficiency = engineInput[3];

                engine = new Engine(model, power, displacement, efficiency);
            }

            engineList.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= m; i++) {
            //{Model} {Engine} {Weight} {Color}

            String[] carInput = scanner.nextLine().split("\\s+");
            String model = carInput[0];
            String eng = carInput[1];
            Engine engine = engineList.stream().filter(engine1 -> engine1.getModel().equals(eng)).findFirst().get();
            Car car = null;

            if (carInput.length == 2) {
                car = new Car(model, engine, "n/a", "n/a");

            } else if (carInput.length == 3) {

                String input2 = carInput[2];

                if (Character.isDigit(input2.charAt(0))) {
                    car = new Car(model, engine, input2, "n/a");
                } else {
                    car = new Car(model, engine, "n/a", input2);
                }

            } else if (carInput.length == 4) {
                String weight = carInput[2];
                String color = carInput[3];

                car = new Car(model, engine, weight, color);

            }

            carsList.add(car);
        }

        carsList.forEach(car -> System.out.println(car.toString()));
    }
}
