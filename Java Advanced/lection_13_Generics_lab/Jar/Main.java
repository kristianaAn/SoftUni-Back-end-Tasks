package lection_13_Generics_lab.Jar;


import lection_13_Generics_lab.Jar.Jar;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();

        jar.add(5);
        jar.add(8);
        jar.add(11);

        jar.remove();
        System.out.println(jar.remove());
    }
}
