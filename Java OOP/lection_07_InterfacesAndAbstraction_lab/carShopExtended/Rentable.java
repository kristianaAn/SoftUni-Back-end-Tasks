package lection_07_InterfacesAndAbstraction_lab.carShopExtended;

public interface Rentable extends Car {
    public Integer getMinRentDay();
    public Double getPricePerDay();
}
