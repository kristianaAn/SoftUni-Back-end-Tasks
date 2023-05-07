package lection_07_InterfacesAndAbstraction_lab.Ferrari;

public class Ferrari extends Car {
    private String driverName;
    private String model = "488-Spider";


    public Ferrari(String driverName) {
        super(driverName);
        setModel(model);
    }
}
