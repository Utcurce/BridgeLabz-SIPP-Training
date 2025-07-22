 class Book {
    String title;
    int publicationYear;

    Book(String title,int publicationYear){
        this.title=title;
        this.publicationYear=publicationYear;
    }

    void showInfo(){
        System.out.println("Title: "+title+"Publication Year: "+publicationYear);
    }

}
class author extends Book{
    String name;
    String bio;

    author(String title,int publicationYear,String name,String bio){
        super(title,publicationYear);
        this.name=name;
        this.bio=bio;
    }
    @Override
   void  showInfo(){
        super.showInfo();
        System.out.println("Name: "+name+ "Bio: "+bio);
    }
}
class LibraryManagement{
    public static void main(String[] args) {
        Book b1=new author("four sward",1996,"koshokai","a sward in the war");
        Book b2=new author("a flying mask",2002,"hotokasi","a beautiful mask ");

        b1.showInfo();
        System.out.println();

        b2.showInfo();
    }
}
