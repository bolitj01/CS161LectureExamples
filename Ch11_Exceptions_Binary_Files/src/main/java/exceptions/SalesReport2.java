package exceptions;

import java.io.*;    // For File class and FileNotFoundException
 import java.util.*;  // For Scanner and InputMismatchException
 
 /**
    This program demonstrates how exception handlers can
    be used to recover from errors.
 */
  
 public class SalesReport2
 {
    public static void main(String[] args)
    {
       String filename = "/SalesData.txt"; // Resource name
       int months = 0;                    // Month counter
       double oneMonth;                   // One month's sales
       double totalSales = 0.0;           // Total sales
       double averageSales;               // Average sales
 
       // Attempt to open the file by calling the
       // openfile method.
       Scanner inputFile = openFile(filename);
       
       // If the openFile method returned null, then
       // the file was not found. Get a new file name.
       while (inputFile == null)
       {
          System.out.println("ERROR: " + filename +
                         " does not exist.\n" +
                         "Enter another file name: ");
          inputFile = openFile(filename);
       }
 
       // Process the contents of the file.
       while (inputFile.hasNext())
       {
          try
          {
             // Get a month's sales amount.
             oneMonth = inputFile.nextDouble();
  
             // Accumulate the amount.
             totalSales += oneMonth;
                
             // Increment the month counter.
             months++;
          }
          catch(InputMismatchException e)
          {
             // Display an error message.
             System.out.println("Non-numeric data found in the file.\n" +
                "The invalid record will be skipped.");
             
             // Skip past the invalid data.
             inputFile.nextLine();
          }
       }
 
       // Close the file.
       inputFile.close();
 
       // Calculate the average.
       averageSales = totalSales / months;
 
       // Display the results.
       System.out.printf("Number of months: %d\n" +
                        "Total Sales: $%,.2f\n" +
                        "Average Sales: $%,.2f\n",
                        months, totalSales, averageSales);
                        
       System.exit(0);
    }
 
    /**
       The opeFile method opens the specified file and
       returns a reference to a Scanner object.
       @param filename The name of the file to open.
       @return A Scanner reference, if the file exists
               Otherwise, null is returned.
    */
 
    public static Scanner openFile(String filename)
    {
       Scanner scan;
 
       // Attempt to open the file.
       try
       {
          InputStream stream = SalesReport2.class.getResourceAsStream(filename);
          if (stream == null) {
             throw new FileNotFoundException(filename);
          }
          scan = new Scanner(stream);
          return scan;
       }
       catch(FileNotFoundException e)
       {
          scan = null;
       }
       finally {
    	   System.out.println("Finally Happened!");
       }
 
       return scan;
    }
 }
