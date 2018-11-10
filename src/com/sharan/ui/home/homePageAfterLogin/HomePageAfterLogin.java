/*
 * Created by JFormDesigner on Tue Oct 30 12:03:37 IST 2018
 */

package com.sharan.ui.home.homePageAfterLogin;

import com.sharan.DataBaseController;
import com.sharan.ui.home.homePage.HomePage;
import com.sharan.ui.home.homePageAfterLogin.fillOutFields.FillOutFieldsToViewHotel;
import com.sharan.ui.hotelView.displaySelectedHotelsMultipleView.DisplaySelectedHotelsMultipleView;
import com.sharan.ui.myAccount.MyAccount;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static com.sharan.Main.checkInCheckOutCheck;

/**
 * @author SAI SHARAN
 */
public class HomePageAfterLogin {

    private String stateSelected;
    private String citySelected;
    private String checkInDate;
    private String checkOutDate;
    private String roomsSelected;

    private String userName;
    private ArrayList<String> list;
    private String universalHotelSearch;

    private DataBaseController dataBaseController;

    public HomePageAfterLogin(String userName,DataBaseController dataBaseController) {
        this.dataBaseController=dataBaseController;



        initComponents();

        addtoStateComboBox(StateField);
        addToUniversalHotelSearch();



        this.userName=userName;



        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        checkInField.setFormats(dateFormat);
        checkOutField.setFormats(dateFormat);

        AutoCompleteDecorator.decorate(StateField);
        AutoCompleteDecorator.decorate(CityField);
        AutoCompleteDecorator.decorate(Hotels);
        homePageAfterLogin.setVisible(true);
        checkInCheckOutCheck=0;

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

    private void SearchActionPerformed(ActionEvent e) {
        if((!universalHotelSearch.isEmpty()) && (!universalHotelSearch.equalsIgnoreCase("Select a Hotel"))) {

            String temp[]=universalHotelSearch.split(",");
            dataBaseController.initialiseDatabase();
            System.out.println(temp[0]+"/"+temp[1]+"/"+temp[2]);
            String uniqueId=dataBaseController.setUniversalSearchData(temp);
            dataBaseController.closeDatabaseConnection();
//            if(login.returnLoginStatus()==1) {
//                loginSuccess=0;
//                homeFrame.dispose();
//                HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(userName,dataBaseController);
//                login.getLogin().dispose();
//
//            }
//
            if(checkInCheckOutCheck==0) {
                FillOutFieldsToViewHotel fillOutFieldsToViewHotel = new FillOutFieldsToViewHotel(userName, uniqueId, universalHotelSearch, Search, dataBaseController);
            }else {
                checkInCheckOutCheck=0;
                homePageAfterLogin.dispose();
            }




        }
        else {
            JOptionPane.showMessageDialog(null,"Please Select a Hotel First");
        }
    }


    private void HotelsItemStateChanged(ItemEvent e) {
        universalHotelSearch=e.getItem().toString();
    }

    private void addtoStateComboBox(JComboBox<String> stateField) {
        stateField.addItem("Telangana");
        stateField.addItem("AndhraPradesh");
        stateField.addItem("Maharashtra");
        stateField.addItem("NewDelhi");
    }

    //**@HARD CODED**//
    private void addtoCityComboBox(JComboBox<String> cityField) {
        if(stateSelected.equalsIgnoreCase("Telangana")) {
            cityField.removeAllItems();
            cityField.addItem("Hyderabad");
            cityField.addItem("Warangal");
            cityField.addItem("KarimNagar");
            cityField.addItem("Kammam");
        }
        else if(stateSelected.equalsIgnoreCase("AndhraPradesh")) {
            cityField.removeAllItems();
            cityField.addItem("Tirupati");
            cityField.addItem("Vijayawada");
            cityField.addItem("Vishakapatnam");
            cityField.addItem("Guntur");
        }
        else if (stateSelected.equalsIgnoreCase("Maharashtra")) {
            cityField.removeAllItems();
            cityField.addItem("Aurangabad");
            cityField.addItem("Mumbai");
            cityField.addItem("Nagpur");
            cityField.addItem("Pune");
        }
        else if(stateSelected.equalsIgnoreCase("NewDelhi")) {
            cityField.removeAllItems();
            cityField.addItem("Panipat");
            cityField.addItem("NewDelhi");
            cityField.addItem("Gurgaon");
            cityField.addItem("Faridabad");
        }
        else if (stateSelected.equalsIgnoreCase("")) {
            cityField.removeAllItems();
            cityField.addItem("Select State First");
        }
    }

    private String getDate(JXDatePicker checkField) {

       java.util.Date unparsedDate=checkField.getDate();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(unparsedDate);

        return formattedDate;
    }



    private void LogoutActionPerformed(ActionEvent e) {
        homePageAfterLogin.dispose();
        homePageAfterLogin.setVisible(false);
        HomePage homePage=new HomePage(dataBaseController);

    }


    private void SearchBottomActionPerformed(ActionEvent e) {

        checkInDate=getDate(checkInField);
        checkOutDate=getDate(checkOutField);
//        try {
//            noOfRooms.commitEdit();
//        } catch ( java.text.ParseException exception ) {
//            System.out.println(exception.getMessage());
//        }
//        int value = (Integer) noOfRooms.getValue();
//        roomsSelected=String.valueOf(value);
        java.util.Date current=null;
        java.util.Date checkin=null;
        java.util.Date checkout=null;

        java.util.Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c);


        try {
            current =  df.parse(formattedDate);
        } catch (ParseException p) {

            p.printStackTrace();
        }
        try {
            checkin =  df.parse(checkInDate);
        } catch (ParseException p) {
            p.printStackTrace();
        }
        try {
            checkout =  df.parse(checkOutDate);
        } catch (ParseException p) {
            p.printStackTrace();
        }
        long duration = checkin.getTime()-current.getTime();
        long diffInDaysForCheckIn = TimeUnit.MILLISECONDS.toDays(duration);
        long duration1 = checkout.getTime()-current.getTime();
        long diffInDaysForCheckOut = TimeUnit.MILLISECONDS.toDays(duration1);
        if(diffInDaysForCheckIn<=0)
        {
            JOptionPane.showMessageDialog(null,"Please Enter Valid CheckIn Date");
        }
        else if(diffInDaysForCheckOut<=0)
        {
            JOptionPane.showMessageDialog(null,"Please Enter Valid CheckOut Date");
        }
        else if(diffInDaysForCheckIn>=diffInDaysForCheckOut)
        {
            JOptionPane.showMessageDialog(null,"Please Enter Valid CheckIn and CheckOut Dates");
        }
        else if(diffInDaysForCheckIn>90||diffInDaysForCheckOut>90)
        {
            JOptionPane.showMessageDialog(null,"Sorry Bookings are not yet Opened!!!");
        }
        else {
            ArrayList<String> list = new ArrayList<>();
            list.add(userName);
            list.add(stateSelected);
            list.add(citySelected);
            list.add(checkInDate);
            list.add(checkOutDate);
//        list.add(roomsSelected);


            dataBaseController.initialiseDatabase();
            dataBaseController.addAllotmentDetailsToDatabase(userName, stateSelected, citySelected, checkInDate, checkOutDate, roomsSelected);
            dataBaseController.closeDatabaseConnection();

            homePageAfterLogin.dispose();
            DisplaySelectedHotelsMultipleView displaySelectedHotels = new DisplaySelectedHotelsMultipleView(list, dataBaseController);
        }

    }
    private void StateFieldItemStateChanged(ItemEvent e) {
        stateSelected=e.getItem().toString();
        addtoCityComboBox(CityField);

    }

    private void CityFieldItemStateChanged(ItemEvent e) {
        citySelected=e.getItem().toString();
    }


    private void myAccountActionPerformed(ActionEvent e) {
        homePageAfterLogin.dispose();
        MyAccount account=new MyAccount(userName,dataBaseController);
    }







    //*********************SEARCH FIELDS**********************************************



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        homePageAfterLogin = new JFrame();
        applicationName = new JLabel();
        menuBar1 = new JMenuBar();
        separator1 = new JSeparator();
        Hotels = new JComboBox();
        Search = new JButton();
        separator2 = new JSeparator();
        profile = new JMenu();
        myAccount = new JMenuItem();
        Logout = new JMenuItem();
        separator3 = new JSeparator();
        homePagePhoto = new JLabel();
        StateField = new JComboBox();
        CityField = new JComboBox();
        checkInField = new JXDatePicker();
        checkOutField = new JXDatePicker();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        SearchBottom = new JButton();

        //======== homePageAfterLogin ========
        {
            homePageAfterLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            homePageAfterLogin.setVisible(true);
            Container homePageAfterLoginContentPane = homePageAfterLogin.getContentPane();

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
                separator1.setMaximumSize(new Dimension(1100, 50));
                separator1.setBackground(Color.darkGray);
                menuBar1.add(separator1);

                //---- Hotels ----
                Hotels.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
                Hotels.setToolTipText("Search for Hotels");
                Hotels.setMaximumSize(new Dimension(500, 50));
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

                //---- separator2 ----
                separator2.setMaximumSize(new Dimension(50, 50));
                separator2.setBackground(Color.darkGray);
                menuBar1.add(separator2);

                //======== profile ========
                {
                    profile.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                    //---- myAccount ----
                    myAccount.setText("My Account");
                    myAccount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
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

            //---- homePagePhoto ----
            homePagePhoto.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/HomePagePic.jpg")));

            //---- StateField ----
            StateField.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            StateField.addItemListener(e -> StateFieldItemStateChanged(e));

            //---- CityField ----
            CityField.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            CityField.addItemListener(e -> CityFieldItemStateChanged(e));

            //---- checkInField ----
            checkInField.setFont(checkInField.getFont().deriveFont(checkInField.getFont().getSize() + 6f));
            checkInField.setToolTipText("CheckIN");
            checkInField.setInheritsPopupMenu(true);
            checkInField.setOpaque(true);

            //---- checkOutField ----
            checkOutField.setFont(checkOutField.getFont().deriveFont(checkOutField.getFont().getSize() + 6f));
            checkOutField.setToolTipText("CheckOut");

            //---- label1 ----
            label1.setText("Select the Check-In and Check-Out Dates to view selected Hotels:");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));

            //---- label2 ----
            label2.setText("From:");
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

            //---- label3 ----
            label3.setText("To:");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

            //---- label4 ----
            label4.setText("State:");
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 10f));

            //---- label5 ----
            label5.setText("City:");
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 10f));

            //---- SearchBottom ----
            SearchBottom.setText("Search Availability");
            SearchBottom.setBackground(new Color(204, 0, 0));
            SearchBottom.setFont(SearchBottom.getFont().deriveFont(SearchBottom.getFont().getSize() + 6f));
            SearchBottom.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/findSmall.png")));
            SearchBottom.setForeground(Color.white);
            SearchBottom.addActionListener(e -> SearchBottomActionPerformed(e));

            GroupLayout homePageAfterLoginContentPaneLayout = new GroupLayout(homePageAfterLoginContentPane);
            homePageAfterLoginContentPane.setLayout(homePageAfterLoginContentPaneLayout);
            homePageAfterLoginContentPaneLayout.setHorizontalGroup(
                homePageAfterLoginContentPaneLayout.createParallelGroup()
                    .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                        .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup()
                            .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addGap(18, 18, 18)
                                        .addComponent(StateField, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(label5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CityField, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(label2)
                                .addGap(26, 26, 26)
                                .addComponent(checkInField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkOutField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addComponent(SearchBottom, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208))
                    .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(applicationName, GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE)
                            .addComponent(menuBar1, GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE)
                            .addComponent(homePagePhoto, GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            homePageAfterLoginContentPaneLayout.setVerticalGroup(
                homePageAfterLoginContentPaneLayout.createParallelGroup()
                    .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                        .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                .addComponent(applicationName, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(homePagePhoto, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4)
                                    .addComponent(label5)
                                    .addComponent(StateField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CityField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(label1))
                            .addComponent(SearchBottom, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(checkOutField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkInField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2)))
                        .addContainerGap(107, Short.MAX_VALUE))
            );
            homePageAfterLogin.pack();
            homePageAfterLogin.setLocationRelativeTo(homePageAfterLogin.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame homePageAfterLogin;
    private JLabel applicationName;
    private JMenuBar menuBar1;
    private JSeparator separator1;
    private JComboBox Hotels;
    private JButton Search;
    private JSeparator separator2;
    private JMenu profile;
    private JMenuItem myAccount;
    private JMenuItem Logout;
    private JSeparator separator3;
    private JLabel homePagePhoto;
    private JComboBox StateField;
    private JComboBox CityField;
    private JXDatePicker checkInField;
    private JXDatePicker checkOutField;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton SearchBottom;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
