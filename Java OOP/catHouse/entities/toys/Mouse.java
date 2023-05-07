package catHouse.entities.toys;

public class Mouse extends BaseToy{

    public static final int SOFTNESS = 5;
    public static final int PRICE = 15;

    public Mouse() {
        super(SOFTNESS, PRICE);
    }

    @Override
    public int getSoftness() {
        return SOFTNESS;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}
