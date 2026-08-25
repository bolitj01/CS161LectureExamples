package file_io;
import java.util.Scanner;

public class HourlyWageScanner {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What is your name?");
		String name = keyboard.nextLine();

		System.out.println("What is your hourly wage?");
		double hourlyWage = keyboard.nextDouble();
		
		System.out.println("How many hours?");
		int hoursWorked = keyboard.nextInt();
		
		System.out.printf("%s earned %.2f", name, hoursWorked * hourlyWage);
		
		keyboard.close();
	}
}
