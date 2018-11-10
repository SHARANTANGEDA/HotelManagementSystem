/*
 * Created by JFormDesigner on Sat Nov 03 17:38:41 IST 2018
 */

package com.sharan.ui.home.homePage;

import com.sharan.DataBaseController;
import com.sharan.fileHandler.TextFileController;
import com.sharan.ui.home.homePageAfterLogin.HomePageAfterLogin;
import com.sharan.ui.home.loginPopUp.Login;
import com.sharan.ui.home.signUpPopUp.SignUp;
import com.sharan.ui.hotelView.hotelHome.HotelHomeBeforeLogin;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import static com.sharan.Main.loginSuccess;
import static com.sharan.Main.signUpSuccess;


public class HomePage {

    private DataBaseController dataBaseController;
    private String userName;
    private String universalHotelSearch;
    private String uniqueId;

    public HomePage(DataBaseController dataBaseController) {

        this.dataBaseController=dataBaseController;
        initComponents();
        addToUniversalHotelSearch();
        AutoCompleteDecorator.decorate(Hotels);
        TextFileController textFileController=new TextFileController();
        userName=textFileController.readFile();

        homeFrame.setVisible(true);


    }
    private void addToUniversalHotelSearch() {
        dataBaseController.initialiseDatabase();
        ArrayList<String> list=dataBaseController.getUniversalSearchData();
        dataBaseController.closeDatabaseConnection();
        Hotels.addItem("Select a Hotel");
        for(String str:list) {
            Hotels.addItem(str);
        }
    }


    public JButton getLogin() {
        return LoginField;
    }

    private void loginActionPerformed(ActionEvent e) {
        com.sharan.ui.home.loginPopUp.Login login=new Login(dataBaseController,LoginField);


        if(login.returnLoginStatus()==1) {
            loginSuccess=0;
            homeFrame.dispose();
            HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(userName,dataBaseController);
            login.getLogin().dispose();

        }

    }

    private void signUpActionPerformed(ActionEvent e) {
        com.sharan.ui.home.signUpPopUp.SignUp signUp=new SignUp(dataBaseController,LoginField);
        if(signUpSuccess==1) {
            signUpSuccess=0;
            homeFrame.dispose();
            HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(signUp.getName(),dataBaseController);
            signUp.getSignUp().dispose();
        }
    }


    private void SearchActionPerformed(ActionEvent e) {
        if((!universalHotelSearch.isEmpty()) && (!universalHotelSearch.equalsIgnoreCase("Select a Hotel"))) {
            String temp[]=universalHotelSearch.split(",");
            dataBaseController.initialiseDatabase();
            String uniqueId=dataBaseController.setUniversalSearchData(temp);
            dataBaseController.closeDatabaseConnection();
            HotelHomeBeforeLogin hotelHomeBeforeLogin=new HotelHomeBeforeLogin(uniqueId,dataBaseController);
        }
        else {
            JOptionPane.showMessageDialog(null,"Please Select a Hotel First");
        }
    }


    private void HotelsItemStateChanged(ItemEvent e) {
        universalHotelSearch=e.getItem().toString();
    }






    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        homeFrame = new JFrame();
        applicationName = new JLabel();
        menuBar1 = new JMenuBar();
        separator1 = new JSeparator();
        Hotels = new JComboBox();
        Search = new JButton();
        homePagePhoto = new JLabel();
        LoginField = new JButton();
        SignUpField = new JButton();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== homeFrame ========
        {
            homeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container homeFrameContentPane = homeFrame.getContentPane();

            //---- applicationName ----
            applicationName.setText("Online Hotel Booking System");
            applicationName.setHorizontalAlignment(SwingConstants.CENTER);
            applicationName.setFont(new Font("Dialog", Font.BOLD, 28));
            applicationName.setBackground(new Color(255, 204, 0));
            applicationName.setOpaque(true);

            //======== menuBar1 ========
            {
                menuBar1.setBackground(Color.darkGray);

                //---- separator1 ----
                separator1.setMaximumSize(new Dimension(1200, 50));
                separator1.setBackground(Color.darkGray);
                menuBar1.add(separator1);

                //---- Hotels ----
                Hotels.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
                Hotels.setToolTipText("Search for Hotels");
                Hotels.setMaximumSize(new Dimension(600, 50));
                Hotels.setEditable(true);
                Hotels.addItemListener(e -> HotelsItemStateChanged(e));
                menuBar1.add(Hotels);

                //---- Search ----
                Search.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
                Search.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/findSmall.png")));
                Search.setText("Search");
                Search.setBackground(Color.darkGray);
                Search.setForeground(new Color(238, 238, 238));
                Search.addActionListener(e -> SearchActionPerformed(e));
                menuBar1.add(Search);
            }

            //---- homePagePhoto ----
            homePagePhoto.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/HomePagePic.jpg")));

            //---- LoginField ----
            LoginField.setText("Login");
            LoginField.setFont(new Font("Dialog", Font.BOLD, 22));
            LoginField.addActionListener(e -> loginActionPerformed(e));

            //---- SignUpField ----
            SignUpField.setText("Sign Up");
            SignUpField.setFont(new Font("Dialog", Font.BOLD, 22));
            SignUpField.addActionListener(e -> signUpActionPerformed(e));

            //======== scrollPane1 ========
            {

                //---- textPane1 ----
                textPane1.setBackground(new Color(238, 238, 238));
                textPane1.setText("BASIC INTRO HERE");
                scrollPane1.setViewportView(textPane1);
            }

            GroupLayout homeFrameContentPaneLayout = new GroupLayout(homeFrameContentPane);
            homeFrameContentPane.setLayout(homeFrameContentPaneLayout);
            homeFrameContentPaneLayout.setHorizontalGroup(
                homeFrameContentPaneLayout.createParallelGroup()
                    .addGroup(homeFrameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(homeFrameContentPaneLayout.createParallelGroup()
                            .addComponent(applicationName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(homeFrameContentPaneLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(menuBar1, GroupLayout.DEFAULT_SIZE, 1183, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LoginField)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SignUpField, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addComponent(homePagePhoto, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1448, Short.MAX_VALUE)
                    .addGroup(homeFrameContentPaneLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1292, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(130, Short.MAX_VALUE))
            );
            homeFrameContentPaneLayout.setVerticalGroup(
                homeFrameContentPaneLayout.createParallelGroup()
                    .addGroup(homeFrameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(applicationName, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(homeFrameContentPaneLayout.createParallelGroup()
                            .addGroup(homeFrameContentPaneLayout.createSequentialGroup()
                                .addGroup(homeFrameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LoginField, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                    .addComponent(SignUpField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                            .addGroup(homeFrameContentPaneLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(menuBar1, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addGap(27, 27, 27)))
                        .addComponent(homePagePhoto, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
            );
            homeFrame.pack();
            homeFrame.setLocationRelativeTo(homeFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame homeFrame;
    private JLabel applicationName;
    private JMenuBar menuBar1;
    private JSeparator separator1;
    private JComboBox Hotels;
    private JButton Search;
    private JLabel homePagePhoto;
    private JButton LoginField;
    private JButton SignUpField;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
