package lection_02_WorkingWithAbstraction_Exercise.CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (Ranks ranks : Ranks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", ranks.ordinal(), ranks.name());
        }
    }
}
