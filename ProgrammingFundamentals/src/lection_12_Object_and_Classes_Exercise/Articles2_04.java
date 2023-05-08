package lection_12_Object_and_Classes_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2_04 {

    static class articles2 {
        private String title;
        private String content;
        private String author;


        public articles2 (String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString () {
            return this.title + " - " + this.content + ": " + this.author;

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        //title", "content", "author
        List<articles2> articlesList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String articleSpecificsInput = scanner.nextLine();
            String title = articleSpecificsInput.split(", ")[0];
            String content = articleSpecificsInput.split(", ")[1];
            String author = articleSpecificsInput.split(", ")[2];

            articles2 articles_2_0 = new articles2(title, content, author);
            articlesList.add(articles_2_0);
        }

        String finalInput = scanner.nextLine();


        for (articles2 article : articlesList) {
            System.out.println(article.toString());
        }
    }
}
