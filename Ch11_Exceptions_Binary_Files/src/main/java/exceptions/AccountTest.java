package exceptions;

/**
   This program demonstrates how the exceptions.BankAccount
   class constructor throws custom exceptions.
*/

public class AccountTest
{
   public static void main(String [] args)
   {
      // Force a exceptions.NegativeStartingBalance exception.
      try
      {
         BankAccount account =
                     new BankAccount(-100.0);
      }
      catch(NegativeStartingBalance e)
      {
         System.out.println(e.getMessage());
      }
   }
}