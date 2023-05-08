package articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputArticle = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String title = inputArticle.split(", ")[0];
        String content = inputArticle.split(", ")[1];
        String author = inputArticle.split(", ")[2];

        Articles1 articles = new Articles1(title, content, author);

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String command = input.split(": ")[0];
            String inputForUpdate = input.split(": ")[1];

            switch (command) {
                case "Edit":
                    articles.editContent(inputForUpdate);
                    break;
                case "ChangeAuthor":
                    articles.changeAuthor(inputForUpdate);
                    break;
                case "Rename":
                    articles.rename(inputForUpdate);
                    break;
            }
        }

        System.out.println(articles.toString());
    }
}
