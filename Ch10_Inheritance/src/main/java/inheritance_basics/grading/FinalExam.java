package inheritance_basics.grading;

/**
   This class determines the grade for a final exam.
 */

public class FinalExam extends GradedActivity
{
	//protected double score; inherited from the inheritance_basics.grading.GradedActivity class
	private int numQuestions;  // Number of questions
	private double pointsEach; // Points for each question
	private int numMissed;     // Questions missed

	/**
      The constructor sets the number of questions on the
      exam and the number of questions missed.
      @param questions The number of questions.
      @param missed The number of questions missed.
	 */

	public FinalExam(int questions, int missed)
	{
//		super(0); //isn't necessary because the inheritance_basics.grading.GradedActivity class doesn't have a default constructor
		double numericScore;  // To hold a numeric score

		// Set the numQuestions and numMissed fields.
		numQuestions = questions;
		numMissed = missed;

		// Calculate the points for each question and
		// the numeric score for this exam.
		pointsEach = 100.0 / numQuestions;
		numericScore = 100.0 - (missed * pointsEach);

		// Call the inherited setScore method to
		// set the numeric score.
		setScore(numericScore);
//		super.setScore(numericScore); //this is the same as the above line
		// Round the score.
		roundScore();
	}

	/**
      The getPointsEach method returns the number of
      points each question is worth.
      @return The value in the pointsEach field.
	 */

	public double getPointsEach()
	{
		return pointsEach;
	}

	/**
      The getNumMissed method returns the number of 
      questions missed.
      @return The value in the numMissed field.
	 */

	public int getNumMissed()
	{
		return numMissed;
	}

	//public char getGrade() inherited from the inheritance_basics.grading.GradedActivity class

	/**
	 * If score is within 0.5 points of the next whole
	 * number, round the score up.
	 */
	private void roundScore()
	{
		double fraction;

		// Get the fractional part of the score.
		fraction = getScore() - (int) getScore();

		// If the fractional part is .5 or greater,
		// round the score up to the next whole number.
		if (fraction >= 0.5)
			setScore(getScore() + (1.0 - fraction));
	}
}
