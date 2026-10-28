package inheritance_basics.grading;

import interfaces.Relatable;

/**
   A class that holds a grade for a graded activity.
 */

public class GradedActivity implements Relatable
{
	private double score;  // Numeric score

	/**
      The setScore method sets the score field.
      @param score The value to store in score.
	 */
	//   
//	   public inheritance_basics.grading.GradedActivity (double score) {
//		   this.score = score;
//	   }

	public void setScore(double s)
	{
		score = s;
	}

	/**
      The getScore method returns the score.
      @return The value stored in the score field.
	 */

	public double getScore()
	{
		return score;
	}

	/**
      The getGrade method returns a letter grade
      determined from the score field.
      @return The letter grade.
	 */

	public char getGrade()
	{
		char letterGrade;

		if (score >= 90)
			letterGrade = 'A';
		else if (score >= 80)
			letterGrade = 'B';
		else if (score >= 70)
			letterGrade = 'C';
		else if (score >= 60)
			letterGrade = 'D';
		else
			letterGrade = 'F';

		return letterGrade;
	}



	// Implementing the Relatable interface
	/***************************************************************
   The equals method compares the calling object
   to the argument object for equality.
   @return true if the calling
   object's score is equal to the argument's
   score.
	 */
	@Override
	public boolean equals(GradedActivity other)
	{
		GradedActivity otherGradedActivity = (GradedActivity) other;
		return this.getScore() == otherGradedActivity.getScore();
	}


	/**
   The isGreater method determines whether the calling
   object is greater than the argument object.
   @return true if the calling object's score is
   greater than the argument object's score.
	 */
	public boolean isGreater(GradedActivity g)
	{
		boolean status; 

		if (this.getScore() > g.getScore())
			status = true;
		else
			status = false;

		return status;
	}

	/**
   The isLess method determines whether the calling
   object is less than the argument object.
   @return true if the calling object's score is
   less than the argument object's score.
	 */
	public boolean isLess(GradedActivity g)
	{
		boolean status; 

		if (this.getScore() < g.getScore())
			status = true;
		else
			status = false;

		return status;
	}

}