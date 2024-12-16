package main.java.OrganismsAbstract;

public interface IAnimal extends IOrganism, Groupable {

    int getxSpeed();
    int getySpeed();
    short getxDirection();
    void setxDirection(short xDirection);
    short getyDirection();
    void setyDirection(short yDirection);
    void changeDirection();
    boolean isPredator();
    int getAttack();
    void attack(IAnimal opponent);
    boolean isFriend(IAnimal org);
    void spell();

    IAnimal reproduct();

    public int getHp();
    public void hpUp(int hp);
}
