package main.java.LivingSimulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private MenuPanelListener listener;
    private SettingsListener settingsListener;
    private JLabel lblSimulation;
    private JButton btnNewSimulation;
    private JButton btnExit;
    private JButton btnSettings;
    private JLabel lblKacperW;


    public MenuPanel() {
        setBackground(new Color(0, 0, 0));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{741};
        gridBagLayout.columnWeights = new double[]{0.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        setLayout(gridBagLayout);

        lblSimulation = new JLabel("Living in the world");
        lblSimulation.setForeground(new Color(245, 255, 250));
        lblSimulation.setFont(new Font("Candara", Font.PLAIN, 42));
        lblSimulation.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_lblSimulation = new GridBagConstraints();
        gbc_lblSimulation.weighty = 1.0;
        gbc_lblSimulation.fill = GridBagConstraints.VERTICAL;
        gbc_lblSimulation.insets = new Insets(0, 0, 5, 0);
        gbc_lblSimulation.gridx = 0;
        gbc_lblSimulation.gridy = 1;
        add(lblSimulation, gbc_lblSimulation);

        btnNewSimulation = new JButton("New Simulation");
        btnNewSimulation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeView();
            }
        });
        btnNewSimulation.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewSimulation.setPreferredSize(new Dimension(250,80));
        GridBagConstraints gbc_btnNewSimulation = new GridBagConstraints();
        gbc_btnNewSimulation.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewSimulation.gridx = 0;
        gbc_btnNewSimulation.gridy = 3;
        add(btnNewSimulation, gbc_btnNewSimulation);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }

        });

        btnSettings = new JButton("Settings");
        btnSettings.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {

                openSettings();
            }

        });
        btnSettings.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnSettings.setPreferredSize(new Dimension(150,50));
        GridBagConstraints gbc_btnSettings = new GridBagConstraints();
        gbc_btnSettings.weighty = 0.2;
        gbc_btnSettings.weightx = 0.2;
        gbc_btnSettings.insets = new Insets(0, 0, 5, 0);
        gbc_btnSettings.gridx = 0;
        gbc_btnSettings.gridy = 5;
        add(btnSettings, gbc_btnSettings);
        GridBagConstraints gbc_btnExit = new GridBagConstraints();
        gbc_btnExit.weighty = 0.5;
        gbc_btnExit.insets = new Insets(0, 0, 5, 0);
        gbc_btnExit.gridx = 0;
        gbc_btnExit.gridy = 6;
        add(btnExit, gbc_btnExit);

        lblKacperW = new JLabel("inż. Kacper Wiącek");
        lblKacperW.setForeground(new Color(255, 255, 255));
        lblKacperW.setFont(new Font("Tahoma", Font.PLAIN, 17));
        GridBagConstraints gbc_lblKacperW = new GridBagConstraints();
        gbc_lblKacperW.anchor = GridBagConstraints.WEST;
        gbc_lblKacperW.fill = GridBagConstraints.VERTICAL;
        gbc_lblKacperW.gridx = 0;
        gbc_lblKacperW.gridy = 8;
        add(lblKacperW, gbc_lblKacperW);
    }

    public void setListener(MenuPanelListener listener)
    {
        this.listener=listener;
    }

    public void setSettingsListener(SettingsListener listener)
    {
        this.settingsListener=listener;
    }

    public void openSettings()
    {
        if(listener!=null)
            settingsListener.openSettings();
    }

    public void changeView()
    {
        if(listener!=null)
            listener.changeView();
    }
}
