package inheritance_basics.grading;

import java.util.Scanner;

/**
   This program demonstrates the inheritance_basics.grading.GradedActivity
   class.
 */

public class GradedActivityDemo
{
	public static void main(String[] args)
	{
		double testScore;    // A test score

		// Create a inheritance_basics.grading.GradedActivity object.
		GradedActivity grade = new GradedActivity();

		Scanner keyboard = new Scanner(System.in);

		// Get a test score.
		System.out.println("Enter " +
				"a numeric test score.");
		testScore = Double.parseDouble(keyboard.nextLine());

		// Store the score in the grade object.
		grade.setScore(testScore);

		// Display the letter grade for the score.
		System.out.println("The grade for that test is " +
				grade.getGrade());

		keyboard.close();
	}
}