package basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

	@Test
	void defaultConstructorStartsAtZeroBalance() {
		BankAccount account = new BankAccount();
		assertEquals(0, account.getBalance());
	}

	@Test
	void overloadedConstructorSetsStartingBalance() {
		BankAccount account = new BankAccount(100);
		assertEquals(100, account.getBalance());
	}

	@Test
	void depositIncreasesBalance() {
		BankAccount account = new BankAccount(50);
		account.deposit(25);
		assertEquals(75, account.getBalance());
	}

	@Test
	void depositIgnoresNonPositiveAmounts() {
		BankAccount account = new BankAccount(50);
		account.deposit(-10);
		account.deposit(0);
		assertEquals(50, account.getBalance());
	}

	@Test
	void withdrawDecreasesBalance() {
		BankAccount account = new BankAccount(50);
		account.withdraw(20);
		assertEquals(30, account.getBalance());
	}

	@Test
	void withdrawIgnoresAmountsGreaterThanBalance() {
		BankAccount account = new BankAccount(50);
		account.withdraw(100);
		assertEquals(50, account.getBalance());
	}

	@Test
	void withdrawIgnoresNonPositiveAmounts() {
		BankAccount account = new BankAccount(50);
		account.withdraw(-10);
		account.withdraw(0);
		assertEquals(50, account.getBalance());
	}
}
