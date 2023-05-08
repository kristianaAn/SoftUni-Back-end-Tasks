package lection_12_Object_and_Classes_Exercise;

import java.util.*;

public class AdvertisementMessage_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> phrases = new ArrayList<>(Arrays.asList("Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."));
        List<String> events = new ArrayList<>(Arrays.asList("Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"));
        List<String> authors = new ArrayList<>(Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"));
        List<String> cities = new ArrayList<>(Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"));

        Random rndWord = new Random();
        for (int i = 1; i <= n; i++) {
            int randomIndexPhrase = rndWord.nextInt(phrases.size());
            int randomIndexEvent = rndWord.nextInt(events.size());
            int randomIndexAuthor = rndWord.nextInt(authors.size());
            int randomIndexCity = rndWord.nextInt(cities.size());

            String outputText = phrases.get(randomIndexPhrase) + " " + events.get(randomIndexEvent) + " " +
            authors.get(randomIndexAuthor) + " - " + cities.get(randomIndexCity);

            System.out.println(outputText);
        }
    }
}
