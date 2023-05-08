package articles;

public class Articles1 {

    private String title;
    private String content;
    private String author;

    public Articles1(String title, String content, String author) {
        //нов обект
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public void editContent(String newContent) {
        this.content = newContent;
    }

    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void rename(String newTitle) {
        this.title = newTitle;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.content + ": " + this.author;
    }
}
