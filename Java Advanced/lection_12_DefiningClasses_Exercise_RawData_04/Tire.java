package lection_12_DefiningClasses_Exercise_RawData_04;

import java.util.List;

public class Tire {
    private double tire1pressure;
    private int tire1age;
    private double tire2pressure;
    private int tire2age;
    private double tire3pressure;
    private int tire3age;
    private double tire4pressure;
    private int tire4age;

    public Tire(double tire1pressure, int tire1age, double tire2pressure, int tire2age,
                double tire3pressure, int tire3age, double tire4pressure, int tire4age) {
        this.tire1pressure = tire1pressure;
        this.tire1age = tire1age;
        this.tire2pressure = tire2pressure;
        this.tire2age = tire2age;
        this.tire3pressure = tire3pressure;
        this.tire3age = tire3age;
        this.tire4pressure = tire4pressure;
        this.tire4age = tire4age;
    }

    public double calculateAveragePressure() {
        return (tire1pressure + tire2pressure + tire3pressure + tire4pressure) / 4;
    }

}
