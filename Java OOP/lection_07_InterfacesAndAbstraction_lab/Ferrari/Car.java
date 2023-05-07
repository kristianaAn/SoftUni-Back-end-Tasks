package lection_07_InterfacesAndAbstraction_lab.Ferrari;

public class Car implements carInterface{
    private String driverName;
    private String model;

    public Car(String driverName) {
        setDriverName(driverName);
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.model, brakes(), gas(), this.driverName);
    }
}
