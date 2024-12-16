package main.java.LivingSimulation;

import javax.swing.SwingUtilities;

public class SimulatorApp {

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run() {
                new SimulationFrame();
            }
        });
    }
}
