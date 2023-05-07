package lection_14_ReflectionAndAnnotation_Exercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt newBlackBox = constructor.newInstance();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Field hiddenField = clazz.getDeclaredField("innerValue");
        hiddenField.setAccessible(true);

        while (!input.equals("END")) {
            String[] inputData = input.split("_");
            String method = inputData[0];
            int value = Integer.parseInt(inputData[1]);

            Method currentMethod = clazz.getDeclaredMethod(method, int.class);
            currentMethod.setAccessible(true);
            currentMethod.invoke(newBlackBox, value);
            System.out.println(hiddenField.get(newBlackBox));

            input = scanner.nextLine();
        }

    }
}
