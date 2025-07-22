interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}
abstract class Employee implements Department{
    private int empId;
    private String name;
    private double baseSalary;
    private String department;


   public Employee(String name,int empId,double baseSalary){
        this.name=name;
        this.empId=empId;
        this.baseSalary=baseSalary;

   }
    //get method
    public int  getEmpId(){
       return empId;
    }
    public  String getName(){
       return name;
    }
    public double getBaseSalary(){
       return baseSalary;
    }
    //set method
    public void setBaseSalary(double baseSalary){
       this.baseSalary=baseSalary;
    }

    public abstract double calculateSalary();

   public void displayDetails(){
       System.out.println("Employee Id: "+empId+" Name: "+name+" Base salary: "+baseSalary);
       System.out.println("Total salary:"+calculateSalary());
       System.out.println("Department: "+getDepartmentDetails());
   }
   @Override
    public  void assignDepartment(String departmentName){
       this.department=departmentName;
   }

   @Override
    public String getDepartmentDetails(){
       return department !=null ? department:"not assinged";
   }


}
class FullTimeEmployee extends Employee{
    private double bonus;


    public FullTimeEmployee(int empId,String name,double baseSalary,double bonus){
        super(name,empId,baseSalary);
        this.bonus=bonus;
    }

    @Override
    public double calculateSalary(){
        return getBaseSalary()+bonus;
    }


}

class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private int workHour;


    public PartTimeEmployee(int empId,String name,double baseSalary,double hourlyRate,int workHour){
        super(name,empId,baseSalary);
        this.workHour=workHour;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return getBaseSalary()+(workHour*hourlyRate);
    }



}

public class Employee_Management {
    public static void main(String[] args) {
        Employee e1=new FullTimeEmployee(324,"Subodh Singh",34533,12000);
        Employee e2=new PartTimeEmployee(4321,"Abhi",3424,1200,5);
        e1.assignDepartment("Development");
        e2.assignDepartment("Finance");

        Employee[] employees={e1,e2};

        System.out.println();
        for( Employee emp:employees){
            emp.displayDetails();
            System.out.println();
        }
    }

}