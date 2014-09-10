/**
 * Created by vaccum1 on 21.08.2014.
 */
import com.vaccum.TicTacToe.TicTacToe;
import javax.swing.UIManager.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
       //Setting Nimbus L&F
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }

       new TicTacToe();


    }
}
