/*
 * Created by JFormDesigner on Sat Nov 03 16:09:05 IST 2018
 */

package com.sharan.ui.hotelView.hotelHomeAfterLogin;

import javax.swing.plaf.*;
import com.sharan.DataBaseController;
import com.sharan.ui.home.homePageAfterLogin.HomePageAfterLogin;
import com.sharan.ui.hotelView.displaySelectedHotelsMultipleView.DisplaySelectedHotelsMultipleView;
import com.sharan.ui.hotelView.fillOutFields.FillOutFieldsToViewHotelIndividual;
import com.sharan.ui.hotelView.hotelHome.HotelHomeBeforeLogin;
import com.sharan.ui.hotelView.rating.Rating;
import com.sharan.ui.hotelView.roomBooking.roomBookingAll.RoomBooking;
import com.sharan.ui.hotelView.roomBooking.roomBookingTwo.RoomBookingTwo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import static com.sharan.Main.*;

/**
 * @author vamsi adapa
 */
public class HotelHomeAfterLogin {

    private String uniqueId;
    private DataBaseController dataBaseController;
    private double rate;
    private String starRatingPath;


    private String hotelName;
    private String description;
    private String address;
    private String hotelMainImagePath;
    private String numberOfVotes;
    private ArrayList<String> list;
    private String universalHotelSearch;
    private String checkIn;
    private String checkOut;
    private String userName;
    private String state;
    private String city;
    private String setHotel;

    public HotelHomeAfterLogin(ArrayList<String> list, DataBaseController dataBaseController) {

        this.list = list;

        for (String str : list) {
            System.out.println(str);
        }
        this.uniqueId = list.get(0);
        this.dataBaseController = dataBaseController;
        this.hotelName = list.get(1);
        this.description = list.get(2);
        this.address = list.get(3);
        this.hotelMainImagePath = list.get(4);
        this.numberOfVotes = list.get(5);
        this.checkIn = list.get(6);
        this.checkOut = list.get(7);
        this.userName = list.get(8);
        this.city = list.get(9);
        this.state = list.get(10);


        dataBaseController.initialiseDatabase();
        rate = dataBaseController.calculateRating(uniqueId);
        String rateString = String.valueOf(rate);
        starRatingPath = "/com/sharan/ui/pictures/stars/" + rateString + ".jpg";
        dataBaseController.closeDatabaseConnection();

        initComponents();
        userId.setText(userName);

        addToUniversalHotelSearch();

        hotelPhoto.setIcon(new ImageIcon(getClass().getResource(hotelMainImagePath)));
        ratingLabel.setIcon(new ImageIcon(getClass().getResource(starRatingPath)));
        contactDetails.setText(address);
        hotelDetails.setText(description);
        Title.setText(hotelName);
        numberOfRatings.setText(numberOfVotes + " people rated this");
        starUpdate=1;
        setHotel=dataBaseController.getSelectedQuickSearch(uniqueId);


        individualHotelHome.setVisible(true);
        individualHotelHome.setIconImage(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/hotel.png")).getImage());


    }

    private void addToUniversalHotelSearch() {
        dataBaseController.initialiseDatabase();
        ArrayList<String> list = dataBaseController.getUniversalSearchData();
        dataBaseController.closeDatabaseConnection();
        Hotels.addItem("Select a Hotel");
        for (String str : list) {
            Hotels.addItem(str);
        }
    }

    private void backButtonActionPerformed(ActionEvent e) {
        ArrayList<String> displayList = new ArrayList<>();
        displayList.add(userName);
        displayList.add(state);
        displayList.add(city);
        displayList.add(checkIn);
        displayList.add(checkOut);
        if (viewToindividual == 1) {
            individualHotelHome.dispose();
            DisplaySelectedHotelsMultipleView displaySelectedHotels = new DisplaySelectedHotelsMultipleView(displayList, dataBaseController);
            viewToindividual = 0;
        } else {
            individualHotelHome.dispose();
            HomePageAfterLogin HomeAfterLogin = new HomePageAfterLogin(userName, dataBaseController);
        }
    }


    private void HotelsItemStateChanged(ItemEvent e) {
        universalHotelSearch = e.getItem().toString();
    }


    //********ButtonFields****************************************
    private void LogoutFieldActionPerformed(ActionEvent e) {
        loginSuccess =0;
        dataBaseController.initialiseDatabase();
        individualHotelHome.dispose();
        HotelHomeBeforeLogin hotelHomeBeforeLogin=new HotelHomeBeforeLogin(uniqueId,dataBaseController);
        dataBaseController.closeDatabaseConnection();
    }

    private void rateYourExperienceActionPerformed(ActionEvent e) {

        dataBaseController.initialiseDatabase();
        if(starUpdate==1) {
            Rating rating = new Rating(uniqueId,userName, dataBaseController, rateYourExperience);
            starUpdate=0;
        }
        rate = dataBaseController.calculateRating(uniqueId);
        ArrayList<String> latest=dataBaseController.parseHotel(uniqueId);
        numberOfVotes=latest.get(5);
        String rateString = String.valueOf(rate);
        starRatingPath = "/com/sharan/ui/pictures/stars/" + rateString + ".jpg";
        ratingLabel.setIcon(new ImageIcon(getClass().getResource(starRatingPath)));
        numberOfRatings.setText(numberOfVotes + " people rated this");
        System.out.println(rate);
        System.out.println(starRatingPath);
        dataBaseController.closeDatabaseConnection();
    }

    private void checkAvailabilityActionPerformed(ActionEvent e) {
        ArrayList<String> list = new ArrayList<>();
        dataBaseController.initialiseDatabase();
        ArrayList<String> wholeData = dataBaseController.getWholeData(uniqueId);
        list.add(hotelName);
        list.add(wholeData.get(3));
        list.add(wholeData.get(6));
        list.add(wholeData.get(9));
        list.add(uniqueId);
        list.add(checkIn);
        list.add(checkOut);
        list.add(wholeData.get(4));
        list.add(wholeData.get(7));
        list.add(wholeData.get(10));
        list.add(userName);
        ArrayList<String> imageList = dataBaseController.getIndividualHotelImages(uniqueId);
        dataBaseController.closeDatabaseConnection();

        if ((imageList.get(0).equalsIgnoreCase("NA")) || (imageList.get(1).equalsIgnoreCase("NA")) || (imageList.get(2).equalsIgnoreCase("NA"))) {
            RoomBookingTwo roomBookingTwo = new RoomBookingTwo(list, dataBaseController);

        } else {
            RoomBooking roomBooking = new RoomBooking(list, dataBaseController);
        }
    }


    private void SearchActionPerformed(ActionEvent e) {
        if ((!universalHotelSearch.isEmpty()) && (!universalHotelSearch.equalsIgnoreCase("Select a Hotel"))) {
            String temp[] = universalHotelSearch.split(",");
            dataBaseController.initialiseDatabase();
            String uniqueId = dataBaseController.setUniversalSearchData(temp);
            dataBaseController.closeDatabaseConnection();
            FillOutFieldsToViewHotelIndividual fillOutFieldsToViewHotel=new FillOutFieldsToViewHotelIndividual(userName,uniqueId,universalHotelSearch,Search,dataBaseController);
        } else {
            JOptionPane.showMessageDialog(null, "Please Select a Hotel First");
        }
    }


//********ButtonFields****************************************

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        individualHotelHome = new JFrame();
        menuBar = new JMenuBar();
        backButton = new JMenuItem();
        separator1 = new JSeparator();
        Hotels = new JComboBox();
        Search = new JButton();
        menu2 = new JMenu();
        myAccountField = new JMenuItem();
        LogoutField = new JMenuItem();
        userId = new JLabel();
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

        //======== individualHotelHome ========
        {
            individualHotelHome.setResizable(false);
            individualHotelHome.setMaximizedBounds(new Rectangle(0, 0, 1500, 1080));
            individualHotelHome.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container individualHotelHomeContentPane = individualHotelHome.getContentPane();

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
                separator1.setMaximumSize(new Dimension(400, 50));
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

                //======== menu2 ========
                {
                    menu2.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                    //---- myAccountField ----
                    myAccountField.setText("My Account");
                    myAccountField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    menu2.add(myAccountField);

                    //---- LogoutField ----
                    LogoutField.setText("Log Out");
                    LogoutField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    LogoutField.addActionListener(e -> LogoutFieldActionPerformed(e));
                    menu2.add(LogoutField);
                }
                menuBar.add(menu2);

                //---- userId ----
                userId.setMaximumSize(new Dimension(150, 32767));
                userId.setText("userName");
                userId.setFont(new Font("Arial", Font.BOLD, 16));
                userId.setHorizontalAlignment(SwingConstants.CENTER);
                userId.setForeground(Color.white);
                menuBar.add(userId);
            }
            individualHotelHome.setJMenuBar(menuBar);

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
                scrollPane2.setViewportView(contactDetails);
            }

            GroupLayout individualHotelHomeContentPaneLayout = new GroupLayout(individualHotelHomeContentPane);
            individualHotelHomeContentPane.setLayout(individualHotelHomeContentPaneLayout);
            individualHotelHomeContentPaneLayout.setHorizontalGroup(
                individualHotelHomeContentPaneLayout.createParallelGroup()
                    .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(individualHotelHomeContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                                .addGroup(individualHotelHomeContentPaneLayout.createParallelGroup()
                                    .addComponent(Title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 1021, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 259, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                                .addGroup(individualHotelHomeContentPaneLayout.createParallelGroup()
                                    .addComponent(hotelPhoto, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleContactDetails, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(individualHotelHomeContentPaneLayout.createParallelGroup()
                                    .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                                        .addGroup(individualHotelHomeContentPaneLayout.createParallelGroup()
                                            .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                                                .addGroup(individualHotelHomeContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ratingLabel, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(numberOfRatings, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                                                .addComponent(checkAvailability, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(HotelDetails))
                                        .addGap(10, 10, 10))
                                    .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                                        .addComponent(rateYourExperience, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(504, Short.MAX_VALUE))))))
            );
            individualHotelHomeContentPaneLayout.setVerticalGroup(
                individualHotelHomeContentPaneLayout.createParallelGroup()
                    .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                        .addComponent(Title, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(individualHotelHomeContentPaneLayout.createParallelGroup()
                            .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                                .addComponent(hotelPhoto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleContactDetails, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                                .addComponent(HotelDetails, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(individualHotelHomeContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(individualHotelHomeContentPaneLayout.createSequentialGroup()
                                        .addComponent(rateYourExperience)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(numberOfRatings, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ratingLabel))
                                    .addComponent(checkAvailability, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)))
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
            );
            individualHotelHome.pack();
            individualHotelHome.setLocationRelativeTo(individualHotelHome.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame individualHotelHome;
    private JMenuBar menuBar;
    private JMenuItem backButton;
    private JSeparator separator1;
    private JComboBox Hotels;
    private JButton Search;
    private JMenu menu2;
    private JMenuItem myAccountField;
    private JMenuItem LogoutField;
    private JLabel userId;
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
