package serialization.autobattler;

import java.util.ArrayList;

public class Demolitionist extends Character {

	ArrayList<Bomb> bombs;
	ArrayList<Damageable> damageables;
    private final int BOMB_COUNT = 2;
	
	public Demolitionist(String name, ArrayList<Damageable> d) {
		super(name, "Demolitionist", 110, 4);
		bombs = new ArrayList<>();
		//Load bombs
		for (int i = 0; i < BOMB_COUNT; i++) {
			bombs.add(new Bomb(this));
		}
		damageables = d;
	}

	@Override
	public void attacks(Character enemy) {
		//30% chance to use a bomb
		boolean useBomb = Math.random() < .3 ? true: false;
		if (useBomb && bombs.size() > 0) {
			//Use a bomb
			Bomb b = bombs.remove(0);
			b.explode(damageables);
		}
		else{
			//Attack normally
			enemy.takeDamage(damage, getName());
		}

	}
	
	
	/**
	 * Generated serial version ID for Serializable
	 */
	private static final long serialVersionUID = 8572213249247839182L;

}
