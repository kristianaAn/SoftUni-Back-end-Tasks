package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class HouseTests {
    House house;
    Cat cat1;
    Cat cat2;
    Cat cat3;
    Cat cat4;
    Collection<Cat> catsList;
    public static final int LOUDHOUSE_CAPACITY = 3;

    @Before
    public void setup() {
        house = new House("LoudHouse", LOUDHOUSE_CAPACITY);
        cat1 = new Cat("Snejko");
        cat2 = new Cat("Topcho");
        cat3 = new Cat("Puhcho");
        cat4 = new Cat("Tom");
        catsList = new ArrayList<>();
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrows() {
        House nullHouse = new House(null, 5);
        House noNameHouse = new House("  ", 10);
    }

    @Test
    public void testSetNameSetsCorrect() {
        Assert.assertEquals("LoudHouse", house.getName());
    }

    @Test
    public void testGetCapacityGetCorrect() {
        Assert.assertEquals(LOUDHOUSE_CAPACITY, house.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityThrows() {
        House house = new House("Kasagrande", -1);
    }

    @Test
    public void testAddCatToListCorrectly() {
        house.addCat(cat1);
        Assert.assertTrue(catsList.size() < house.getCapacity());
        house.addCat(cat2);
        Assert.assertTrue(catsList.size() < house.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddCatToListThrows() {
        fillHouseWithCats();
        house.addCat(cat4);
        Assert.assertEquals(catsList.size(), house.getCapacity());
    }

    @Test
    public void testGetCountSuccessfully() {
        fillHouseWithCats();
        Assert.assertEquals(3, house.getCount());
    }

    private void fillHouseWithCats() {
        house.addCat(cat1);
        house.addCat(cat2);
        house.addCat(cat3);
    }

    @Test
    public void testRemoveCatSuccessfully() {
        fillHouseWithCats();
        Assert.assertEquals(3, house.getCount());
        house.removeCat("Snejko");
        Assert.assertEquals(2, house.getCount());
        house.removeCat("Puhcho");
        Assert.assertEquals(1, house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveCatThrows() {
        fillHouseWithCats();
        house.removeCat("Tom");
    }

    @Test
    public void testCatForSaleReturnsCatCorrectly() {
        fillHouseWithCats();
        Cat catForSale = house.catForSale("Puhcho");
        Assert.assertFalse(catForSale.isHungry());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCatForSaleThrows() {
        fillHouseWithCats();
        house.catForSale("Jerry");
    }

    @Test
    public void testGetStatisticsReturnsCorrect() {
        fillHouseWithCats();
        String statistics = house.statistics();
        Assert.assertEquals( "The cat Snejko, Topcho, Puhcho is in the house LoudHouse!" ,statistics);
    }
}
