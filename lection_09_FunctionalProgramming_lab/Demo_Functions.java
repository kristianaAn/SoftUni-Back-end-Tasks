package lection_09_FunctionalProgramming_lab;

import java.util.Random;
import java.util.Scanner;
import java.util.function.*;

public class Demo_Functions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parser = e -> Integer.parseInt(e);
        Function<String, Integer> parser2 = Integer::parseInt;
        parser.apply("12");
        //gets data and returns data

        Consumer<Integer> printer = e -> System.out.print(e);
        Consumer<Integer> printer2 = System.out::print;
        printer.accept(6);
        //gets data, does not return any type of data

        Supplier<Integer> getRandomInt = () -> new Random().nextInt(51);
        getRandomInt.get();
        //does not get data, returns data of type

        Predicate<Integer> isEven = e -> e % 2 == 0;
        isEven.test(10);
        //boolean

        BiFunction<Integer, Integer, String> sum = (integer, integer2) -> "Sum = " + integer + integer2;

        BiConsumer<String, Integer> printNameAge = (name, age) -> System.out.println(name + " " + age);

        BiPredicate<Integer, Integer> compareNums = (number1, number2) -> number1 > number2;
    }
}
