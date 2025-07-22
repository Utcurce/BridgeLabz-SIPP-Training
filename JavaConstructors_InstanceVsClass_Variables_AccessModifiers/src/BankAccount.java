public class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    //Constracter
    public BankAccount(int accountNumber, String accountHolder, double balance) {

        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }


    //  public method  to deposit
    public void deposit(double amount) {
        balance +=amount;
    }
    //withdraw
    public  void withdraw(double amount){
        if(amount<=balance){
            balance -=amount;
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
    // mathod to get belance
    public double getBalance(){
        return balance;
    }



}
//Extand subclass from superClass

class SaveingAccount extends BankAccount{
    public SaveingAccount( int accountNumber, String accountHolder, double balance){
        super(accountNumber,accountHolder,balance);
    }


    // Display Details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);


    }

    public static void main(String[] args) {
        SaveingAccount a=new SaveingAccount(13132424,"Brij Mohan tiwari",223234);
        a.displayDetails();
        a.deposit(2000);
        a.withdraw(500);

        System.out.println("Balance : "+a.getBalance());
    }
}
