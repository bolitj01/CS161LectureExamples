package inheritance_basics.overload_override;

/**
   This program demonstrates the methods in the
   inheritance_basics.overload_override.SuperClass3 and inheritance_basics.overload_override.SubClass3 classes.
*/

public class ShowValueDemo
{
   public static void main(String[] args)
   {
      // Create a inheritance_basics.overload_override.SubClass3 object.
      SubClass3 myObject = new SubClass3();

      myObject.showValue(10);       // Pass an int.
      myObject.showValue(1.2);      // Pass a double.
      myObject.showValue("Hello");  // Pass a String.
   }
}