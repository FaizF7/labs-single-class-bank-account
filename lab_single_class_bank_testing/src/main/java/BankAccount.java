import java.time.LocalDate;
import java.util.Random;

public class BankAccount {
    private String firstName;
    private String lastName;
//    String dateOfBirth;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private double balance;
//    private String accountType;

    public BankAccount(String firstName, String lastName, LocalDate dateOfBirth, int accountNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber = accountNumber;
//        this.accountType = accouy
        this.balance=0;

    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance+=amount;
    }

    public void withdrawal(double amount){
        this.balance-=amount;
    }

    public void payInterest(){
        this.balance *= 1.05;
    }
}
