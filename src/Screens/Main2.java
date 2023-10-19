package Screens;

import javax.swing.*;
import java.awt.*;

public class Main2 {
    private JPanel Main2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mainscreen");
        frame.setContentPane(new Main2().Main2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
//        scroll.setViewportView(hiTextField);
    }

}
