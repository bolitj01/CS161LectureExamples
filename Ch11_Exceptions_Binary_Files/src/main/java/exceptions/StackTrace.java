package exceptions;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
   This program demonstrates the stack trace that is
   produced when an exception is thrown.
 */

public class StackTrace
{
	public static void main(String[] args)
	{
		System.out.println("Calling myMethod...");
		myMethod();
		System.out.println("Method main is done.");
	}

	/**
      MyMethod
	 */

	public static void myMethod()
	{
		System.out.println("Calling produceError...");
		produceError();
		System.out.println("myMethod is done.");
	}

	/**
      produceError
	 */

	public static void produceError()
	{
		String str = "abc";

		// The following statement will cause an error.
		System.out.println(str.charAt(3));
		System.out.println("produceError is done.");
	}

	// This method will not compile! Why?
	public void displayFile(String name) throws FileNotFoundException
	{
		// Open the file.
		InputStream file = StackTrace.class.getResourceAsStream("/" + name);
		if (file == null) {
			throw new FileNotFoundException(name);
		}
		Scanner inputFile = new Scanner(file);
		// Read and display the file's contents.
		while (inputFile.hasNext())
		{
			System.out.println(inputFile.nextLine());
		}
		// Close the file.
		inputFile.close();
	}

}
