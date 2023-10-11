import java.time.LocalDate;
import java.util.Collections;
import java.util.Random;

public class BankAccount {
    private String firstName;
    private String lastName;
//    String dateOfBirth;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private double balance;
    private String accountType;
    private double overdraft;

    public BankAccount(String firstName, String lastName, LocalDate dateOfBirth, int accountNumber, String accountType, double overdraft){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.overdraft = overdraft;

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

    public String withdrawal(double amount){
        if (this.balance-amount>=-this.overdraft){
        this.balance -= amount;
        return null;
        }else{
            return "Unable to fulfil request";
        }

    }

    public void payInterest(){
        if (this.accountType == "saver"){
            this.balance *= 1.07;
        }else if(this.accountType == "current"){
            this.balance*=1.05;
        }
    }


}
