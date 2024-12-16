package main.java.OrganismsAbstract;

public abstract class Plant extends Organism implements IPlant{

    private static final long serialVersionUID = 1L;
    private int reproductionTime;
    private int generation=1;
    private int repDelay;
    public static int visiblePlants=0;
    public static int livedPlants=0;

    public Plant(String iconName,int x, int y, int reproductionTime, int repDelay) {
        super(x, y, iconName);
        this.reproductionTime=reproductionTime;
        this.repDelay=repDelay;
    }

    @Override
    public int getReproductionTime()
    {
        return reproductionTime;
    }
    @Override
    public int getGeneration()
    {
        return generation;
    }
    @Override
    public void setGeneration(int amount)
    {
        this.generation=amount;
    }
    @Override
    public void upGeneration()
    {
        this.generation=this.generation+repDelay;
    }
}
