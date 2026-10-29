package binary.exercises;

import java.io.EOFException;
import java.io.IOException;
import java.io.DataInputStream;
import java.util.ArrayList;

public class RandomBinaryReader_Solution {

	public static void main(String[] args) throws IOException {
		
		//TODO Read the resource "/random.cs161" (use getResourceAsStream) and count the occurrences of each data type
		//File format: order is [type] [data] [type] [data].
		//type is a String of either "char", "int", "String", or "boolean"
        
        //SOLUTION IS BELOW AFTER SCROLLING (TRY THE EXERCISE FIRST!)
























        DataInputStream reader = new DataInputStream(RandomBinaryReader_Solution.class.getResourceAsStream("/random.cs161"));

		ArrayList<Integer> ints = new ArrayList<>();
		ArrayList<Boolean> bools = new ArrayList<>();
		ArrayList<String> strings = new ArrayList<>();
		ArrayList<Character> chars = new ArrayList<>();

		while (true) {
			try {
				String type = reader.readUTF();
				switch (type) {
					case "char" -> {
						chars.add(reader.readChar());
					}
					case "int" -> {
						ints.add(reader.readInt());
					}
					case "String" -> {
						strings.add(reader.readUTF());
					}
					case "boolean" -> {
						bools.add(reader.readBoolean());
					}
				}
			} catch (EOFException e) {
				System.out.println("End of file.");
				break;
			}
		}

		System.out.println(chars.size());
		System.out.println(ints.size());
		System.out.println(strings);
	}
}
