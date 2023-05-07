package catHouse.entities.toys;

public class Ball extends BaseToy{

    public static final int SOFTNESS = 1;
    public static final int PRICE = 10;

    public Ball() {
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
