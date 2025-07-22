 class Product {
    private static double discount=0.0;
    private String productName;
    private double price;
    private  int Quantity;
    private final String productID;

    public Product(String productID,String productName,double price,int Quantity){
        this.productID=productID;
        this.productName=productName;
        this.price=price;
        this.Quantity=Quantity;
    }
     public static void updateDiscount(double newDiscount) {
         if (newDiscount >= 0.0 && newDiscount <= 100.0) {
             discount = newDiscount;
         } else {
             System.out.println("Invalid discount percentage. Please enter a value between 0 and 100.");
         }
     }
     // Method to calculate the price after applying the discount
     public double getDiscountedPrice() {
         return price - (price * discount / 100);
     }


     public void  displayProductDetails(){
        if(this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Product Quantity: " + Quantity);
            System.out.println("Product Discount: " + discount + "%");
            System.out.println("Product Price After Discount: " + getDiscountedPrice());
        }else{
            System.out.println("The object is not an instance of the Product class.");
        }

     }
     public String getProductID() {
         return productID;
     }
     public String getProductName() {
         return productName;
     }
     public void setProductName(String productName) {
         this.productName = productName;
     }
     public double getPrice() {
         return price;
     }
     public void setPrice(double price) {
         this.price = price;
     }
     public int getQuantity() {
         return Quantity;
     }
     public void setQuantity(int quantity) {
         this.Quantity = quantity;
     }

     public static void main(String[] args) {
         Product.updateDiscount(10.0);

         Product p1=new Product("101","fan",1234,3);
         Product p2=new Product("102","Monitar",12534,5);
         p1.displayProductDetails();
         System.out.println();
         p2.displayProductDetails();


     }


 }
