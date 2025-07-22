import java.util.Scanner;

class Employee {
    String name;
    int id;
    Double salary;

    Employee(String name,int id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;

    }
    void  display(){
        System.out.println("Employee name: "+name+" id: "+id+" Salary: "+salary);
    }

    public static void main(String[] args) {
        Scanner details=new Scanner(System.in);
        String name=details.next();
        int id=details.nextInt();
        int salary=details.nextInt();

        Employee E=new Employee(name,id,salary);
        E.display();
    }
}
