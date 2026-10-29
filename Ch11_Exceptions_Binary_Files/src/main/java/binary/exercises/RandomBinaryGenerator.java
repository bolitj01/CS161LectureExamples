package binary.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomBinaryGenerator {
	
	public static void main(String[] args) throws IOException, URISyntaxException {

		/* Don't read any code below until the exercise has been completed */



























































		RandomAccessFile writer = new RandomAccessFile(new File(RandomBinaryGenerator.class.getResource("/random.cs161").toURI()), "rw");
		
		Random r = new Random();
		
		String[] words = "Never gonna give you up never gonna let you down never gonna turn around and desert you".split(" ");
		
		Map<Integer, String> writeTypes = new HashMap<>();
		writeTypes.put(0, "char");
		writeTypes.put(1, "int");
		writeTypes.put(2, "String");
		writeTypes.put(3, "boolean");
		
		try {
			for (int i = 0; i < 1000; i++) {
				int choice = r.nextInt(4);
				writer.writeUTF(writeTypes.get(choice));
				switch (choice) {
				case 0:
					char randChar = (char)(Math.random() * 26 + 97);
					writer.writeChar(randChar);
					System.out.println("wrote char: " + randChar);
					break;
				
				case 1:
					int randInt = r.nextInt(Integer.MAX_VALUE);
					writer.writeInt(randInt);
					System.out.println("wrote int: " + randInt);
					break;
				
				case 2:
					String word = words[r.nextInt(words.length)];
					writer.writeUTF(word);
					System.out.println("wrote word: " + word);
					break;
					
				case 3:
					boolean randBool = r.nextBoolean();
					writer.writeBoolean(randBool);
					System.out.println("wrote boolean: " + randBool);
					break;
				}	
			}
		} catch (Exception e) {
			System.out.println();		
		}
		
		writer.close();
	}
}
