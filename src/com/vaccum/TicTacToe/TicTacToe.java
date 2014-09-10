package com.vaccum.TicTacToe;
import com.vaccum.TicTacToe.XOButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TODO: Add comments
/**
 * Created by vaccum1 on 21.08.2014.
 * Класс главного окна игры крестики-нолики
 */
public class TicTacToe extends JFrame implements ActionListener {

    private XOButton[][] buttons = new XOButton[FIELD_SIZE][FIELD_SIZE];
    private static final byte FIELD_SIZE = 3;
    private static final String FRAME_NAME = "The Tic-Tac-Toe Game";
//    private Object opponentType;
    private static int stepCount = 0;


    public TicTacToe() {
        super(FRAME_NAME);
       /* opponentType = getOpponentType();
        if(opponentType == null){
            System.exit(0);
        }
        */

        Dimension frameSize = new Dimension(450, 500);
        setSize(frameSize);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        this.add(panel);
        center(this);


        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++) {
                buttons[i][j] = new XOButton();
                buttons[i][j].addActionListener(this);
                panel.add(buttons[i][j]);

            }

        setVisible(true);

    }

    private static void center(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        frame.setLocation(x, y);
    }

   /* public Object getOpponentType() {
        Object[] possibleValues = {"Human", "AI"};
        Object selectedValue = null;
        selectedValue = JOptionPane.showInputDialog(null,
                "Choose opponent type", "Input",
                JOptionPane.OK_CANCEL_OPTION, null,
                possibleValues, possibleValues[0]);
        return selectedValue;

    }*/

    private void winDialog(int winnerValue) {
        //Setting wonMessage
        String wonMessage = " won!";
        switch (winnerValue) {
            case -1:
                wonMessage = "Tie game!";
                break;
            case 0:
                return;
            case 1:
                wonMessage = "X" + wonMessage;
                break;
            case 2:
                wonMessage = "O" + wonMessage;
                break;
        }

        //Showing end of the game dialog
        int selectedAction;
        Object [] options = {"Play Again!", "Exit"};
        selectedAction = JOptionPane.showOptionDialog(null, wonMessage, "End of the game!",
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
                );
        switch (selectedAction) {
            case -1:
                newGame();
                break;
            case 0:
                newGame();
                break;
            case 1:
                System.exit(0);
                break;

        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setButton((XOButton) e.getSource());
        whoWon();
    }

    public void whoWon() {
        if (stepCount == 9){
            winDialog(-1);
            return;
        }
        for (int i = 0; i < FIELD_SIZE; i++)//Line
            if (buttons[i][0].getButtonValue() == buttons[i][1].getButtonValue() &&
                    buttons[i][1].getButtonValue() == buttons[i][2].getButtonValue()) {
                winDialog(buttons[i][0].getButtonValue());
                return;
            }

        for (int i = 0; i < FIELD_SIZE; i++) //Column
            if (buttons[0][i].getButtonValue() == buttons[1][i].getButtonValue() &&
                    buttons[1][i].getButtonValue() == buttons[2][i].getButtonValue()) {
                winDialog(buttons[i][0].getButtonValue());
                return;
            }
        if (buttons[0][0].getButtonValue() == buttons[1][1].getButtonValue() &&//Diagonal
                buttons[1][1].getButtonValue() == buttons[2][2].getButtonValue()){
            winDialog(buttons[1][1].getButtonValue());
        }

        if (buttons[0][2].getButtonValue() == buttons[1][1].getButtonValue() &&//Diagonal
                buttons[1][1].getButtonValue() == buttons[2][0].getButtonValue()){
            winDialog(buttons[1][1].getButtonValue());
        }

        }

    public void setButton(XOButton btn){
        if (btn.getButtonValue() == 0) {
            stepCount++;
            if (stepCount % 2 == 0) btn.setButtonValue(2);
            else btn.setButtonValue(1);
        }
    }

    private void clearField(){

        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++){
                buttons[i][j].setButtonValue(0);
            }

    }

    private void newGame(){
        clearField();
        stepCount = 0;
    }
}