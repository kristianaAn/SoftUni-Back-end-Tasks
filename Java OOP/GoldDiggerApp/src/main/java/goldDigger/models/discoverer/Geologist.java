package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer {

    public final static int INITIAL_ENERGY_UNITS = 100;

    public Geologist(String name) {
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
