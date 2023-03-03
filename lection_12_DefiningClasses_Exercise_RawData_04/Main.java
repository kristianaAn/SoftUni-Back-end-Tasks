package lection_12_DefiningClasses_Exercise_RawData_04;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Car> carSet = new LinkedHashSet<>();

        for (int i = 1; i <= n; i++) {
            //{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType}
            // {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire3Age} {Tire4Pressure} {Tire4Age}
            // 13

            String[] inputData = scanner.nextLine().split("\\s+");
            String model = inputData[0];
            Engine engine = new Engine(Integer.parseInt(inputData[1]),
                    Integer.parseInt(inputData[2]));
            Cargo cargo = new Cargo(Integer.parseInt(inputData[3]), inputData[4]);

            double tire1Pressure = Double.parseDouble(inputData[5]);
            int tire1Age = Integer.parseInt(inputData[6]);
            double tire2Pressure = Double.parseDouble(inputData[7]);
            int tire2age = Integer.parseInt(inputData[8]);
            double tire3Pressure = Double.parseDouble(inputData[9]);
            int tire3age = Integer.parseInt(inputData[10]);
            double tire4Pressure = Double.parseDouble(inputData[11]);
            int tire4Age = Integer.parseInt(inputData[12]);

            Tire tires = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2age,
                    tire3Pressure, tire3age, tire4Pressure, tire4Age);


            Car car = new Car(model, engine, cargo, tires);
            carSet.add(car);
        }

        String command = scanner.nextLine();

        List<Car> filteredCars = new ArrayList<>();
        if (command.equals("fragile")) {

            filteredCars = carSet
                    .stream()
                    .filter(car -> car.getCargo().getType().equals("fragile"))
                    .collect(Collectors.toList());

            filteredCars = filteredCars
                    .stream()
                    .filter(car -> car.getTire().calculateAveragePressure() < 1)
                            .collect(Collectors.toList());


            filteredCars.forEach(entry -> System.out.println(entry.getModel()));

        } else if (command.equals("flamable")) {

            filteredCars = carSet
                    .stream()
                    .filter(entry -> entry.getCargo().getType().equals("flamable"))
                    .collect(Collectors.toList());

            filteredCars = filteredCars
                    .stream()
                    .filter(car -> car.getEngine().getPower() > 250)
                    .collect(Collectors.toList());

            filteredCars.forEach(car -> System.out.println(car.getModel()));
        }
    }
}
