import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Amadeusz on 13.11.2015.
 */
public class CzasKlikniecia extends JFrame {

    JButton button1;

    public CzasKlikniecia(int width, int height)
    {
        super("Gra testowa");//wywo�anie konstruktora klasy nadrz�dnej JFrame z nazw� okienka
        setSize(width, height);
        //setLocation(x,y); //ustaw pozycję okna
        setResizable(false); //zablokuj możliwość zmian rozmiaru o
        init();
        setVisible(true);
    }

    public void init()
    {
        setLayout(null);
        button1 = new JButton();
        button1.setSize(30,30);
        button1.setLocation(50,150);
        button1.addActionListener(new Zdarzenie1());
        add(button1);
    }

    class Zdarzenie1 implements ActionListener                // definicja dzia�ania buttona
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}
