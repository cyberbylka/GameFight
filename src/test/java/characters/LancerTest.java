package characters;
import client.Army;
import client.Battle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class LancerTest {
    @Test
    @DisplayName("Smoke test for Lancer task")
    void smokeTest5() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();
        var freelancer = new Lancer();
        var vampire = new Vampire();

        assertTrue(Battle.fight(chuck, bruce));
        assertFalse(Battle.fight(dave, carl));
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
        assertFalse(Battle.fight(carl, mark));
        assertFalse(carl.isAlive());
        assertFalse(Battle.fight(bob, mike));
        assertTrue(Battle.fight(lancelot, rog));
        assertFalse(Battle.fight(eric, richard));
        assertTrue(Battle.fight(ogre, adam));
        assertTrue(Battle.fight(freelancer, vampire));
        assertTrue(freelancer.isAlive());

        var myArmy = new Army()
                .addUnits(Defender::new, 2)
                .addUnits(Vampire::new, 2)
                .addUnits(Lancer::new, 4)
                .addUnits(Warrior::new, 1);

        var enemyArmy = new Army()
                .addUnits(Warrior::new, 2)
                .addUnits(Lancer::new, 2)
                .addUnits(Defender::new, 2)
                .addUnits(Vampire::new, 3);

        var army3 = new Army()
                .addUnits(Warrior::new, 1)
                .addUnits(Lancer::new, 1)
                .addUnits(Defender::new, 2);

        var army4 = new Army()
                .addUnits(Vampire::new, 3)
                .addUnits(Warrior::new, 1)
                .addUnits(Lancer::new, 2);

        assertTrue(Battle.fight(myArmy, enemyArmy));
        assertFalse(Battle.fight(army3, army4));
    }
}
