/**
 * Created by Amadeusz on 11.11.2015.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class Okienko1 extends JFrame{

    JButton button1;
    JLabel label1;
    static JButton button2;
    JButton button3;
    JButton getTextBTN;
    CzasKlikniecia c;

    public Okienko1(int width, int height)
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
        setLayout(null);                                    // layout na null - sami definiujemy+
        button1 = new JButton("Teskt");    					// tworzenie buttona z teksten
        button1.setLocation(50,50);
        button1.setSize(120,120);
        button1.addActionListener(new Zdarzenie1());  		// utworzenie listenera
        add(button1);                                       // dodanie buttona do okienka


        label1 = new JLabel();
        label1.setLocation(200,200);
        label1.setSize(100,50);
        add(label1);

        button2 = new JButton("dupa");
        button2.setLocation(losujPolozenie());
        button2.setSize(120,120);
        button2.addActionListener(new buttonClick());
        add(button2);

        button3 = new JButton ("4");
        button3.setLocation(50,310);
        button3.setSize(120,120);
        button3.addActionListener(new buttonClick());
        add(button3);

        getTextBTN = new JButton();
        getTextBTN.setLocation(300,300);
        getTextBTN.setSize(120,120);
        getTextBTN.addActionListener(new pobierzTekst());
        add(getTextBTN);
    }

    class Zdarzenie1 implements ActionListener				// definicja dzia³ania buttona
    {
        public void actionPerformed(ActionEvent e)
        {
            c = new CzasKlikniecia(700,700);
            c.setVisible(true);
        }
    }

    class pobierzTekst implements ActionListener				// definicja dzia³ania buttona
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                getTextBTN.setText(c.przekazTekst());
            }
            catch (Exception ex)
            {
                getTextBTN.setText("Nie uda³o siê pobraæ tekstu");
            }
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

    public Point losujPolozenie()
    {
        Random rand = new Random();
        int wys = rand.nextInt(1280);
        int sze = rand.nextInt(800);
        Point pol = new Point(wys, sze);
        return pol;
    }
}