package auto_battler;

import java.util.ArrayList;

public class Summoner extends Character {

    int mana;
    final int SUMMON_COST = 2;
    ArrayList<Minion> summons;
    ArrayList<Damageable> damageables;

    public Summoner(String name, ArrayList<Damageable> damageables) {
        super(name, "Summoner", 60, 1);
        summons = new ArrayList<>();
        mana = 3;
        this.damageables = damageables;
    }

    @Override
    public void attacks(Character enemy) {
        double attackDamage = damage;
        if (mana >= 3) { //New summon if not full
            if (summons.size() < 3){
                Minion m = new Minion("Oathbreaker " + (summons.size() + 1));
                summons.add(m);
                damageables.add(m);
                System.out.println(getName() + " summons a new minion: " + m.getName());
            }
            mana -= SUMMON_COST;
        }
        enemy.takeDamage(attackDamage, getName());
        mana += 1;

        //All summons attack same target
        if (!summons.isEmpty()){
            for (Minion m: summons){
                m.attacks(enemy);
            }
        }
    }

    @Override
    public void takeDamage(double damage, String damageSource) {
        //Chance to his summoner is 1/(number of summons + summoner themselves)
        double hitSummonChance = 1.0 / (summons.size() + 1);

        double dodgeRoll = Math.random();

        if (dodgeRoll < hitSummonChance){
            //Summoner gets hit
            super.takeDamage(damage, damageSource);
        }
        else {
            //Random summon takes damage
            int summonIndex = (int)(Math.random() * summons.size());
            Minion damagedMinion = summons.get(summonIndex);
            damagedMinion.takeDamage(damage, damageSource);
            System.out.println(getName() + "'s minion " + damagedMinion.getName() + " covers the damage.");
            if (damagedMinion.isDead()){
                summons.remove(summonIndex);
                damageables.remove(damagedMinion);
                System.out.println(damagedMinion.getName() + " has died.");
            }
        }
    }

    /**
     * Generated serial version ID for Serializable
     */
    private static final long serialVersionUID = -5182786534055168478L;

}
