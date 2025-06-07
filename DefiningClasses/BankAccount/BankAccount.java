package DefiningClasses.BankAccount;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int counter = 1;

    public int getId() {
        return id;
    }

    BankAccount(){
        this.id = counter++;
    }
    static void setInterestRate (double interestRate){
        BankAccount.interestRate=interestRate;
    }
    void deposit (double amount){
        this.balance+=amount;
    }
    double getInterest (int years){
        return BankAccount.interestRate*years*this.balance;
    }
}
