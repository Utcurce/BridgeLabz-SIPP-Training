import java.util.ArrayList;

public class Bank {
     private String BankName;
     private ArrayList<Account>accounts;

     public Bank(String BankName){
         this.BankName=BankName;
         accounts=new ArrayList<>();

     }

     public void  OpenAccount(Customer customer,double initialDeposit){
         Account account = new Account(this, customer, initialDeposit);
         accounts.add(account);
         customer.addAccount(account);
         System.out.println("Account opened for " + customer.getName() + " in " + BankName + " with ₹" + initialDeposit);

     }
    public String getBankName() {
        return BankName;
    }

}
class Customer{

    private String name;
     private ArrayList<Account>accounts;

    public Customer(String name){
        this.name=name;
        accounts=new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public  void viewBalance(){
        System.out.println("Accounts of " + name + ":");
        for (Account acc : accounts) {
            System.out.println("Bank: " + acc.getBank().getBankName() + ", Balance: ₹" + acc.getBalance());
        }
        System.out.println();
    }

}

class Account{
    private Bank bank;
    private Customer customer;
    private double balance;

    public Account(Bank bank, Customer customer, double initialDeposit) {
        this.bank = bank;
        this.customer = customer;
        this.balance = initialDeposit;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public Customer getCustomer() {
        return customer;
    }
}

class nain{
    public static void main(String[] args) {
        Bank sbi=new Bank("SBI");
        Bank icici=new Bank("ICICI");

        Customer c1=new Customer("mohan");
        Customer c2=new Customer("shyam");

        sbi.OpenAccount(c1,222234);
        icici.OpenAccount(c1,24566);
        sbi.OpenAccount(c2,44575);

        c1.viewBalance();
        c2.viewBalance();


    }
}
