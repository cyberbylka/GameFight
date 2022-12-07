package characters;
import client.Army;

public class Lancer extends Warrior{
    private static final int ATTACK = 6;
    private static final int PIERCING_POWER = 50;

    @Override
    public int getAttack()
    {
        return ATTACK;
    }

    @Override
    public void hit(Warrior opponent)
    {
        int real_damage = opponent.receiveDamage(getAttack());

        if (opponent instanceof Army.HasWarriorBehind unitInArmy)
        {
            Warrior next = unitInArmy.getWarriorBehind();
            if(next != null)
                next.receiveDamage(real_damage*PIERCING_POWER/100);
        }
    }
}
