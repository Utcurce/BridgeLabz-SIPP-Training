 class Product {

     String productName;
      double price;
       public static int totalProduct=0;


        Product(String productName,double price){
            this.productName=productName;
            this.price=price;
            totalProduct++;
        }
       void  displayProductDeatils(){
            System.out.println("Product Name: "+productName);
           System.out.println("Price: "+price);
        }
       public static void displayTotalProduct(){
            System.out.println("Total product is: "+totalProduct);
        }

     public static void main(String[] args) {
         Product p1=new Product("Mobile",20000);
         Product p2=new Product("laptop",200000);
         p1.displayProductDeatils();
         System.out.println();
         p2.displayProductDeatils();
         System.out.println();
         Product.displayTotalProduct();
     }

}
