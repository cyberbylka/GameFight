package characters;

import client.Army;

public class Warrior {
    private static final int ATTACK = 5;
    private static final int BASIC_HEALTH = 50;
    private int health = BASIC_HEALTH;

    Warrior() {this(BASIC_HEALTH);}

    protected Warrior(int health )
    {
        this.health = health;
    }

    public int getAttack() { return ATTACK; }
    public int getHealth() { return health; }

    public void setHealth(int health) {
        if(health < 0)
            this.health = 0;
        else this.health = health;
    }

    public boolean isAlive() {return health > 0;}

    public void hit(Warrior opponent)
    {
        opponent.receiveDamage(getAttack());
        opponent.processCommand(new OurChampionHasHit(){},null);
    }

    public int receiveDamage(int damage)
    {
        if(damage < 0)
            damage = 0;
        setHealth(getHealth() - damage);
        return damage;
    }

    public void processCommand(Command command, Warrior sender)
    {
        if(this instanceof Army.HasWarriorBehind current) {
            var next = current.getWarriorBehind();
            if (next != null && next instanceof Army.UnitInArmy unit) {
                if(sender == null)
                    unit.processCommand(command, this);
                else unit.processCommand(command, sender);
            }
        }
    }

    protected void healBy(int heal_power)
    {
        if(getHealth() + heal_power <= BASIC_HEALTH)
            setHealth(getHealth() + heal_power);
    }

    @Override
    public String toString()
    {
        return String.format("%s {health = %d, attack = %d}",getClass().getSimpleName(),getHealth(),getAttack());
    }
}
