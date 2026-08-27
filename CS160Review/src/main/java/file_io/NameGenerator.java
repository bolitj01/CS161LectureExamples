package file_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NameGenerator {

	public static void main(String[] args) throws IOException {

		// Read all adjectives from adjectives.txt
		Scanner adjectivesReader = new Scanner(NameGenerator.class.getResourceAsStream("/adjectives.txt"));
		ArrayList<String> adjectives = new ArrayList<>();

		while (adjectivesReader.hasNext()) {
			adjectives.add(adjectivesReader.next());
		}

		adjectivesReader.close();

		// Read all names from names.txt
		Scanner namesReader = new Scanner(NameGenerator.class.getResourceAsStream("/names.txt"));
		ArrayList<String> names = new ArrayList<>();

		while (namesReader.hasNext()) {
			String[] nameParts = namesReader.nextLine().split("\t");
			names.add(nameParts[0]);
		}

		namesReader.close();

		// Generate 15 random "adjective name" pairs
		Random random = new Random();
		PrintWriter writer = new PrintWriter("CS160Review/src/main/resources/generated_names.txt");

		// TODO Practice: Make all generated names use alliteration (same first letter
		// for adjective and name, e.g., "Tenacious Tommy")

		for (int i = 0; i < 15; i++) {
			String adjective = adjectives.get(random.nextInt(adjectives.size()));
			String name = names.get(random.nextInt(names.size()));
			writer.println(adjective + " " + name);
		}

		writer.close();

		System.out.println("Names generated and saved to generated_names.txt");

	}

}
