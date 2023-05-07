package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Spaceship spaceship;
    private Astronaut astronaut;
    private Astronaut astronaut1;
    private Astronaut astronaut2;

    @Before
    public void setup() {
        spaceship = new Spaceship("SpaceX", 4);
        astronaut = new Astronaut("Pesho", 60);
        astronaut1 = new Astronaut("Gosho", 40);
        astronaut2 = new Astronaut("Tosho", 80);
    }

    @Test
    public void testConstructorCreatesCorrectly() {
        fillSpaceship();
    }

    private void fillSpaceship() {
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
    }

    @Test
    public void testGetCountGetCorrect() {
        Assert.assertEquals(0, spaceship.getCount());
        fillSpaceship();
        Assert.assertEquals(3, spaceship.getCount());
    }

    @Test
    public void testGetNameGetsCorrect() {
        Assert.assertEquals("SpaceX", spaceship.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddWhenAstronautExistsThrows() {
        fillSpaceship();
        spaceship.add(astronaut1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddThrowsWhenCapacityReached() {
        fillSpaceship();
        Astronaut astronaut3 = new Astronaut("Andrey", 10);
        Astronaut astronaut4 = new Astronaut("Drago", 10);
        spaceship.add(astronaut3);
        spaceship.add(astronaut4);
    }

    @Test
    public void testRemoveDeletesCorrectly() {
        fillSpaceship();
        Assert.assertEquals(3, spaceship.getCount());
        spaceship.remove("Pesho");
        Assert.assertEquals(2, spaceship.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsForInvalidCapacity() {
        Spaceship spaceship = new Spaceship("MySpaceship", -1);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameThrowsForNullName() {
        Spaceship mySpaceship = new Spaceship(null, 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameThrowsForEmptyName() {
        Spaceship mySpaceship = new Spaceship("  ", 7);
    }
}
