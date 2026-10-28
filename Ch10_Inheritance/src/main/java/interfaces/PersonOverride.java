package interfaces;
import interfaces.default_methods.Displayable;

public class PersonOverride implements Displayable
{
   private String name;
   
   // Constructor
   public PersonOverride(String n)
   {
      name = n;
   }
   
   // display method
   public void display()
   {
      System.out.println("My name is " + name);
   }
}
