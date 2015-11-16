import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Amadeusz on 16.11.2015.
 */
public class Grafika extends JFrame {
    double aktualnaMoc = 5;
    double potrzebnaMoc = 10;

    public void paint (Graphics g)
    {
        int wypelnienie = (int)((aktualnaMoc/potrzebnaMoc)*150);
        int prosX = 200;
        int prosY = 200;
        int prosSzer = 15;
        int prosWys = 150;
        g.drawRect(prosX,prosY,prosSzer,prosWys);
        g.setColor(Color.green);
        g.fillRect(prosX+1,(prosY+prosWys-wypelnienie),prosSzer-1,wypelnienie);
    }

    Grafika(int width, int height)
    {
        setSize(width, height);
        init();
    }

    private void init()
    {
    }



}
