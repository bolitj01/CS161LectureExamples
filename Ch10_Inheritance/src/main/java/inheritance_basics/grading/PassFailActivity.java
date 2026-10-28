package inheritance_basics.grading;

import polymorphism.PassFailExam;

/**
   This class holds a numeric score and determines
   whether the score is passing or failing.
*/

public class PassFailActivity extends GradedActivity
{
   private double minPassingScore; // Minimum passing score

   /**
      The constructor sets the minimum passing score.
      @param mps The minimum passing score.
   */

   public PassFailActivity(double mps)
   {
      minPassingScore = mps;
   }

   /**
      The getGrade method returns a letter grade determined
      from the score field. This method overrides the
      superclass method.
      @return The letter grade.
   */

   @Override
   public char getGrade()
   {
      char letterGrade;

      if (super.getScore() >= minPassingScore)
         letterGrade = 'P';
      else
         letterGrade = 'F';

      return letterGrade;
   }

public boolean equals(PassFailExam other) {
	// TODO Auto-generated method stub
	return false;
}
}