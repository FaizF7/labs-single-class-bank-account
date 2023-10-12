import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestBankAccount {

    BankAccount bankAccount; // instantiating this out here ensures that all the testing functions can see the object

    @BeforeEach // This will run this code before each test
    public void setUp(){
        bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100 );

    }

    @Test
    void canGetFirstName(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100 );
        String result = bankAccount.getFirstName();
        String expected =  "Jimmy";
        assertThat(result).isEqualTo(expected);

    }
    @Test
    void canSetFirstName(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        bankAccount.setFirstName("Bob");
        String result = bankAccount.getFirstName();
        assertThat(result).isEqualTo("Bob");
    }

    @Test
    void canGetLastName(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        String result = bankAccount.getLastName();
        String expected =  "Neutron";
        assertThat(result).isEqualTo(expected);
    }
    @Test
    void canSetLastName(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        bankAccount.setLastName("Smith");
        String result = bankAccount.getLastName();
        assertThat(result).isEqualTo("Smith");
    }

    @Test
    void canGetDateOfBirth(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        LocalDate result = bankAccount.getDateOfBirth();
        LocalDate expected = LocalDate.of(2000, 8, 7);
        assertThat(result).isEqualTo(expected);
    }
    @Test
    void canSetDateOfBirth(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        bankAccount.setDateOfBirth(LocalDate.of(2013, 6, 7));
        LocalDate result = bankAccount.getDateOfBirth();
        assertThat(result).isEqualTo(LocalDate.of(2013, 6, 7));
    }

    @Test
    void canGetAccountNumber(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        int result = bankAccount.getAccountNumber();
        int expected =  12345678;
        assertThat(result).isEqualTo(expected);

    }
    @Test
    void canSetAccountNumber(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        bankAccount.setAccountNumber(11223344);
        int result = bankAccount.getAccountNumber();
        assertThat(result).isEqualTo(11223344);
    }

    @Test
    void canGetBalance(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        double result = bankAccount.getBalance();
        double expected =  0;
        assertThat(result).isEqualTo(expected);

    }
    @Test
    void canSetBalance(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        bankAccount.setBalance(10.10);
        double result = bankAccount.getBalance();
        assertThat(result).isEqualTo(10.10);
    }

    @Test
    void canDeposit(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        bankAccount.deposit(100);
        double result = bankAccount.getBalance();
        assertThat(result).isEqualTo(100);
    }

    @Test
    void canWithdraw(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        bankAccount.deposit(100);
        bankAccount.withdrawal(100);
        double result = bankAccount.getBalance();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void canNotWithdrawOverdraftBalance(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100);
        String message = bankAccount.withdrawal(200);
        double result = bankAccount.getBalance();

        assertThat(result).isEqualTo(0);
        assertThat(message).isEqualTo("Unable to fulfil request");
    }


    @Test
    void canPayInterestCurrent(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "current", 100 );
        bankAccount.deposit(100);
        bankAccount.payInterest();
        double result = bankAccount.getBalance();
        assertThat(result).isEqualTo(105);
    }

    @Test
    void canPayInterestSaver(){
        BankAccount bankAccount = new BankAccount("Jimmy", "Neutron", LocalDate.of(2000, 8, 7), 12345678, "saver", 100 );
        bankAccount.deposit(100);
        bankAccount.payInterest();
        double result = bankAccount.getBalance();
        assertThat(result).isEqualTo(110, Offset.offset(0.001));
    }


}
