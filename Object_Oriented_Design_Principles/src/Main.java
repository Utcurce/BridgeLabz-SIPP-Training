import java.util.ArrayList;

class  Book{
    private String title;
    private  String author;

    public  Book(String title,String author){
        this.author=author;
        this.title=title;
    }
      public  void displayBookInfo(){
        System.out.println("Title: "+title+"  Author: "+author);
    }

}


class Library {
    private   ArrayList<Book> books;
    private  String name;

   public Library(String name){
        this.name=name;
        books=new ArrayList<>();

    }
    void addBook(Book book){
      books.add(book);
    }
    public  void  displayLibrary(){
        System.out.println("Library:"+name);
        for(Book book:books){
            book.displayBookInfo();
        }
        System.out.println();

    }


}
public  class  Main{

    public static void main(String[] args) {
        Book book1=new Book("Java ","poas");
        Book book2=new Book("python ","jhon");
        Book book3=new Book("C++","rechard");

        Library city=new Library("City Library");
        Library collage=new Library("Collage Library");

        city.addBook(book1);
        city.addBook(book2);

        collage.addBook(book2);
        collage.addBook(book3);

        city.displayLibrary();
        collage.displayLibrary();

    }
}


