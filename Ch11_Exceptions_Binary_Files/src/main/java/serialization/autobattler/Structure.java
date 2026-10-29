package serialization.autobattler;

import java.io.Serializable;

public class Structure implements Damageable, Serializable {
	
	String name;
	double durability;
    boolean broken;
	
	public Structure(String name, double durability) {
		this.name = name;
		this.durability = durability;
        broken = durability > 0 ? true : false;
	}


	public void takeDamage(double damage, String damageSource) {
		durability -= damage;
        if (durability < 0){
            durability = 0;
            broken = true;
        }
		System.out.println(name + " took " + damage + " damage");
	}

	public void repair(double durability) {
		this.durability += durability;
        System.out.println(name + " repaired " + durability + " durability.");
	}

	public boolean isBroken() {
		return durability <= 0;
	}
}
