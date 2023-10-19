import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage {
    JFrame frame = new JFrame();
    public String text;
    JButton myButton = new JButton("New Window");
    JButton myButton2 = new JButton("0");

    public int number = 0;
    LaunchPage(){
        myButton.setBounds(100,160, 200, 40);
        myButton.setFocusable(false);
        myButton.addActionListener(e -> {
            System.out.println(text);
            JDialog myWindow = new Window().Window(frame, this);
            System.out.println(myWindow);
        });

        myButton2.setBounds(100,220, 200, 40);
        myButton2.setFocusable(false);
        myButton2.addActionListener(e -> {

            myButton2.setText(String.valueOf (Integer.parseInt(myButton2.getText()) + 1) );

        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(myButton);
        frame.add(myButton2);
        System.out.println(text);

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if (e.getSource()==myButton) {
//            newWindow myWindow = new newWindow();
//        }
//
//    }
}
