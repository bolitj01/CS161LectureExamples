package serialization.autobattler;


public class Templar extends Character {

    private Structure shield;

    public Templar(String name) {
        super(name, "Templar", 130, 3.5);
        shield = new Structure("Shield", 50);
    }

    /**
     * @param enemy
     */
    @Override
    public void attacks(Character enemy) {
        enemy.takeDamage(damage, getName());
    }

    @Override
    public void takeDamage(double damage, String damageSource) {
        if (!shield.isBroken()) {
            //Mitigate 75% of damage
            double shieldDamage = damage * .75;
            damage = damage * .25;
            shield.takeDamage(shieldDamage, damageSource);
        }
        super.takeDamage(damage, damageSource);
    }
}
