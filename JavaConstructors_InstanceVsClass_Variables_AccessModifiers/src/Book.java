public class Book {
    public String ISBN;
    protected String title;
    private String author;

    //Constracter
    public Book(String ISBN, String title, String author) {

        this.ISBN=ISBN;
        this.title=title;
        this.author=author;
    }


    //  public method to access cgpa
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author=author;
    }
}

class Ebook extends Book{
    public Ebook( String ISBN,String title,String author){
        super(ISBN,title,author);
    }


    // Display Details
    public void displayDetails() {
        System.out.println("ISBN Number: " + ISBN);
        System.out.println("Title: " + title);

    }

    public static void main(String[] args) {
        Ebook b=new Ebook("123-234-4","Envoirement Development","jhon Weak");
        b.displayDetails();
        System.out.println("Author : "+b.getAuthor());
    }
}
