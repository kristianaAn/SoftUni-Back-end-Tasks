package christmasPastryShop.entities.delicacies;

public class Gingerbread extends BaseDelicacy {
    private static final int INITIAL_GINGERBREAD_PORTION = 200;

    public Gingerbread(String name, double price) {
        super(name, INITIAL_GINGERBREAD_PORTION, price);
    }
}
