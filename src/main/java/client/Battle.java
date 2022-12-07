package client;

import characters.Warrior;
import client.Army;

public class Battle {
    public static boolean fight(Warrior warrior1, Warrior warrior2)
    {
        while (warrior1.isAlive() && warrior2.isAlive())
        {
            warrior1.hit(warrior2);
            if(warrior2.isAlive())
                warrior2.hit(warrior1);
        }
        return warrior1.isAlive();
    }

    public static boolean fight(Army army1, Army army2)
    {
        var it1 = army1.firstAlive();
        var it2 = army2.firstAlive();
        while (it1.hasNext() && it2.hasNext())
        {
           // System.out.print(it2.next().getHealth());
            fight(it1.next(), it2.next());
            //System.out.print(it2.next().getHealth());
        }
        return it1.hasNext();
    }
}
