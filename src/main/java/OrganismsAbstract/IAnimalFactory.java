package main.java.OrganismsAbstract;

public interface IAnimalFactory {
    IAnimal createRandomAnimal(String choice);
    IAnimal createAnimal(String choice, int x, int y);
}
