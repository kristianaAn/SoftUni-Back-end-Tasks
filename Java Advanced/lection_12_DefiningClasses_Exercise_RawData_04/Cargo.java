package lection_12_DefiningClasses_Exercise_RawData_04;

import java.util.Map;

public class Cargo {
    private int weight;
    private String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
