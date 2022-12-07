package characters;

import client.Army;

public class Healer extends Warrior{
    private static final int HEAL_POWER = 2;
    private static final int BASIC_HEALTH = 60;
    private static final int ATTACK = 0;

    @Override
    public void hit(Warrior warrior)
    {

    }
    Healer()
    {
        super(BASIC_HEALTH);
    }
    @Override
    public int getAttack() { return ATTACK;}

    public void processCommand(Command command,Warrior sender)
    {
        if(sender instanceof OurChampionHasHit && sender instanceof Army.UnitInArmy unit) {
            heal(sender);
            unit.processCommand(command, sender);
        }

    }

    public int getHealPower()
    {
        return HEAL_POWER;
    }
    private void heal(Warrior warrior)
    {
        warrior.healBy(getHealPower());
    }
}
