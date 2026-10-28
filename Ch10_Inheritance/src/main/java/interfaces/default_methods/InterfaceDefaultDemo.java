package interfaces.default_methods;

/**
   This program demonstrates a class that implements
   the Displayable interface (with a default method).
*/

public class InterfaceDefaultDemo
{
   public static void main(String[] args)
   {
      // Create an instance of the Person class.
      Displayable p = new PersonDefault("Antonio");
      
      // Call the object's display method.
      p.display();
   }
}