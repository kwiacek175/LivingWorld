package main.java.Organisms;

import main.java.OrganismsAbstract.Plant;

public class Flower extends Plant{

    private static final long serialVersionUID = 1L;

    public Flower(int x, int y) {
        super("Flower.png", x, y, 4000,10);
    }
}
