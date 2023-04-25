package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {
    private Garage garage;
    private Car car;
    private Car car2;
    private Car car3;

    @Before
    public void setup() {
        garage = new Garage();
        car = new Car("Audi", 300, 10000.50);
        car2 = new Car("Porsche", 320, 50000.50);
        car3 = new Car("BMW", 280, 15000.50);
    }

    @Test
    public void testAddCarAndGetCountSuccessfully() {
        garage.addCar(car);
        Assert.assertEquals(1, garage.getCount());
        garage.addCar(car2);
        Assert.assertEquals(2, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarThrows() {
        garage.addCar(null);
    }

    @Test
    public void testGetCarsUnmodifiable() {
        garage.addCar(car);
        List<Car> carsInList = new ArrayList<>();
        carsInList = garage.getCars();
        Assert.assertEquals(1, carsInList.size());
        Assert.assertEquals(car.getBrand(), carsInList.get(0).getBrand());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveSuccessfully() {
        garage.addCar(car);
        garage.addCar(car2);
        garage.addCar(car3);
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(290);

        Assert.assertEquals(2, allCarsWithMaxSpeedAbove.size());
        Assert.assertEquals("Audi", allCarsWithMaxSpeedAbove.get(0).getBrand());
        Assert.assertEquals("Porsche", allCarsWithMaxSpeedAbove.get(1).getBrand());
    }

    @Test
    public void testGetMostExpensiveCarSuccessfully() {
        garage.addCar(car);
        garage.addCar(car2);
        garage.addCar(car3);

        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();

        Assert.assertEquals("Porsche", theMostExpensiveCar.getBrand());
        Assert.assertEquals(320, theMostExpensiveCar.getMaxSpeed());
    }


    @Test
    public void testFindAllCarsByBrand() {
        Car car1 = new Car("Porsche", 350, 100000.99);
        garage.addCar(car);
        garage.addCar(car1);
        garage.addCar(car2);

        List<Car> allCarsByBrand = garage.findAllCarsByBrand("Porsche");

        Assert.assertEquals(2, allCarsByBrand.size());
    }
}