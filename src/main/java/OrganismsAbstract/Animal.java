package main.java.OrganismsAbstract;

public abstract class Animal extends Organism implements IAnimal, Groupable
{

    private static final long serialVersionUID = 1L;
    String leftImage;
    String rightImage;

    protected short xDirection;
    protected short yDirection;
    protected int xSpeed;
    protected int ySpeed;
    protected int hp;
    protected int attackPoint;
    protected boolean predator;
    public static int visibleAnimals=0;
    public static int livedAnimals=0;

    protected Group group;

    public Animal(String leftImage, String rightImage, int x, int y, short xDirection, short yDirection, int xSpeed, int ySpeed, boolean predator, int attack, int hp)
    {
        super(x, y, rightImage);
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
        this.xDirection=xDirection;
        this.yDirection=yDirection;
        this.predator=predator;
        this.attackPoint=attack;
        this.hp=hp;
        this.leftImage=leftImage;
        this.rightImage=rightImage;
    }

    public Animal(String rightImage, int x, int y, short xDirection, short yDirection, int xSpeed, int ySpeed, boolean predator, int attack, int hp)
    {
        this(rightImage, rightImage, x, y, xDirection, yDirection, xSpeed, ySpeed, predator, attack, hp);
    }


    @Override
    public int getxSpeed() {
        return xSpeed;
    }


    @Override
    public int getySpeed() {
        return ySpeed;
    }


    @Override
    public short getxDirection() {
        return xDirection;
    }


    @Override
    public void setxDirection(short xDirection) {
        this.xDirection = xDirection;
    }


    @Override
    public short getyDirection() {
        return yDirection;
    }


    @Override
    public void setyDirection(short yDirection) {
        this.yDirection = yDirection;
    }


    @Override
    public void changeDirection()
    {
        this.xDirection*=-1;
        this.yDirection*=-1;
    }


    @Override
    public boolean isPredator()
    {
        return this.predator;
    }

    public int getAttack()
    {
        return this.attackPoint;
    }


    @Override
    public void setGroup(Group group) {
        this.group=group;

    }


    @Override
    public Group getGroup() {
        return this.group;

    }

    @Override
    public boolean isGrouped() {
        if(group!=null) return true;
        else return false;
    }

    private void changeImage()
    {
        if(xDirection==1) setIcon(rightImage);
        else if(xDirection==-1) setIcon(leftImage);
    }

    @Override

    public int getX()
    {
        changeImage();
        return x;
    }

    @Override
    public int getHp()
    {
        return hp;
    }
    @Override
    public void hpUp(int hp)
    {
        this.hp+=hp;
    }
}

