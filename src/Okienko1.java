/**
 * Created by Amadeusz on 11.11.2015.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import javax.swing.*;


public class Okienko1 extends JFrame{

    JButton button1;
    JLabel label1;
    static JButton button2;
    JButton button3;

    public Okienko1(int width, int height)
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
        setLayout(null);                                    // layout na null - sami definiujemy+
        button1 = new JButton("Teskt");    					// tworzenie buttona z teksten
        button1.setLocation(50,50);
        button1.setSize(120,120);
        button1.addActionListener(new Zdarzenie1());  		// utworzenie listenera
        add(button1);                                       // dodanie buttona do okienka
        Integer wysb1 = button1.getHeight();

        label1 = new JLabel();
        label1.setLocation(200,200);
        label1.setSize(100,50);
        label1.setText(wysb1.toString());
        add(label1);

        button2 = new JButton("dupa");
        button2.setLocation(50,180);
        button2.setSize(120,120);
        button2.addActionListener(new buttonClick());
        add(button2);

        button3 = new JButton ("4");
        button3.setLocation(50,310);
        button3.setSize(120,120);
        button3.addActionListener(new buttonClick());
        add(button3);
    }

    class Zdarzenie1 implements ActionListener				// definicja dzia�ania buttona
    {
        public void actionPerformed(ActionEvent e)
        {
            Okienko2 o = new Okienko2(400,400);
            o.iloscOtworzen++;
            o.setVisible(true);
        }
    }

    class buttonClick implements  ActionListener
    {
        public void actionPerformed(ActionEvent e) {

            Okienko2 o = new Okienko2(400,400);
            o.iloscOtworzen++;
            try
            {
                String t = ((JButton)e.getSource()).getText();
                o.coKliknieto.setText("Kliknieto button z napidfdfssem " + t);
            }
            catch (Exception wyjatek)
            {

            }
            o.setVisible(true);
        }
    }

    public String getButtonText(JButton b)
    {
        return b.getText();
    }
}