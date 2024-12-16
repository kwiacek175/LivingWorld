package main.java.Organisms;

import main.java.LivingSimulation.SimulationDisplay;
import main.java.OrganismsAbstract.Animal;
import main.java.OrganismsAbstract.IAnimal;

public class Llama extends Animal{

    private static final long serialVersionUID = 1L;
    final int REP_TIME=2000;
    private boolean specialAbility;

    public Llama(int x, int y, int xDirection, int yDirection) {
        super("LlamaL.png","LlamaR.png", x, y, (short)xDirection,(short) yDirection, 1, 1, false, 3, 7);
        specialAbility=false;
    }

    @Override
    public void attack(IAnimal opponent)
    {
        if(!(opponent instanceof Llama)) {
            System.out.println("false");
            this.hp -= opponent.getAttack();
        }
        this.specialAbility=true;
        if (this.hp<=0) {
            setVisible(false);	Animal.visibleAnimals--;
        }
    }
    @Override
    public boolean isFriend(IAnimal org) {
        if(org instanceof Llama) return true;
        else return false;
    }

    @Override
    public void spell()
    {
        if(specialAbility)
        {
            this.setX(this.getX()+this.xDirection*15);
            this.setY(this.getY()+this.yDirection*15);
            specialAbility=false;
        }
    }
    @Override
    public IAnimal reproduct()
    {
        System.out.println("Llama reproduction");
        return SimulationDisplay.aFactory.createAnimal("Llama", group.chef.getX(), group.chef.getY());
    }
}
