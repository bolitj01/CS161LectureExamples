package serialization.autobattler;

/**
 * Warrior deals increased damage based on lost health.
 */
public class Warrior extends Character {
    private static final double MID_HP_THRESHOLD = 0.5;
    private static final double MID_HP_MULTIPLIER = 1.5;
    private static final double LOW_HP_THRESHOLD = 0.2;
    private static final double LOW_HP_MULTIPLIER = 2.0;
    private static final double MAX_HP = 115;

    public Warrior(String name) {
        super(name, "Warrior", MAX_HP, 10);
    }

    @Override
    public void attacks(Character enemy) {
        double healthPercent = getHealth() / MAX_HP;
        double multiplier = 1.0;
        if (healthPercent < LOW_HP_THRESHOLD) {
            multiplier = LOW_HP_MULTIPLIER;
        } else if (healthPercent < MID_HP_THRESHOLD) {
            multiplier = MID_HP_MULTIPLIER;
        }

        enemy.takeDamage(damage * multiplier, getName());
    }


    /**
     * Generated serial version ID for Serializable
     */
    private static final long serialVersionUID = 444137185355925021L;
}
