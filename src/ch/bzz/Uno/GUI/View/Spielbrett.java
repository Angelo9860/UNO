import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spielbrett extends JFrame{
    private JTextArea textArea1;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton getCard;
    private JComboBox comboBox2;
    private JButton setCard;
    private JComboBox comboBox3;
    private JButton uno;
    private JComboBox comboBox4;
    private JButton pass;

    public Spielbrett() {
        add(panel1);
        setTitle("UNO");
        setSize(500, 500);

        getCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
