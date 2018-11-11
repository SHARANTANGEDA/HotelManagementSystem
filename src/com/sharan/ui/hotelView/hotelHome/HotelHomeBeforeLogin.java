/*
 * Created by JFormDesigner on Fri Nov 09 18:13:27 IST 2018
 */

package com.sharan.ui.hotelView.hotelHome;

import com.sharan.DataBaseController;
import com.sharan.fileHandler.TextFileController;
import com.sharan.ui.home.homePage.HomePage;
import com.sharan.ui.home.loginPopUp.Login;
import com.sharan.ui.home.signUpPopUp.SignUp;
import com.sharan.ui.hotelView.fillOutFields.FillOutFieldsToViewHotelIndividual;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import static com.sharan.Main.loginSuccess;
import static com.sharan.Main.signUpSuccess;

/**
 * @author SAI SHARAN
 */
public class HotelHomeBeforeLogin extends JFrame {

    DataBaseController dataBaseController;
    private String universalHotelSearch;
    private String userName;
    private String uniqueId;
    private ArrayList<String> list;
    private double rate;
    private String starRatingPath;

    public HotelHomeBeforeLogin(String uniqueId,DataBaseController dataBaseController) {
        this.dataBaseController=dataBaseController;
        this.uniqueId=uniqueId;
        initComponents();
        addToUniversalHotelSearch();
        AutoCompleteDecorator.decorate(Hotels);
        TextFileController textFileController=new TextFileController();
        userName=textFileController.readFile();

        list=dataBaseController.parseHotel(uniqueId);

        rate = dataBaseController.calculateRating(uniqueId);
        String rateString = String.valueOf(rate);
        starRatingPath = "/com/sharan/ui/pictures/stars/" + rateString + ".jpg";
        dataBaseController.closeDatabaseConnection();
        ratingLabel.setIcon(new ImageIcon(getClass().getResource(starRatingPath)));
        hotelPhoto.setIcon(new ImageIcon(getClass().getResource(list.get(4))));
        Title.setText(list.get(1));
        contactDetails.setText(list.get(3));
        hotelDetails.setText(list.get(2));
        numberOfRatings.setText(list.get(5) + " people rated this");



        hotelHomeBeforeLogin.setVisible(true);
    }

    private void backButtonActionPerformed(ActionEvent e) {
        hotelHomeBeforeLogin.dispose();
        HomePage homePage=new HomePage(dataBaseController);
    }

    private void HotelsItemStateChanged(ItemEvent e) {
        universalHotelSearch=e.getItem().toString();
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
    private void addToUniversalHotelSearch() {
        dataBaseController.initialiseDatabase();
        ArrayList<String> list=dataBaseController.getUniversalSearchData();
        dataBaseController.closeDatabaseConnection();
        Hotels.addItem("Select a Hotel");
        for(String str:list) {
            Hotels.addItem(str);
        }
    }
    private void rateYourExperienceActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"Please Login To Rate your Experience");

    }

    private void checkAvailabilityActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"Please Login To Continue");
    }

    private void loginActionPerformed(ActionEvent e) {
        com.sharan.ui.home.loginPopUp.Login login=new Login(dataBaseController,LoginField);


        if(login.returnLoginStatus()==1) {
            loginSuccess=0;
            hotelHomeBeforeLogin.dispose();
            FillOutFieldsToViewHotelIndividual fillOutFieldsToViewHotel=new FillOutFieldsToViewHotelIndividual(userName,uniqueId,list.get(1),LoginField,dataBaseController);
            login.getLogin().dispose();

        }

    }

    private void signUpActionPerformed(ActionEvent e) {
        com.sharan.ui.home.signUpPopUp.SignUp signUp=new SignUp(dataBaseController,LoginField);
        if(signUpSuccess==1) {
            signUpSuccess=0;
            hotelHomeBeforeLogin.dispose();
            FillOutFieldsToViewHotelIndividual fillOutFieldsToViewHotel=new FillOutFieldsToViewHotelIndividual(userName,uniqueId,list.get(1),LoginField,dataBaseController);
            signUp.getSignUp().dispose();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        hotelHomeBeforeLogin = new JFrame();
        menuBar = new JMenuBar();
        backButton = new JMenuItem();
        separator1 = new JSeparator();
        Hotels = new JComboBox();
        Search = new JButton();
        LoginField = new JButton();
        SignUpField = new JButton();
        Title = new JLabel();
        hotelPhoto = new JLabel();
        rateYourExperience = new JButton();
        ratingLabel = new JLabel();
        HotelDetails = new JScrollPane();
        hotelDetails = new JTextPane();
        checkAvailability = new JButton();
        titleContactDetails = new JLabel();
        scrollPane2 = new JScrollPane();
        contactDetails = new JTextPane();
        numberOfRatings = new JLabel();

        //======== hotelHomeBeforeLogin ========
        {
            hotelHomeBeforeLogin.setResizable(false);
            hotelHomeBeforeLogin.setMaximizedBounds(new Rectangle(0, 0, 1500, 1080));
            hotelHomeBeforeLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container hotelHomeBeforeLoginContentPane = hotelHomeBeforeLogin.getContentPane();

            //======== menuBar ========
            {
                menuBar.setPreferredSize(new Dimension(83, 50));
                menuBar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
                menuBar.setBackground(Color.darkGray);
                menuBar.setForeground(new Color(238, 238, 238));

                //---- backButton ----
                backButton.setBackground(Color.darkGray);
                backButton.setPreferredSize(new Dimension(50, 13));
                backButton.setMaximumSize(new Dimension(50, 32767));
                backButton.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/Back24.gif")));
                backButton.addActionListener(e -> backButtonActionPerformed(e));
                menuBar.add(backButton);

                //---- separator1 ----
                separator1.setMaximumSize(new Dimension(350, 50));
                menuBar.add(separator1);

                //---- Hotels ----
                Hotels.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
                Hotels.setToolTipText("Search for Hotels");
                Hotels.setMaximumSize(new Dimension(500, 50));
                Hotels.addItemListener(e -> HotelsItemStateChanged(e));
                menuBar.add(Hotels);

                //---- Search ----
                Search.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
                Search.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/findSmall.png")));
                Search.setText("Search");
                Search.setForeground(new Color(238, 238, 238));
                Search.setBackground(Color.darkGray);
                Search.addActionListener(e -> SearchActionPerformed(e));
                menuBar.add(Search);

                //---- LoginField ----
                LoginField.setText("Login");
                LoginField.setFont(new Font("Dialog", Font.BOLD, 22));
                LoginField.addActionListener(e -> loginActionPerformed(e));
                menuBar.add(LoginField);

                //---- SignUpField ----
                SignUpField.setText("Sign Up");
                SignUpField.setFont(new Font("Dialog", Font.BOLD, 22));
                SignUpField.addActionListener(e -> signUpActionPerformed(e));
                menuBar.add(SignUpField);
            }
            hotelHomeBeforeLogin.setJMenuBar(menuBar);

            //---- Title ----
            Title.setText("Hotel");
            Title.setHorizontalAlignment(SwingConstants.CENTER);
            Title.setFont(new Font("Dialog", Font.BOLD, 47));
            Title.setBackground(new Color(255, 204, 0));
            Title.setOpaque(true);

            //---- hotelPhoto ----
            hotelPhoto.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/Ncr/New/Rose/Ncr_New_RoseA.jpg")));

            //---- rateYourExperience ----
            rateYourExperience.setText("Rate Your Experience");
            rateYourExperience.setFont(new Font("Droid Sans", Font.BOLD | Font.ITALIC, 15));
            rateYourExperience.addActionListener(e -> rateYourExperienceActionPerformed(e));

            //---- ratingLabel ----
            ratingLabel.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/stars/5.0.jpg")));

            //======== HotelDetails ========
            {

                //---- hotelDetails ----
                hotelDetails.setBackground(new Color(238, 238, 238));
                hotelDetails.setText("This is a good Hotel.");
                hotelDetails.setFont(new Font("Dialog", Font.PLAIN, 18));
                hotelDetails.setEditable(false);
                HotelDetails.setViewportView(hotelDetails);
            }

            //---- checkAvailability ----
            checkAvailability.setText("Check Availability");
            checkAvailability.setFont(new Font("Dialog", Font.BOLD, 30));
            checkAvailability.setBackground(new Color(153, 0, 0));
            checkAvailability.setForeground(new Color(238, 238, 238));
            checkAvailability.addActionListener(e -> checkAvailabilityActionPerformed(e));

            //---- titleContactDetails ----
            titleContactDetails.setText("Contact Details");
            titleContactDetails.setVerticalAlignment(SwingConstants.BOTTOM);
            titleContactDetails.setFont(new Font("Dialog", Font.BOLD, 18));

            //======== scrollPane2 ========
            {

                //---- contactDetails ----
                contactDetails.setBackground(new Color(238, 238, 238));
                contactDetails.setEditable(false);
                contactDetails.setText("address is  some where");
                contactDetails.setFont(new Font("Arial", Font.ITALIC, 20));
                scrollPane2.setViewportView(contactDetails);
            }

            GroupLayout hotelHomeBeforeLoginContentPaneLayout = new GroupLayout(hotelHomeBeforeLoginContentPane);
            hotelHomeBeforeLoginContentPane.setLayout(hotelHomeBeforeLoginContentPaneLayout);
            hotelHomeBeforeLoginContentPaneLayout.setHorizontalGroup(
                hotelHomeBeforeLoginContentPaneLayout.createParallelGroup()
                    .addGroup(hotelHomeBeforeLoginContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(hotelHomeBeforeLoginContentPaneLayout.createParallelGroup()
                            .addComponent(Title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, hotelHomeBeforeLoginContentPaneLayout.createSequentialGroup()
                                .addGroup(hotelHomeBeforeLoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(scrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
                                    .addGroup(hotelHomeBeforeLoginContentPaneLayout.createSequentialGroup()
                                        .addGroup(hotelHomeBeforeLoginContentPaneLayout.createParallelGroup()
                                            .addComponent(hotelPhoto, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(titleContactDetails, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(hotelHomeBeforeLoginContentPaneLayout.createParallelGroup()
                                            .addComponent(HotelDetails)
                                            .addGroup(hotelHomeBeforeLoginContentPaneLayout.createSequentialGroup()
                                                .addComponent(rateYourExperience, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 494, Short.MAX_VALUE))
                                            .addGroup(hotelHomeBeforeLoginContentPaneLayout.createSequentialGroup()
                                                .addGroup(hotelHomeBeforeLoginContentPaneLayout.createParallelGroup()
                                                    .addComponent(numberOfRatings, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(ratingLabel, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                                .addComponent(checkAvailability, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)))))
                                .addGap(10, 10, 10))))
            );
            hotelHomeBeforeLoginContentPaneLayout.setVerticalGroup(
                hotelHomeBeforeLoginContentPaneLayout.createParallelGroup()
                    .addGroup(hotelHomeBeforeLoginContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Title, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(hotelHomeBeforeLoginContentPaneLayout.createParallelGroup()
                            .addGroup(hotelHomeBeforeLoginContentPaneLayout.createSequentialGroup()
                                .addComponent(HotelDetails, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rateYourExperience)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hotelHomeBeforeLoginContentPaneLayout.createParallelGroup()
                                    .addGroup(hotelHomeBeforeLoginContentPaneLayout.createSequentialGroup()
                                        .addComponent(numberOfRatings, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ratingLabel))
                                    .addComponent(checkAvailability, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(hotelHomeBeforeLoginContentPaneLayout.createSequentialGroup()
                                .addComponent(hotelPhoto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleContactDetails, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
            );
            hotelHomeBeforeLogin.pack();
            hotelHomeBeforeLogin.setLocationRelativeTo(hotelHomeBeforeLogin.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame hotelHomeBeforeLogin;
    private JMenuBar menuBar;
    private JMenuItem backButton;
    private JSeparator separator1;
    private JComboBox Hotels;
    private JButton Search;
    private JButton LoginField;
    private JButton SignUpField;
    private JLabel Title;
    private JLabel hotelPhoto;
    private JButton rateYourExperience;
    private JLabel ratingLabel;
    private JScrollPane HotelDetails;
    private JTextPane hotelDetails;
    private JButton checkAvailability;
    private JLabel titleContactDetails;
    private JScrollPane scrollPane2;
    private JTextPane contactDetails;
    private JLabel numberOfRatings;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
