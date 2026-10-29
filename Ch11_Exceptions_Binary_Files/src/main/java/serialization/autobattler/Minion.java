package serialization.autobattler;

public class Minion extends Character{

    public Minion(String name) {
        super(name, "Minion", 10, 5);
    }

	@Override
	public void attacks(Character enemy) {
		enemy.takeDamage(damage, getName());
	}
    
}
