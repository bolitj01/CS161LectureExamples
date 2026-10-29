package exceptions;

/**
   This program demonstrates how the exceptions.Die class throws
   an exception when an invalid value is passed to the
   constructor.
 */

public class DiceExceptionDemo
{
	public static void main(String[] args)
	{
		final int DIE_SIDES = 4;  // Number of sides

		// Create an instance of the exceptions.Die class.
		// Die die = new Die(DIE_SIDES);

		System.out.println("Initial value of the die:");
//		System.out.println(die.getValue());

		try {
			MTGSetup();
			DnDSetup();
		} catch (DiceSideException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void MTGSetup() throws DiceSideException{
		Die healthD = new Die(20);
		System.out.println("Initial value of the health die:");
		healthD.roll();
		System.out.println(healthD.getValue());
		Die damageCounterD = new Die(15);
		System.out.println("Initial value of the damage counter die:");
		damageCounterD.roll();
		System.out.println(damageCounterD.getValue());
	}

	public static void DnDSetup() throws DiceSideException{
		Die badD = new Die(1); 
	}
}