package main.java.Organisms;

import java.util.Random;

import main.java.LivingSimulation.SimulationDisplay;
import main.java.OrganismsAbstract.Animal;
import main.java.OrganismsAbstract.IAnimal;

public class Tiger extends Animal{


    private static final long serialVersionUID = 1L;
    private boolean specialAbility;
    Random rnd;

    public Tiger(int x, int y, int xDirection, int yDirection) {
        super("TigerL.png", "TigerR.png", x, y,(short) xDirection,(short) yDirection, 1, 1, true, 5, 11);
        specialAbility=false;
        rnd=new Random();
    }

    @Override
    public void attack(IAnimal opponent)
    {
        if(!(this.isFriend(opponent))) {
            System.out.println("false");
            this.hp -= opponent.getAttack();
        }
        specialAbility=true;
        if (this.hp<=0) setVisible(false);

    }

    @Override
    public boolean isFriend(IAnimal org) {
        if(org instanceof Tiger) return true;
        else return false;
    }
    public void spell()
    {
        if(specialAbility==true)
        {
            int chance = rnd.nextInt(20);
            if(chance == 1)  attackPoint++;

            specialAbility=false;
        }

    }
    @Override
    public IAnimal reproduct()
    {
        System.out.println("Tiger reproduction");
        return SimulationDisplay.aFactory.createAnimal("Tiger", group.chef.getX(), group.chef.getY());
    }
}
