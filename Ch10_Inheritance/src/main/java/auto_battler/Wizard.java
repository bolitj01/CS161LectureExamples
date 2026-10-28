package auto_battler;

public class Wizard extends Character {

    int mana;
    Structure magicShield;
    final static int SHIELD_RECHARGE = 30;

    public Wizard(String name) {
        super(name, "Wizard", 60, 12);
        magicShield = new Structure("Magic Shield", 0);
        mana = 0;
    }

    @Override
    public void attacks(Character enemy) {
        double attackDamage = damage;
        if (mana >= 3) {
            if (magicShield.isBroken()) {
                magicShield.repair(SHIELD_RECHARGE);
            } else {
                attackDamage *= 1.5;
            }
            mana -= 3;
        }
        enemy.takeDamage(attackDamage, getName());
        mana += 1;
    }

    @Override
    public void takeDamage(double damage, String damageSource) {
        if (!magicShield.isBroken()) {
            double difference = damage - magicShield.durability;
            magicShield.takeDamage(damage, damageSource);
            if (difference > 0) {
                super.takeDamage(difference, damageSource);
            }
        }
        else {
            super.takeDamage(damage, damageSource);
        }
    }

    /**
     * Generated serial version ID for Serializable
     */
    private static final long serialVersionUID = -5182786534055168478L;

}
