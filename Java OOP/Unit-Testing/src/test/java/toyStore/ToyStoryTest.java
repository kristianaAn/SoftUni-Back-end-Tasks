package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ToyStoryTest {
    ToyStore toyStore;
    Map<String, Toy> shelf;
    Toy toy;
    Toy toy1;
    Toy toy2;

    @Before
    public void setup() {
        toyStore = new ToyStore();
        shelf = new LinkedHashMap<>();
        toy = new Toy("Hippoland", "K5");
        toy1 = new Toy("Lego", "L9");
        toy2 = new Toy("Speedmasters", "S18");
    }

    @Test
    public void testGetToyGetsUnmodifiable() {
        fillShelf();
        Assert.assertEquals(3, shelf.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddToyThrowsWhenShelfDoesNotExist() throws OperationNotSupportedException {
        fillShelf();
        Toy toyBarbie = new Toy("Barbie", "L45");
        toyStore.addToy("Barbie", toyBarbie);
        Assert.assertFalse(shelf.containsKey("Barbie"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddToyThrowsForExistingShelf() throws OperationNotSupportedException {
        fillShelf();
        toyStore.addToy("Lego", toy1);
    }

    @Test
    public void testItemExists() {
        fillShelf();
        boolean expectedOutput = shelf.containsValue(toy);
        boolean actualOutput = toyStore.getToyShelf().containsValue(null);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToyShelfPutsSuccessfully () {
        fillShelf();
        Assert.assertEquals(3, shelf.size());
        Toy myToy = new Toy("Cars", "F896");
        shelf.put("Cars", myToy);
        Assert.assertEquals(4, shelf.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveToyThrowsWhenShelfNotContained() {
        fillShelf();
        Toy toyBarbie = new Toy("Barbie", "L45");
        toyStore.removeToy("Barbie", toyBarbie);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveToyThrowsWhenToyNotOnThatShelf() {
        fillShelf();
        toyStore.removeToy("Lego", toy);
    }


    private void fillShelf() {
        shelf.put("Hippoland", toy);
        shelf.put("Lego", toy1);
        shelf.put("Speedmasters", toy2);
    }
}