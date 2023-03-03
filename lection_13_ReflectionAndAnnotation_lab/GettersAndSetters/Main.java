package lection_13_ReflectionAndAnnotation_lab.GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class reflection = Reflection.class;
        Method[] declaredMethods = reflection.getDeclaredMethods();
        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted((lm, rm) -> lm.getName().compareTo(rm.getName()))
                .forEach(method -> System.out.printf("%s will return %s%n", method.getName(),method.getReturnType()));

        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .sorted((l,r) -> l.getName().compareTo(r.getName()))
                .forEach(method -> System.out.printf("%s will set field of class %s%n", method.getName(), method.getParameterTypes()[0].getName()));
    }
}
