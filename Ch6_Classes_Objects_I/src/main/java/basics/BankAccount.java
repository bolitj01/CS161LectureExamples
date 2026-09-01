package basics;

public class BankAccount {

	private double balance;

	public BankAccount() {
		balance = 0;
	}

	public BankAccount(double startBalance) {
		balance = startBalance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
		}
	}

	public double getBalance() {
		return balance;
	}
}
