/**
 * Created by Amadeusz on 11.11.2015.
 */
import javax.swing.*;
import java.awt.*;

public class Okienko2 extends JFrame{

    static Integer iloscOtworzen = 1;				// ZMIENNA NIE ZERUJE SIÊ PRZY KOLEJNYCH WYWO£ANIACH OKIENKA,
    JLabel iloscOtworzenLabel;
    JLabel coKliknieto;

    Okienko2(int h, int w)
    {

        init();
        setSize(h,w);
        setLayout(null);
    }

    public void init()
    {
        iloscOtworzenLabel = new JLabel();
        iloscOtworzenLabel.setText("Okienko otworzono " + iloscOtworzen.toString() + " razy");
        iloscOtworzenLabel.setBounds(20,20,300,20);
        add(iloscOtworzenLabel);

        coKliknieto = new JLabel();
        // coKliknieto.setText(Okienko1.button2.getText());
        coKliknieto.setBounds(20,120,300,20);
        add(coKliknieto);
    }
}
