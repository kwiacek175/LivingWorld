package main.java.Organisms;

import main.java.LivingSimulation.SimulationDisplay;
import main.java.OrganismsAbstract.Animal;
import main.java.OrganismsAbstract.IAnimal;

public class Sheep extends Animal{


    private static final long serialVersionUID = 1L;
    private int spAbTime; private boolean specialAbility;

    public Sheep(int x, int y, int xDirection, int yDirection) {
        super("SheepL.png", "SheepR.png", x, y,(short) xDirection,(short)yDirection, 1, 1, false, 2,9);
        spAbTime=0;
        specialAbility=false;
    }

    @Override
    public void attack(IAnimal opponent)
    {
        if(!(opponent instanceof Sheep)) {
            System.out.println("false");
            this.hp -= opponent.getAttack();
        }
        if (this.hp<=0) setVisible(false);
        spAbTime=3000;

    }

    @Override
    public boolean isFriend(IAnimal org) {
        if(org instanceof Sheep) return true;
        else return false;
    }

    //	@Override
    public void spell()
    {
        if(spAbTime>0 && this.specialAbility==false)
        {
            this.specialAbility=true;
            this.xSpeed*=2;
            this.ySpeed*=2;
        }
        else if(this.specialAbility==true)
        {
            this.spAbTime-=25;
            if(spAbTime<0)
            {
                this.xSpeed/=2;
                this.ySpeed/=2;
                this.specialAbility=false;
            }
        }
    }

    @Override
    public IAnimal reproduct()
    {
        System.out.println("Sheep reproduction");
        return SimulationDisplay.aFactory.createAnimal("Sheep", group.chef.getX(), group.chef.getY());
    }

}
