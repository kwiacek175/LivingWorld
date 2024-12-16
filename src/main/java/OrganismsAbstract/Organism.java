package main.java.OrganismsAbstract;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;

public abstract class Organism extends JComponent implements IOrganism{

    private static final long serialVersionUID = 1L;
    protected int x;
    protected int y;
    protected boolean collide;
    protected Image icon;

    public Organism(int x, int y, String iconName)
    {
        this.x=x;
        this.y=y;

        this.icon=Toolkit.getDefaultToolkit().getImage("src/main/resources/"+iconName);
    }
    public int getX()
    {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Image getIcon() {
        return this.icon;
    }
    public void setIcon(String iconName) {
        this.icon=Toolkit.getDefaultToolkit().getImage("src/main/resources/"+iconName);
    }
    public boolean ifCollide()
    {
        return this.collide;
    }
    public void collision(boolean c)
    {
        this.collide=c;
    }
}
