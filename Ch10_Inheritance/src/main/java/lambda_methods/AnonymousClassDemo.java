package lambda_methods; /**
 * This program demonstrates an anonymous inner class
 */

import java.util.Scanner;

public class AnonymousClassDemo {
    public static void main(String[] args) {
        int num;

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Create an object that implements IntCalculator
        // using an anonymous inner class instead of a lambda expression.
        IntCalculator square = number ->
        {
            return number * number;
        };

        IntCalculator cube = number -> {
            return number * number * number;
        };

        // Get a number from the user.
        System.out.print("Enter an integer number: ");
        num = keyboard.nextInt();

        // Display the square of the number.
        System.out.println("The square is " + square.calculate(num));
        System.out.println("The cube is " + cube.calculate(num));

        keyboard.close();
    }
}