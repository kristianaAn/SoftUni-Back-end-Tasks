package articles_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        //title", "content", "author
        List<Articles_2_0> articlesList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String articleSpecificsInput = scanner.nextLine();
            String title = articleSpecificsInput.split(", ")[0];
            String content = articleSpecificsInput.split(", ")[1];
            String author = articleSpecificsInput.split(", ")[2];

            Articles_2_0 articles_2_0 = new Articles_2_0(title, content, author);
            articlesList.add(articles_2_0);
        }

        String finalInput = scanner.nextLine();


        for (Articles_2_0 article : articlesList) {
            System.out.println(article.toString());
        }
    }
}
