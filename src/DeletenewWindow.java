import javax.swing.*;
import java.awt.*;

public class DeletenewWindow {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public String text;


    DeletenewWindow() {
        JFrame frame2 = new JFrame();
        JLabel label2 = new JLabel("hello");
        label2.setBounds(0, 0, 100, 50);
        label2.setFont(new Font(null, Font.PLAIN, 25));
        text = "hi2";
        frame2.add(label2);

        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setSize(420, 420);
        frame2.setLayout(null);
        frame2.setVisible(true);
    }

}
