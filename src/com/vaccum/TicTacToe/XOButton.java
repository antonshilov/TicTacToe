package com.vaccum.TicTacToe;

import javax.swing.*;

/**
 * Created by vaccum1 on 21.08.2014.
 * Класс, описывающий поведение ячеек игрового поля
 */
//TODO: Add comments

public class XOButton extends JButton{
    private final ImageIcon xIcon;
    private final ImageIcon oIcon;
    private int buttonValue;

    /* buttonValue
    0: nothing
    1: X
    2: O
     */

    public int getButtonValue() {
        return buttonValue;
    }

    public void setButtonValue(int buttonValue) {
        this.buttonValue = buttonValue;
        setIcon(buttonValue);
    }

    public XOButton(){

        xIcon = new ImageIcon("res/X.png");
        oIcon = new ImageIcon("res/O.png");

    }

    private void setIcon(int buttonValue) {
        switch (buttonValue){
            case 0:
                this.setIcon(null);
                break;
            case 1:
                this.setIcon(xIcon);
                break;
            case 2:
                this.setIcon(oIcon);
        }
    }

}
