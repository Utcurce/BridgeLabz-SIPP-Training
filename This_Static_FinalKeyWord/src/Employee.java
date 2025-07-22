class Employee {
    private static String companyName;
    private static int totalEmployees = 0;

    private String name;
    private final int id; // Final variable to ensure the employee ID cannot be modified
    private String designation;


    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }
    public static void setCompanyName(String name) {
        companyName = name;
    }
    // Static method to display the total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    // Method to display employee details
    public void displayEmployeeDetails() {
        // Using 'instanceof' to verify the object's type before displaying details
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("The object is not an instance of the Employee class.");
        }
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getDesignation() {
        return designation;
    }

    public static void main(String[] args) {
        Employee.setCompanyName("TimeVision Solutions pvt.ltd");
        // Create new employee instances
        Employee emp1 = new Employee("raju", 111, "QA");
        Employee emp2 = new Employee("Ram", 112, "Project Manager");
        // Display total number of employees
        Employee.displayTotalEmployees();
        // Display employee details
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();

    }


}
