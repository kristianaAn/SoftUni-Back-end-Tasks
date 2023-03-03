package lection_13_Generics_lab.ArrayCreator;

import lection_13_Generics_lab.ArrayCreator.ArrayCreator;

public class Main {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        ArrayCreator.create(7, "n");
        ArrayCreator.create(Integer.class, 5, 0);

    }
}
