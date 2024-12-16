package main.java.Organisms;

import main.java.LivingSimulation.SimulationDisplay;
import main.java.OrganismsAbstract.Animal;
import main.java.OrganismsAbstract.IAnimal;

public class PlaceHolder extends Animal{

    private static final long serialVersionUID = 1L;

    public PlaceHolder(int x, int y, int xDirection, int yDirection)
    {
        super("PlaceHolder.png", x, y,(short) xDirection, (short)yDirection, 1, 1, true, 1, 1);
    }

    @Override
    public void attack(IAnimal opponent) {

        System.out.println("false");
        this.hp -= opponent.getAttack();

        if (this.hp<=0) {
            setVisible(false);	Animal.visibleAnimals--;
        }
    }
    @Override
    public boolean isFriend(IAnimal org) {
        if(org instanceof PlaceHolder) return true;
        else return false;
    }

    @Override
    public IAnimal reproduct()
    {
        return SimulationDisplay.aFactory.createRandomAnimal("a");
    }

    @Override
    public void spell()
    {

    }
}
