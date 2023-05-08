package vehicleCatalogue;

public class VehicleCatalogue {

    private String typeOfVehicle;
    private String model;
    private String color;
    private int horsepower;

    public VehicleCatalogue (String typeOfVehicle, String model, String color, int horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    //Type: {typeOfVehicle}
    //Model: {modelOfVehicle}
    //Color: {colorOfVehicle}
    //Horsepower: {horsepowerOfVehicle}
    @Override
    public String toString() {
        String formattedType = "";
        if (this.typeOfVehicle.equals("car")) {
            formattedType = "Car";
        } else if (this.typeOfVehicle.equals("truck")) {
            formattedType = "Truck";
        }
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", formattedType, this.model, this.color, this.horsepower);
    }
}
