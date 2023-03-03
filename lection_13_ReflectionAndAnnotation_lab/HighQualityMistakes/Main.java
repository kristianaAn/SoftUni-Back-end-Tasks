package lection_13_ReflectionAndAnnotation_lab.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class reflection = Reflection.class;
        Field[] fields = reflection.getDeclaredFields();
        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Method[] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods).filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .forEach(method -> System.out.printf("%s have to be public!%n", method.getName()));

        Arrays.stream(methods).filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .forEach(method -> System.out.printf("%s have to be private!%n", method.getName()));
    }
}
