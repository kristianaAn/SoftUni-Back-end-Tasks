package lection_13_Generics_lab.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("aa", "bb");
        System.out.println(scale.getHeavier());

        Scale<Integer> scaleInt = new Scale<>(5, 5);
        System.out.println(scaleInt.getHeavier());
    }
}
