package lection_02_WorkingWithAbstraction_Exercise.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] signals = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        List<TrafficLights> trafficLightsList = new ArrayList<>();

        for (String signal : signals) {
            TrafficLights trafficLight = new TrafficLights(Color.valueOf(signal));
            trafficLightsList.add(trafficLight);
        }

        for (int i = 0; i < n; i++) {
            for (TrafficLights light : trafficLightsList) {
                light.switchColor();
                System.out.print(light.getColor() + " ");

            }
            System.out.println();
        }


    }
}
