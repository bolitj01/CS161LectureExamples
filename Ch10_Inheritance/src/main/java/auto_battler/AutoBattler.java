package auto_battler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AutoBattler {

	public static void main(String[] args) {
		ArrayList<Damageable> damageables = new ArrayList<Damageable>();
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

		/**
		 * Each character attacks a random other character
		 * until only one character is left alive
		 * e.g. characters[0] should attack [1] or [2] or i != 0
		 * e.g. characters[n] should attack [i != n]
		 */
		while (!gameOver(characters)) {
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
				}
			}
			return true;
		}

		return false;
	}

}
