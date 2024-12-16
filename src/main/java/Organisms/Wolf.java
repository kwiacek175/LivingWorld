package main.java.Organisms;

import main.java.LivingSimulation.SimulationDisplay;
import main.java.OrganismsAbstract.Animal;
import main.java.OrganismsAbstract.IAnimal;

public class Wolf extends Animal
{

    private static final long serialVersionUID = 1L;

    private int spAbTime; private boolean specialAbility;

    public Wolf(int x, int y, int xDirection, int yDirection)
    {
        super("WolfL.png", "WolfR.png", x, y,(short) xDirection, (short)yDirection, 1, 1, true, 6, 10);
        spAbTime=0;
        specialAbility=false;
    }

    public void attack(IAnimal opponent)
    {
        if(!isFriend(opponent)) {
            System.out.println("false");
            this.hp -= opponent.getAttack();
        }
        spAbTime=2000;
        if (this.hp<=0) {
            setVisible(false); Animal.visibleAnimals--;
        }
    }

    @Override
    public boolean isFriend(IAnimal org) {
        if(org instanceof Wolf) return true;
        else return false;
    }

    @Override
    public void spell()
    {
        if(spAbTime>0 && this.specialAbility==false)
        {
            this.specialAbility=true;
            this.attackPoint*=2;
        }
        else if(this.specialAbility==true)
        {
            this.spAbTime-=25;
            if(spAbTime<0)
            {
                this.attackPoint/=2;
                this.specialAbility=false;
            }
        }
    }

    public IAnimal reproduct()
    {
        System.out.println("Wolf reproduction");
        return SimulationDisplay.aFactory.createAnimal("Wolf", group.chef.getX(), group.chef.getY());
    }
}
