package aggregation;

public class TextBook {

    private String title;
    private String author;
    private String publisher;

    public TextBook(String textTitle, String auth, String pub) {
        this.title = textTitle;
        this.author = auth;
        this.publisher = pub;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String toString() {
        return "TextBook: " + title + " by " + author + ", Publisher: " + publisher;
    }
}
