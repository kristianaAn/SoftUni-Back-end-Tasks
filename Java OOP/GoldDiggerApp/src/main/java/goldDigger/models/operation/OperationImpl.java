package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;


public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        Collection<String> exhibits = spot.getExhibits();

        for (Discoverer discoverer : discoverers) {
             while (discoverer.canDig() && !exhibits.isEmpty()) {
                 discoverer.dig();
                 String name = exhibits.iterator().next();
                 exhibits.remove(name);
                 discoverer.getMuseum().getExhibits().add(name);
             }
        }

    }
}
