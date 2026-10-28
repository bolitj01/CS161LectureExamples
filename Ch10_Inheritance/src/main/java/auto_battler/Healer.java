package auto_battler;

public class Healer extends Character {

    // Chance to heal instead of attack
    private final double HEAL_CHANCE = 0.65;

    public Healer(String name) {
        super(name, "Healer", 85, 5);
    }

    /**
     * Decide to attack the enemy or just heal themselves
     *
     * @param enemy
     */
    @Override
    public void attacks(Character enemy) {
        double turnChance = Math.random();
        //Heal
        if (turnChance <= HEAL_CHANCE) {
            gainHealth(damage);
            healReport(this, damage);
        }
        //Attack
        else {
            enemy.takeDamage(damage, getName());
        }

    }
}
