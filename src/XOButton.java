import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vaccum1 on 21.08.2014.
 * Класс, описывающий поведение ячеек игрового поля
 */
//TODO: Add commets

public class XOButton extends JButton implements ActionListener{
    private ImageIcon xIcon,oIcon;
    private int buttonValue;
    private static int stepCount = 0;

    /* XOButton buttonValue
    0: nothing
    1: X
    2: O
     */

    public int getButtonValue() {
        return buttonValue;
    }

    public void setButtonValue(int buttonValue) {
        this.buttonValue = buttonValue;
    }

    public XOButton(){

        xIcon = new ImageIcon("recources/X.png");
        oIcon = new ImageIcon("recources/O.png");

        this.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (buttonValue != 0) return;
        stepCount++;
        if (stepCount % 2 == 0) buttonValue = 2;
        else buttonValue = 1;
        switch (buttonValue){
            case 1:
                this.setIcon(xIcon);
                break;
            case 2:
                this.setIcon(oIcon);
        }
    }
}
