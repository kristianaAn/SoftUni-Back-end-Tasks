package lection_13_ReflectionAndAnnotation_lab.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class reflection = Reflection.class;

        System.out.println(reflection);
        System.out.println(reflection.getSuperclass().toString());
        Class[] reflectionInterfaces = reflection.getInterfaces();
        Arrays.stream(reflectionInterfaces).forEach(System.out::println);
        Object instance = reflection.getDeclaredConstructor().newInstance();
        System.out.println(instance);

    }
}
