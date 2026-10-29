package exceptions;

import java.io.*;  // For File class and FileNotFoundException
import java.util.Scanner;       // For the Scanner class

/**
 * This program demonstrates how a FileNotFoundException
 * exception can be handled.
 */

public class OpenFile {
    public static void main(String[] args) {
        InputStream file;  // For file input
        Scanner inputFile; // For file input
        String fileName;   // To hold a file name
        Scanner kb = new Scanner(System.in);

        boolean found = false;
        while (!found) {
            // Get a file name from the user.
            System.out.println("Enter the name of a file:");
            fileName = kb.nextLine();

            // Attempt to open the file.
            try {
                file = OpenFile.class.getResourceAsStream("/" + fileName);
                if (file == null) {
                    throw new FileNotFoundException(fileName);
                }
                inputFile = new Scanner(file);
                found = true;
                while (inputFile.hasNext()) {
                    System.out.println(inputFile.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}