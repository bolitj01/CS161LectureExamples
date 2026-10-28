package interfaces;
/**
   This program demonstrates a class that implements
   the Displayable interface.
*/

public class InterfaceDemo
{
   public static void main(String[] args)
   {
      // Create an instance of the Person class.
      PersonOverride p = new PersonOverride("Antonio");
      
      // Call the object's display method.
      p.display();
   }
}