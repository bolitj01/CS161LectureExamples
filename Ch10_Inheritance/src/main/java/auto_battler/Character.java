package auto_battler;

import java.io.Serializable;

public abstract class Character implements Damageable, Serializable{

	private double health;
	protected double damage;
	private String name;
    private String specialization;
	
	public Character(String name, String specialization, double health, double damage) {
		this.health = health;
        this.specialization = specialization;
		this.damage = damage;
		this.name = name;
	}
	
	public void takeDamage(double damage, String damageSource) {
		health -= damage;
		System.out.printf("%s hits %s for %.0f damage\n", damageSource, name, damage);
		System.out.printf(toString());
	}

    public void gainHealth(double health){
        this.health += health;
    }
	
	/**
	 * Attack by calling enemy.takeDamage(damage, getName()), which prints the report
	 * @param enemy
	 */
	public abstract void attacks(Character enemy);

    public void healReport(Character ally, double health) {
        System.out.printf("%s heals %s for %.0f health\n", name, ally.name, health);
        System.out.printf(ally.toString());
    }
	
	public boolean isDead() {
		return health <= 0 ? true: false;
	}
	
	public String toString() {
		return String.format("%s the %s %s\n\n", name, specialization,
				isDead() ? 	String.format("is dead.") : 
							String.format("has %.0f health", health)); 
	}

	public String getName() {
		return name;
	}

    public double getHealth() {
        return health;
    }
	
	/**
	 * Generated serial version ID for Serializable
	 */
	private static final long serialVersionUID = 6223241193634034129L;
}
