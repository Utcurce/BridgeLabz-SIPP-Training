public class Course {
    String courseName;
    int duration;
    double fee;
  public static String instituteName="Default name";

    Course(String courseName,int duration,double fee){
      this.courseName=courseName;
      this.duration=duration;
      this.fee=fee;
    }

    void  displayCourseDetails(){
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " Months");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute Name: " + instituteName);
    }
    public static void updateInstituteName(String newName){
        instituteName=newName;
    }

    public static void main(String[] args) {
          Course.updateInstituteName("GLA ");
          Course c1=new Course("java",4,2000);
          Course c2=new Course("Python",6,4200);
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
        System.out.println();

    }
}
