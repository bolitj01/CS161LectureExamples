package auto_battler;

import java.io.Serializable;
import java.util.ArrayList;

public class Bomb implements Serializable{

	double damage;
	Character owner;
	
	public Bomb(Character owner) {
		this.owner = owner;
		damage = 20;
	}
	
	public void explode(ArrayList<Damageable> dables) {
		System.out.println(owner.getName() + "explodes a Bomb!");
		//50% chance for the Bomb to damage its owner
		boolean damageOwner = Math.random() < .5 ? true: false;
		//Iterate a copy since damaged units (e.g. dead minions) remove themselves from the list
		for (Damageable d: new ArrayList<>(dables)) {
			//Damage others always and sometimes owner
			if (d != owner || (d == owner && damageOwner)) {
				d.takeDamage(damage, "Bomb");
			}
		}
	}
	
	/**
	 * Generated serial version ID for Serializable
	 */
	private static final long serialVersionUID = 7359959069933234108L;
	
}
