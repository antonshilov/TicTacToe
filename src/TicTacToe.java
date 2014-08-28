import javax.swing.*;
import java.awt.*;
//TODO: Add commets, change constructor(Show dialog before show Frame
/**
 * Created by vaccum1 on 21.08.2014.
 * Класс главного окна игры крестики-нолики
 */
public class TicTacToe extends JFrame{

private JPanel panel = new JPanel();
XOButton buttons[][] = new XOButton[FIELD_SIZE][FIELD_SIZE];
private static final byte FIELD_SIZE = 3;
private static final String FRAME_NAME = "The Tic-Tac-Toe Game";
private Object opponentType;
    public TicTacToe(){
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
        panel.setLayout(new GridLayout(3, 3));

        this.add(panel);
        center(this);



        for ( int i = 0;i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++){
                buttons[i][j] = new XOButton();
                panel.add(buttons[i][j]);
            }

        setVisible(true);

    }

    public static void center(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        frame.setLocation(x, y);
    }

    public Object getOpponentType() {
        Object[] possibleValues = { "Human", "AI"};
        Object selectedValue = null;
        selectedValue = JOptionPane.showInputDialog(null,
                "Choose opponent type", "Input",
                JOptionPane.OK_CANCEL_OPTION, null,
                possibleValues, possibleValues[0]);
        return selectedValue;

    }


}
