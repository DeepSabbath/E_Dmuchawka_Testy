import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.*;


/**
 * Created by Amadeusz on 13.11.2015.
 */
public class CzasKlikniecia extends JFrame {

    JButton button1;
    Integer czas = 0;
    JLabel czasLbl;
    javax.swing.Timer timer1 = new javax.swing.Timer(1000, new timerListener());


    public CzasKlikniecia(int width, int height)
    {
        super("Gra testowa");//wywo³anie konstruktora klasy nadrzêdnej JFrame z nazw¹ okienka
        setSize(width, height);
        //setLocation(x,y); //ustaw pozycjÄ™ okna
        setResizable(false); //zablokuj moÅ¼liwoÅ›Ä‡ zmian rozmiaru o
        init();
        setVisible(true);
    }

    public void init()
    {
        setLayout(null);
        button1 = new JButton();
        button1.setSize(30,30);
        button1.setLocation(50,150);
        button1.addMouseListener(new Zdarzenie1());
        add(button1);

        czasLbl = new JLabel("czas");
        czasLbl.setSize(100,25);
        czasLbl.setLocation(300,25);
        add(czasLbl);
    }

    class Zdarzenie1 implements MouseListener                // definicja dzia³ania buttona
    {
        MyTimerTask timer1_task = new MyTimerTask();

        @Override
        public void mouseClicked(MouseEvent e) {
//            timer1.schedule (timer1_task, 0, 500);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            timer1.start();

        }

        @Override
        public void mouseReleased(MouseEvent e) {

            timer1.stop();
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class MyTimerTask extends TimerTask
    {
        public void run()
        {
            czas++;
            czasLbl.setText(czas.toString());
        }

    }
    public void liczCzas()
    {

    }
    class timerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            czas++;
            czasLbl.setText(czas.toString());
        }
    }
    public String przekazTekst()
    {
        return  czasLbl.getText();
    }

}
