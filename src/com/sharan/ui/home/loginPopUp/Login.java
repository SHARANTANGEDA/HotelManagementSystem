/*
 * Created by JFormDesigner on Tue Oct 30 03:33:14 IST 2018
 */

package com.sharan.ui.home.loginPopUp;

import com.sharan.DataBaseController;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {

    DataBaseController dataBaseController;


    public Login(DataBaseController dataBaseController) {
        this.dataBaseController = dataBaseController;
        initComponents();


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

        //======== Login ========
        {
            Login.setMinimumSize(new Dimension(10, 25));
            Login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Login.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
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

            GroupLayout LoginContentPaneLayout = new GroupLayout(LoginContentPane);
            LoginContentPane.setLayout(LoginContentPaneLayout);
            LoginContentPaneLayout.setHorizontalGroup(
                LoginContentPaneLayout.createParallelGroup()
                    .addGroup(LoginContentPaneLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(219, Short.MAX_VALUE))
                    .addGroup(LoginContentPaneLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(LoginContentPaneLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                            .addGroup(LoginContentPaneLayout.createSequentialGroup()
                                .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(LoginContentPaneLayout.createParallelGroup()
                                    .addComponent(passwordField1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))
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
                        .addContainerGap())
            );
            Login.pack();
            Login.setLocationRelativeTo(Login.getOwner());
            Login.setVisible(true);
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
