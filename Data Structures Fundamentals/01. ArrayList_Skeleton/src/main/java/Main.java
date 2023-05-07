import implementations.ArrayList;
import interfaces.List;

public class Main {
    public static void main(String[] args) {
        List<String> nums = new ArrayList<>();

        for (int i = 0; i < 99; i++) {
            nums.add(String.valueOf(i));
        }

        System.out.println(nums.get(0));
        System.out.println(nums.get(1));
        System.out.println(nums.indexOf(String.valueOf(73)));
    }
}
