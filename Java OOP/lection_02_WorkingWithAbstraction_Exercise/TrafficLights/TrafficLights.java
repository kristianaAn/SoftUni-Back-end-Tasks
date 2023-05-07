package lection_02_WorkingWithAbstraction_Exercise.TrafficLights;

public class TrafficLights {
    private Color color;

    public TrafficLights(Color color) {
        this.color = color;
    }

    public void switchColor() {
        switch (color) {
            case RED:
                color = Color.GREEN;
                break;
            case GREEN:
                color = Color.YELLOW;
                break;
            case YELLOW:
                color = Color.RED;
                break;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
