package exceptions;

/**
   This program demonstrates how the Integer.parseInt
   method throws an exception.
*/

public class ParseIntError
{
   public static void main(String[] args)
   {
       String str = "abcde";
       int number;

       try
       {
          number = Integer.parseInt(str);
          int x = 5/0;
       }
       catch (NumberFormatException e)
       { 
          System.err.println("Conversion error: " +
                             e.getMessage());
          e.printStackTrace();
       }
       System.out.println("Something else important.");
   }
}