import java.sql.SQLOutput;

class BankAccount {
    private static String bankName = "American express";
    private static int totalAccounts = 0;
    // Final variable to ensure accountnumber cannot be changed once assigned
    private final String accountNumber;
    private String accountHolderName;
    private double balance;
     //constructor useing "this" keywords
    public BankAccount( String accountHolderName, String accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.balance=balance;
        totalAccounts++;
    }
     public static void getTotalAccounts() {
         System.out.println("Total number of accounts: " + totalAccounts);
     }
     // Method to display account details
     public void displayAccountDetails() {
         // Using instanceof to check if the object is a BankAccount instance
         if (this instanceof BankAccount) {
             System.out.println("Bank Name: " + bankName);
             System.out.println("Account Holder: " + accountHolderName);
             System.out.println("Account Number: " + accountNumber);
             System.out.println("Balance: $" + balance);
         } else {
             System.out.println("Invalid account instance.");
         }

     }
     // Getters
     public String getAccountHolderName() {
         return accountHolderName;
     }
     //  setters
     public void setAccountHolderName(String accountHolderName) {
         this.accountHolderName = accountHolderName;
     }
     public double getBalance() {
         return balance;
     }
     public void deposit(double amount) {
         if (amount > 0) {
             balance += amount;
             System.out.println("Deposited: $" + amount);
         } else {
             System.out.println("Invalid deposit amount.");
         }
     }
     public void withdrow(double amount){
         if (amount > 0 && amount <= balance) {
             balance -= amount;
             System.out.println("Withdrawn: $" + amount);
         } else {
             System.err.println("Insufficient balance or invalid amount.");
         }
     }

     public static void main(String[] args) {
        //create two object BankAccount
         BankAccount b1=new BankAccount("ABhi","ACC2324",243435);
         BankAccount b2=new BankAccount("Subodh","ACC236743",34123455);
         System.out.println("\n Account 1 Details: ");
         b1.displayAccountDetails();
         System.out.println("\n Account 2 Details: ");
         b2.displayAccountDetails();
         System.out.println("\n ");
         //check total acc
         BankAccount.getTotalAccounts();
         //Deopsit and withdrow
         System.out.println("\nDeposit and withdraw operation: ");
         b1.deposit(1222);
         b1.withdrow(23451);
         b1.displayAccountDetails();

         b2.deposit(224566);
         b2.withdrow(677654);
         b2.displayAccountDetails();


     }


 }
