/*
 * Created by JFormDesigner on Tue Oct 30 03:33:14 IST 2018
 */

package com.sharan.ui.home.loginPopUp;

import com.sharan.DataBaseController;
import com.sharan.PasswordHashing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static com.sharan.Main.loginSuccess;
import static com.sharan.Main.signUpSuccess;

public class Login extends JPanel {

    private DataBaseController dataBaseController;
    private JButton tobeClicked;

    public int returnLoginStatus() {
        return loginSuccess;
    }

    public int returnSignUpSuccess() {
        return signUpSuccess;
    }
    public JDialog getLogin() {
        return Login;
    }



    public Login(DataBaseController dataBaseController,JButton tobeClicked) {
        this.dataBaseController = dataBaseController;
        this.tobeClicked=tobeClicked;
        initComponents();


    }

    private void button1ActionPerformed(ActionEvent e) {
        String username = textField1.getText();
        String pass = passwordField1.getText();
        PasswordHashing passwordHashing = new PasswordHashing();
        String password =passwordHashing.hashPassword(pass);
        // System.out.println(password);
        verify(username,password);
    }
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        Login = new JDialog();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== Login ========
        {
            Login.setMinimumSize(new Dimension(10, 25));
            Login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Login.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            Login.setVisible(true);
            Container LoginContentPane = Login.getContentPane();

            //---- label1 ----
            label1.setText("LOGIN");
            label1.setForeground(Color.red);
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 18f));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            label1.setBackground(Color.yellow);

            //---- label2 ----
            label2.setText("USERNAME");
            label2.setFont(new Font("Comic Sans MS", Font.ITALIC, 24));
            label2.setBackground(new Color(0, 155, 0));

            //---- textField1 ----
            textField1.setFont(new Font("Arial", Font.PLAIN, 18));

            //---- label3 ----
            label3.setText("PASSWORD");
            label3.setFont(new Font("Comic Sans MS", Font.ITALIC, 24));
            label3.setBackground(new Color(0, 166, 0));

            //---- passwordField1 ----
            passwordField1.setFont(new Font("Arial", Font.PLAIN, 18));

            //---- button1 ----
            button1.setText("LOGIN");
            button1.setFont(new Font("Times New Roman", Font.BOLD, 18));
            button1.setBackground(new Color(0, 155, 0));
            button1.addActionListener(e -> {
			button1ActionPerformed(e);
		});

            //---- button2 ----
            button2.setText("FORGOT PASSWORD");
            button2.addActionListener(e -> button2ActionPerformed(e));

            GroupLayout LoginContentPaneLayout = new GroupLayout(LoginContentPane);
            LoginContentPane.setLayout(LoginContentPaneLayout);
            LoginContentPaneLayout.setHorizontalGroup(
                LoginContentPaneLayout.createParallelGroup()
                    .addGroup(LoginContentPaneLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(label3, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(LoginContentPaneLayout.createParallelGroup()
                            .addComponent(passwordField1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(LoginContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                        .addGap(57, 57, 57))
                    .addGroup(LoginContentPaneLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(button2, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                        .addContainerGap(288, Short.MAX_VALUE))
            );
            LoginContentPaneLayout.setVerticalGroup(
                LoginContentPaneLayout.createParallelGroup()
                    .addGroup(LoginContentPaneLayout.createSequentialGroup()
                        .addComponent(label1)
                        .addGap(64, 64, 64)
                        .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                        .addComponent(button2)
                        .addGap(26, 26, 26))
            );
            Login.pack();
            Login.setLocationRelativeTo(Login.getOwner());

        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JDialog Login;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void verify(String username,String password)
    {
        dataBaseController.initialiseDatabase();
        String p= dataBaseController.Verify(username);
        dataBaseController.closeDatabaseConnection();
        System.out.println(username);
        System.out.println(p+password);
        if(p.equals(password))
        {
            Login.dispose();
            loginSuccess=1;
            tobeClicked.doClick();

        }
        else
        {
            JOptionPane.showMessageDialog(null,"Check Your Password");
        }

    }


}