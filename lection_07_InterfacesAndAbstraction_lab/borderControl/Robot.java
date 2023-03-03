package lection_07_InterfacesAndAbstraction_lab.borderControl;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}
