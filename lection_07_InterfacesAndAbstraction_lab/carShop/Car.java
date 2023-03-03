package lection_07_InterfacesAndAbstraction_lab.carShop;

public interface Car {
     Integer TIRES = 4;

     public String getModel();
     public String getColor();

     public Integer getHorsePower();

     public String countryProduced();

}
