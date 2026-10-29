package exceptions;

import java.io.*;               // For file I/O classes
import java.util.Scanner;       // For the Scanner class

/**
   This program demonstrates how a FileNotFoundException
   exception can be handled.
*/

public class ExceptionMessage
{
	
	static InputStream file;  // For file input
    static Scanner inputFile; // For file input
    static  String fileName;  
   public static void main(String[] args)
   {
      
      // To hold a file name

      // Get a file name from the user.
      System.out.println("Enter " +
                                "the name of a file:");
      Scanner reader = new Scanner(System.in);
      fileName = reader.nextLine();
      
      // Attempt to open the file.
      read();
      
      System.exit(0);
   }
   
   public static void read() {
	   try
	      {
	         file = ExceptionMessage.class.getResourceAsStream("/" + fileName);
	         if (file == null) {
	            throw new FileNotFoundException(fileName);
	         }
	         inputFile = new Scanner(file);
	      }
	      catch (FileNotFoundException e)
	      {
	         System.err.println(e.getMessage());
	      }
	   		finally {
	   			System.out.println("Still happens");
	   		}
   }
}