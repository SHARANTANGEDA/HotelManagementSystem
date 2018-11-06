/*
 * Created by JFormDesigner on Wed Oct 31 10:17:03 IST 2018
 */

package com.sharan.ui.hotelView.hotelHome.beforeLogin.loginToContinueDialog;

import com.sharan.DataBaseController;
import com.sharan.ui.home.loginPopUp.Login;
import com.sharan.ui.home.signUpPopUp.SignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static com.sharan.Main.loginSuccess;
import static com.sharan.Main.signUpSuccess;

/**
 * @author SAI SHARAN
 */
public class LoginToContinue {
    private DataBaseController dataBaseController;
    private String uniqueId;


    public LoginToContinue(String id,DataBaseController dataBaseController) {
        this.dataBaseController=dataBaseController;
        initComponents();
    }

    private void redirectLoginActionPerformed(ActionEvent e) {

        dataBaseController.initialiseDatabase();
        Login login=new Login(dataBaseController,redirectLogin);
        if(loginSuccess==1) {
            loginToContinue.dispose();
            loginSuccess=0;
//            OldHotelIndividualSite hotelHomePageAfterLogin =new OldHotelIndividualSite(uniqueId,dataBaseController);
            login.getLogin().dispose();
        }
        dataBaseController.closeDatabaseConnection();
    }

    private void redirectSignUpActionPerformed(ActionEvent e) {
        dataBaseController.initialiseDatabase();
        SignUp signUp=new SignUp(dataBaseController,redirectSignUp);

        if(signUpSuccess==1) {
            loginToContinue.dispose();
            signUpSuccess=0;
//            OldHotelIndividualSite hotelHomePageAfterLogin =new OldHotelIndividualSite(uniqueId,dataBaseController);
            signUp.getSignUp().dispose();
        }
        dataBaseController.closeDatabaseConnection();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        loginToContinue = new JDialog();
        label1 = new JLabel();
        redirectLogin = new JButton();
        textField1 = new JTextField();
        redirectSignUp = new JButton();

        //======== loginToContinue ========
        {
            loginToContinue.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container loginToContinueContentPane = loginToContinue.getContentPane();

            //---- label1 ----
            label1.setText("Please Login to Continue");
            label1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setForeground(new Color(238, 238, 238));
            label1.setBackground(new Color(0, 204, 0));
            label1.setOpaque(true);

            //---- redirectLogin ----
            redirectLogin.setText("Login");
            redirectLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            redirectLogin.addActionListener(e -> redirectLoginActionPerformed(e));

            //---- textField1 ----
            textField1.setText("Don't have an account yet?,No problem click the button below to signUp");
            textField1.setFont(textField1.getFont().deriveFont(textField1.getFont().getSize() + 2f));
            textField1.setBackground(UIManager.getColor("window"));

            //---- redirectSignUp ----
            redirectSignUp.setText("SignUp");
            redirectSignUp.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            redirectSignUp.addActionListener(e -> redirectSignUpActionPerformed(e));

            GroupLayout loginToContinueContentPaneLayout = new GroupLayout(loginToContinueContentPane);
            loginToContinueContentPane.setLayout(loginToContinueContentPaneLayout);
            loginToContinueContentPaneLayout.setHorizontalGroup(
                loginToContinueContentPaneLayout.createParallelGroup()
                    .addGroup(loginToContinueContentPaneLayout.createSequentialGroup()
                        .addGroup(loginToContinueContentPaneLayout.createParallelGroup()
                            .addGroup(loginToContinueContentPaneLayout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
                            .addGroup(loginToContinueContentPaneLayout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(redirectLogin, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                            .addGroup(loginToContinueContentPaneLayout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(redirectSignUp, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                            .addGroup(loginToContinueContentPaneLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(66, Short.MAX_VALUE))
            );
            loginToContinueContentPaneLayout.setVerticalGroup(
                loginToContinueContentPaneLayout.createParallelGroup()
                    .addGroup(loginToContinueContentPaneLayout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(redirectLogin, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(redirectSignUp, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
            );
            loginToContinue.pack();
            loginToContinue.setLocationRelativeTo(loginToContinue.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JDialog loginToContinue;
    private JLabel label1;
    private JButton redirectLogin;
    private JTextField textField1;
    private JButton redirectSignUp;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
