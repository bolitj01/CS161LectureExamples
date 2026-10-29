package serialization.autobattler;

public class Ranger extends Character {
	
	
	double criticalHitChance;
	
	public Ranger(String name) {
		super(name, "Ranger", 76, 11);
		criticalHitChance = .25;
	}
	
	@Override
	public void attacks(Character enemy) {
		double attackDamage = damage;
		if (Math.random() >= criticalHitChance) {
			attackDamage *= 2;
		}
		enemy.takeDamage(attackDamage, getName());
	}

    //Ranger has a 20% chance to dodge an attack
    @Override
    public void takeDamage(double damage, String damageSource) {
        if (Math.random() <= 0.20) {
            System.out.println(getName() + " dodged the attack!");
        } else {
            super.takeDamage(damage, damageSource);
        }
    }
	
	/**
	 * Generated serial version ID for Serializable
	 */
	private static final long serialVersionUID = -1797907076213073842L;
}
