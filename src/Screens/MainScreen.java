package Screens;

import javax.swing.*;

public class MainScreen {
    private JButton shortButton;
    private JButton qtyAdd;
    private JButton FOCButton;
    private JButton allFreeButton;
    private JButton amend要求Button;
    private JButton qtyMinus;
    private JButton priceButton;
    private JButton clearButton;
    private JButton £0Button;
    private JButton incChangeButton;
    private JButton button14;
    private JButton newOrderButton;
    private JButton discountMinus;
    private JButton aceptOrderButton;
    private JButton discountAdd;
    private JTextField Total;
    private JButton deliveryButton;
    private JButton collectionButton;
    private JTextField OrderDetails;
    private JButton deliveryMinus;
    private JButton deliveryAdd;
    private JButton button8;
    private JButton button13;
    private JTextField textField4;
    private JButton websiteButton;
    private JButton uberEatButton;
    private JButton justEatButton;
    private JButton storeButton;
    private JTabbedPane tabbedPane1;
    private JButton button24;
    private JButton button29;
    private JButton button30;
    private JButton button31;
    private JButton button32;
    // Product Buttons
    private JButton P1;
    private JButton P2;
    private JButton P3;
    private JButton P4;
    private JButton P5;
    private JButton P6;
    private JButton P7;
    private JButton P8;
    private JButton P9;
    private JButton P10;
    private JButton P11;
    private JButton P12;
    private JButton P13;
    private JButton P14;
    // Product back and forth buttons
    private JButton P15;
    private JButton P16;
    private JTabbedPane tabbedPane2;
    private JButton button15;
    //Category Buttons
    private JButton C1;
    private JButton C2;
    private JButton C3;
    private JButton C4;
    private JButton C5;
    private JButton C6;
    private JButton C7;
    private JButton C8;
    private JButton C9;
    private JButton C10;
    private JButton C11;
    private JButton C12;
    private JButton C13;
    private JButton C14;
    private JButton C15;
    private JButton C16;
    private JButton C17;
    private JButton C18;
    private JButton C19;
    private JButton C20;
    private JButton C21;
    private JButton C22;
    private JButton C23;
    private JButton C24;
    private JButton C25;
    private JButton C26;
    private JButton C27;
    private JButton C28;
    private JButton C29;
    private JButton C30;
    private JButton C31;
    private JButton C32;
    private JButton C33;
    // Category back and forth buttons
    private JButton C34;
    private JButton C35;
    private JButton button83;
    private JButton button84;
    private JButton button85;
    private JButton button86;
    private JButton button87;
    private JButton button88;
    private JButton button89;
    private JButton button90;
    private JButton button91;
    private JButton button92;
    private JButton button93;
    private JButton button94;
    private JButton button95;
    private JPanel Main;
    private JList Order;


    public MainScreen(){

        Order.setFont(new java.awt.Font("Georgia", 1, 24));
        Total.setFont(new java.awt.Font("Georgia", 1, 24));
        OrderDetails.setFont(new java.awt.Font("Georgia", 1, 24));


        P1.addActionListener(e -> {
                DefaultListModel listModel1 = (DefaultListModel) Order.getModel();

                String st="Working hard";
                listModel1.addElement(st);


                Order.setModel(listModel1);

//                ensures it scrolls to the last item
                int lastIndex = Order.getModel().getSize() - 1;
                if (lastIndex >= 0) {
                    Order.ensureIndexIsVisible(lastIndex);
                }

        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Mainscreen");
        frame.setContentPane(new MainScreen().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

//        scroll.setViewportView(hi);
    }

}

