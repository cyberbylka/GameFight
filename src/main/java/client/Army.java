package client;

import characters.Command;
import characters.Warrior;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.Supplier;


public class Army {
    private LinkedList<UnitInArmy> troops = new LinkedList<UnitInArmy>();

    public interface HasWarriorBehind
    {
        Warrior getWarriorBehind();

        void setWarriorBehind(Warrior behind);
    }
    public static class UnitInArmy extends Warrior implements HasWarriorBehind {
        Warrior behind;
        Warrior current;

        @Override
        public Warrior getWarriorBehind() {
            return behind;
        }



        @Override
        public void setWarriorBehind(Warrior behind)
        {
            this.behind = behind;
        }
       /* protected UnitInArmy(int health) {
            super(health);
        }*/

        UnitInArmy(Warrior current,Warrior behind)
        {
            super(0);
            this.current = current;
            this.behind = behind;
        }
        @Override
        public int receiveDamage(int damage)
        {
            return current.receiveDamage(damage);
        }
        @Override
        public int getAttack() {
            return current.getAttack();
        }

        @Override
        public int getHealth() {
            return current.getHealth();
        }

        @Override
        public void setHealth(int health) {
            current.setHealth(health);
        }

        @Override
        public boolean isAlive() {
            return current.isAlive();
        }



        @Override
        public void hit(Warrior opponent)
        {
            current.hit(opponent);
        }
        UnitInArmy(Warrior warrior) {
            super(warrior.getHealth());
            current = warrior;
            //super();
            //this->behind = warrior;
        }
    }
    public Iterator<Warrior> firstAlive()
    {
        return new FirstAliveIterator();
    }
    private class FirstAliveIterator implements Iterator<Warrior>
    {
        @Override
        public boolean hasNext()
        {
            while (peekFirst() != null && !peekFirst().isAlive())
            {
                removeFirst();
            }
            return peekFirst() != null;
        }

        @Override
        public Warrior next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return peekFirst();
        }
    }

    public Army addUnits(Warrior warrior)
    {
        if(!troops.isEmpty())
            troops.get(troops.size() - 1).setWarriorBehind(warrior);
        troops.add(new UnitInArmy(warrior,null));
        return this;
    }

    public Army addUnits(Supplier<Warrior> factory, int count)
    {
        for(int i = 0; i < count;i++)
            addUnits(factory.get());
        return this;
    }

    private Warrior peekFirst()
    {
        return troops.peek();
    }

    private void removeFirst()
    {
        troops.poll();
    }


}
