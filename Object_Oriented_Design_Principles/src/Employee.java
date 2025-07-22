import java.util.ArrayList;

class Employee {
    private String name;
    private String position;

    public Employee(String name,String position){
        this.name=name;
        this.position=position;

    }
     public void displayEmployeeInfo() {
         System.out.println("Employee: " + name + ", Position: " + position);
     }
}

class  Department{
    public String  DepartmentName;
    private ArrayList<Employee>employees;

    public Department(String DepartmentName){
        this.DepartmentName=DepartmentName;
        employees=new ArrayList<>();
    }
    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    public void displayDepartmentInfo() {
        System.out.println("Department: " + DepartmentName);
        for (Employee emp : employees) {
            emp.displayEmployeeInfo();
        }
        System.out.println();
    }
}

class Company{
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }
    public Department getDepartment(String deptName) {
        for (Department dept : departments) {
            if (deptName.equals(dept.DepartmentName)) {
                return dept;
            }
        }
        return null;
    }

    public void displayCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartmentInfo();
        }
    }
}

class main{
    public static void main(String[] args) {
        Company tcs=new Company("TCS");

        tcs.addDepartment("IT");
        tcs.addDepartment("HR");
        Department it = tcs.getDepartment("IT");


        if (it != null) {
            it.addEmployee("Alice", "Software Engineer");
            it.addEmployee("Bob", "System Analyst");
        }

        Department hr = tcs.getDepartment("HR");
        if (hr != null) {
            hr.addEmployee("Carol", "HR Manager");
        }
        tcs.displayCompanyStructure();
    }
}
