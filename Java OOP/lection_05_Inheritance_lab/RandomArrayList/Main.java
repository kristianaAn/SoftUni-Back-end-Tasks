package lection_05_Inheritance_lab.RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add("aaa");
        randomArrayList.add("bbb");
        randomArrayList.add("ccc");
        randomArrayList.add("ddd");

        System.out.println(randomArrayList.getRandomElement());
    }
}
