package articles_2;

public class Articles_2_0 {

    private String title;
    private String content;
    private String author;

    public Articles_2_0(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString () {

        return this.title + " - " + this.content + ": " + this.author;
    }
}


