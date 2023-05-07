package viceCity.models.guns;

public class Rifle extends BaseGun{
    public final static int BULLETS_PER_SHOOT_COUNT = 5;
    public final static int RIFLE_BULLET_PER_BARREL = 50;
    public final static int RIFLE_TOTAL_BULLETS = 500;

    public Rifle(String name) {
        super(name, RIFLE_BULLET_PER_BARREL, RIFLE_TOTAL_BULLETS);
    }

    @Override
    public int fire() {

        if (getBulletsPerBarrel() > 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_PER_SHOOT_COUNT);
        } else if (getBulletsPerBarrel() <= 0 && getTotalBullets() > 0) {
            setBulletsPerBarrel(RIFLE_BULLET_PER_BARREL);
            setTotalBullets(getTotalBullets() - RIFLE_BULLET_PER_BARREL);
        }

        return BULLETS_PER_SHOOT_COUNT;
    }
}
