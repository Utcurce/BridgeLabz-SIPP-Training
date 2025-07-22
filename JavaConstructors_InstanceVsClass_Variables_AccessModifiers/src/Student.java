import java.sql.SQLOutput;

class Student {
     public int rollNumber;
     protected String name;
     private double CGPA;

     //Constracter
     public Student(int rollNumber, String name, double CGPA) {

         this.rollNumber = rollNumber;
         this.name = name;
         this.CGPA = CGPA;
     }

     //  public method to access cgpa
     public double getCGPA() {
         return CGPA;
     }

     public void setCGPA(double CGPA) {
         this.CGPA = CGPA;
     }
}

 class PostgraduateStudent extends Student{
    public PostgraduateStudent(  int rollNumber,String name,double CGPA){
        super(rollNumber,name,CGPA);
    }


     // Display Details
     public void displayDetails() {
         System.out.println("Roll Number: " + rollNumber);
         System.out.println("Name: " + name);

     }

     public static void main(String[] args) {
         PostgraduateStudent pg=new PostgraduateStudent(122,"akash",6.7);
         pg.displayDetails();
         System.out.println("CGPA: "+pg.getCGPA());
     }


 }







