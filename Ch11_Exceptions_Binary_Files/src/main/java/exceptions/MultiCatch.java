package exceptions;

import java.io.*;    // For File class and FileNotFoundException
import java.util.*;  // For Scanner and InputMismatchException

/**
   This program demonstrates how multiple exceptions can
   be caught with a single catch clause.
*/

public class MultiCatch
{
   public static void main(String[] args)
   {
      int number;    // To hold a number from the file
      
      try
      {
         // Open the file.
         InputStream stream = MultiCatch.class.getResourceAsStream("/Numbers.txt");
         if (stream == null) {
            throw new FileNotFoundException("Numbers.txt");
         }
         Scanner inputFile = new Scanner(stream);

         // Process the contents of the file.
         while (inputFile.hasNext())
         {
            // Get a number from the file.
            number = inputFile.nextInt();
            
            // Display the number.
            System.out.println(number);
         }

         // Close the file.
         inputFile.close();
      }
      catch(IOException ex)
      {
         // Display an error message.
         System.out.println("Error processing the file.");
      }
      catch (InputMismatchException ex)
      {
         // Display an error message.
         System.out.println("Error: Non-numeric data in the file.");
      }
   }
}