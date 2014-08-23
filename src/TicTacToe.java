import javax.swing.*;
import java.awt.*;

/**
 * Created by vaccum1 on 21.08.2014.
 * Класс главного окна игры крестики-нолики
 */
public class TicTacToe extends JFrame{

private JPanel panel = new JPanel();
XOButton buttons[][] = new XOButton[FIELD_SIZE][FIELD_SIZE];
private static final byte FIELD_SIZE = 3;
private static final String FRAME_NAME = "The Tic-Tac-Toe Game";




    public TicTacToe(){
        super(FRAME_NAME);
        Dimension frameSize = new Dimension(600, 600);
        setSize(frameSize);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 3));
        this.add(panel);



        for ( int i = 0;i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++){
                buttons[i][j] = new XOButton();
                panel.add(buttons[i][j]);
            }
        setVisible(true);
    }

}
