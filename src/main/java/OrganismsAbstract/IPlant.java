package main.java.OrganismsAbstract;

public interface IPlant extends IOrganism {
    int getReproductionTime();
    int getGeneration();
    void setGeneration(int amount);
    void upGeneration();
}
