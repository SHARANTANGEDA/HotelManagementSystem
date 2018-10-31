/*
 * Created by JFormDesigner on Mon Oct 29 21:09:04 IST 2018
 */

package com.sharan.ui.home.signUpPopUp;

import com.sharan.DataBaseController;
import com.sharan.PasswordHashing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static com.sharan.Main.signUpSuccess;


public class SignUp extends JPanel {
    DataBaseController dataBaseController;
    String id;
    private JButton toBeClicked;
    public SignUp(DataBaseController dataBaseController,JButton toBeClicked) {
        initComponents();
        this.toBeClicked=toBeClicked;
        this.dataBaseController = dataBaseController;
    }

    public JDialog getSignUp() {
        return jDialog;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ajith
        jDialog = new JDialog();
        //frame1 = new JFrame();
        label1 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        textField8 = new JTextField();
        label15 = new JLabel();
        textField9 = new JTextField();
        signUpButton = new JButton();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        comboBox3 = new JComboBox();

        //======== frame1 ========
        {
            jDialog.setBackground(Color.green);
            jDialog.setForeground(Color.green);
            Container frame1ContentPane = jDialog.getContentPane();
            frame1ContentPane.setLayout(null);

            //---- label1 ----
            label1.setText("Sign Up");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 19f));
            label1.setForeground(Color.red);
            frame1ContentPane.add(label1);
            label1.setBounds(70, 15, 535, label1.getPreferredSize().height);
            frame1ContentPane.add(textField1);
            textField1.setBounds(250, 75, 230, textField1.getPreferredSize().height);
            frame1ContentPane.add(passwordField1);
            passwordField1.setBounds(250, 115, 230, passwordField1.getPreferredSize().height);

            //---- label2 ----
            label2.setText("USER NAME");
            frame1ContentPane.add(label2);
            label2.setBounds(85, 75, 90, label2.getPreferredSize().height);

            //---- label3 ----
            label3.setText("PASSWORD");
            frame1ContentPane.add(label3);
            label3.setBounds(85, 115, 75, label3.getPreferredSize().height);

            //---- label4 ----
            label4.setText("DATE OF BIRTH");
            frame1ContentPane.add(label4);
            label4.setBounds(85, 155, 95, label4.getPreferredSize().height);

            //---- label5 ----
            label5.setText("/");
            frame1ContentPane.add(label5);
            label5.setBounds(300, 155, 15, 20);

            //---- label6 ----
            label6.setText("/");
            frame1ContentPane.add(label6);
            label6.setBounds(new Rectangle(new Point(385, 155), label6.getPreferredSize()));

            //---- label7 ----
            label7.setText("RESIDENTIAL ADDRESS:");
            frame1ContentPane.add(label7);
            label7.setBounds(85, 195, 160, label7.getPreferredSize().height);

            //---- label8 ----
            label8.setText("H.NO.");
            frame1ContentPane.add(label8);
            label8.setBounds(85, 235, 85, label8.getPreferredSize().height);

            //---- label9 ----
            label9.setText("AREA/LOCALITY");
            frame1ContentPane.add(label9);
            label9.setBounds(new Rectangle(new Point(85, 275), label9.getPreferredSize()));

            //---- label10 ----
            label10.setText("CITY");
            frame1ContentPane.add(label10);
            label10.setBounds(new Rectangle(new Point(85, 315), label10.getPreferredSize()));

            //---- label11 ----
            label11.setText("STATE");
            frame1ContentPane.add(label11);
            label11.setBounds(new Rectangle(new Point(85, 355), label11.getPreferredSize()));

            //---- label12 ----
            label12.setText("AADHAR/PAN CARD");
            frame1ContentPane.add(label12);
            label12.setBounds(new Rectangle(new Point(85, 395), label12.getPreferredSize()));

            //---- label13 ----
            label13.setText("EMAIL ID");
            frame1ContentPane.add(label13);
            label13.setBounds(new Rectangle(new Point(85, 435), label13.getPreferredSize()));

            //---- label14 ----
            label14.setText("PHONE NUMBER");
            frame1ContentPane.add(label14);
            label14.setBounds(new Rectangle(new Point(85, 475), label14.getPreferredSize()));
            frame1ContentPane.add(textField2);
            textField2.setBounds(250, 235, 230, textField2.getPreferredSize().height);
            frame1ContentPane.add(textField3);
            textField3.setBounds(250, 275, 230, textField3.getPreferredSize().height);
            frame1ContentPane.add(textField4);
            textField4.setBounds(250, 315, 230, textField4.getPreferredSize().height);
            frame1ContentPane.add(textField5);
            textField5.setBounds(250, 355, 230, textField5.getPreferredSize().height);
            frame1ContentPane.add(textField6);
            textField6.setBounds(250, 435, 230, 20);
            frame1ContentPane.add(textField7);
            textField7.setBounds(250, 475, 230, 20);
            frame1ContentPane.add(textField8);
            textField8.setBounds(250, 395, 175, 20);

            //---- label15 ----
            label15.setText("/");
            frame1ContentPane.add(label15);
            label15.setBounds(440, 395, 15, 20);
            frame1ContentPane.add(textField9);
            textField9.setBounds(460, 395, 175, 20);

            //---- signUpButton ----
            signUpButton.setText("SIGN UP");
            frame1ContentPane.add(signUpButton);
            signUpButton.setBounds(315, 545, 145, 45);

            frame1ContentPane.add(comboBox1);
            comboBox1.setBounds(250, 155, 50, comboBox1.getPreferredSize().height);
            comboBox1.setFont(new Font("Dialog",Font.BOLD,18));
            int[] day = new int[31];
            for(int i=0;i<31;i++)
            {
                day[i] = i+1;
                comboBox1.addItem(day[i]);
            }
            comboBox1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    Object selectedStateobj = comboBox1.getSelectedItem();
                    selectedState1 = Integer.valueOf(selectedStateobj.toString());
                    // index = comboBox1.getSelectedIndex();

                }
            });

            frame1ContentPane.add(comboBox2);
            comboBox2.setBounds(325, 155, 50, 25);
            comboBox2.setFont(new Font("Dialog",Font.BOLD,18));
            int[] month = new int[12];
            for(int i=0;i<12;i++)
            {
                month[i] = i+1;
                comboBox2.addItem(month[i]);
            }
            comboBox2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    Object selectedStateobj = comboBox2.getSelectedItem();
                    selectedState2 = Integer.valueOf(selectedStateobj.toString());
                    // index = comboBox1.getSelectedIndex();

                }
            });
            frame1ContentPane.add(comboBox3);
            comboBox3.setBounds(410, 155, 90, 25);
            comboBox3.setFont(new Font("Dialog",Font.BOLD,18));
            int[] year = new int[87];
            for(int i=0;i<87;i++)
            {
                year[i] = i+1918;
                comboBox3.addItem(year[i]);
            }
            comboBox3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    Object selectedStateobj = comboBox3.getSelectedItem();
                    selectedState3 = Integer.valueOf(selectedStateobj.toString());
                    // index = comboBox1.getSelectedIndex();

                }
            });

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < frame1ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = frame1ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width+2, preferredSize.width+2);
                    preferredSize.height = Math.max(bounds.y + bounds.height+2, preferredSize.height+2);
                }
                Insets insets = frame1ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                frame1ContentPane.setMinimumSize(preferredSize);
                frame1ContentPane.setPreferredSize(preferredSize);
            }
            jDialog.pack();
            jDialog.setLocationRelativeTo(jDialog.getOwner());
            jDialog.setVisible(true);

        }
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInformation();
                Authenticate();
                if(flag==0)
                {
                    try {
                        dataBaseController.initialiseDatabase();
                        if(aadhar.equals(""))
                        {
                            id = pan;
                        }
                        else if(pan.equals(""))
                        {
                            id = aadhar;
                        }
                        else
                        {
                            id = aadhar;
                        }
                        dataBaseController.addUser(name,password,dob,address,email,id,phn);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    jDialog.dispose();
                    signUpSuccess=1;
                    toBeClicked.doClick();
                }

                dataBaseController.closeDatabaseConnection();

            }
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ajith
    private JDialog jDialog;
    private JFrame frame1;
    private JLabel label1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JLabel label15;
    private JTextField textField9;
    private JButton signUpButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private int selectedState1;
    private int selectedState2;
    private int selectedState3;
    private String name;
    private String password;
    private String dob;
    private String aadhar;
    private String pan;
    private String phn;
    private String address;
    private String email;
    private int flag;
    private String pass;



    public void getInformation()
    {
        name = textField1.getText();
        pass = passwordField1.getText();
        dob = selectedState1+"/"+selectedState2+"/"+selectedState3;
        address = textField2.getText() + textField3.getText() +textField4.getText()+textField5.getText();
        aadhar = textField8.getText();
        pan = textField9.getText();
        email = textField6.getText();
        phn = textField7.getText();
        PasswordHashing passwordHashing = new PasswordHashing();
        password = passwordHashing.hashPassword(pass);
        if(aadhar.equals(""))
        {
            id = pan+"p";
        }
        else if(pan.equals(""))
        {
            id = aadhar+"a";
        }
        else
        {
            id = aadhar+"a";
        }
    }
    public void Authenticate()
    {
        flag =0;
        String s= dataBaseController.checkUser(name);
        if(s.equals("s"))
        {
            JOptionPane.showMessageDialog(null,"UserName Already Exists");
            flag =1;
        }
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Enter Name");
            flag =1;
        }
        else if(password.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Enter Password");
            flag =1;
        }
        else if(textField2.getText().equals("")||textField3.getText().equals("")||textField4.getText().equals("")||textField5.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Enter Address");
            flag =1;
        }
        else if(pan.equals("")&&aadhar.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Enter Aadhar or Pan Card Details");
            flag =1;
        }

        else if(phn.equals("")||phn.length()!=10||phn.matches(".*[a-zA-Z]+.*"))
        {
            JOptionPane.showMessageDialog(null,"Enter Valid PhoneNumber");
            flag =1;
        }
        else if(email.equals("")||!email.contains("@")||!email.contains(".com"))
        {
            JOptionPane.showMessageDialog(null,"Enter Valid EmailId");
            flag =1;
        }
    }


    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
