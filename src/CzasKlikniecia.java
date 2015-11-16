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
    Integer dlugoscDmuchniecia = 0;
    Integer potrzebnaMoc = 0;
    Integer moc = 5;
    javax.swing.Timer timer1 = new javax.swing.Timer(200, new timerListener());
    JLabel wynikKlikniecia;
    JLabel aktualnaMoc;
    JLabel potrzebnaMocLbl;


    public CzasKlikniecia(int width, int height, int d, int p)
    {
        super("Gra testowa");//wywo³anie konstruktora klasy nadrzêdnej JFrame z nazw¹ okienka
        setSize(width, height);
        this.dlugoscDmuchniecia = d;
        this.potrzebnaMoc = p;
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

        wynikKlikniecia = new JLabel();
        wynikKlikniecia.setLocation(300,300);
        wynikKlikniecia.setSize(200,50);
        int fontSize=32;
        Font font = new Font("Helvetica", Font.BOLD, fontSize);
        wynikKlikniecia.setFont(font);

        aktualnaMoc = new JLabel();
        aktualnaMoc.setLocation(300,500);
        aktualnaMoc.setSize(200,50);
        aktualnaMoc.setText("Aktualna moc wynosi " + moc);
        add(aktualnaMoc);

        potrzebnaMocLbl = new JLabel();
        potrzebnaMocLbl.setLocation(100,500);
        potrzebnaMocLbl.setSize(200,50);
        potrzebnaMocLbl.setText("Potrzebna moc wynosi " + potrzebnaMoc);
        add(potrzebnaMocLbl);

    }

    class Zdarzenie1 implements MouseListener                // definicja dzia³ania buttona
    {
        MyTimerTask timer1_task = new MyTimerTask();

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            timer1.start();
            add(czasLbl);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            add(wynikKlikniecia);
            mierzDlugoscKlikniecia();
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

    public void mierzDlugoscKlikniecia() {
        if ((czas - 5) <= dlugoscDmuchniecia && (czas + 5) >= dlugoscDmuchniecia) {
            wynikKlikniecia.setForeground(Color.green);
            wynikKlikniecia.setText("You WON");
        } else {
            wynikKlikniecia.setForeground(Color.red);
            wynikKlikniecia.setText("Przegrales");
        }
    }
}
