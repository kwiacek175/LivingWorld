package main.java.OrganismsAbstract;

public interface IPlantFactory {
    IPlant createNewPlant(String choice, int x, int y);
    IPlant createRandomPlant(String choice);
    IPlant createNewChild(IPlant plant, int x, int y);
}
