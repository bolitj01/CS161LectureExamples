package exceptions;

/**
   This program causes an error and crashes.
*/

public class BadArray
{
   public static void main(String[] args)
   {
      doArrayStuff();
   }
   
   public static void doArrayStuff() {
	// Create an array with 3 elements.
	      int[] numbers = new int[1000];
			for (int i = 0; i < 1000; i++) {
				numbers[i] = i;
			}
	      
	      // Attempt to read beyond the bounds
	      // of the array.
	      for (int i = 0; i <= 1000; i++)
	         System.out.println(numbers[i]);
   }
}

