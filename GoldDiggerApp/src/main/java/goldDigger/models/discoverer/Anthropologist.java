package goldDigger.models.discoverer;

public class Anthropologist extends BaseDiscoverer {

    public static final int INITIAL_ENERGY_UNITS = 40;

    public Anthropologist(String name) {
        super(name, INITIAL_ENERGY_UNITS);
    }

    @Override
    public void dig() {
        if (getEnergy() > 0) {
            setEnergy(getEnergy() - 15);
        }
        if (getEnergy() < 0) {
            setEnergy(0);
        }
    }
}
