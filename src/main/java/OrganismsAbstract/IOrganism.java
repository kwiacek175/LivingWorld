package main.java.OrganismsAbstract;

import java.awt.Image;

public interface IOrganism
{
    Image getIcon();
    public void setIcon(String iconName);
    int getX();
    void setX(int x);
    int getY();
    void setY(int y);
    boolean ifCollide();
    void collision(boolean c);
    void setVisible(boolean a);
    boolean isVisible();
}
