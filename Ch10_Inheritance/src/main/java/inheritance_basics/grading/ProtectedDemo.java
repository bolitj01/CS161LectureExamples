package inheritance_basics.grading;

import java.util.Scanner;

/**
   * This program demonstrates the inheritance_basics.grading.FinalExam class, which uses
   * the protected modifier.
 */

public class ProtectedDemo
{
	public static void main(String[] args)
	{
		int questions;    // Number of questions
		int missed;       // Number of questions missed

		Scanner keyboard = new Scanner(System.in);

		// Get the number of questions on the exam.
		System.out.println("How many " +
				"questions are on the final exam?");
		questions = Integer.parseInt(keyboard.nextLine());

		// Get the number of questions the student missed.
		System.out.println("How many " +
				"questions did the student miss?");
		missed = Integer.parseInt(keyboard.nextLine());

		// Create a inheritance_basics.grading.FinalExam object which uses the protected score field.
		FinalExam exam = new FinalExam(questions, missed);

		// Display the test results.
		System.out.println("Each question counts " + exam.getPointsEach() +
				" points.\nThe exam score is " +
				exam.getScore() + "\nThe exam grade is " +
				exam.getGrade());

		keyboard.close();
	}
}