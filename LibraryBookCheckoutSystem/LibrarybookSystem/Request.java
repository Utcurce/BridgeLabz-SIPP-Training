public class Request<T extends Book> {
    private String user;
    private T book;

    public Request(String user, T book) {
        this.user = user;
        this.book = book;
    }

    public String getUser() {
        return user;
    }

    public T getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Request by " + user + " for " + book.toString();
    }
}