package main.java.LivingSimulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Vector;
import javax.swing.JComponent;
import main.java.OrganismsAbstract.Animal;
import main.java.OrganismsAbstract.AnimalFactory;
import main.java.OrganismsAbstract.Group;
import main.java.OrganismsAbstract.IAnimal;
import main.java.OrganismsAbstract.IAnimalFactory;
import main.java.OrganismsAbstract.IPlant;
import main.java.OrganismsAbstract.IPlantFactory;
import main.java.OrganismsAbstract.Plant;
import main.java.OrganismsAbstract.PlantFactory;

public class SimulationDisplay extends JComponent {

    private static final long serialVersionUID = 1L;
    private Image backgroundImage;
    private Vector<IAnimal> vAnimals;
    private Vector<IPlant> vPlants;
    public static int time;
    public static IAnimalFactory aFactory;
    public static IPlantFactory pFactory;
    private Vector<Group> vGroups;

    public SimulationDisplay()
    {
        aFactory= new AnimalFactory();
        pFactory =new PlantFactory();
        vAnimals= new Vector<IAnimal>();
        vPlants = new Vector<IPlant>();
        vGroups = new Vector<Group>();

        time=0;
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        backgroundImage = Toolkit.getDefaultToolkit().getImage("src/main/resources/DirtBackground.png");

        g2.drawImage(backgroundImage , 0, 0, this);

        for(int i=0; i<vPlants.size(); i++)
        {
            if(vPlants.get(i).isVisible())
                g2.drawImage(vPlants.get(i).getIcon(), vPlants.get(i).getX(), vPlants.get(i).getY(), this);
            //else vPlants.removeElementAt(i);
        }

        for(int i=0; i<vAnimals.size(); i++)
        {
            if(vAnimals.get(i).isVisible())
                g2.drawImage(vAnimals.get(i).getIcon(), vAnimals.get(i).getX(), vAnimals.get(i).getY(), this);
            //else vAnimals.removeElementAt(i);
        }

        g.setColor(Color.WHITE);
        g2.drawString("Plants: " + Plant.visiblePlants, 20, 10);
        g2.drawString("Animals: " + Animal.visibleAnimals, 20, 20);
    }

    public void nextStep()
    {
        charactersMove();
        borderCheck();
        ifCollided();
        plantsReproduction();
        groupsChecker();
        time+= SimulationFrame.TIME_RES;
        pregnantCheck();
        repaint();
    }

    private void charactersMove()
    {

        for(int i=0; i<vAnimals.size(); i++)
        {
            vAnimals.get(i).setX( vAnimals.get(i).getX() + (vAnimals.get(i).getxSpeed() * vAnimals.get(i).getxDirection()));
            vAnimals.get(i).setY( vAnimals.get(i).getY() + (vAnimals.get(i).getySpeed() * vAnimals.get(i).getyDirection()));
            vAnimals.get(i).spell();


        }
    }

    private void borderCheck()
    {
        for(int i=0; i<vAnimals.size(); i++)
        {
            if(vAnimals.get(i).getX()<0)
            {
                vAnimals.get(i).setxDirection((short)1);
            }
            else if(vAnimals.get(i).getX()>this.getBounds().width-vAnimals.get(i).getIcon().getWidth(this))
            {
                vAnimals.get(i).setxDirection((short)-1);
            }
            if(vAnimals.get(i).getY()<0)
            {
                vAnimals.get(i).setyDirection((short)1);
            }
            else if(vAnimals.get(i).getY()>this.getBounds().height-vAnimals.get(i).getIcon().getHeight(this))
            {
                vAnimals.get(i).setyDirection((short)-1);
            }
        }
    }

    private void plantsReproduction()
    {

        for(int i=0; i<vPlants.size(); i++)
        {
            int repTime=vPlants.get(i).getReproductionTime();


            if(time>(vPlants.get(i).getGeneration()*repTime) && vPlants.get(i).isVisible() && Plant.visiblePlants<1000)
            {
                {
                    Random rand = new Random();
                    boolean randx=rand.nextBoolean();
                    boolean randy=rand.nextBoolean();
                    int x = rand.nextInt(150);
                    int y = rand.nextInt(150);
                    if(randx) x*=-1;
                    if(randy) y*=-1;

                    IPlant newPlant= pFactory.createNewChild(vPlants.get(i),vPlants.get(i).getX()+50+x, vPlants.get(i).getY()+50+y);
                    Plant.visiblePlants++;
                    newPlant.setGeneration(vPlants.get(i).getGeneration()+2);
                    vPlants.get(i).upGeneration();
                    this.vPlants.add(newPlant);
                    System.out.println("New Plant!");

                }
            }
        }
    }

    private void ifCollided()
    {
        int j=0;
        for(int i=0; i<vAnimals.size(); i++)
        {
            int collisions=0;
            for( j=0; j<vAnimals.size(); j++)
            {
                IAnimal a1 = vAnimals.get(i);
                IAnimal a2 = vAnimals.get(j);

                if(i==j) continue;
                else if((a1.getX() >= a2.getX()-a2.getIcon().getWidth(this) &&
                        a1.getX() <= a2.getX() + a2.getIcon().getWidth(this) &&
                        a1.getY() >= a2.getY() -a2.getIcon().getHeight(this) &&
                        a1.getY() <= a2.getY() + a2.getIcon().getWidth(this)) && a1.isVisible() && a2.isVisible() )
                {
                    collisions++;
                    if(!a1.ifCollide() && !a2.ifCollide() && !a1.isFriend(a2))
                    {
                        System.out.println("Collision"+"|"+ i +" "+ j+"|");
                        a1.changeDirection();
                        a2.changeDirection();
                        a1.collision(true);
                        a2.collision(true);
                        System.out.println(a1.getHp()+" "+a2.getHp());
                        a1.attack(a2);
                        a2.attack(a1);

                    }
                    if(!a2.isGrouped() && a1.isFriend(a2))
                    {
                        if(!a1.isGrouped())
                        {
                            Group group=new Group(a1, a2);
                            a1.setGroup(group);
                            a2.setGroup(group);
                            vGroups.add(group);
                        }
                        else if(a1.isGrouped())
                        {
                            a1.getGroup().addMember(a2);
                        }

                    }

                }

            }
            if(collisions==0) vAnimals.get(i).collision(false);

            for( j=0; j<vPlants.size(); j++)
            {
                IAnimal a1 = vAnimals.get(i);
                IPlant p1 = vPlants.get(j);


                if((a1.getX() >= p1.getX()-p1.getIcon().getWidth(this) &&
                        a1.getX() <= p1.getX() + p1.getIcon().getWidth(this) &&
                        a1.getY() >= p1.getY() -p1.getIcon().getHeight(this) &&
                        a1.getY() <= p1.getY() + p1.getIcon().getWidth(this))&& a1.isVisible() && p1.isVisible() && !a1.isPredator())
                {
                    if(!a1.ifCollide() && !p1.ifCollide() )
                    {
                        //a1.changeDirection();
                        a1.collision(true);
                        p1.collision(true);
                        p1.setVisible(false);
                        if(a1.getHp()<20)
                        {
                            a1.hpUp(1);
                        }
                        Plant.visiblePlants--;
                        vPlants.remove(j);
                    }

                }
                else
                {
                    a1.collision(false);
                    p1.collision(false);
                }


            }//plant for END

        }// i for END
    }

    public void start(int w, int h, int l, int t, int s, int sb, int lg, int f, int d)
    {
        vAnimals.removeAllElements();  vPlants.removeAllElements();
        for(int i=0; i<w; i++)
        {
            vAnimals.add(aFactory.createRandomAnimal("Wolf"));
        }

        for(int i=0; i<h; i++)
        {
            vAnimals.add(aFactory.createRandomAnimal("Human"));
        }
        for(int i=0; i<l; i++)
        {
            vAnimals.add(aFactory.createRandomAnimal("Llama"));
        }
        for(int i=0; i<t; i++)
        {
            vAnimals.add(aFactory.createRandomAnimal("Tiger"));
        }
        for(int i=0; i<s; i++)
        {
            vAnimals.add(aFactory.createRandomAnimal("Sheep"));
        }

        for(int i=0; i<sb; i++)
        {
            vPlants.add(pFactory.createRandomPlant("SosnowskiBorch"));
        }
        for(int i=0; i<f; i++)
        {
            vPlants.add(pFactory.createRandomPlant("Flower"));
        }
        for(int i=0; i<d; i++)
        {
            vPlants.add(pFactory.createRandomPlant("Daisy"));
        }
        for(int i=0; i<lg; i++)
        {
            vPlants.add(pFactory.createRandomPlant("LongGrass"));
        }
    }

    private void groupsChecker()
    {
        for(int j=0; j<vGroups.size(); j++)
        {
            vGroups.get(j).reCoord();
            for(int i=0; i<vGroups.get(j).members.size(); i++)

            {
                if(vGroups.get(j).members.get(i).getX()<vGroups.get(j).x)
                {
                    vGroups.get(j).members.get(i).setxDirection((short)1);
                }
                else if(vGroups.get(j).members.get(i).getX()>vGroups.get(j).x + vGroups.get(j).size)
                {
                    vGroups.get(j).members.get(i).setxDirection((short)-1);
                }
                if(vGroups.get(j).members.get(i).getY()<= vGroups.get(j).y)
                {
                    vGroups.get(j).members.get(i).setyDirection((short)1);
                }
                else if(vGroups.get(j).members.get(i).getY()>vGroups.get(j).y + vGroups.get(j).size)
                {
                    vGroups.get(j).members.get(i).setyDirection((short)-1);
                }
            }
        }

    }

    private void pregnantCheck()
    {
        for(int i = 0; i<vGroups.size(); i++)
        {
            if(vGroups.get(i).isPregnant()==true)
            {
                IAnimal child = vGroups.get(i).getChild();
                vGroups.get(i).addMember(child);
                child.setGroup(vGroups.get(i));
                vAnimals.add(child);
            }
        }
    }
}
