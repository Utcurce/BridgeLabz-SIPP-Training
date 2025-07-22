interface Taxable{
    double calculateTax();
    String getTaxDetails();
}


abstract class Product{
    private String productId;
    private String name;
    private double price;

    public Product(String name, String productId, double price) {
        this.name = name;
        this.productId = productId;
        this.price = price;

    }

    public String  getProductId(){
        return productId;
    }
    public  String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    //set method
    public void setPrice(double price) { this.price = price; }


    public abstract double calculateDiscount();

    public void displayInfo() {
        System.out.println("Product ID: " + productId + " | Name: " + name + " | Price: " + price);
    }
}
//Electronic class

class Electronics extends Product implements Taxable{
    private  double warrantyYear;

    public  Electronics(String name, int productId, double price,double warrantyYear){
        super(name, String.valueOf(productId),price);
        this.warrantyYear=warrantyYear;
    }


    @Override
    public double calculateDiscount(){
        return  getPrice()*0.1;//10% Discunt
    }

    @Override
    public double calculateTax(){
        return getPrice()*0.18; //18%tax

    }

    @Override
    public String getTaxDetails(){
        return "Electronics GST: 18%";
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Category: Electronics | Warranty: " + warrantyYear + " years");
    }
}



// Clothing class
class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(String productId, String name, double price, String size) {
        super(name,productId, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% VAT
    }

    @Override
    public String getTaxDetails() {
        return "Clothing VAT: 5%";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Category: Clothing | Size: " + size);
    }
}

// Groceries class (Non-taxable)
class Groceries extends Product {
    private int shelfLifeDays;

    public Groceries(String productId, String name, double price, int shelfLifeDays) {
        super(productId, name, price);
        this.shelfLifeDays = shelfLifeDays;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Category: Groceries | Shelf Life: " + shelfLifeDays + " days");
    }
}

// Main class to demonstrate
public class E_Commerce {
    // Polymorphic method
    public static void printFinalPrice(Product p) {
        p.displayInfo();
        double discount = p.calculateDiscount();
        double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
        double finalPrice = p.getPrice() + tax - discount;

        if (p instanceof Taxable) {
            System.out.println(((Taxable) p).getTaxDetails());
        }

        System.out.printf("Discount: ₹%.2f | Tax: ₹%.2f | Final Price: ₹%.2f\n", discount, tax, finalPrice);
        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {
        Product[] products = {
                new Electronics("Smartphone", 1344, 30000, 2),
                new Clothing("C205", "T-Shirt", 1000, "M"),
                new Groceries("G502", "Rice", 800, 90)
        };

        System.out.println("---- Product Summary ----");
        for (Product p : products) {
            printFinalPrice(p); // Polymorphic behavior
        }
    }
}