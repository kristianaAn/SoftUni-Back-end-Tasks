package viceCity.models.guns;

public class Pistol extends BaseGun {
    public final static int BULLETS_PER_SHOOT_COUNT = 1;
    public final static int PISTOL_BULLET_PER_BARREL = 10;
    public final static int PISTOL_TOTAL_BULLETS = 100;

    public Pistol(String name) {
        super(name, PISTOL_BULLET_PER_BARREL, PISTOL_TOTAL_BULLETS);
    }

    @Override
    public int fire() {

        if (getBulletsPerBarrel() > 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_PER_SHOOT_COUNT);
        } else if (getBulletsPerBarrel() <= 0 && getTotalBullets() > 0) {
            setBulletsPerBarrel(PISTOL_BULLET_PER_BARREL);
            setTotalBullets(getTotalBullets() - PISTOL_BULLET_PER_BARREL);
        }

        return BULLETS_PER_SHOOT_COUNT;
    }
}
