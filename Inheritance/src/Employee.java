 class Employee {
    String name;
    int id;
    int salary;

    Employee(String name,int id,int salary){
        this.name=name;
        this.id=id;
        this.salary=salary;

    }
    void displayDetails(){
        System.out.println("Name: "+name+" id: "+id+" Salary: "+salary);
    }
}
class Manager extends Employee{
    int teamSize;
    Manager(String name,int id,int salary,int teamSize){
        super(name,id,salary);
        this.teamSize=teamSize;
    }
    @Override
    void displayDetails(){
        System.out.println("Role: manager |Team Size: "+teamSize);
    }

}

 class Developer extends Employee{
     String programmingLanguage;
     Developer(String name,int id,int salary,String programmingLanguage ){
         super(name,id,salary);
         this.programmingLanguage=programmingLanguage;
     }
     @Override
     void displayDetails(){
         System.out.println("Role: Developer |Programing Language: "+programmingLanguage);
     }

 }



 class Intern extends Employee{
     int duration;
     Intern(String name,int id,int salary,int duration ){
         super(name,id,salary);
         this.duration=duration;

     }
     @Override
     void displayDetails(){
         System.out.println("Role: Intern |Duration: "+duration);
     }

 }

 class  Main1{
     public static void main(String[] args) {
         Employee E1=new Developer("jon",120,23244,"java");
         Employee E2=new Manager("Riya",245,23321,8);
         Employee E3=new Intern("Subodh",243,54665,6);

         E1.displayDetails();



         E2.displayDetails();


         E3.displayDetails();

     }
 }