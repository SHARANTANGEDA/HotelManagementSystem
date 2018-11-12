/*
 * Created by JFormDesigner on Sat Nov 03 21:40:23 IST 2018
 */

package com.sharan.ui.hotelView.displaySelectedHotelsMultipleView;

import com.sharan.DataBaseController;
import com.sharan.ui.home.homePage.HomePage;
import com.sharan.ui.home.homePageAfterLogin.HomePageAfterLogin;
import com.sharan.ui.home.homePageAfterLogin.fillOutFields.FillOutFieldsToViewHotel;
import com.sharan.ui.hotelView.hotelHomeAfterLogin.HotelHomeAfterLogin;
import com.sharan.ui.hotelView.roomBooking.roomBookingAll.RoomBooking;
import com.sharan.ui.hotelView.roomBooking.roomBookingTwo.RoomBookingTwo;
import com.sharan.ui.myAccount.MyAccount;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import static com.sharan.Main.viewToindividual;

/**
 * @author SAI SHARAN
 */
public class DisplaySelectedHotelsMultipleView {

    private String state;
    private String city;
    private String checkIN;
    private String checkOUT;
    private String userName;


    private DataBaseController dataBaseController;
    private String universalHotelSearch;
    private ArrayList<String> list;
    private ArrayList<ElementsInHotelView> displayList;
    private String rating;

    private ArrayList<JPanel> hotelPanel = new ArrayList<>();

    private ArrayList<JLabel> hotelPhoto = new ArrayList<>();
    private ArrayList<JLabel> hotelNameTitle = new ArrayList<>();
    private ArrayList<JLabel> priceStandard = new ArrayList<>();
    private ArrayList<JLabel> priceDeluxe = new ArrayList<>();
    private ArrayList<JLabel> priceSuite = new ArrayList<>();
    private ArrayList<JLabel> ratingBracket = new ArrayList<>();

    private ArrayList<JTextPane> description = new ArrayList<>();
    private ArrayList<JScrollPane> descriptionScrollPane = new ArrayList<>();

    private ArrayList<JLabel> hotelRatingStar = new ArrayList<>();
    private ArrayList<JButton> bookNow = new ArrayList<>();
    private ArrayList<JButton> viewHotel = new ArrayList<>();
    private ArrayList<JLabel> standardRoomNumber = new ArrayList<>();
    private ArrayList<JLabel> deluxeRoomNumber = new ArrayList<>();
    private ArrayList<JLabel> suiteRoomNumber = new ArrayList<>();
    private ArrayList<JLabel> label9=new ArrayList<>();
    private ArrayList<JLabel> label10=new ArrayList<>();
    private ArrayList<JLabel> label11=new ArrayList<>();
    private ArrayList<JLabel> label50=new ArrayList<>();
    private ArrayList<JLabel> label=new ArrayList<>();
    private ArrayList<JLabel> label60=new ArrayList<>();


    private JFrame displayTable;
    private JLabel label1;
    private JMenuBar menuBar1;
    private JMenuItem backButton;
    private JSeparator separator2;
    private JComboBox Hotels;
    private JButton Search;
    private JSeparator separator1;
    private JMenu profile;
    private JMenuItem myAccount;
    private JMenuItem Logout;
    private JSeparator separator3;
    private JScrollPane scrollPane1;
    private JPanel homePanel;



    public DisplaySelectedHotelsMultipleView(ArrayList<String> list, DataBaseController dataBaseController) {

        this.userName = list.get(0);
        this.state = list.get(1);
        this.city = list.get(2);
        this.checkIN = list.get(3);
        this.checkOUT = list.get(4);
        this.dataBaseController = dataBaseController;
        System.out.println("check-1");
        dataBaseController.initialiseDatabase();
        ArrayList<ElementsInHotelView> displayList = dataBaseController.getHotelsBasedOnAllotmentDetails(list);
        dataBaseController.closeDatabaseConnection();

        this.displayList = displayList;
        System.out.println(displayList.size());

        initComponents();
        addToUniversalHotelSearch();





        for (int i = 0; i < displayList.size(); i++) {
            ElementsInHotelView elements = displayList.get(i);
            hotelPhoto.get(i).setIcon(new ImageIcon(getClass().getResource(elements.getImagePath())));
            hotelNameTitle.get(i).setText(elements.getHotelName());
            System.out.println("check-2");

            dataBaseController.initialiseDatabase();
            String databaseRate = String.valueOf(dataBaseController.calculateRating(elements.getUniqueId()));
            rating = "/com/sharan/ui/pictures/stars/" + databaseRate + ".jpg";
            dataBaseController.closeDatabaseConnection();


            priceStandard.get(i).setText("Rs." + elements.getStandardRoomPrice());
            priceDeluxe.get(i).setText("Rs." + elements.getDeluxeRoomPrice());
            priceSuite.get(i).setText("Rs." + elements.getSuiteRoomPrice());

            standardRoomNumber.get(i).setText(String.valueOf(elements.getStandardRoomCapacity()));
            deluxeRoomNumber.get(i).setText(String.valueOf(elements.getDeluxeRoomCapacity()));
            suiteRoomNumber.get(i).setText(String.valueOf(elements.getSuiteRoomCapacity()));

            description.get(i).setText(elements.getHotelDescription());

            hotelRatingStar.get(i).setIcon(new ImageIcon(getClass().getResource(rating)));
            hotelRatingStar.get(i).setText("Rating(" + String.valueOf(elements.getNumberOfVotes()) + ")");
        }


        displayTable.setExtendedState(JFrame.MAXIMIZED_BOTH);
        displayTable.setVisible(true);
        displayTable.setIconImage(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/hotel.png")).getImage());
        displayTable.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        AutoCompleteDecorator.decorate(Hotels);


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


    private void myAccountActionPerformed(ActionEvent e) {
        displayTable.dispose();
        MyAccount myAccount = new MyAccount(userName, dataBaseController);
    }

    private void LogoutActionPerformed(ActionEvent e) {
        displayTable.dispose();
        HomePage page = new HomePage(dataBaseController);
    }

    private void backButtonActionPerformed(ActionEvent e) {
        displayTable.dispose();
        HomePageAfterLogin homePageAfterLogin = new HomePageAfterLogin(userName, dataBaseController);
    }


    private void HotelsItemStateChanged(ItemEvent e) {
        universalHotelSearch = e.getItem().toString();
    }


    private void SearchActionPerformed(ActionEvent e) {
        if ((!universalHotelSearch.isEmpty()) && (!universalHotelSearch.equalsIgnoreCase("Select a Hotel"))) {
            String temp[] = universalHotelSearch.split(",");
            dataBaseController.initialiseDatabase();
            String uniqueId = dataBaseController.setUniversalSearchData(temp);
            dataBaseController.closeDatabaseConnection();
            FillOutFieldsToViewHotel fillOutFieldsToViewHotel=new FillOutFieldsToViewHotel(userName,uniqueId,universalHotelSearch,Search,dataBaseController);
        } else {
            JOptionPane.showMessageDialog(null, "Please Select a Hotel First");
        }
    }

    private void viewHotelActionPerformed(ActionEvent e,int i) {
        list = new ArrayList<>();
        list.add(displayList.get(i).getUniqueId());
        list.add(displayList.get(i).getHotelName());
        list.add(displayList.get(i).getHotelDescription());
        list.add(displayList.get(i).getAddress());
        list.add(displayList.get(i).getImagePath());
        list.add(String.valueOf(displayList.get(0).getNumberOfVotes()));
        list.add(checkIN);
        list.add(checkOUT);
        list.add(userName);
        list.add(city);
        list.add(state);
        viewToindividual = 1;
        displayTable.dispose();
        HotelHomeAfterLogin hotelHomeAfterLogin = new HotelHomeAfterLogin(list, dataBaseController);
    }



    private void bookNowActionPerformed(ActionEvent e,int i) {

        ElementsInHotelView elements = displayList.get(i);
        ArrayList<String> list = new ArrayList<>();
        list.add(elements.getHotelName());
        list.add(elements.getStandardRoomPrice());
        list.add(elements.getDeluxeRoomPrice());
        list.add(elements.getSuiteRoomPrice());
        list.add(elements.getUniqueId());
        list.add(checkIN);
        list.add(checkOUT);
        list.add(String.valueOf(elements.getStandardRoomCapacity()));
        list.add(String.valueOf(elements.getDeluxeRoomCapacity()));
        list.add(String.valueOf(elements.getSuiteRoomCapacity()));
        list.add(userName);

        dataBaseController.initialiseDatabase();
        ArrayList<String> imageList = dataBaseController.getIndividualHotelImages(elements.getUniqueId());
        dataBaseController.closeDatabaseConnection();

        if ((imageList.get(0).equalsIgnoreCase("NA")) || (imageList.get(1).equalsIgnoreCase("NA")) || (imageList.get(2).equalsIgnoreCase("NA"))) {
            RoomBookingTwo roomBookingTwo = new RoomBookingTwo(list, dataBaseController);

        } else {
            RoomBooking roomBooking = new RoomBooking(list, dataBaseController);
        }

    }


    private void initComponents() {
        for (int i = 0; i < displayList.size(); i++) {
            descriptionScrollPane.add(i, new JScrollPane());
            hotelPanel.add(i, new JPanel());
            hotelPhoto.add(i, new JLabel());
            hotelNameTitle.add(i, new JLabel());
            priceStandard.add(i, new JLabel());
            priceDeluxe.add(i, new JLabel());
            priceSuite.add(i, new JLabel());
            hotelRatingStar.add(i, new JLabel());
            ratingBracket.add(i, new JLabel());
            description.add(i, new JTextPane());
            hotelRatingStar.add(i, new JLabel());
            bookNow.add(i, new JButton());
            viewHotel.add(i, new JButton());
            standardRoomNumber.add(i, new JLabel());
            deluxeRoomNumber.add(i, new JLabel());
            suiteRoomNumber.add(i, new JLabel());
            label.add(i, new JLabel());
            label9.add(i, new JLabel());
            label10.add(i, new JLabel());
            label11.add(i, new JLabel());
            label50.add(i, new JLabel());
            label60.add(i, new JLabel());
        }

        displayTable = new JFrame();



        label1 = new JLabel();
        menuBar1 = new JMenuBar();
        backButton = new JMenuItem();
        separator2 = new JSeparator();
        Hotels = new JComboBox();
        Search = new JButton();
        separator1 = new JSeparator();
        profile = new JMenu();
        myAccount = new JMenuItem();
        Logout = new JMenuItem();
        separator3 = new JSeparator();
        scrollPane1 = new JScrollPane();
        homePanel = new JPanel();





        //======== displayTable ========
        {
            Container displayTableContentPane = displayTable.getContentPane();

            //---- label1 ----
            label1.setText("Hotels For Selected Choice");
            label1.setBackground(new Color(255, 204, 0));
            label1.setOpaque(true);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Dialog", Font.BOLD, 38));

            //======== menuBar1 ========
            {
                menuBar1.setBackground(Color.darkGray);

                //---- backButton ----
                backButton.setBackground(Color.darkGray);
                backButton.setPreferredSize(new Dimension(50, 13));
                backButton.setMaximumSize(new Dimension(50, 32767));
                backButton.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/Back24.gif")));
                backButton.addActionListener(e -> backButtonActionPerformed(e));
                menuBar1.add(backButton);

                //---- separator2 ----
                separator2.setMaximumSize(new Dimension(1000, 50));
                separator2.setBackground(Color.darkGray);
                menuBar1.add(separator2);

                //---- Hotels ----
                Hotels.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
                Hotels.setToolTipText("Search for Hotels");
                Hotels.setMaximumSize(new Dimension(500, 50));
                Hotels.setMinimumSize(new Dimension(250, 35));
                Hotels.setFocusable(false);
                Hotels.setLightWeightPopupEnabled(false);
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

                //---- separator1 ----
                separator1.setMaximumSize(new Dimension(20, 50));
                separator1.setBackground(Color.darkGray);
                menuBar1.add(separator1);

                //======== profile ========
                {
                    profile.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                    //---- myAccount ----
                    myAccount.setText("My Account");
                    myAccount.setFont(new Font("Arial", Font.PLAIN, 18));
                    myAccount.addActionListener(e -> myAccountActionPerformed(e));
                    profile.add(myAccount);

                    //---- Logout ----
                    Logout.setText("Logout");
                    Logout.setFont(new Font("Arial", Font.PLAIN, 18));
                    Logout.addActionListener(e -> LogoutActionPerformed(e));
                    profile.add(Logout);
                }
                menuBar1.add(profile);

                //---- separator3 ----
                separator3.setMaximumSize(new Dimension(150, 32767));
                menuBar1.add(separator3);
            }

            //======== scrollPane1 ========
            {
                scrollPane1.setAutoscrolls(true);

                //======== homePanel ========
                {
                    homePanel.setForeground(Color.darkGray);



                    for (int i = 0; i < displayList.size(); i++) {

                        //======== hotelPanel ========
                        hotelPanel.get(i).setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                        hotelPanel.get(i).setForeground(new Color(238, 238, 238));

                        //---- hotelPhoto ----
                        hotelPhoto.get(i).setHorizontalAlignment(SwingConstants.CENTER);
                        hotelPhoto.get(i).setBorder(LineBorder.createBlackLineBorder());
                        hotelPhoto.get(i).setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePic.png")));

                        //---- hotelName1 ----
                        hotelNameTitle.get(i).setText("Mint karegoan park");
                        hotelNameTitle.get(i).setFont(new Font("Roboto", Font.BOLD, 36));
                        hotelNameTitle.get(i).setOpaque(true);
                        hotelNameTitle.get(i).setForeground(Color.black);
                        hotelNameTitle.get(i).setHorizontalAlignment(SwingConstants.CENTER);

                        //---- label9 ----
                        label9.get(i).setText("standard");
                        label9.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label10 ----
                        label10.get(i).setText("deluxe");
                        label10.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label11 ----
                        label11.get(i).setText("suite");
                        label11.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceStandard ----
                        priceStandard.get(i).setText("text");
                        priceStandard.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceDeluxe ----
                        priceDeluxe.get(i).setText("text");
                        priceDeluxe.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceSuite ----
                        priceSuite.get(i).setText("text");
                        priceSuite.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- hotelRating ----
                        hotelRatingStar.get(i).setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                        //---- ratingBracket ----
                        ratingBracket.get(i).setText("Rating");
                        ratingBracket.get(i).setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 22));

                        //======== scrollPane ========
                        {

                            //---- description1 ----
                            description.get(i).setBackground(new Color(238, 238, 238));
                            description.get(i).setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
                            descriptionScrollPane.get(i).setViewportView(description.get(i));
                        }

                        int iteration = i;

                        //---- bookNow1 ----
                        bookNow.get(i).setText("Book Now");
                        bookNow.get(i).setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        bookNow.get(i).setBackground(new Color(153, 0, 0));
                        bookNow.get(i).setForeground(new Color(238, 238, 238));
                        bookNow.get(i).addActionListener(e -> bookNowActionPerformed(e, iteration));

                        //---- viewHotel1 ----
                        viewHotel.get(i).setText("View Hotel");
                        viewHotel.get(i).setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        viewHotel.get(i).setBackground(new Color(153, 0, 0));
                        viewHotel.get(i).setForeground(new Color(238, 238, 238));
                        viewHotel.get(i).addActionListener(e -> viewHotelActionPerformed(e, iteration));

                        //---- label50 ----
                        label50.get(i).setText("Room Price");
                        label50.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

                        //---- label ----
                        label.get(i).setText("Types");
                        label.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label60 ----
                        label60.get(i).setText("Number of Rooms");
                        label60.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

                        //---- standardRooms1 ----
                        standardRoomNumber.get(i).setText("text");
                        standardRoomNumber.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- deluxeRooms ----
                        deluxeRoomNumber.get(i).setText("text");
                        deluxeRoomNumber.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- suiteRooms ----
                        suiteRoomNumber.get(i).setText("text");
                        suiteRoomNumber.get(i).setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        GroupLayout hotelPanelLayout = new GroupLayout(hotelPanel.get(i));
                        hotelPanel.get(i).setLayout(hotelPanelLayout);
                        hotelPanelLayout.setHorizontalGroup(
                                hotelPanelLayout.createParallelGroup()
                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(hotelPhoto.get(i), GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(hotelPanelLayout.createParallelGroup()
                                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                                .addGroup(hotelPanelLayout.createParallelGroup()
                                                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                                                .addGroup(hotelPanelLayout.createParallelGroup()
                                                                                        .addComponent(label9.get(i), GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(label10.get(i), GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(label11.get(i), GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(hotelPanelLayout.createParallelGroup()
                                                                                        .addComponent(priceDeluxe.get(i))
                                                                                        .addComponent(priceStandard.get(i))
                                                                                        .addComponent(priceSuite.get(i)))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(hotelPanelLayout.createParallelGroup()
                                                                                        .addComponent(standardRoomNumber.get(i))
                                                                                        .addComponent(deluxeRoomNumber.get(i))
                                                                                        .addComponent(suiteRoomNumber.get(i)))
                                                                                .addGap(121, 121, 121))
                                                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                                                .addComponent(ratingBracket.get(i), GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                                                .addComponent(hotelRatingStar.get(i), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGap(258, 258, 258)))
                                                                .addGroup(hotelPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(viewHotel.get(i), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(bookNow.get(i), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(27, 27, 27))
                                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                                .addComponent(label.get(i), GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(label50.get(i), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(label60.get(i))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addComponent(descriptionScrollPane.get(i), GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))
                                        .addComponent(hotelNameTitle.get(i), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanelLayout.setVerticalGroup(
                                hotelPanelLayout.createParallelGroup()
                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                .addContainerGap(12, Short.MAX_VALUE)
                                                .addComponent(hotelNameTitle.get(i))
                                                .addGroup(hotelPanelLayout.createParallelGroup()
                                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                                                .addGroup(hotelPanelLayout.createParallelGroup()
                                                                        .addComponent(hotelPhoto.get(i), GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                                                .addGroup(hotelPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(label.get(i))
                                                                                        .addComponent(label50.get(i))
                                                                                        .addComponent(label60.get(i)))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(hotelPanelLayout.createParallelGroup()
                                                                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanelLayout.createSequentialGroup()
                                                                                                .addGroup(hotelPanelLayout.createParallelGroup()
                                                                                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                                                                                .addComponent(label9.get(i))
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(label10.get(i))
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(label11.get(i)))
                                                                                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                                                                                .addComponent(standardRoomNumber.get(i))
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(deluxeRoomNumber.get(i))
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(suiteRoomNumber.get(i)))
                                                                                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                                                                                .addComponent(priceStandard.get(i))
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(priceDeluxe.get(i))
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(priceSuite.get(i))))
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(ratingBracket.get(i), GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(78, 78, 78))
                                                                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanelLayout.createSequentialGroup()
                                                                                                .addComponent(viewHotel.get(i), GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(bookNow.get(i), GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(29, 29, 29))))))
                                                        .addGroup(hotelPanelLayout.createSequentialGroup()
                                                                .addComponent(descriptionScrollPane.get(i), GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)

                                                                .addContainerGap())))
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanelLayout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(hotelRatingStar.get(i), GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                        );

                    }




                    GroupLayout homePanelLayout = new GroupLayout(homePanel);
                    homePanel.setLayout(homePanelLayout);


                    GroupLayout.ParallelGroup parallelGroup=homePanelLayout.createParallelGroup();
                    for (int i=0;i<displayList.size();i++) {
                        parallelGroup.addComponent(hotelPanel.get(i), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);

                    }

                    GroupLayout.SequentialGroup sequentialGroup=homePanelLayout.createSequentialGroup();
                    sequentialGroup.addContainerGap();
                    for(int i=0;i<displayList.size();i++) {
                        sequentialGroup.addComponent(hotelPanel.get(i), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                        if(i!=3) {
                            sequentialGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
                        }
                    }
                    sequentialGroup.addContainerGap(82, Short.MAX_VALUE);

                    homePanelLayout.setHorizontalGroup(
                            homePanelLayout.createParallelGroup()
                                    .addGroup(homePanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(parallelGroup)
                                            .addContainerGap())
                    );
                    homePanelLayout.setVerticalGroup(
                            homePanelLayout.createParallelGroup()
                                    .addGroup(sequentialGroup)
                    );



                }
                scrollPane1.setViewportView(homePanel);

                GroupLayout displayTableContentPaneLayout = new GroupLayout(displayTableContentPane);
                displayTableContentPane.setLayout(displayTableContentPaneLayout);
                displayTableContentPaneLayout.setHorizontalGroup(
                        displayTableContentPaneLayout.createParallelGroup()
                                .addGroup(displayTableContentPaneLayout.createSequentialGroup()
                                        .addGroup(displayTableContentPaneLayout.createParallelGroup()
                                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(menuBar1, GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE))
                                        .addContainerGap())
                                .addGroup(displayTableContentPaneLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1421, Short.MAX_VALUE)
                                        .addGap(15, 15, 15))
                );
                displayTableContentPaneLayout.setVerticalGroup(
                        displayTableContentPaneLayout.createParallelGroup()
                                .addGroup(displayTableContentPaneLayout.createSequentialGroup()
                                        .addComponent(label1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
                                        .addGap(27, 27, 27))
                );
                displayTable.pack();
                displayTable.setLocationRelativeTo(displayTable.getOwner());

            }
        }

    }


















}
