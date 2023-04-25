package catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private final static int INITIAL_KG = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, INITIAL_KG, price);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 3);
    }
}
