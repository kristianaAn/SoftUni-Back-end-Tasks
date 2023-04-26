package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.*;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        BaseDiscoverer discoverer;

        switch (kind) {
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }

        discovererRepository.add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED, discoverer.getClass().getSimpleName(), discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        spotRepository.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discovererToRemove = discovererRepository.getCollection().stream()
                .filter(discoverer -> discoverer.getName().equals(discovererName))
                .findFirst().orElse(null);

        if (discovererToRemove == null) {
            String message = String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName);
            throw new IllegalArgumentException(message);
        }

        discovererRepository.remove(discovererToRemove);
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> appropriateDiscoverersList = discovererRepository.getCollection().stream()
                .filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());

        if (appropriateDiscoverersList.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot spot = spotRepository.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spot, appropriateDiscoverersList);
        long count = appropriateDiscoverersList.stream().filter(discoverer -> discoverer.getEnergy() == 0).count();
        return String.format(ConstantMessages.INSPECT_SPOT, spotName, count);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format(ConstantMessages.FINAL_SPOT_INSPECT, spotRepository.getCollection().size()));
        sb.append(System.lineSeparator())
                .append(ConstantMessages.FINAL_DISCOVERER_INFO)
                .append(System.lineSeparator());

        for (Discoverer discoverer : discovererRepository.getCollection()) {
            sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME, discoverer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, extractExhibits(discoverer)))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    private String extractExhibits(Discoverer discoverer) {
        String result;
        if (discoverer.getMuseum().getExhibits().isEmpty()) {
            result = "None";
        } else {
            result = String.join(", ", discoverer.getMuseum().getExhibits());
        }
        return result;
    }
}
