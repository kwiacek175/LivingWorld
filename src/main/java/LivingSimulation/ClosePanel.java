package main.java.LivingSimulation;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.java.OrganismsAbstract.Animal;
import main.java.OrganismsAbstract.Plant;

public class ClosePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    JLabel animals;
    JLabel plants;
    JLabel time;

    ClosePanel()
    {
        animals=new JLabel("Lived animals: "+ Animal.livedAnimals + " (including living ones: "+ Animal.visibleAnimals + ")");
        plants=new JLabel("Lived plants: "+ Plant.livedPlants + " (including living ones: "+ Plant.visiblePlants+ ")" );
        time= new JLabel("Time: " + (double) SimulationDisplay.time/1000 + " s");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(animals);
        add(plants);
        add(time);
    }
}
