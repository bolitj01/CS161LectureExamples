package decision_structures;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Switch {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("gradereport.txt"));

		var totalCredits = 0;
		double totalGradePoints = 0;
		
		while (reader.hasNext()){

			var credits = Integer.parseInt(reader.next());
			totalCredits += credits;
			
			var grade = reader.next();
			
			totalGradePoints += switch (grade) {
				case "A" -> (4 * credits); //equivalent to case "A" -> yield 4 * credits; 
				case "B" -> (3 * credits);
				case "C" -> (2 * credits);
				case "D" -> (1 * credits);
				case "F" -> (0 * credits);
				default -> throw new IllegalArgumentException("Unexpected value: " + grade); 
			};

		}
		
		System.out.printf("GPA is %.2f", totalGradePoints / totalCredits);
		
		reader.close();
		
	}
}