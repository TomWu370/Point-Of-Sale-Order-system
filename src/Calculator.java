import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Calculator extends JDialog {
    private double total1 = 0.0;
    private double total2 = 0.0;
    private char math_operator;
    private JPanel Calculator;
    private JTextField textField1;
    private JButton btnMultiply;
    private JButton btn2;
    private JButton btn3;
    private JButton btn5;
    private JButton btn8;
    private JButton btnDot;
    private JButton btnPlus;
    private JButton btn6;
    private JButton btn9;
    private JButton btnCE;
    private JButton btnMinus;
    private JButton btnDivide;
    private JButton btn1;
    private JButton btn4;
    private JButton btn7;
    private JButton btn0;
    private JButton btnEqual;

    private void getOperator(String btnText) {
        math_operator = btnText.charAt(0);
        total1 = total1 + Double.parseDouble(textField1.getText());
        textField1.setText("");
    }

    public Calculator() {
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = textField1.getText() + btn0.getText();
                textField1.setText(btn1Text);
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = textField1.getText() + btn1.getText();
                textField1.setText(btn1Text);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = textField1.getText() + btn2.getText();
                textField1.setText(btn1Text);
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = textField1.getText() + btn3.getText();
                textField1.setText(btn1Text);
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = textField1.getText() + btn4.getText();
                textField1.setText(btn1Text);
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = textField1.getText() + btn5.getText();
                textField1.setText(btn1Text);
            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = textField1.getText() + btn6.getText();
                textField1.setText(btn1Text);
            }
        });

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = textField1.getText() + btn7.getText();
                textField1.setText(btn1Text);
            }
        });

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = textField1.getText() + btn8.getText();
                textField1.setText(btn1Text);
            }
        });

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = textField1.getText() + btn9.getText();
                textField1.setText(btn1Text);
            }
        });

        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnPlus.getText();
                getOperator(button_text);
            }
        });
        btnEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (math_operator) {
                    case '+':
                        total2 = total1 + Double.parseDouble(textField1.getText());
                        break;
                    case '-':
                        total2 = total1 - Double.parseDouble(textField1.getText());
                        break;
                    case '/':
                        total2 = total1 / Double.parseDouble(textField1.getText());
                        break;
                    case '*':
                        total2 = total1 * Double.parseDouble(textField1.getText());
                        break;
                }
                textField1.setText(Double.toString(total2));
                total1 = 0;
            }
        });
        btnCE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total2 = 0;
                textField1.setText("");
            }
        });
        btnDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("")) {
                    textField1.setText("0.");
                } else if (textField1.getText().contains(".")) {
                    btnDot.setEnabled(false);
                } else {
                    String btnDotText = textField1.getText() + btnDot.getText();
                    textField1.setText(btnDotText);
                }
                btnDot.setEnabled(true);
            }
        });
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnMinus.getText();
                getOperator(button_text);
            }
        });
        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnMultiply.getText();
                getOperator(button_text);

            }
        });
        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnDivide.getText();
                getOperator(button_text);
            }
        });

    }

    public static void main(String[] args) {
        LaunchPage page = new LaunchPage();

        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(760, 340);
//        frame.setLayout(new FlowLayout());
        frame.pack();
        frame.setVisible(true);
//        frame.setSize(1500,1000);
//        frame.setLayout(new FlowLayout());
//
//        JLabel label = new JLabel("POS");
//        frame.add(label);
//        JTextField text = new JTextField(20);
//        frame.add(text);
//
//        JButton button = new JButton("Submit");
//        frame.add(button);
    }

    //    static JFrame frame = new JFrame();
//    public static String text;
//    static JButton myButton = new JButton("New Window");
//    public static void LaunchPage(){
//        System.out.println(":"+text);
//        myButton.setBounds(100,160, 200, 40);
//        myButton.setFocusable(false);
//        myButton.addActionListener(e -> {
//            newWindow myWindow = new newWindow();
//        });
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(420,420);
//        frame.setLayout(null);
//        frame.setVisible(true);
//
//        frame.add(myButton);
//        System.out.println(text);
//
//    }
//
//    JFrame frame2 = new JFrame();
//    JLabel label = new JLabel("hello");
//    public static void newWindow(){
//        label.setBounds(0,0,100,50);
//        label.setFont(new Font(null, Font.PLAIN,25));
//
//        text = "hi2";
//        System.out.println(":"+text);
//        frame2.add(label);
//
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.setSize(420,420);
//        frame2.setLayout(null);
//        frame2.setVisible(true);
//    }


//    @Override
//    public void actionPerformed(ActionEvent e) {
////        if (e.getSource()==myButton) {
//////            newWindow myWindow = new newWindow();
////        }
//    }
}
