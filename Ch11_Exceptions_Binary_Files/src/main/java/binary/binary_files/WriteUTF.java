package binary.binary_files; /**
   This program opens a binary file and writes a series 
   of strings using UTF-8 encoding.
*/

import java.io.*;
import java.net.URISyntaxException;

public class WriteUTF
{
   public static void main(String[] args)    throws IOException, URISyntaxException
   {
      String names[] = { "Warren", "Becky", "Holly", 
                         "Zach", "Chloe" };
      
      // Create the output objects.
      FileOutputStream fstream =
                new FileOutputStream(new File(WriteUTF.class.getResource("/UTFnames.dat").toURI()));
      DataOutputStream outputFile =
                new DataOutputStream(fstream);
      
      System.out.println("Writing the names to the file...");
      
      // Write the array elements to the file.
      for (int i = 0; i < names.length; i++)
         outputFile.writeUTF(names[i]);
      
      System.out.println("Done.");
      
      // Close the file.
      outputFile.close();     
   }
}
