import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Amadeusz on 16.11.2015.
 */
public class Grafika extends JFrame {
    double aktualnaMoc = 0;
    double calkowitaMoc = 10;
    double potrzebnaMoc = 7;
    javax.swing.Timer timer1 = new javax.swing.Timer(1000, new timerListener());
    boolean maleje = false;
    boolean rosnie = false;

    JLabel test1;
    JButton zwieksz, zmniejsz;

    public void paint (Graphics g)
    {
        int prosX = 200;
        int prosY = 200;
        int prosSzer = 15;
        int prosWys = 150;
        double prosWysD = prosWys;
        int wypelnienie = (int)((aktualnaMoc/calkowitaMoc)*prosWysD);
        g.drawRect(prosX,prosY-1,prosSzer,prosWys+1);
        if(potrzebnaMoc + 1 >= aktualnaMoc && potrzebnaMoc - 1 <= aktualnaMoc)
        {
            g.setColor(Color.green);
        }
        else
        {
            g.setColor(Color.red);
        }
        g.fillRect(prosX+1,(prosY+prosWys-wypelnienie),prosSzer-1,wypelnienie);

        //g.setColor(Color.red);
        //g.fillRect(prosX+1, prosY, prosSzer-1, (prosWys-wypelnienie));

    }

    public Grafika(int width, int height)
    {
        super("Grafika");
        setSize(width, height);
        init();
        setVisible(true);
        rosnie = true;
        timer1.start();

    }

    public void init()
    {
        setLayout(null);
        test1 = new JLabel("Witam");
        test1.setSize(100,20);
        test1.setLocation(200,50);
        test1.setForeground(Color.red);
        test1.setBackground(Color.red);
        add(test1);
    }

    private class timerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            if(rosnie && aktualnaMoc < 10)
            {
                aktualnaMoc++;
                repaint();
            }
            if (maleje && aktualnaMoc > 0)
            {
                aktualnaMoc--;
                repaint();
            }

        }
    }



}
