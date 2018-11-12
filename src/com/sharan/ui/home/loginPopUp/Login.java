/*
 * Created by JFormDesigner on Tue Oct 30 03:33:14 IST 2018
 */

package com.sharan.ui.home.loginPopUp;

import com.sharan.DataBaseController;
import com.sharan.encryptionAlgorithms.PasswordHashing;
import com.sharan.fileHandler.TextFileController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static com.sharan.Main.loginSuccess;

public class Login extends JPanel {

    private DataBaseController dataBaseController;
    private JButton tobeClicked;
    private String userName="notLoaded";

    public int returnLoginStatus() {
        return loginSuccess;
    }


    public JDialog getLogin() {
        return Login;
    }

    public String getUserName() {
        return userName;
    }

    public Login(DataBaseController dataBaseController, JButton tobeClicked) {
        this.dataBaseController = dataBaseController;
        this.tobeClicked=tobeClicked;
        initComponents();
        Login.setVisible(true);
        Login.setIconImage(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/hotel.png")).getImage());

        Login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    private void button1ActionPerformed(ActionEvent e) {
        String username = userNameField.getText();
        if(!username.isEmpty()) {
            TextFileController fileController=new TextFileController();
            fileController.writeToFile(username);
        }
        PasswordHashing passwordHashing = new PasswordHashing();
        String password =passwordHashing.hashPassword(passwordField1.getText());
        verify(username,password);
    }

    public void verify(String username,String password)
    {
        dataBaseController.initialiseDatabase();
        String p= dataBaseController.Verify(username);
        dataBaseController.closeDatabaseConnection();
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
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        Login = new JDialog();
        label1 = new JLabel();
        label2 = new JLabel();
        userNameField = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();

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
            label1.setOpaque(true);

            //---- label2 ----
            label2.setText("USERNAME");
            label2.setFont(new Font("Comic Sans MS", Font.ITALIC, 24));
            label2.setBackground(new Color(0, 155, 0));

            //---- userNameField ----
            userNameField.setFont(new Font("Arial", Font.PLAIN, 18));

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
            button1.addActionListener(e -> button1ActionPerformed(e));

            GroupLayout LoginContentPaneLayout = new GroupLayout(LoginContentPane);
            LoginContentPane.setLayout(LoginContentPaneLayout);
            LoginContentPaneLayout.setHorizontalGroup(
                LoginContentPaneLayout.createParallelGroup()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(LoginContentPaneLayout.createSequentialGroup()
                        .addGroup(LoginContentPaneLayout.createParallelGroup()
                            .addGroup(LoginContentPaneLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(label3, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(LoginContentPaneLayout.createParallelGroup()
                                    .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(LoginContentPaneLayout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(56, Short.MAX_VALUE))
            );
            LoginContentPaneLayout.setVerticalGroup(
                LoginContentPaneLayout.createParallelGroup()
                    .addGroup(LoginContentPaneLayout.createSequentialGroup()
                        .addComponent(label1)
                        .addGap(64, 64, 64)
                        .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
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
    private JTextField userNameField;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables



}