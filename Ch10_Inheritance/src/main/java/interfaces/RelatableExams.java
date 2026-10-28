package interfaces;
import inheritance_basics.grading.FinalExam;

/**
   This program demonstrates the inheritance_basics.grading.FinalExam class which
   implements the Relatable interface.
*/

public class RelatableExams
{
   public static void main(String[] args)
   {
      // Exam #1 had 100 questions and the student
      // missed 20 questions.
      FinalExam exam1 = new FinalExam(100, 20);

      // Exam #2 had 100 questions and the student
      // missed 30 questions.
      FinalExam exam2 = new FinalExam(100, 30);

      // Display the exam scores.
      System.out.println("Exam 1: " + exam1.getScore());
      System.out.println("Exam 2: " + exam2.getScore());

      // Compare the exam scores.
      if (exam1.equals(exam2))
         System.out.println("The exam scores are equal.");

      if (exam1.isGreater(exam2))
         System.out.println("The Exam 1 score is the highest.");

      if (exam1.isLess(exam2))
         System.out.println("The Exam 1 score is the lowest.");
   }
}
