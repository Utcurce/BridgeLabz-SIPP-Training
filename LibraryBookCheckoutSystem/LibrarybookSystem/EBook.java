public class EBook implements Book {
    private String title;
    private String author;
    private String format;

    public EBook(String title, String author, String format) {
        this.title = title;
        this.author = author;
        this.format = format;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "EBook [Title=" + title + ", Author=" + author + ", Format=" + format + "]";
    }
}