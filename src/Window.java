import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JDialog {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel Window;

    private JDialog frame;


    public JDialog Window(Frame parentFrame, LaunchPage page) {
//        return JOptionPane.showConfirmDialog(parentFrame, "hi tehre", "this is my title", JOptionPane.YES_NO_CANCEL_OPTION);
//        JOptionPane.showMessageDialog(parentFrame,);
//        JDialog dialog = new JDialog(parentFrame);
//        dialog.add(Window);
//        dialog.setVisible(true);
//        return dialog;


//        Object[] options = {"Yes, please",
//                "No, thanks",
//                "No eggs, no ham!"};
//        int n = JOptionPane.showOptionDialog(parentFrame,
//                "Would you like some green eggs to go "
//                        + "with that ham?",
//                "A Silly Question",
//                JOptionPane.YES_NO_CANCEL_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                options,
//                options[2]);


        frame = new JDialog(parentFrame, "hi", true);
        frame.getContentPane().add(Window);
        button2.addActionListener(e -> {
            frame.dispose();
            System.out.println("hi");
            page.text = "changed";
        });
        frame.pack();
        frame.setVisible(true);
        return frame;


//        JFrame frame = new JFrame("Window");
//        frame.setContentPane(Window);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setLocation(760, 340);
////        frame.setLayout(new FlowLayout());
//        frame.pack();
//        frame.setVisible(true);
//        frame.setSize(600, 600);
//        frame.setLayout(new FlowLayout());
    }

}


