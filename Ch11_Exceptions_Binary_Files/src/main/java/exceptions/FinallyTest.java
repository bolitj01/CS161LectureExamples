package exceptions;

public class FinallyTest {
    public static void main(String[] args) throws NegativeStartingBalance {
        BankAccount bank1 = new BankAccount(1000);
        bank1.withdraw(100);
        System.out.println(bank1.getBalance());
    }
}
