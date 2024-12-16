package main.java.OrganismsAbstract;

import java.util.Vector;
import main.java.LivingSimulation.SimulationFrame;

public class Group {
    public Vector<IAnimal> members;
    public IAnimal chef;
    public int x;
    public int y;
    public int size = 150;
    public int repTime;
    public static int REP_TIME=6000;

    public Group(IAnimal a1, IAnimal a2)
    {
        members=new Vector<IAnimal>(1);
        chef = a1;
        members.add(a1);
        members.add(a2);
        this.x = a1.getX()-size/2;
        this.y = a1.getY()-size/2;
        repTime=REP_TIME;

    }

    public void reCoord()
    {

        this.x = chef.getX() - size/2;
        this.y = chef.getY() - size/2;
        repTime= repTime - SimulationFrame.TIME_RES;
    }

    public void addMember(IAnimal a)
    {
        if(chef.isFriend(a)) members.add(a);
    }

    public boolean isPregnant()
    {
        int visible=0;
        for(int i=0;i<members.size();i++)
        {

            if(members.get(i).isVisible())
                visible++;


        }
        if(repTime<0 && visible>=2 && visible<15) return true;
        return false;

    }

    public IAnimal getChild()
    {
        repTime=REP_TIME;
        if(!chef.isPredator()) repTime-=2000;
        return chef.reproduct();
    }
}
