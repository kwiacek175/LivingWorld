package main.java.LivingSimulation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private JLabel frameTitle;
    private JLabel[] labelsTab;
    private String[] title;
    private OrganismSlider[] sliderTab;
    public JButton acceptBtn;
    private OrganismSetListener orgListener;
    private SettingsFrame parent;

    public SettingsPanel()
    {
        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        frameTitle = new JLabel("Set amount of species: ");
        frameTitle.setForeground(Color.WHITE);
        add(frameTitle);

        acceptBtn = new JButton("Accept");
        sliderTab = new OrganismSlider[9];
        labelsTab= new JLabel[9];
        title = new String[] {"Wolf","Human","Llama","Tiger", "Sheep",  "Sosnowski Borch", "Grass", "Flower",  "Daisy"};
        for(int i = 0; i<sliderTab.length; i++)
        {

            labelsTab[i] = new JLabel(title[i]);
            labelsTab[i].setForeground(Color.WHITE);
            add(labelsTab[i]);
            sliderTab[i] = new OrganismSlider();
            add(sliderTab[i]);
        }
        add(acceptBtn,CENTER_ALIGNMENT);
    }

    public void setListener(OrganismSetListener listener)
    {
        this.orgListener=listener;
    }

    public void setParent(SettingsFrame parent)
    {
        this.parent=parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        orgListener.getVariables(sliderTab[0].getValue(), sliderTab[1].getValue(), sliderTab[2].getValue(), sliderTab[3].getValue(), sliderTab[4].getValue(), sliderTab[5].getValue(), sliderTab[6].getValue(), sliderTab[7].getValue(), sliderTab[8].getValue());


        parent.setVisible(false);
    }
}
