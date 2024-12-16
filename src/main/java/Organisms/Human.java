package main.java.Organisms;

import java.util.Random;

import main.java.LivingSimulation.SimulationDisplay;
import main.java.OrganismsAbstract.Animal;
import main.java.OrganismsAbstract.IAnimal;

public class Human extends Animal
{

    private static final long serialVersionUID = 1L;

    private boolean specialAbility; private Random rnd;

    public Human(int x, int y, int xDirection, int yDirection)
    {
        super("Human.png", x, y,(short) xDirection, (short)yDirection, 1, 1, false, 5, 10);
        specialAbility=false;
        rnd=new Random();
    }

    @Override
    public void attack(IAnimal opponent)
    {
        if(!(opponent instanceof Human)) {
            System.out.println("false");
            this.hp -= opponent.getAttack();
        }
        specialAbility=true;
        if (this.hp<=0) {
            setVisible(false);	Animal.visibleAnimals--;
        }
    }

    @Override
    public boolean isFriend(IAnimal org) {
        if(org instanceof Human) return true;
        else return false;
    }

    @Override
    public IAnimal reproduct()
    {
        return SimulationDisplay.aFactory.createAnimal("Human", group.chef.getX(), group.chef.getY());
    }

    @Override
    public void spell()
    {
        if(specialAbility==true)
        {
            int chance =rnd.nextInt(50);
            if(chance==1) hp++;
            specialAbility=false;
        }
    }


}
