package lection_15_ExceptionsAndErrorHandling;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        a();
        System.out.println("Continue...");
    }

    private static void a () {
        try {
            b();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    private static void b() {
        System.out.println("B");
        c();
    }

    private static void c() {
        int[] arr = new int[5];
        int a = arr[1000];
        System.out.println("C");
    }
}
