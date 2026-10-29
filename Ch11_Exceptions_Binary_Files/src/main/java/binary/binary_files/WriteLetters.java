package binary.binary_files;

import java.io.*;
import java.net.URISyntaxException;

/**
   This program uses a RandomAccessFile object to 
   create the file Letters.dat. The letters of the
   alphabet are written to the file.
*/

public class WriteLetters
{
   public static void main(String[] args)
                      throws IOException, URISyntaxException
   {
    // The letters array has all 26 letters.
    char[] letters = {
               'a', 'b', 'c', 'd', 'e', 'f', 'g',
               'h', 'i', 'j', 'k', 'l', 'm', 'n',
               'o', 'p', 'q', 'r', 's', 't', 'u',
               'v', 'w', 'x', 'y', 'z' };

    System.out.println("Opening the file.");

    // Open a file for reading and writing.
    DataOutputStream randomFile = new DataOutputStream(new FileOutputStream(new File(WriteLetters.class.getResource("/Letters.dat").toURI())));

    System.out.println("Writing data to the file...");

    // Sequentially write the letters array to the file.
    for (int i = 0; i < letters.length; i++)
       randomFile.writeChar(letters[i]);
    
    // Close the file.
    randomFile.close();
    
    System.out.println("Done.");
   }
}