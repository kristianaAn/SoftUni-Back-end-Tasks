package lection_13_ReflectionAndAnnotation_lab.Annotation;

public class Main {
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor();
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl) {
        System.out.println("The author is ");
    }

}
