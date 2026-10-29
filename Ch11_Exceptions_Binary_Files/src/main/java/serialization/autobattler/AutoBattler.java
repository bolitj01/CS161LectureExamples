package serialization.autobattler;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AutoBattler {

	static int TURN_MAX = 3;

	public static void main(String[] args) {
		Game game = loadGame();
		if (game == null) {
			//There is not a save file (yet)
			System.out.println("There is not a save file");
			game = newGame();
		}
		ArrayList<Character> characters = game.characters();
		ArrayList<Damageable> damageables = game.damageables();

		int turn = 1;

		/*
		 * Each character attacks a random other character
		 * until only one character is left alive
		 * e.g. characters[0] should attack [1] or [2] or i != 0
		 * e.g. characters[n] should attack [i != n]
		 */
		while (!gameOver(characters)) {
			if (turn < TURN_MAX) {
				// Each character's attack
				for (Character current : characters) {
					if (!current.isDead()) {
						Character other = null;

						Random r = new Random();
						// Get a random character that is not ourself and is still alive
						while (other == null || current == other || other.isDead()) {
							other = characters.get(r.nextInt(characters.size()));
						}

						// other is not ourself
						current.attacks(other);
					}
				}
				turn++;
			}
			else { //Save the game and exit
				System.out.println("""
				All %d turns are over. 
				
				Party report:
				%s
				
				Saving the game until next time."
				""".formatted(TURN_MAX, characters.toString().replace(", ", "")));
				saveGame(characters, damageables);
				break; //Exit the game
			}
		}
	}

	/**
	 * Everything that makes up a battle: the fighters and everything that can take damage (e.g. minions, too)
	 */
	private record Game(ArrayList<Character> characters, ArrayList<Damageable> damageables) {}

	/**
	 * Creates the starting party
	 */
	private static Game newGame() {
		ArrayList<Damageable> damageables = new ArrayList<>();
		ArrayList<Character> characters = new ArrayList<>();

		Wizard wizard = new Wizard("Gandalf");
		Warrior warrior = new Warrior("Gimli");
		Ranger ranger = new Ranger("Legolas");
		Templar templar = new Templar("TreeBeard");
		Healer healer = new Healer("Samwise");
		Summoner summoner = new Summoner("King of the Dead", damageables);

		characters.addAll(Arrays.asList(wizard, warrior, ranger, templar, healer, summoner));
		damageables.addAll(characters);

		Demolitionist demolitionist = new Demolitionist("Pippin", damageables);
		damageables.add(demolitionist);
		characters.add(demolitionist);

		return new Game(characters, damageables);
	}

	/**
	 * Loads a partially finished game from the save file.
	 * Both lists are saved in one stream so objects they share
	 * (e.g. the damageables list held by the Summoner and Demolitionist) stay shared after loading.
	 * @return the saved game, or null if there is no usable save file
	 */
	@SuppressWarnings("unchecked")
	private static Game loadGame() {
		InputStream inF = AutoBattler.class.getResourceAsStream("/gamedata.auto");
		if (inF == null) {
			return null;
		}

		Game game;
		try (ObjectInputStream reader = new ObjectInputStream(inF)) {
			game = new Game((ArrayList<Character>) reader.readObject(), (ArrayList<Damageable>) reader.readObject());
		} catch (IOException | ClassNotFoundException | ClassCastException e) {
			System.err.println("Error reading file/objects\n" + e.getMessage());
			return null;
		}

		System.out.println("There is a save file");
		System.out.println("Character Status:");
		for (Character c : game.characters()) {
			System.out.print(c.toString());
		}
		return game;
	}

	private static void saveGame(ArrayList<Character> characters, ArrayList<Damageable> damageables) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(saveFile()))) {
			writer.writeObject(characters);
			writer.writeObject(damageables);
		} catch (IOException e) {
			System.err.println("Error writing file/objects\n" + e.getMessage());
		}
	}

	// The save file lives in the resources root so getResourceAsStream can find it later.
	// getResource("/") is null inside a named module, so use the classes folder's location instead.
	private static File saveFile() throws IOException {
		try {
			File root = new File(AutoBattler.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			return new File(root, "gamedata.auto");
		} catch (URISyntaxException e) {
			throw new IOException(e);
		}
	}

	public static boolean gameOver(ArrayList<Character> characters) {
		// Check if a single character is alive and all others are dead
		int dead = 0;
		for (Character c : characters) {
			if (c.isDead()) {
				dead++;
			}
		}
		if (dead >= (characters.size() - 1)) {
			for (Character c : characters) {
				if (!c.isDead()) {
					System.out.println(c);
					System.out.println(c.getName() + " is the winner!");
					try {
						//Delete the saved game file
						Files.deleteIfExists(saveFile().toPath());
					} catch (IOException e) {
						System.err.println("Error deleting file\n" + e.getMessage());
					}
					return true;
				}
			}
			return true;
		}

		return false;
	}

}
