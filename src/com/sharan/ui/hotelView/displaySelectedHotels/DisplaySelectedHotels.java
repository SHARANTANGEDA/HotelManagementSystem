/*
 * Created by JFormDesigner on Sat Nov 03 21:40:23 IST 2018
 */

package com.sharan.ui.hotelView.displaySelectedHotels;

import java.awt.event.*;
import javax.swing.plaf.*;
import com.sharan.DataBaseController;
import com.sharan.ui.home.homePage.HomePage;
import com.sharan.ui.home.homePageAfterLogin.HomePageAfterLogin;
import com.sharan.ui.hotelView.displaySelectedHotelsMultipleView.ElementsInHotelView;
import com.sharan.ui.hotelView.hotelHomeAfterLogin.HotelHomeAfterLogin;
import com.sharan.ui.hotelView.roomBooking.roomBookingAll.RoomBooking;
import com.sharan.ui.hotelView.roomBooking.roomBookingTwo.RoomBookingTwo;
import com.sharan.ui.myAccount.MyAccount;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
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
public class DisplaySelectedHotels {

    private String state;
    private String city;
    private String checkIN;
    private String checkOUT;
//    private String noOfRooms;
    private String userName;

//    private String uniqueId[];
//    private String hotelNameString[];
//    private String hotelDescription[];
//    private String standardRoomPrice[];
//    private int standardRoomCapacity[];
//    private String deluxeRoomPrice[];
//    private int deluxeRoomCapacity[];
//    private String suiteRoomPrice[];
//    private int suiteRoomCapacity[];
//    private String imagePath[];
//    private String starRating[];
//    private int numberOfVotes[];

    private DataBaseController dataBaseController;
    private String universalHotelSearch;
    private ArrayList<String> list;
    private ArrayList<ElementsInHotelView> displayList;
    private String rating;

//    private ArrayList<JLabel> hotelPhoto;
//    private ArrayList<JLabel> hotelNameTitle;
//    private ArrayList<JLabel> priceStandard;
//    private ArrayList<JLabel> priceDeluxe;
//    private ArrayList<JLabel> priceSuite;
//    private ArrayList<JLabel> hotelRating;
//    private ArrayList<JLabel> ratingBracket;



    public DisplaySelectedHotels(ArrayList<String> list, DataBaseController dataBaseController) {

        this.userName=list.get(0);
        this.state=list.get(1);
//        System.out.println(state);
        this.city=list.get(2);
//        System.out.println(city);
        this.checkIN=list.get(3);
        this.checkOUT=list.get(4);
//        this.noOfRooms=list.get(5);
        this.dataBaseController=dataBaseController;
        System.out.println("check-1");

        initComponents();
        addToUniversalHotelSearch();
        dataBaseController.initialiseDatabase();
        ArrayList<ElementsInHotelView> displayList=dataBaseController.getHotelsBasedOnAllotmentDetails(list);
        dataBaseController.closeDatabaseConnection();
//
//        hotelPhoto.set(0,hotelPhoto1);
//        hotelPhoto.set(1,hotelPhoto2);
//        hotelPhoto.set(2,hotelPhoto3);
//        hotelPhoto.set(3,hotelPhoto4);
//
//        hotelNameTitle.set(0,hotelName1);
//        hotelNameTitle.set(1,hotelName2);
//        hotelNameTitle.set(2,hotelName3);
//        hotelNameTitle.set(3,hotelName4);
//
//        priceStandard.set(0,priceStandard1);
//        priceStandard.set(1,priceStandard2);
//        priceStandard.set(2,priceStandard3);
//        priceStandard.set(3,priceStandard4);
//
//        priceDeluxe.set(0,priceDeluxe1);
//
        this.displayList=displayList;

        {//hotel1************************************************************************************
            ElementsInHotelView elements = displayList.get(0);
            hotelPhoto1.setIcon(new ImageIcon(getClass().getResource(elements.getImagePath())));
            hotelName1.setText(elements.getHotelName());
            System.out.println("check-2");

//            if (Integer.parseInt(noOfRooms) > elements.getStandardRoomCapacity()) {
//                priceStandard1.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getStandardRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceStandard1.setText(totalPriceString);
//            }
//
//            if (Integer.parseInt(noOfRooms) > elements.getDeluxeRoomCapacity()) {
//                priceDeluxe1.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getDeluxeRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceDeluxe1.setText(totalPriceString);
//            }
//
//
//            if (Integer.parseInt(noOfRooms) > elements.getSuiteRoomCapacity()) {
//                priceSuite1.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getSuiteRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceSuite1.setText(totalPriceString);
//            }
            dataBaseController.initialiseDatabase();
            String databaseRate=String.valueOf(dataBaseController.calculateRating(elements.getUniqueId()));
            rating="/com/sharan/ui/pictures/stars/"+databaseRate+".jpg";
            dataBaseController.closeDatabaseConnection();


            priceStandard1.setText("Rs."+elements.getStandardRoomPrice());
            priceDeluxe1.setText("Rs."+elements.getDeluxeRoomPrice());
            priceSuite1.setText("Rs."+elements.getSuiteRoomPrice());

            standardRooms1.setText(String.valueOf(elements.getStandardRoomCapacity()));
            deluxeRooms.setText(String.valueOf(elements.getDeluxeRoomCapacity()));
            suiteRooms.setText(String.valueOf(elements.getSuiteRoomCapacity()));

            hotelRating1.setIcon(new ImageIcon(getClass().getResource(rating)));
            ratingBracket1.setText("Rating(" + String.valueOf(elements.getNumberOfVotes()) + ")");
            //hotel1************************************************************************************
        }


        {
            //hotel2************************************************************************************
            ElementsInHotelView elements = displayList.get(1);
            hotelPhoto2.setIcon(new ImageIcon(getClass().getResource(elements.getImagePath())));
            hotelName2.setText(elements.getHotelName());

            dataBaseController.initialiseDatabase();
            String databaseRate=String.valueOf(dataBaseController.calculateRating(elements.getUniqueId()));
            rating="/com/sharan/ui/pictures/stars/"+databaseRate+".jpg";
            dataBaseController.closeDatabaseConnection();


//            if (Integer.parseInt(noOfRooms) > elements.getStandardRoomCapacity()) {
//                priceStandard2.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getStandardRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceStandard2.setText(totalPriceString);
//            }
//
//            if (Integer.parseInt(noOfRooms) > elements.getDeluxeRoomCapacity()) {
//                priceDeluxe2.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getDeluxeRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceDeluxe2.setText(totalPriceString);
//            }
//
//
//            if (Integer.parseInt(noOfRooms) > elements.getSuiteRoomCapacity()) {
//                priceSuite2.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getSuiteRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceSuite2.setText(totalPriceString);
//            }
            priceStandard2.setText("Rs."+elements.getStandardRoomPrice());
            priceDeluxe2.setText("Rs."+elements.getDeluxeRoomPrice());
            priceSuite2.setText("Rs."+elements.getSuiteRoomPrice());

            standardRooms2.setText(String.valueOf(elements.getStandardRoomCapacity()));
            deluxeRooms2.setText(String.valueOf(elements.getDeluxeRoomCapacity()));
            suiteRooms2.setText(String.valueOf(elements.getSuiteRoomCapacity()));

            hotelRating2.setIcon(new ImageIcon(getClass().getResource(rating)));
            ratingBracket2.setText("Rating(" + String.valueOf(elements.getNumberOfVotes()) + ")");
            //hotel2************************************************************************************
        }

        {
            //hotel3************************************************************************************
            ElementsInHotelView elements = displayList.get(2);
            hotelPhoto3.setIcon(new ImageIcon(getClass().getResource(elements.getImagePath())));
            hotelName3.setText(elements.getHotelName());

            dataBaseController.initialiseDatabase();
            String databaseRate=String.valueOf(dataBaseController.calculateRating(elements.getUniqueId()));
            rating="/com/sharan/ui/pictures/stars/"+databaseRate+".jpg";
            dataBaseController.closeDatabaseConnection();


//            if (Integer.parseInt(noOfRooms) > elements.getStandardRoomCapacity()) {
//                priceStandard3.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getStandardRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceStandard3.setText(totalPriceString);
//            }
//
//            if (Integer.parseInt(noOfRooms) > elements.getDeluxeRoomCapacity()) {
//                priceDeluxe3.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getDeluxeRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceDeluxe3.setText(totalPriceString);
//            }
//
//
//            if (Integer.parseInt(noOfRooms) > elements.getSuiteRoomCapacity()) {
//                priceSuite3.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getSuiteRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceSuite3.setText(totalPriceString);
//            }
            priceStandard3.setText("Rs."+elements.getStandardRoomPrice());
            priceDeluxe3.setText("Rs."+elements.getDeluxeRoomPrice());
            priceSuite3.setText("Rs."+elements.getSuiteRoomPrice());

            standardRooms3.setText(String.valueOf(elements.getStandardRoomCapacity()));
            deluxeRooms3.setText(String.valueOf(elements.getDeluxeRoomCapacity()));
            suiteRooms3.setText(String.valueOf(elements.getSuiteRoomCapacity()));

            hotelRating3.setIcon(new ImageIcon(getClass().getResource(rating)));
            ratingBracket3.setText("Rating(" + String.valueOf(elements.getNumberOfVotes()) + ")");
            //hotel3************************************************************************************
        }

        {
            //hotel4************************************************************************************
            ElementsInHotelView elements = displayList.get(3);
//            hotelPhoto4.setIcon(new ImageIcon(getClass().getResource(elements.getImagePath())));
  //          hotelName4.setText(elements.getHotelName());

//            if (Integer.parseInt(noOfRooms) > elements.getStandardRoomCapacity()) {
//                priceStandard4.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getStandardRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceStandard4.setText(totalPriceString);
//            }
//
//            if (Integer.parseInt(noOfRooms) > elements.getDeluxeRoomCapacity()) {
//                priceDeluxe4.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getDeluxeRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceDeluxe4.setText(totalPriceString);
//            }
//
//
//            if (Integer.parseInt(noOfRooms) > elements.getSuiteRoomCapacity()) {
//                priceSuite4.setText("Not Enough Rooms Available");
//            } else {
//                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getSuiteRoomPrice()));
//                String totalPriceString = String.valueOf(totalPrice);
//                priceSuite4.setText(totalPriceString);
//            }
            dataBaseController.initialiseDatabase();
            String databaseRate=String.valueOf(dataBaseController.calculateRating(elements.getUniqueId()));
            rating="/com/sharan/ui/pictures/stars/"+databaseRate+".jpg";
            dataBaseController.closeDatabaseConnection();


            priceStandard4.setText("Rs."+elements.getStandardRoomPrice());
            priceDeluxe4.setText("Rs."+elements.getDeluxeRoomPrice());
            priceSuite4.setText("Rs."+elements.getSuiteRoomPrice());

            standardRooms4.setText(String.valueOf(elements.getStandardRoomCapacity()));
            deluxeRooms4.setText(String.valueOf(elements.getDeluxeRoomCapacity()));
            suiteRooms4.setText(String.valueOf(elements.getSuiteRoomCapacity()));

            hotelRating4.setIcon(new ImageIcon(getClass().getResource(rating)));
            ratingBracket4.setText("Rating(" + String.valueOf(elements.getNumberOfVotes()) + ")");
            //hotel4************************************************************************************
        }



        displayTable.setVisible(true);
        AutoCompleteDecorator.decorate(Hotels);


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


    private void myAccountActionPerformed(ActionEvent e) {
        displayTable.dispose();
        MyAccount myAccount=new MyAccount(userName,dataBaseController);
    }

    private void LogoutActionPerformed(ActionEvent e) {
        displayTable.dispose();
        HomePage page=new HomePage(dataBaseController);
    }

    private void backButtonActionPerformed(ActionEvent e) {
        displayTable.dispose();
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(userName, dataBaseController);
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
//            LoginToContinue loginToContinue=new LoginToContinue(uniqueId,dataBaseController);
        }
        else {
            JOptionPane.showMessageDialog(null,"Please Select a Hotel First");
        }
    }

    private void viewHotel1ActionPerformed(ActionEvent e) {
        list=new ArrayList<>();
        list.add(displayList.get(0).getUniqueId());
        list.add(displayList.get(0).getHotelName());
        list.add(displayList.get(0).getHotelDescription());
        list.add(displayList.get(0).getAddress());
        list.add(displayList.get(0).getImagePath());
        list.add(String.valueOf(displayList.get(0).getNumberOfVotes()));
        list.add(checkIN);
        list.add(checkOUT);
        list.add(userName);
        list.add(city);
        list.add(state);
        viewToindividual=1;
        displayTable.dispose();
        HotelHomeAfterLogin hotelHomeAfterLogin=new HotelHomeAfterLogin(list,dataBaseController);
    }

    private void viewHotel2ActionPerformed(ActionEvent e) {
        list=new ArrayList<>();
        list.add(displayList.get(1).getUniqueId());
        list.add(displayList.get(1).getHotelName());
        list.add(displayList.get(1).getHotelDescription());
        list.add(displayList.get(1).getAddress());
        list.add(displayList.get(1).getImagePath());
        list.add(String.valueOf(displayList.get(1).getNumberOfVotes()));
        list.add(checkIN);
        list.add(checkOUT);
        list.add(userName);
        list.add(city);
        list.add(state);
        viewToindividual=1;
        displayTable.dispose();
        HotelHomeAfterLogin hotelHomeAfterLogin=new HotelHomeAfterLogin(list,dataBaseController);
    }

    private void viewHotel3ActionPerformed(ActionEvent e) {
        list=new ArrayList<>();
        list.add(displayList.get(2).getUniqueId());
        list.add(displayList.get(2).getHotelName());
        list.add(displayList.get(2).getHotelDescription());
        list.add(displayList.get(2).getAddress());
        list.add(displayList.get(2).getImagePath());
        list.add(String.valueOf(displayList.get(2).getNumberOfVotes()));
        list.add(checkIN);
        list.add(checkOUT);
        list.add(userName);
        list.add(city);
        list.add(state);
        viewToindividual=1;
        displayTable.dispose();
        HotelHomeAfterLogin hotelHomeAfterLogin=new HotelHomeAfterLogin(list,dataBaseController);
    }

    private void viewHotel4ActionPerformed(ActionEvent e) {
        list=new ArrayList<>();
        list.add(displayList.get(3).getUniqueId());
        list.add(displayList.get(3).getHotelName());
        list.add(displayList.get(3).getHotelDescription());
        list.add(displayList.get(3).getAddress());
        list.add(displayList.get(3).getImagePath());
        list.add(String.valueOf(displayList.get(3).getNumberOfVotes()));
        list.add(checkIN);
        list.add(checkOUT);
        list.add(userName);
        list.add(city);
        list.add(state);
        viewToindividual=1;
        displayTable.dispose();
        HotelHomeAfterLogin hotelHomeAfterLogin=new HotelHomeAfterLogin(list,dataBaseController);
    }


    private void itckohenurActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void TheParkActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void TajVivantaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void manasarovarActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void HotelAshokaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void CrystalPalaceActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void LandmarkActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void SuprabhaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void HotelAdityaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void HotelAkshayaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void TheBudgetHotelActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void HotelSwethaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void GayathriActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void KaveriActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void ManasarovarActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void OnagiriActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void GingerMumbaiAndheriActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void IbisMumbaiAirportActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void TridentNarimanPointActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void RoyalOrchidCentralGraziaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void MintKoregaonParkActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void TajGatewayActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void HotelMintHighstreetActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void FourPointsActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void LeMeridienNagpurActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void HotelGangakashiActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void HotelSiddharthaInnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void RadissonBluActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void Ambassador_AjantaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void VivantaAurangabadActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void THEONEHOTELActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void HotelAtithiActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void HotelsActionPerformed(ActionEvent e) {
        // TODO add your code here
    }



    private void bookNow1ActionPerformed(ActionEvent e) {

        ElementsInHotelView elements=displayList.get(0);
        ArrayList<String> list=new ArrayList<>();
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
        ArrayList<String> imageList=dataBaseController.getIndividualHotelImages(elements.getUniqueId());
        dataBaseController.closeDatabaseConnection();

        if((imageList.get(0).equalsIgnoreCase("NA")) || (imageList.get(1).equalsIgnoreCase("NA")) || (imageList.get(2).equalsIgnoreCase("NA"))) {
            RoomBookingTwo roomBookingTwo =new RoomBookingTwo(list,dataBaseController);

        }else  {
            RoomBooking roomBooking = new RoomBooking(list,dataBaseController);
        }

    }

    private void bookNow2ActionPerformed(ActionEvent e) {
        ElementsInHotelView elements=displayList.get(1);
        ArrayList<String> list=new ArrayList<>();
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
        ArrayList<String> imageList=dataBaseController.getIndividualHotelImages(elements.getUniqueId());
        dataBaseController.closeDatabaseConnection();

        if((imageList.get(0).equalsIgnoreCase("NA")) || (imageList.get(1).equalsIgnoreCase("NA")) || (imageList.get(2).equalsIgnoreCase("NA"))) {
            RoomBookingTwo roomBookingTwo =new RoomBookingTwo(list,dataBaseController);

        }else  {
            RoomBooking roomBooking = new RoomBooking(list,dataBaseController);
        }    }

    private void bookNow3ActionPerformed(ActionEvent e) {
        ElementsInHotelView elements=displayList.get(2);
        ArrayList<String> list=new ArrayList<>();
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
        ArrayList<String> imageList=dataBaseController.getIndividualHotelImages(elements.getUniqueId());
        dataBaseController.closeDatabaseConnection();

        if((imageList.get(0).equalsIgnoreCase("NA")) || (imageList.get(1).equalsIgnoreCase("NA")) || (imageList.get(2).equalsIgnoreCase("NA"))) {
            RoomBookingTwo roomBookingTwo =new RoomBookingTwo(list,dataBaseController);

        }else  {
            RoomBooking roomBooking = new RoomBooking(list,dataBaseController);
        }    }

    private void bookNow4ActionPerformed(ActionEvent e) {
        ElementsInHotelView elements=displayList.get(3);
        ArrayList<String> list=new ArrayList<>();
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
        ArrayList<String> imageList=dataBaseController.getIndividualHotelImages(elements.getUniqueId());
        dataBaseController.closeDatabaseConnection();

        if((imageList.get(0).equalsIgnoreCase("NA")) || (imageList.get(1).equalsIgnoreCase("NA")) || (imageList.get(2).equalsIgnoreCase("NA"))) {
            RoomBookingTwo roomBookingTwo =new RoomBookingTwo(list,dataBaseController);

        }else  {
            RoomBooking roomBooking = new RoomBooking(list,dataBaseController);
        }    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
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
        hotelPanel1 = new JPanel();
        hotelPhoto1 = new JLabel();
        hotelName1 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        priceStandard1 = new JLabel();
        priceDeluxe1 = new JLabel();
        priceSuite1 = new JLabel();
        hotelRating1 = new JLabel();
        ratingBracket1 = new JLabel();
        scrollPane2 = new JScrollPane();
        description1 = new JTextPane();
        bookNow1 = new JButton();
        viewHotel1 = new JButton();
        label50 = new JLabel();
        label = new JLabel();
        label60 = new JLabel();
        standardRooms1 = new JLabel();
        deluxeRooms = new JLabel();
        suiteRooms = new JLabel();
        hotelPanel2 = new JPanel();
        hotelPhoto2 = new JLabel();
        hotelName2 = new JLabel();
        hotelRating2 = new JLabel();
        ratingBracket2 = new JLabel();
        scrollPane3 = new JScrollPane();
        description2 = new JTextPane();
        bookNow2 = new JButton();
        viewHotel2 = new JButton();
        standardRooms2 = new JLabel();
        label2 = new JLabel();
        label51 = new JLabel();
        label61 = new JLabel();
        priceStandard2 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        priceDeluxe2 = new JLabel();
        deluxeRooms2 = new JLabel();
        suiteRooms2 = new JLabel();
        priceSuite2 = new JLabel();
        label14 = new JLabel();
        hotelPanel3 = new JPanel();
        hotelPhoto3 = new JLabel();
        hotelName3 = new JLabel();
        hotelRating3 = new JLabel();
        ratingBracket3 = new JLabel();
        scrollPane4 = new JScrollPane();
        description3 = new JTextPane();
        bookNow3 = new JButton();
        viewHotel3 = new JButton();
        standardRooms3 = new JLabel();
        label3 = new JLabel();
        label52 = new JLabel();
        label62 = new JLabel();
        priceStandard3 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        priceDeluxe3 = new JLabel();
        deluxeRooms3 = new JLabel();
        suiteRooms3 = new JLabel();
        priceSuite3 = new JLabel();
        label17 = new JLabel();
        hotelPanel4 = new JPanel();
        hotelPhoto4 = new JLabel();
        hotelName4 = new JLabel();
        hotelRating4 = new JLabel();
        ratingBracket4 = new JLabel();
        scrollPane5 = new JScrollPane();
        description4 = new JTextPane();
        bookNow4 = new JButton();
        viewHotel4 = new JButton();
        standardRooms4 = new JLabel();
        label4 = new JLabel();
        label53 = new JLabel();
        label63 = new JLabel();
        priceStandard4 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        priceDeluxe4 = new JLabel();
        deluxeRooms4 = new JLabel();
        suiteRooms4 = new JLabel();
        priceSuite4 = new JLabel();
        label20 = new JLabel();

        //======== displayTable ========
        {
            displayTable.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        backButtonActionPerformed(e);
                    }
                });
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
                Hotels.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        HotelsActionPerformed(e);
                    }
                });
                Hotels.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        HotelsItemStateChanged(e);
                    }
                });
                menuBar1.add(Hotels);

                //---- Search ----
                Search.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
                Search.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/findSmall.png")));
                Search.setText("Search");
                Search.setBackground(Color.darkGray);
                Search.setForeground(new Color(238, 238, 238));
                Search.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SearchActionPerformed(e);
                    }
                });
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
                    myAccount.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            myAccountActionPerformed(e);
                        }
                    });
                    profile.add(myAccount);

                    //---- Logout ----
                    Logout.setText("Logout");
                    Logout.setFont(new Font("Arial", Font.PLAIN, 18));
                    Logout.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            LogoutActionPerformed(e);
                        }
                    });
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

                    // JFormDesigner evaluation mark
                    homePanel.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), homePanel.getBorder())); homePanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                    //======== hotelPanel1 ========
                    {
                        hotelPanel1.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                        hotelPanel1.setForeground(new Color(238, 238, 238));

                        //---- hotelPhoto1 ----
                        hotelPhoto1.setHorizontalAlignment(SwingConstants.CENTER);
                        hotelPhoto1.setBorder(LineBorder.createBlackLineBorder());
                        hotelPhoto1.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePic.png")));

                        //---- hotelName1 ----
                        hotelName1.setText("Mint karegoan park");
                        hotelName1.setFont(new Font("Roboto", Font.BOLD, 36));
                        hotelName1.setOpaque(true);
                        hotelName1.setForeground(Color.black);
                        hotelName1.setHorizontalAlignment(SwingConstants.CENTER);

                        //---- label9 ----
                        label9.setText("standard");
                        label9.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label10 ----
                        label10.setText("deluxe");
                        label10.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label11 ----
                        label11.setText("suite");
                        label11.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceStandard1 ----
                        priceStandard1.setText("text");
                        priceStandard1.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceDeluxe1 ----
                        priceDeluxe1.setText("text");
                        priceDeluxe1.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceSuite1 ----
                        priceSuite1.setText("text");
                        priceSuite1.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- hotelRating1 ----
                        hotelRating1.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                        //---- ratingBracket1 ----
                        ratingBracket1.setText("Rating");
                        ratingBracket1.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 22));

                        //======== scrollPane2 ========
                        {

                            //---- description1 ----
                            description1.setBackground(new Color(238, 238, 238));
                            scrollPane2.setViewportView(description1);
                        }

                        //---- bookNow1 ----
                        bookNow1.setText("Book Now");
                        bookNow1.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        bookNow1.setBackground(new Color(153, 0, 0));
                        bookNow1.setForeground(new Color(238, 238, 238));
                        bookNow1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                bookNow1ActionPerformed(e);
                            }
                        });

                        //---- viewHotel1 ----
                        viewHotel1.setText("View Hotel");
                        viewHotel1.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        viewHotel1.setBackground(new Color(153, 0, 0));
                        viewHotel1.setForeground(new Color(238, 238, 238));
                        viewHotel1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                viewHotel1ActionPerformed(e);
                            }
                        });

                        //---- label50 ----
                        label50.setText("Room Price");
                        label50.setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

                        //---- label ----
                        label.setText("Types");
                        label.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label60 ----
                        label60.setText("Number of Rooms");
                        label60.setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

                        //---- standardRooms1 ----
                        standardRooms1.setText("text");
                        standardRooms1.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- deluxeRooms ----
                        deluxeRooms.setText("text");
                        deluxeRooms.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- suiteRooms ----
                        suiteRooms.setText("text");
                        suiteRooms.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        GroupLayout hotelPanel1Layout = new GroupLayout(hotelPanel1);
                        hotelPanel1.setLayout(hotelPanel1Layout);
                        hotelPanel1Layout.setHorizontalGroup(
                            hotelPanel1Layout.createParallelGroup()
                                .add(hotelPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .add(hotelPhoto1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                    .add(hotelPanel1Layout.createParallelGroup()
                                        .add(hotelPanel1Layout.createSequentialGroup()
                                            .add(hotelPanel1Layout.createParallelGroup()
                                                .add(hotelPanel1Layout.createSequentialGroup()
                                                    .add(hotelPanel1Layout.createParallelGroup()
                                                        .add(label9, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                        .add(label10, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                        .add(label11, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                                    .add(18, 18, 18)
                                                    .add(hotelPanel1Layout.createParallelGroup()
                                                        .add(priceDeluxe1)
                                                        .add(priceStandard1)
                                                        .add(priceSuite1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .add(hotelPanel1Layout.createParallelGroup()
                                                        .add(standardRooms1)
                                                        .add(deluxeRooms)
                                                        .add(suiteRooms))
                                                    .add(121, 121, 121))
                                                .add(hotelPanel1Layout.createSequentialGroup()
                                                    .add(ratingBracket1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .add(hotelPanel1Layout.createSequentialGroup()
                                                    .add(hotelRating1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .add(258, 258, 258)))
                                            .add(hotelPanel1Layout.createParallelGroup(GroupLayout.LEADING, false)
                                                .add(viewHotel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(bookNow1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .add(27, 27, 27))
                                        .add(hotelPanel1Layout.createSequentialGroup()
                                            .add(label, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                            .add(18, 18, 18)
                                            .add(label50, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.UNRELATED)
                                            .add(label60)
                                            .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .add(scrollPane2, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .add(30, 30, 30))
                                .add(hotelName1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanel1Layout.setVerticalGroup(
                            hotelPanel1Layout.createParallelGroup()
                                .add(hotelPanel1Layout.createSequentialGroup()
                                    .addContainerGap(12, Short.MAX_VALUE)
                                    .add(hotelName1)
                                    .add(hotelPanel1Layout.createParallelGroup()
                                        .add(GroupLayout.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.RELATED, 11, Short.MAX_VALUE)
                                            .add(hotelPanel1Layout.createParallelGroup()
                                                .add(hotelPhoto1, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                                                .add(hotelPanel1Layout.createSequentialGroup()
                                                    .add(hotelPanel1Layout.createParallelGroup(GroupLayout.BASELINE)
                                                        .add(label)
                                                        .add(label50)
                                                        .add(label60))
                                                    .add(18, 18, 18)
                                                    .add(hotelPanel1Layout.createParallelGroup()
                                                        .add(GroupLayout.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                                            .add(hotelPanel1Layout.createParallelGroup()
                                                                .add(hotelPanel1Layout.createSequentialGroup()
                                                                    .add(label9)
                                                                    .add(18, 18, 18)
                                                                    .add(label10)
                                                                    .add(18, 18, 18)
                                                                    .add(label11))
                                                                .add(hotelPanel1Layout.createSequentialGroup()
                                                                    .add(standardRooms1)
                                                                    .add(18, 18, 18)
                                                                    .add(deluxeRooms)
                                                                    .add(18, 18, 18)
                                                                    .add(suiteRooms))
                                                                .add(hotelPanel1Layout.createSequentialGroup()
                                                                    .add(priceStandard1)
                                                                    .add(18, 18, 18)
                                                                    .add(priceDeluxe1)
                                                                    .add(18, 18, 18)
                                                                    .add(priceSuite1)))
                                                            .addPreferredGap(LayoutStyle.RELATED)
                                                            .add(ratingBracket1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                            .add(78, 78, 78))
                                                        .add(GroupLayout.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                                            .add(viewHotel1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.UNRELATED)
                                                            .add(bookNow1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                            .add(29, 29, 29))))))
                                        .add(hotelPanel1Layout.createSequentialGroup()
                                            .add(scrollPane2, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap())))
                                .add(GroupLayout.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(hotelRating1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                        );
                    }

                    //======== hotelPanel2 ========
                    {
                        hotelPanel2.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                        hotelPanel2.setForeground(new Color(238, 238, 238));

                        //---- hotelPhoto2 ----
                        hotelPhoto2.setHorizontalAlignment(SwingConstants.CENTER);
                        hotelPhoto2.setBorder(LineBorder.createBlackLineBorder());
                        hotelPhoto2.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePic.png")));

                        //---- hotelName2 ----
                        hotelName2.setText("Mint karegoan park");
                        hotelName2.setFont(new Font("Roboto", Font.BOLD, 36));
                        hotelName2.setOpaque(true);
                        hotelName2.setForeground(Color.black);
                        hotelName2.setHorizontalAlignment(SwingConstants.CENTER);

                        //---- hotelRating2 ----
                        hotelRating2.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                        //---- ratingBracket2 ----
                        ratingBracket2.setText("Rating");
                        ratingBracket2.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 22));

                        //======== scrollPane3 ========
                        {

                            //---- description2 ----
                            description2.setBackground(new Color(238, 238, 238));
                            scrollPane3.setViewportView(description2);
                        }

                        //---- bookNow2 ----
                        bookNow2.setText("Book Now");
                        bookNow2.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        bookNow2.setBackground(new Color(153, 0, 0));
                        bookNow2.setForeground(new Color(238, 238, 238));
                        bookNow2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                bookNow2ActionPerformed(e);
                            }
                        });

                        //---- viewHotel2 ----
                        viewHotel2.setText("View Hotel");
                        viewHotel2.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        viewHotel2.setBackground(new Color(153, 0, 0));
                        viewHotel2.setForeground(new Color(238, 238, 238));
                        viewHotel2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                viewHotel2ActionPerformed(e);
                            }
                        });

                        //---- standardRooms2 ----
                        standardRooms2.setText("text");
                        standardRooms2.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label2 ----
                        label2.setText("Types");
                        label2.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label51 ----
                        label51.setText("Room Price");
                        label51.setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

                        //---- label61 ----
                        label61.setText("Number of Rooms");
                        label61.setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

                        //---- priceStandard2 ----
                        priceStandard2.setText("text");
                        priceStandard2.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label12 ----
                        label12.setText("standard");
                        label12.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label13 ----
                        label13.setText("deluxe");
                        label13.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceDeluxe2 ----
                        priceDeluxe2.setText("text");
                        priceDeluxe2.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- deluxeRooms2 ----
                        deluxeRooms2.setText("text");
                        deluxeRooms2.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- suiteRooms2 ----
                        suiteRooms2.setText("text");
                        suiteRooms2.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceSuite2 ----
                        priceSuite2.setText("text");
                        priceSuite2.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label14 ----
                        label14.setText("suite");
                        label14.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        GroupLayout hotelPanel2Layout = new GroupLayout(hotelPanel2);
                        hotelPanel2.setLayout(hotelPanel2Layout);
                        hotelPanel2Layout.setHorizontalGroup(
                            hotelPanel2Layout.createParallelGroup()
                                .add(hotelPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .add(hotelPhoto2, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .add(12, 12, 12)
                                    .add(hotelPanel2Layout.createParallelGroup()
                                        .add(hotelPanel2Layout.createSequentialGroup()
                                            .add(hotelPanel2Layout.createParallelGroup(GroupLayout.LEADING, false)
                                                .add(hotelPanel2Layout.createSequentialGroup()
                                                    .add(label2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                    .add(18, 18, 18)
                                                    .add(label51, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                                .add(ratingBracket2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .add(hotelRating2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .add(12, 12, 12)
                                            .add(label61))
                                        .add(hotelPanel2Layout.createSequentialGroup()
                                            .add(hotelPanel2Layout.createParallelGroup()
                                                .add(label12, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .add(label13, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                .add(label14, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                            .add(32, 32, 32)
                                            .add(hotelPanel2Layout.createParallelGroup()
                                                .add(priceStandard2)
                                                .add(priceDeluxe2)
                                                .add(priceSuite2))
                                            .add(107, 107, 107)
                                            .add(hotelPanel2Layout.createParallelGroup()
                                                .add(standardRooms2)
                                                .add(deluxeRooms2)
                                                .add(suiteRooms2))))
                                    .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(hotelPanel2Layout.createParallelGroup(GroupLayout.LEADING, false)
                                        .add(viewHotel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(bookNow2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .add(27, 27, 27)
                                    .add(scrollPane3, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .add(30, 30, 30))
                                .add(hotelName2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanel2Layout.setVerticalGroup(
                            hotelPanel2Layout.createParallelGroup()
                                .add(hotelPanel2Layout.createSequentialGroup()
                                    .addContainerGap(12, Short.MAX_VALUE)
                                    .add(hotelName2)
                                    .add(hotelPanel2Layout.createParallelGroup()
                                        .add(hotelPanel2Layout.createSequentialGroup()
                                            .add(scrollPane3, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(24, Short.MAX_VALUE))
                                        .add(GroupLayout.TRAILING, hotelPanel2Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.RELATED)
                                            .add(hotelPanel2Layout.createParallelGroup()
                                                .add(GroupLayout.TRAILING, hotelPanel2Layout.createSequentialGroup()
                                                    .add(hotelPanel2Layout.createParallelGroup()
                                                        .add(label2)
                                                        .add(hotelPanel2Layout.createSequentialGroup()
                                                            .add(4, 4, 4)
                                                            .add(hotelPanel2Layout.createParallelGroup()
                                                                .add(label51)
                                                                .add(label61))))
                                                    .add(18, 18, 18)
                                                    .add(hotelPanel2Layout.createParallelGroup()
                                                        .add(hotelPanel2Layout.createSequentialGroup()
                                                            .add(label12)
                                                            .add(18, 18, 18)
                                                            .add(label13)
                                                            .add(18, 18, 18)
                                                            .add(label14))
                                                        .add(hotelPanel2Layout.createSequentialGroup()
                                                            .add(priceStandard2)
                                                            .add(18, 18, 18)
                                                            .add(priceDeluxe2)
                                                            .add(18, 18, 18)
                                                            .add(priceSuite2))
                                                        .add(hotelPanel2Layout.createSequentialGroup()
                                                            .add(standardRooms2)
                                                            .add(18, 18, 18)
                                                            .add(deluxeRooms2)
                                                            .add(18, 18, 18)
                                                            .add(suiteRooms2)))
                                                    .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .add(ratingBracket2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.RELATED)
                                                    .add(hotelRating2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                                                .add(GroupLayout.TRAILING, hotelPanel2Layout.createSequentialGroup()
                                                    .add(0, 0, Short.MAX_VALUE)
                                                    .add(viewHotel2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(bookNow2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .add(43, 43, 43))
                                                .add(hotelPanel2Layout.createSequentialGroup()
                                                    .add(hotelPhoto2, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                                                    .addContainerGap())))))
                        );
                    }

                    //======== hotelPanel3 ========
                    {
                        hotelPanel3.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                        hotelPanel3.setForeground(new Color(238, 238, 238));

                        //---- hotelPhoto3 ----
                        hotelPhoto3.setHorizontalAlignment(SwingConstants.CENTER);
                        hotelPhoto3.setBorder(LineBorder.createBlackLineBorder());
                        hotelPhoto3.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePic.png")));

                        //---- hotelName3 ----
                        hotelName3.setText("Mint karegoan park");
                        hotelName3.setFont(new Font("Roboto", Font.BOLD, 36));
                        hotelName3.setOpaque(true);
                        hotelName3.setForeground(Color.black);
                        hotelName3.setHorizontalAlignment(SwingConstants.CENTER);

                        //---- hotelRating3 ----
                        hotelRating3.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                        //---- ratingBracket3 ----
                        ratingBracket3.setText("Rating");
                        ratingBracket3.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 22));

                        //======== scrollPane4 ========
                        {

                            //---- description3 ----
                            description3.setBackground(new Color(238, 238, 238));
                            scrollPane4.setViewportView(description3);
                        }

                        //---- bookNow3 ----
                        bookNow3.setText("Book Now");
                        bookNow3.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        bookNow3.setBackground(new Color(153, 0, 0));
                        bookNow3.setForeground(new Color(238, 238, 238));
                        bookNow3.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                bookNow3ActionPerformed(e);
                            }
                        });

                        //---- viewHotel3 ----
                        viewHotel3.setText("View Hotel");
                        viewHotel3.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        viewHotel3.setBackground(new Color(153, 0, 0));
                        viewHotel3.setForeground(new Color(238, 238, 238));
                        viewHotel3.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                viewHotel3ActionPerformed(e);
                            }
                        });

                        //---- standardRooms3 ----
                        standardRooms3.setText("text");
                        standardRooms3.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label3 ----
                        label3.setText("Types");
                        label3.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label52 ----
                        label52.setText("Room Price");
                        label52.setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

                        //---- label62 ----
                        label62.setText("Number of Rooms");
                        label62.setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

                        //---- priceStandard3 ----
                        priceStandard3.setText("text");
                        priceStandard3.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label15 ----
                        label15.setText("standard");
                        label15.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label16 ----
                        label16.setText("deluxe");
                        label16.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceDeluxe3 ----
                        priceDeluxe3.setText("text");
                        priceDeluxe3.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- deluxeRooms3 ----
                        deluxeRooms3.setText("text");
                        deluxeRooms3.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- suiteRooms3 ----
                        suiteRooms3.setText("text");
                        suiteRooms3.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceSuite3 ----
                        priceSuite3.setText("text");
                        priceSuite3.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label17 ----
                        label17.setText("suite");
                        label17.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        GroupLayout hotelPanel3Layout = new GroupLayout(hotelPanel3);
                        hotelPanel3.setLayout(hotelPanel3Layout);
                        hotelPanel3Layout.setHorizontalGroup(
                            hotelPanel3Layout.createParallelGroup()
                                .add(hotelPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .add(hotelPhoto3, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                    .add(hotelPanel3Layout.createParallelGroup()
                                        .add(GroupLayout.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                            .add(0, 0, Short.MAX_VALUE)
                                            .add(hotelPanel3Layout.createParallelGroup()
                                                .add(hotelPanel3Layout.createSequentialGroup()
                                                    .add(label3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                    .add(18, 18, 18)
                                                    .add(label52, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                    .add(13, 13, 13)
                                                    .add(label62))
                                                .add(hotelPanel3Layout.createSequentialGroup()
                                                    .add(label15, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                    .add(49, 49, 49)
                                                    .add(priceStandard3)
                                                    .add(91, 91, 91)
                                                    .add(standardRooms3))
                                                .add(hotelPanel3Layout.createSequentialGroup()
                                                    .add(label16, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                    .add(58, 58, 58)
                                                    .add(priceDeluxe3)
                                                    .add(91, 91, 91)
                                                    .add(deluxeRooms3))
                                                .add(hotelPanel3Layout.createSequentialGroup()
                                                    .add(label17, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                    .add(58, 58, 58)
                                                    .add(priceSuite3)
                                                    .add(91, 91, 91)
                                                    .add(suiteRooms3))))
                                        .add(hotelPanel3Layout.createSequentialGroup()
                                            .add(hotelPanel3Layout.createParallelGroup()
                                                .add(ratingBracket3, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .add(hotelRating3, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.RELATED, 257, Short.MAX_VALUE)))
                                    .add(hotelPanel3Layout.createParallelGroup(GroupLayout.LEADING, false)
                                        .add(viewHotel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(bookNow3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .add(36, 36, 36)
                                    .add(scrollPane4, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .add(21, 21, 21))
                                .add(hotelName3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanel3Layout.setVerticalGroup(
                            hotelPanel3Layout.createParallelGroup()
                                .add(hotelPanel3Layout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(hotelName3)
                                    .add(hotelPanel3Layout.createParallelGroup()
                                        .add(GroupLayout.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                            .add(0, 0, Short.MAX_VALUE)
                                            .add(hotelPhoto3, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                                        .add(GroupLayout.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(hotelPanel3Layout.createParallelGroup()
                                                .add(GroupLayout.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                                    .add(hotelPanel3Layout.createParallelGroup()
                                                        .add(label3)
                                                        .add(hotelPanel3Layout.createSequentialGroup()
                                                            .add(3, 3, 3)
                                                            .add(hotelPanel3Layout.createParallelGroup()
                                                                .add(label52)
                                                                .add(label62))))
                                                    .add(18, 18, 18)
                                                    .add(hotelPanel3Layout.createParallelGroup()
                                                        .add(label15)
                                                        .add(priceStandard3)
                                                        .add(standardRooms3))
                                                    .add(17, 17, 17)
                                                    .add(hotelPanel3Layout.createParallelGroup()
                                                        .add(label16)
                                                        .add(priceDeluxe3)
                                                        .add(deluxeRooms3))
                                                    .add(19, 19, 19)
                                                    .add(hotelPanel3Layout.createParallelGroup()
                                                        .add(label17)
                                                        .add(priceSuite3)
                                                        .add(suiteRooms3))
                                                    .addPreferredGap(LayoutStyle.RELATED)
                                                    .add(ratingBracket3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.RELATED)
                                                    .add(hotelRating3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                                                .add(GroupLayout.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                                    .add(viewHotel3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .add(18, 18, 18)
                                                    .add(bookNow3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .add(37, 37, 37))
                                                .add(GroupLayout.TRAILING, scrollPane4, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap())
                        );
                    }

                    //======== hotelPanel4 ========
                    {
                        hotelPanel4.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                        hotelPanel4.setForeground(new Color(238, 238, 238));

                        //---- hotelPhoto4 ----
                        hotelPhoto4.setHorizontalAlignment(SwingConstants.CENTER);
                        hotelPhoto4.setBorder(LineBorder.createBlackLineBorder());
                        hotelPhoto4.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePic.png")));

                        //---- hotelName4 ----
                        hotelName4.setText("Mint karegoan park");
                        hotelName4.setFont(new Font("Roboto", Font.BOLD, 36));
                        hotelName4.setOpaque(true);
                        hotelName4.setForeground(Color.black);
                        hotelName4.setHorizontalAlignment(SwingConstants.CENTER);

                        //---- hotelRating4 ----
                        hotelRating4.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                        //---- ratingBracket4 ----
                        ratingBracket4.setText("Rating");
                        ratingBracket4.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 22));

                        //======== scrollPane5 ========
                        {

                            //---- description4 ----
                            description4.setBackground(new Color(238, 238, 238));
                            scrollPane5.setViewportView(description4);
                        }

                        //---- bookNow4 ----
                        bookNow4.setText("Book Now");
                        bookNow4.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        bookNow4.setBackground(new Color(153, 0, 0));
                        bookNow4.setForeground(new Color(238, 238, 238));
                        bookNow4.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                bookNow4ActionPerformed(e);
                            }
                        });

                        //---- viewHotel4 ----
                        viewHotel4.setText("View Hotel");
                        viewHotel4.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        viewHotel4.setBackground(new Color(153, 0, 0));
                        viewHotel4.setForeground(new Color(238, 238, 238));
                        viewHotel4.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                viewHotel4ActionPerformed(e);
                            }
                        });

                        //---- standardRooms4 ----
                        standardRooms4.setText("text");
                        standardRooms4.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label4 ----
                        label4.setText("Types");
                        label4.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label53 ----
                        label53.setText("Room Price");
                        label53.setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

                        //---- label63 ----
                        label63.setText("Number of Rooms");
                        label63.setFont(new Font("Droid Sans Mono", Font.BOLD, 16));

                        //---- priceStandard4 ----
                        priceStandard4.setText("text");
                        priceStandard4.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label18 ----
                        label18.setText("standard");
                        label18.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label19 ----
                        label19.setText("deluxe");
                        label19.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceDeluxe4 ----
                        priceDeluxe4.setText("text");
                        priceDeluxe4.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- deluxeRooms4 ----
                        deluxeRooms4.setText("text");
                        deluxeRooms4.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- suiteRooms4 ----
                        suiteRooms4.setText("text");
                        suiteRooms4.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceSuite4 ----
                        priceSuite4.setText("text");
                        priceSuite4.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label20 ----
                        label20.setText("suite");
                        label20.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        GroupLayout hotelPanel4Layout = new GroupLayout(hotelPanel4);
                        hotelPanel4.setLayout(hotelPanel4Layout);
                        hotelPanel4Layout.setHorizontalGroup(
                            hotelPanel4Layout.createParallelGroup()
                                .add(hotelPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .add(hotelPhoto4, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                    .add(hotelPanel4Layout.createParallelGroup()
                                        .add(ratingBracket4, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                        .add(hotelPanel4Layout.createSequentialGroup()
                                            .add(label4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                            .add(18, 18, 18)
                                            .add(label53, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                            .add(13, 13, 13)
                                            .add(label63))
                                        .add(hotelPanel4Layout.createSequentialGroup()
                                            .add(label18, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                            .add(49, 49, 49)
                                            .add(priceStandard4)
                                            .add(91, 91, 91)
                                            .add(standardRooms4))
                                        .add(hotelPanel4Layout.createSequentialGroup()
                                            .add(label19, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                            .add(58, 58, 58)
                                            .add(priceDeluxe4)
                                            .add(91, 91, 91)
                                            .add(deluxeRooms4))
                                        .add(hotelPanel4Layout.createSequentialGroup()
                                            .add(label20, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                            .add(58, 58, 58)
                                            .add(priceSuite4)
                                            .add(91, 91, 91)
                                            .add(suiteRooms4))
                                        .add(hotelRating4, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.RELATED, 75, Short.MAX_VALUE)
                                    .add(hotelPanel4Layout.createParallelGroup(GroupLayout.LEADING, false)
                                        .add(viewHotel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(bookNow4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .add(36, 36, 36)
                                    .add(scrollPane5, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .add(21, 21, 21))
                                .add(hotelName4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanel4Layout.setVerticalGroup(
                            hotelPanel4Layout.createParallelGroup()
                                .add(hotelPanel4Layout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(hotelName4)
                                    .add(hotelPanel4Layout.createParallelGroup()
                                        .add(GroupLayout.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                            .add(0, 0, Short.MAX_VALUE)
                                            .add(hotelPhoto4, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                                        .add(GroupLayout.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(hotelPanel4Layout.createParallelGroup()
                                                .add(GroupLayout.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                                    .add(hotelPanel4Layout.createParallelGroup()
                                                        .add(label4)
                                                        .add(hotelPanel4Layout.createSequentialGroup()
                                                            .add(3, 3, 3)
                                                            .add(hotelPanel4Layout.createParallelGroup()
                                                                .add(label53)
                                                                .add(label63))))
                                                    .add(18, 18, 18)
                                                    .add(hotelPanel4Layout.createParallelGroup()
                                                        .add(label18)
                                                        .add(priceStandard4)
                                                        .add(standardRooms4))
                                                    .add(17, 17, 17)
                                                    .add(hotelPanel4Layout.createParallelGroup()
                                                        .add(label19)
                                                        .add(priceDeluxe4)
                                                        .add(deluxeRooms4))
                                                    .add(19, 19, 19)
                                                    .add(hotelPanel4Layout.createParallelGroup()
                                                        .add(label20)
                                                        .add(priceSuite4)
                                                        .add(suiteRooms4))
                                                    .addPreferredGap(LayoutStyle.UNRELATED)
                                                    .add(ratingBracket4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.RELATED)
                                                    .add(hotelRating4, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                                                .add(GroupLayout.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                                    .add(viewHotel4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .add(18, 18, 18)
                                                    .add(bookNow4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .add(37, 37, 37))
                                                .add(GroupLayout.TRAILING, scrollPane5, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap())
                        );
                    }

                    GroupLayout homePanelLayout = new GroupLayout(homePanel);
                    homePanel.setLayout(homePanelLayout);
                    homePanelLayout.setHorizontalGroup(
                        homePanelLayout.createParallelGroup()
                            .add(hotelPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(homePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(homePanelLayout.createParallelGroup()
                                    .add(hotelPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(hotelPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(GroupLayout.TRAILING, hotelPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                    );
                    homePanelLayout.setVerticalGroup(
                        homePanelLayout.createParallelGroup()
                            .add(homePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .add(hotelPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(hotelPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(hotelPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.UNRELATED)
                                .add(hotelPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(313, Short.MAX_VALUE))
                    );
                }
                scrollPane1.setViewportView(homePanel);
            }

            GroupLayout displayTableContentPaneLayout = new GroupLayout(displayTableContentPane);
            displayTableContentPane.setLayout(displayTableContentPaneLayout);
            displayTableContentPaneLayout.setHorizontalGroup(
                displayTableContentPaneLayout.createParallelGroup()
                    .add(displayTableContentPaneLayout.createSequentialGroup()
                        .add(displayTableContentPaneLayout.createParallelGroup()
                            .add(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(menuBar1, GroupLayout.DEFAULT_SIZE, 1529, Short.MAX_VALUE)
                            .add(scrollPane1, GroupLayout.DEFAULT_SIZE, 1529, Short.MAX_VALUE))
                        .addContainerGap())
            );
            displayTableContentPaneLayout.setVerticalGroup(
                displayTableContentPaneLayout.createParallelGroup()
                    .add(displayTableContentPaneLayout.createSequentialGroup()
                        .add(label1)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(menuBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.RELATED)
                        .add(scrollPane1, GroupLayout.DEFAULT_SIZE, 1492, Short.MAX_VALUE))
            );
            displayTable.pack();
            displayTable.setLocationRelativeTo(displayTable.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
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
    private JPanel hotelPanel1;
    private JLabel hotelPhoto1;
    private JLabel hotelName1;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel priceStandard1;
    private JLabel priceDeluxe1;
    private JLabel priceSuite1;
    private JLabel hotelRating1;
    private JLabel ratingBracket1;
    private JScrollPane scrollPane2;
    private JTextPane description1;
    private JButton bookNow1;
    private JButton viewHotel1;
    private JLabel label50;
    private JLabel label;
    private JLabel label60;
    private JLabel standardRooms1;
    private JLabel deluxeRooms;
    private JLabel suiteRooms;
    private JPanel hotelPanel2;
    private JLabel hotelPhoto2;
    private JLabel hotelName2;
    private JLabel hotelRating2;
    private JLabel ratingBracket2;
    private JScrollPane scrollPane3;
    private JTextPane description2;
    private JButton bookNow2;
    private JButton viewHotel2;
    private JLabel standardRooms2;
    private JLabel label2;
    private JLabel label51;
    private JLabel label61;
    private JLabel priceStandard2;
    private JLabel label12;
    private JLabel label13;
    private JLabel priceDeluxe2;
    private JLabel deluxeRooms2;
    private JLabel suiteRooms2;
    private JLabel priceSuite2;
    private JLabel label14;
    private JPanel hotelPanel3;
    private JLabel hotelPhoto3;
    private JLabel hotelName3;
    private JLabel hotelRating3;
    private JLabel ratingBracket3;
    private JScrollPane scrollPane4;
    private JTextPane description3;
    private JButton bookNow3;
    private JButton viewHotel3;
    private JLabel standardRooms3;
    private JLabel label3;
    private JLabel label52;
    private JLabel label62;
    private JLabel priceStandard3;
    private JLabel label15;
    private JLabel label16;
    private JLabel priceDeluxe3;
    private JLabel deluxeRooms3;
    private JLabel suiteRooms3;
    private JLabel priceSuite3;
    private JLabel label17;
    private JPanel hotelPanel4;
    private JLabel hotelPhoto4;
    private JLabel hotelName4;
    private JLabel hotelRating4;
    private JLabel ratingBracket4;
    private JScrollPane scrollPane5;
    private JTextPane description4;
    private JButton bookNow4;
    private JButton viewHotel4;
    private JLabel standardRooms4;
    private JLabel label4;
    private JLabel label53;
    private JLabel label63;
    private JLabel priceStandard4;
    private JLabel label18;
    private JLabel label19;
    private JLabel priceDeluxe4;
    private JLabel deluxeRooms4;
    private JLabel suiteRooms4;
    private JLabel priceSuite4;
    private JLabel label20;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
