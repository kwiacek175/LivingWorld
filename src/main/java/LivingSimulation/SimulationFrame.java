package main.java.LivingSimulation;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SimulationFrame extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    public  static int TIME_RES = 30;
    private SimulationDisplay simDisp;
    private Timer simTimer;
    private MenuPanel menu;
    private CardLayout card;
    private SettingsFrame settingsFrame;
    private CloseWindow closeWindow;

    public SimulationFrame()
    {
        super("LivingWorldSimulation");

        menu = new MenuPanel();
        simDisp=new SimulationDisplay();
        simTimer=new Timer(TIME_RES,this);
        card = new CardLayout();



        menu.setListener(new MenuPanelListener() {

            @Override
            public void changeView() {


                simTimer.start();
                card.show(SimulationFrame.this.getContentPane(), "Simulation");
            }
        });
        menu.setSettingsListener(new SettingsListener()
        {
            @Override
            public void openSettings() {
                settingsFrame.setVisible(true);
            }
        });


        setLayout(card);
        add(menu,"MENU");
        add(simDisp,"Simulation");

        settingsFrame=new SettingsFrame();

        settingsFrame.settingsPanel.setListener(new OrganismSetListener() {

            @Override
            public void getVariables(int w, int h, int l, int t, int s, int sb, int lg, int f, int d) {
                simDisp.start(w, h, l, t, s, sb, lg, f, d);

            }

        });

        setSize(1280,720);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                simTimer.stop();
                closeWindow = new CloseWindow();
                setVisible(false);}
        });
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(false);
        setVisible(true);
        settingsFrame.setAlwaysOnTop(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        simDisp.nextStep();

    }
}
