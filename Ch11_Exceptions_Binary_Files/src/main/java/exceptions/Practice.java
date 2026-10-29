package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        try {
            InputStream stream = Practice.class.getResourceAsStream("/nonexistent.txt");
            if (stream == null) {
                throw new FileNotFoundException("nonexistent.txt");
            }
            Scanner scanner = new Scanner(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Network request to nonexistent server
        try {
            HttpURLConnection connection = (HttpURLConnection) new URI("http://tommyteachescs161.com").toURL().openConnection();
            connection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
