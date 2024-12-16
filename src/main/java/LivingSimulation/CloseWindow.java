package main.java.LivingSimulation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CloseWindow extends JFrame
{
    private static final long serialVersionUID = 1L;
    JPanel closePanel;
    JButton closeBtn;

    CloseWindow()
    {
        setLayout(new BorderLayout());
        closePanel=new ClosePanel();
        add(closePanel, BorderLayout.CENTER);

        closeBtn=new JButton("Close");
        setPreferredSize(new Dimension(100,50));
        add(closeBtn,BorderLayout.PAGE_END);
        closeBtn.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }

        });
        setSize(300,120);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setAlwaysOnTop(true);
    }
}
