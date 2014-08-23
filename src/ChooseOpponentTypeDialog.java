import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TODO: Add commets
/**
 * Created by vaccum1 on 23.08.2014.
 */
public class ChooseOpponentTypeDialog extends JDialog implements ActionListener {
    JPanel panel = new JPanel();
    String humanItem = new String ("Human");
    String aiItem = new String ("AI");
    JComboBox comboBox = new JComboBox();
    private static final String title = new String("Choose your opponent");
    JButton confirmButton = new JButton("Confirm");

    public ChooseOpponentTypeDialog(JFrame parentFrame){
        super(parentFrame, title);
        setLocationRelativeTo(parentFrame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(250, 80);
        comboBox.addItem(humanItem);
        comboBox.addItem(aiItem);
        this.add(panel);
        panel.add(comboBox);
        panel.add(confirmButton);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
