package characters;

public class Vampire extends Warrior{
    private static final int VAMPIRISM = 50;
    private static final int ATTACK = 4;
    private static final int BASIC_HEALTH = 40;
    Vampire()
    {
        super(BASIC_HEALTH);
    }

    @Override
    public int getAttack()
    {
        return ATTACK;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hit(Warrior opponent)
    {
        int real_damage = opponent.receiveDamage(getAttack());
        int heal = getVampirism()*real_damage/100;
        if(getHealth() + heal <= BASIC_HEALTH)
            setHealth(getHealth() +  heal);
        else setHealth(BASIC_HEALTH);
    }
}
