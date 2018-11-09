/*
 * Created by JFormDesigner on Sat Nov 03 21:40:23 IST 2018
 */

package com.sharan.ui.hotelView.displaySelectedHotels;

import com.sharan.DataBaseController;
import com.sharan.ui.home.homePage.HomePage;
import com.sharan.ui.home.homePageAfterLogin.HomePageAfterLogin;
import com.sharan.ui.home.loginToContinueDialog.LoginToContinue;
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
            LoginToContinue loginToContinue=new LoginToContinue(uniqueId,dataBaseController);
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
        Telangana = new JMenu();
        Hyderabad = new JMenu();
        itckohenur = new JMenuItem();
        ThePark = new JMenuItem();
        TajVivanta = new JMenuItem();
        manasarovar = new JMenuItem();
        Warangal = new JMenu();
        HotelAshoka = new JMenuItem();
        CrystalPalace = new JMenuItem();
        Landmark = new JMenuItem();
        Suprabha = new JMenuItem();
        Karimnagar = new JMenu();
        HotelAditya = new JMenuItem();
        HotelAkshaya = new JMenuItem();
        TheBudgetHotel = new JMenuItem();
        HotelSwetha = new JMenuItem();
        Kammam = new JMenu();
        Gayathri = new JMenuItem();
        Kaveri = new JMenuItem();
        Manasarovar = new JMenuItem();
        Onagiri = new JMenuItem();
        Andhra_Pradesh = new JMenu();
        Vijayawada = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        Guntur = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menuItem9 = new JMenuItem();
        Tirupati = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem10 = new JMenuItem();
        menuItem11 = new JMenuItem();
        menuItem12 = new JMenuItem();
        Vizag = new JMenu();
        menuItem13 = new JMenuItem();
        menuItem14 = new JMenuItem();
        menuItem15 = new JMenuItem();
        menuItem16 = new JMenuItem();
        New_Delhi = new JMenu();
        New_Delhi_City = new JMenu();
        menuItem33 = new JMenuItem();
        menuItem34 = new JMenuItem();
        menuItem35 = new JMenuItem();
        menuItem36 = new JMenuItem();
        Panipat = new JMenu();
        menuItem37 = new JMenuItem();
        menuItem38 = new JMenuItem();
        menuItem39 = new JMenuItem();
        menuItem40 = new JMenuItem();
        Gurugram = new JMenu();
        menuItem41 = new JMenuItem();
        menuItem42 = new JMenuItem();
        menuItem43 = new JMenuItem();
        menuItem44 = new JMenuItem();
        Faridabad = new JMenu();
        menuItem45 = new JMenuItem();
        menuItem46 = new JMenuItem();
        menuItem47 = new JMenuItem();
        menuItem48 = new JMenuItem();
        Maharashtra = new JMenu();
        Mumbai = new JMenu();
        GingerMumbaiAndheri = new JMenuItem();
        IbisMumbaiAirport = new JMenuItem();
        TridentNarimanPoint = new JMenuItem();
        RoyalOrchidCentralGrazia = new JMenuItem();
        Pune = new JMenu();
        MintKoregaonPark = new JMenuItem();
        TajGateway = new JMenuItem();
        HotelMintHighstreet = new JMenuItem();
        FourPoints = new JMenuItem();
        Nagpur = new JMenu();
        LeMeridienNagpur = new JMenuItem();
        HotelGangakashi = new JMenuItem();
        HotelSiddharthaInn = new JMenuItem();
        RadissonBlu = new JMenuItem();
        Aurangabad = new JMenu();
        Ambassador_Ajanta = new JMenuItem();
        VivantaAurangabad = new JMenuItem();
        THEONEHOTEL = new JMenuItem();
        HotelAtithi = new JMenuItem();
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
                backButton.addActionListener(e -> backButtonActionPerformed(e));
                menuBar1.add(backButton);

                //======== Telangana ========
                {
                    Telangana.setText("Telangana");
                    Telangana.setPreferredSize(new Dimension(100, 19));
                    Telangana.setFont(new Font("Arial", Font.BOLD, 18));
                    Telangana.setForeground(new Color(238, 238, 238));

                    //======== Hyderabad ========
                    {
                        Hyderabad.setText("Hyderabad");
                        Hyderabad.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- itckohenur ----
                        itckohenur.setText("ITC Kohenur");
                        itckohenur.addActionListener(e -> itckohenurActionPerformed(e));
                        Hyderabad.add(itckohenur);

                        //---- ThePark ----
                        ThePark.setText("The Park");
                        ThePark.addActionListener(e -> TheParkActionPerformed(e));
                        Hyderabad.add(ThePark);

                        //---- TajVivanta ----
                        TajVivanta.setText("Taj Vivanta");
                        TajVivanta.addActionListener(e -> TajVivantaActionPerformed(e));
                        Hyderabad.add(TajVivanta);

                        //---- manasarovar ----
                        manasarovar.setText("Manasarovar");
                        manasarovar.addActionListener(e -> manasarovarActionPerformed(e));
                        Hyderabad.add(manasarovar);
                    }
                    Telangana.add(Hyderabad);

                    //======== Warangal ========
                    {
                        Warangal.setText("Warangal");
                        Warangal.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- HotelAshoka ----
                        HotelAshoka.setText("Hotel Ashoka");
                        HotelAshoka.addActionListener(e -> HotelAshokaActionPerformed(e));
                        Warangal.add(HotelAshoka);

                        //---- CrystalPalace ----
                        CrystalPalace.setText("Crystal Palace");
                        CrystalPalace.addActionListener(e -> CrystalPalaceActionPerformed(e));
                        Warangal.add(CrystalPalace);

                        //---- Landmark ----
                        Landmark.setText("Landmark");
                        Landmark.addActionListener(e -> LandmarkActionPerformed(e));
                        Warangal.add(Landmark);

                        //---- Suprabha ----
                        Suprabha.setText("Hotel Suprabha");
                        Suprabha.addActionListener(e -> SuprabhaActionPerformed(e));
                        Warangal.add(Suprabha);
                    }
                    Telangana.add(Warangal);

                    //======== Karimnagar ========
                    {
                        Karimnagar.setText("Karimnagar");
                        Karimnagar.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- HotelAditya ----
                        HotelAditya.setText("Hotel Aditya");
                        HotelAditya.addActionListener(e -> HotelAdityaActionPerformed(e));
                        Karimnagar.add(HotelAditya);

                        //---- HotelAkshaya ----
                        HotelAkshaya.setText("Hotel Akshaya");
                        HotelAkshaya.addActionListener(e -> HotelAkshayaActionPerformed(e));
                        Karimnagar.add(HotelAkshaya);

                        //---- TheBudgetHotel ----
                        TheBudgetHotel.setText("The Budget Hotel");
                        TheBudgetHotel.addActionListener(e -> TheBudgetHotelActionPerformed(e));
                        Karimnagar.add(TheBudgetHotel);

                        //---- HotelSwetha ----
                        HotelSwetha.setText("Hotel Swetha");
                        HotelSwetha.addActionListener(e -> HotelSwethaActionPerformed(e));
                        Karimnagar.add(HotelSwetha);
                    }
                    Telangana.add(Karimnagar);

                    //======== Kammam ========
                    {
                        Kammam.setText("Kammam");
                        Kammam.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- Gayathri ----
                        Gayathri.setText("Gayathri");
                        Gayathri.addActionListener(e -> GayathriActionPerformed(e));
                        Kammam.add(Gayathri);

                        //---- Kaveri ----
                        Kaveri.setText("Kaveri");
                        Kaveri.addActionListener(e -> KaveriActionPerformed(e));
                        Kammam.add(Kaveri);

                        //---- Manasarovar ----
                        Manasarovar.setText("Manasarovar");
                        Manasarovar.addActionListener(e -> ManasarovarActionPerformed(e));
                        Kammam.add(Manasarovar);

                        //---- Onagiri ----
                        Onagiri.setText("Onagiri");
                        Onagiri.addActionListener(e -> OnagiriActionPerformed(e));
                        Kammam.add(Onagiri);
                    }
                    Telangana.add(Kammam);
                }
                menuBar1.add(Telangana);

                //======== Andhra_Pradesh ========
                {
                    Andhra_Pradesh.setText("Andhra Pradesh");
                    Andhra_Pradesh.setPreferredSize(new Dimension(150, 50));
                    Andhra_Pradesh.setFont(new Font("Arial", Font.BOLD, 18));
                    Andhra_Pradesh.setForeground(Color.white);

                    //======== Vijayawada ========
                    {
                        Vijayawada.setText("Vijayawada");
                        Vijayawada.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem1 ----
                        menuItem1.setText("text");
                        Vijayawada.add(menuItem1);

                        //---- menuItem2 ----
                        menuItem2.setText("text");
                        Vijayawada.add(menuItem2);

                        //---- menuItem3 ----
                        menuItem3.setText("text");
                        Vijayawada.add(menuItem3);

                        //---- menuItem4 ----
                        menuItem4.setText("text");
                        Vijayawada.add(menuItem4);
                    }
                    Andhra_Pradesh.add(Vijayawada);

                    //======== Guntur ========
                    {
                        Guntur.setText("Guntur");
                        Guntur.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem6 ----
                        menuItem6.setText("text");
                        Guntur.add(menuItem6);

                        //---- menuItem7 ----
                        menuItem7.setText("text");
                        Guntur.add(menuItem7);

                        //---- menuItem8 ----
                        menuItem8.setText("text");
                        Guntur.add(menuItem8);

                        //---- menuItem9 ----
                        menuItem9.setText("text");
                        Guntur.add(menuItem9);
                    }
                    Andhra_Pradesh.add(Guntur);

                    //======== Tirupati ========
                    {
                        Tirupati.setText("Tirupati");
                        Tirupati.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem5 ----
                        menuItem5.setText("text");
                        Tirupati.add(menuItem5);

                        //---- menuItem10 ----
                        menuItem10.setText("text");
                        Tirupati.add(menuItem10);

                        //---- menuItem11 ----
                        menuItem11.setText("text");
                        Tirupati.add(menuItem11);

                        //---- menuItem12 ----
                        menuItem12.setText("text");
                        Tirupati.add(menuItem12);
                    }
                    Andhra_Pradesh.add(Tirupati);

                    //======== Vizag ========
                    {
                        Vizag.setText("Vizag");
                        Vizag.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem13 ----
                        menuItem13.setText("text");
                        Vizag.add(menuItem13);

                        //---- menuItem14 ----
                        menuItem14.setText("text");
                        Vizag.add(menuItem14);

                        //---- menuItem15 ----
                        menuItem15.setText("text");
                        Vizag.add(menuItem15);

                        //---- menuItem16 ----
                        menuItem16.setText("text");
                        Vizag.add(menuItem16);
                    }
                    Andhra_Pradesh.add(Vizag);
                }
                menuBar1.add(Andhra_Pradesh);

                //======== New_Delhi ========
                {
                    New_Delhi.setText("New Delhi");
                    New_Delhi.setPreferredSize(new Dimension(100, 50));
                    New_Delhi.setFont(new Font("Arial", Font.BOLD, 18));
                    New_Delhi.setForeground(new Color(238, 238, 238));

                    //======== New_Delhi_City ========
                    {
                        New_Delhi_City.setText("New Delhi");
                        New_Delhi_City.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem33 ----
                        menuItem33.setText("text");
                        New_Delhi_City.add(menuItem33);

                        //---- menuItem34 ----
                        menuItem34.setText("text");
                        New_Delhi_City.add(menuItem34);

                        //---- menuItem35 ----
                        menuItem35.setText("text");
                        New_Delhi_City.add(menuItem35);

                        //---- menuItem36 ----
                        menuItem36.setText("text");
                        New_Delhi_City.add(menuItem36);
                    }
                    New_Delhi.add(New_Delhi_City);

                    //======== Panipat ========
                    {
                        Panipat.setText("Panipat");
                        Panipat.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem37 ----
                        menuItem37.setText("text");
                        Panipat.add(menuItem37);

                        //---- menuItem38 ----
                        menuItem38.setText("text");
                        Panipat.add(menuItem38);

                        //---- menuItem39 ----
                        menuItem39.setText("text");
                        Panipat.add(menuItem39);

                        //---- menuItem40 ----
                        menuItem40.setText("text");
                        Panipat.add(menuItem40);
                    }
                    New_Delhi.add(Panipat);

                    //======== Gurugram ========
                    {
                        Gurugram.setText("Gurugram");
                        Gurugram.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem41 ----
                        menuItem41.setText("text");
                        Gurugram.add(menuItem41);

                        //---- menuItem42 ----
                        menuItem42.setText("text");
                        Gurugram.add(menuItem42);

                        //---- menuItem43 ----
                        menuItem43.setText("text");
                        Gurugram.add(menuItem43);

                        //---- menuItem44 ----
                        menuItem44.setText("text");
                        Gurugram.add(menuItem44);
                    }
                    New_Delhi.add(Gurugram);

                    //======== Faridabad ========
                    {
                        Faridabad.setText("Faridabad");
                        Faridabad.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem45 ----
                        menuItem45.setText("text");
                        Faridabad.add(menuItem45);

                        //---- menuItem46 ----
                        menuItem46.setText("text");
                        Faridabad.add(menuItem46);

                        //---- menuItem47 ----
                        menuItem47.setText("text");
                        Faridabad.add(menuItem47);

                        //---- menuItem48 ----
                        menuItem48.setText("text");
                        Faridabad.add(menuItem48);
                    }
                    New_Delhi.add(Faridabad);
                }
                menuBar1.add(New_Delhi);

                //======== Maharashtra ========
                {
                    Maharashtra.setText("Maharashtra");
                    Maharashtra.setPreferredSize(new Dimension(110, 50));
                    Maharashtra.setFont(new Font("Arial", Font.BOLD, 18));
                    Maharashtra.setForeground(new Color(238, 238, 238));

                    //======== Mumbai ========
                    {
                        Mumbai.setText("Mumbai");
                        Mumbai.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- GingerMumbaiAndheri ----
                        GingerMumbaiAndheri.setText("Ginger Mumbai Andheri");
                        GingerMumbaiAndheri.addActionListener(e -> GingerMumbaiAndheriActionPerformed(e));
                        Mumbai.add(GingerMumbaiAndheri);

                        //---- IbisMumbaiAirport ----
                        IbisMumbaiAirport.setText("Ibis Mumbai Airport");
                        IbisMumbaiAirport.addActionListener(e -> IbisMumbaiAirportActionPerformed(e));
                        Mumbai.add(IbisMumbaiAirport);

                        //---- TridentNarimanPoint ----
                        TridentNarimanPoint.setText("Trident Nariman Point");
                        TridentNarimanPoint.addActionListener(e -> TridentNarimanPointActionPerformed(e));
                        Mumbai.add(TridentNarimanPoint);

                        //---- RoyalOrchidCentralGrazia ----
                        RoyalOrchidCentralGrazia.setText("Royal Orchid Central Grazia");
                        RoyalOrchidCentralGrazia.addActionListener(e -> RoyalOrchidCentralGraziaActionPerformed(e));
                        Mumbai.add(RoyalOrchidCentralGrazia);
                    }
                    Maharashtra.add(Mumbai);

                    //======== Pune ========
                    {
                        Pune.setText("Pune");
                        Pune.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- MintKoregaonPark ----
                        MintKoregaonPark.setText("Mint Koregaon Park");
                        MintKoregaonPark.addActionListener(e -> MintKoregaonParkActionPerformed(e));
                        Pune.add(MintKoregaonPark);

                        //---- TajGateway ----
                        TajGateway.setText("Taj Gateway");
                        TajGateway.addActionListener(e -> TajGatewayActionPerformed(e));
                        Pune.add(TajGateway);

                        //---- HotelMintHighstreet ----
                        HotelMintHighstreet.setText("Hotel Mint Highstreet");
                        HotelMintHighstreet.addActionListener(e -> HotelMintHighstreetActionPerformed(e));
                        Pune.add(HotelMintHighstreet);

                        //---- FourPoints ----
                        FourPoints.setText("Four Points");
                        FourPoints.addActionListener(e -> FourPointsActionPerformed(e));
                        Pune.add(FourPoints);
                    }
                    Maharashtra.add(Pune);

                    //======== Nagpur ========
                    {
                        Nagpur.setText("Nagpur");
                        Nagpur.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- LeMeridienNagpur ----
                        LeMeridienNagpur.setText("Le Meridien Nagpur");
                        LeMeridienNagpur.addActionListener(e -> LeMeridienNagpurActionPerformed(e));
                        Nagpur.add(LeMeridienNagpur);

                        //---- HotelGangakashi ----
                        HotelGangakashi.setText("Hotel Gangakashi");
                        HotelGangakashi.addActionListener(e -> HotelGangakashiActionPerformed(e));
                        Nagpur.add(HotelGangakashi);

                        //---- HotelSiddharthaInn ----
                        HotelSiddharthaInn.setText("Hotel Siddhartha Inn");
                        HotelSiddharthaInn.addActionListener(e -> HotelSiddharthaInnActionPerformed(e));
                        Nagpur.add(HotelSiddharthaInn);

                        //---- RadissonBlu ----
                        RadissonBlu.setText("Radisson Blu");
                        RadissonBlu.addActionListener(e -> RadissonBluActionPerformed(e));
                        Nagpur.add(RadissonBlu);
                    }
                    Maharashtra.add(Nagpur);

                    //======== Aurangabad ========
                    {
                        Aurangabad.setText("Aurangabad");
                        Aurangabad.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- Ambassador_Ajanta ----
                        Ambassador_Ajanta.setText("Ambassador Ajanta");
                        Ambassador_Ajanta.addActionListener(e -> Ambassador_AjantaActionPerformed(e));
                        Aurangabad.add(Ambassador_Ajanta);

                        //---- VivantaAurangabad ----
                        VivantaAurangabad.setText("Vivanta Aurangabad");
                        VivantaAurangabad.addActionListener(e -> VivantaAurangabadActionPerformed(e));
                        Aurangabad.add(VivantaAurangabad);

                        //---- THEONEHOTEL ----
                        THEONEHOTEL.setText("The One Hotel");
                        THEONEHOTEL.addActionListener(e -> THEONEHOTELActionPerformed(e));
                        Aurangabad.add(THEONEHOTEL);

                        //---- HotelAtithi ----
                        HotelAtithi.setText("Hotel Atithi");
                        HotelAtithi.addActionListener(e -> HotelAtithiActionPerformed(e));
                        Aurangabad.add(HotelAtithi);
                    }
                    Maharashtra.add(Aurangabad);
                }
                menuBar1.add(Maharashtra);

                //---- separator2 ----
                separator2.setMaximumSize(new Dimension(400, 50));
                separator2.setBackground(Color.darkGray);
                menuBar1.add(separator2);

                //---- Hotels ----
                Hotels.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
                Hotels.setToolTipText("Search for Hotels");
                Hotels.setMaximumSize(new Dimension(500, 50));
                Hotels.setMinimumSize(new Dimension(250, 35));
                Hotels.setFocusable(false);
                Hotels.setLightWeightPopupEnabled(false);
                Hotels.addActionListener(e -> HotelsActionPerformed(e));
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
                separator1.setMaximumSize(new Dimension(300, 50));
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
                        bookNow1.addActionListener(e -> bookNow1ActionPerformed(e));

                        //---- viewHotel1 ----
                        viewHotel1.setText("View Hotel");
                        viewHotel1.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        viewHotel1.setBackground(new Color(153, 0, 0));
                        viewHotel1.setForeground(new Color(238, 238, 238));
                        viewHotel1.addActionListener(e -> viewHotel1ActionPerformed(e));

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
                                .addGroup(hotelPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(hotelPhoto1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(hotelPanel1Layout.createParallelGroup()
                                        .addGroup(hotelPanel1Layout.createSequentialGroup()
                                            .addGroup(hotelPanel1Layout.createParallelGroup()
                                                .addGroup(hotelPanel1Layout.createSequentialGroup()
                                                    .addGroup(hotelPanel1Layout.createParallelGroup()
                                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label10, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(hotelPanel1Layout.createParallelGroup()
                                                        .addComponent(priceDeluxe1)
                                                        .addComponent(priceStandard1)
                                                        .addComponent(priceSuite1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(hotelPanel1Layout.createParallelGroup()
                                                        .addComponent(standardRooms1)
                                                        .addComponent(deluxeRooms)
                                                        .addComponent(suiteRooms))
                                                    .addGap(121, 121, 121))
                                                .addGroup(hotelPanel1Layout.createSequentialGroup()
                                                    .addComponent(ratingBracket1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(hotelPanel1Layout.createSequentialGroup()
                                                    .addComponent(hotelRating1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGap(258, 258, 258)))
                                            .addGroup(hotelPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(viewHotel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bookNow1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(27, 27, 27))
                                        .addGroup(hotelPanel1Layout.createSequentialGroup()
                                            .addComponent(label, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(label50, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label60)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30))
                                .addComponent(hotelName1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanel1Layout.setVerticalGroup(
                            hotelPanel1Layout.createParallelGroup()
                                .addGroup(hotelPanel1Layout.createSequentialGroup()
                                    .addContainerGap(12, Short.MAX_VALUE)
                                    .addComponent(hotelName1)
                                    .addGroup(hotelPanel1Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                            .addGroup(hotelPanel1Layout.createParallelGroup()
                                                .addComponent(hotelPhoto1, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(hotelPanel1Layout.createSequentialGroup()
                                                    .addGroup(hotelPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label)
                                                        .addComponent(label50)
                                                        .addComponent(label60))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(hotelPanel1Layout.createParallelGroup()
                                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                                            .addGroup(hotelPanel1Layout.createParallelGroup()
                                                                .addGroup(hotelPanel1Layout.createSequentialGroup()
                                                                    .addComponent(label9)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(label10)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(label11))
                                                                .addGroup(hotelPanel1Layout.createSequentialGroup()
                                                                    .addComponent(standardRooms1)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(deluxeRooms)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(suiteRooms))
                                                                .addGroup(hotelPanel1Layout.createSequentialGroup()
                                                                    .addComponent(priceStandard1)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(priceDeluxe1)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(priceSuite1)))
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(ratingBracket1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(78, 78, 78))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                                            .addComponent(viewHotel1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(bookNow1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(29, 29, 29))))))
                                        .addGroup(hotelPanel1Layout.createSequentialGroup()
                                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap())))
                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hotelRating1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
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
                        bookNow2.addActionListener(e -> bookNow2ActionPerformed(e));

                        //---- viewHotel2 ----
                        viewHotel2.setText("View Hotel");
                        viewHotel2.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        viewHotel2.setBackground(new Color(153, 0, 0));
                        viewHotel2.setForeground(new Color(238, 238, 238));
                        viewHotel2.addActionListener(e -> viewHotel2ActionPerformed(e));

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
                                .addGroup(hotelPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(hotelPhoto2, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addGroup(hotelPanel2Layout.createParallelGroup()
                                        .addGroup(hotelPanel2Layout.createSequentialGroup()
                                            .addGroup(hotelPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(hotelPanel2Layout.createSequentialGroup()
                                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(label51, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(ratingBracket2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(hotelRating2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(12, 12, 12)
                                            .addComponent(label61))
                                        .addGroup(hotelPanel2Layout.createSequentialGroup()
                                            .addGroup(hotelPanel2Layout.createParallelGroup()
                                                .addComponent(label12, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label14, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                            .addGap(32, 32, 32)
                                            .addGroup(hotelPanel2Layout.createParallelGroup()
                                                .addComponent(priceStandard2)
                                                .addComponent(priceDeluxe2)
                                                .addComponent(priceSuite2))
                                            .addGap(107, 107, 107)
                                            .addGroup(hotelPanel2Layout.createParallelGroup()
                                                .addComponent(standardRooms2)
                                                .addComponent(deluxeRooms2)
                                                .addComponent(suiteRooms2))))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(hotelPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(viewHotel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bookNow2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(27, 27, 27)
                                    .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30))
                                .addComponent(hotelName2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanel2Layout.setVerticalGroup(
                            hotelPanel2Layout.createParallelGroup()
                                .addGroup(hotelPanel2Layout.createSequentialGroup()
                                    .addContainerGap(12, Short.MAX_VALUE)
                                    .addComponent(hotelName2)
                                    .addGroup(hotelPanel2Layout.createParallelGroup()
                                        .addGroup(hotelPanel2Layout.createSequentialGroup()
                                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(24, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel2Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(hotelPanel2Layout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel2Layout.createSequentialGroup()
                                                    .addGroup(hotelPanel2Layout.createParallelGroup()
                                                        .addComponent(label2)
                                                        .addGroup(hotelPanel2Layout.createSequentialGroup()
                                                            .addGap(4, 4, 4)
                                                            .addGroup(hotelPanel2Layout.createParallelGroup()
                                                                .addComponent(label51)
                                                                .addComponent(label61))))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(hotelPanel2Layout.createParallelGroup()
                                                        .addGroup(hotelPanel2Layout.createSequentialGroup()
                                                            .addComponent(label12)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(label13)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(label14))
                                                        .addGroup(hotelPanel2Layout.createSequentialGroup()
                                                            .addComponent(priceStandard2)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(priceDeluxe2)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(priceSuite2))
                                                        .addGroup(hotelPanel2Layout.createSequentialGroup()
                                                            .addComponent(standardRooms2)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(deluxeRooms2)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(suiteRooms2)))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ratingBracket2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(hotelRating2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel2Layout.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(viewHotel2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(bookNow2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(43, 43, 43))
                                                .addGroup(hotelPanel2Layout.createSequentialGroup()
                                                    .addComponent(hotelPhoto2, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
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
                        bookNow3.addActionListener(e -> bookNow3ActionPerformed(e));

                        //---- viewHotel3 ----
                        viewHotel3.setText("View Hotel");
                        viewHotel3.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        viewHotel3.setBackground(new Color(153, 0, 0));
                        viewHotel3.setForeground(new Color(238, 238, 238));
                        viewHotel3.addActionListener(e -> viewHotel3ActionPerformed(e));

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
                                .addGroup(hotelPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(hotelPhoto3, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(hotelPanel3Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(hotelPanel3Layout.createParallelGroup()
                                                .addGroup(hotelPanel3Layout.createSequentialGroup()
                                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(label52, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(13, 13, 13)
                                                    .addComponent(label62))
                                                .addGroup(hotelPanel3Layout.createSequentialGroup()
                                                    .addComponent(label15, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(49, 49, 49)
                                                    .addComponent(priceStandard3)
                                                    .addGap(91, 91, 91)
                                                    .addComponent(standardRooms3))
                                                .addGroup(hotelPanel3Layout.createSequentialGroup()
                                                    .addComponent(label16, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(58, 58, 58)
                                                    .addComponent(priceDeluxe3)
                                                    .addGap(91, 91, 91)
                                                    .addComponent(deluxeRooms3))
                                                .addGroup(hotelPanel3Layout.createSequentialGroup()
                                                    .addComponent(label17, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(58, 58, 58)
                                                    .addComponent(priceSuite3)
                                                    .addGap(91, 91, 91)
                                                    .addComponent(suiteRooms3))))
                                        .addGroup(hotelPanel3Layout.createSequentialGroup()
                                            .addGroup(hotelPanel3Layout.createParallelGroup()
                                                .addComponent(ratingBracket3, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(hotelRating3, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)))
                                    .addGroup(hotelPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(viewHotel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bookNow3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(36, 36, 36)
                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21))
                                .addComponent(hotelName3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanel3Layout.setVerticalGroup(
                            hotelPanel3Layout.createParallelGroup()
                                .addGroup(hotelPanel3Layout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hotelName3)
                                    .addGroup(hotelPanel3Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(hotelPhoto3, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(hotelPanel3Layout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                                    .addGroup(hotelPanel3Layout.createParallelGroup()
                                                        .addComponent(label3)
                                                        .addGroup(hotelPanel3Layout.createSequentialGroup()
                                                            .addGap(3, 3, 3)
                                                            .addGroup(hotelPanel3Layout.createParallelGroup()
                                                                .addComponent(label52)
                                                                .addComponent(label62))))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(hotelPanel3Layout.createParallelGroup()
                                                        .addComponent(label15)
                                                        .addComponent(priceStandard3)
                                                        .addComponent(standardRooms3))
                                                    .addGap(17, 17, 17)
                                                    .addGroup(hotelPanel3Layout.createParallelGroup()
                                                        .addComponent(label16)
                                                        .addComponent(priceDeluxe3)
                                                        .addComponent(deluxeRooms3))
                                                    .addGap(19, 19, 19)
                                                    .addGroup(hotelPanel3Layout.createParallelGroup()
                                                        .addComponent(label17)
                                                        .addComponent(priceSuite3)
                                                        .addComponent(suiteRooms3))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(ratingBracket3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(hotelRating3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                                    .addComponent(viewHotel3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(bookNow3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(37, 37, 37))
                                                .addComponent(scrollPane4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))))
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
                        bookNow4.addActionListener(e -> bookNow4ActionPerformed(e));

                        //---- viewHotel4 ----
                        viewHotel4.setText("View Hotel");
                        viewHotel4.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        viewHotel4.setBackground(new Color(153, 0, 0));
                        viewHotel4.setForeground(new Color(238, 238, 238));
                        viewHotel4.addActionListener(e -> viewHotel4ActionPerformed(e));

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
                                .addGroup(hotelPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(hotelPhoto4, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(hotelPanel4Layout.createParallelGroup()
                                        .addComponent(ratingBracket4, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(hotelPanel4Layout.createSequentialGroup()
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(label53, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                            .addGap(13, 13, 13)
                                            .addComponent(label63))
                                        .addGroup(hotelPanel4Layout.createSequentialGroup()
                                            .addComponent(label18, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                            .addGap(49, 49, 49)
                                            .addComponent(priceStandard4)
                                            .addGap(91, 91, 91)
                                            .addComponent(standardRooms4))
                                        .addGroup(hotelPanel4Layout.createSequentialGroup()
                                            .addComponent(label19, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                            .addGap(58, 58, 58)
                                            .addComponent(priceDeluxe4)
                                            .addGap(91, 91, 91)
                                            .addComponent(deluxeRooms4))
                                        .addGroup(hotelPanel4Layout.createSequentialGroup()
                                            .addComponent(label20, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                            .addGap(58, 58, 58)
                                            .addComponent(priceSuite4)
                                            .addGap(91, 91, 91)
                                            .addComponent(suiteRooms4))
                                        .addComponent(hotelRating4, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                    .addGroup(hotelPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(viewHotel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bookNow4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(36, 36, 36)
                                    .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21))
                                .addComponent(hotelName4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanel4Layout.setVerticalGroup(
                            hotelPanel4Layout.createParallelGroup()
                                .addGroup(hotelPanel4Layout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hotelName4)
                                    .addGroup(hotelPanel4Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(hotelPhoto4, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(hotelPanel4Layout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                                    .addGroup(hotelPanel4Layout.createParallelGroup()
                                                        .addComponent(label4)
                                                        .addGroup(hotelPanel4Layout.createSequentialGroup()
                                                            .addGap(3, 3, 3)
                                                            .addGroup(hotelPanel4Layout.createParallelGroup()
                                                                .addComponent(label53)
                                                                .addComponent(label63))))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(hotelPanel4Layout.createParallelGroup()
                                                        .addComponent(label18)
                                                        .addComponent(priceStandard4)
                                                        .addComponent(standardRooms4))
                                                    .addGap(17, 17, 17)
                                                    .addGroup(hotelPanel4Layout.createParallelGroup()
                                                        .addComponent(label19)
                                                        .addComponent(priceDeluxe4)
                                                        .addComponent(deluxeRooms4))
                                                    .addGap(19, 19, 19)
                                                    .addGroup(hotelPanel4Layout.createParallelGroup()
                                                        .addComponent(label20)
                                                        .addComponent(priceSuite4)
                                                        .addComponent(suiteRooms4))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(ratingBracket4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(hotelRating4, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                                    .addComponent(viewHotel4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(bookNow4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(37, 37, 37))
                                                .addComponent(scrollPane5, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap())
                        );
                    }

                    GroupLayout homePanelLayout = new GroupLayout(homePanel);
                    homePanel.setLayout(homePanelLayout);
                    homePanelLayout.setHorizontalGroup(
                        homePanelLayout.createParallelGroup()
                            .addComponent(hotelPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(homePanelLayout.createParallelGroup()
                                    .addComponent(hotelPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hotelPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hotelPanel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                    );
                    homePanelLayout.setVerticalGroup(
                        homePanelLayout.createParallelGroup()
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hotelPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hotelPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hotelPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hotelPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(313, Short.MAX_VALUE))
                    );
                }
                scrollPane1.setViewportView(homePanel);
            }

            GroupLayout displayTableContentPaneLayout = new GroupLayout(displayTableContentPane);
            displayTableContentPane.setLayout(displayTableContentPaneLayout);
            displayTableContentPaneLayout.setHorizontalGroup(
                displayTableContentPaneLayout.createParallelGroup()
                    .addGroup(displayTableContentPaneLayout.createSequentialGroup()
                        .addGroup(displayTableContentPaneLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menuBar1, GroupLayout.DEFAULT_SIZE, 1529, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1529, Short.MAX_VALUE))
                        .addContainerGap())
            );
            displayTableContentPaneLayout.setVerticalGroup(
                displayTableContentPaneLayout.createParallelGroup()
                    .addGroup(displayTableContentPaneLayout.createSequentialGroup()
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1492, Short.MAX_VALUE))
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
    private JMenu Telangana;
    private JMenu Hyderabad;
    private JMenuItem itckohenur;
    private JMenuItem ThePark;
    private JMenuItem TajVivanta;
    private JMenuItem manasarovar;
    private JMenu Warangal;
    private JMenuItem HotelAshoka;
    private JMenuItem CrystalPalace;
    private JMenuItem Landmark;
    private JMenuItem Suprabha;
    private JMenu Karimnagar;
    private JMenuItem HotelAditya;
    private JMenuItem HotelAkshaya;
    private JMenuItem TheBudgetHotel;
    private JMenuItem HotelSwetha;
    private JMenu Kammam;
    private JMenuItem Gayathri;
    private JMenuItem Kaveri;
    private JMenuItem Manasarovar;
    private JMenuItem Onagiri;
    private JMenu Andhra_Pradesh;
    private JMenu Vijayawada;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenu Guntur;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenuItem menuItem8;
    private JMenuItem menuItem9;
    private JMenu Tirupati;
    private JMenuItem menuItem5;
    private JMenuItem menuItem10;
    private JMenuItem menuItem11;
    private JMenuItem menuItem12;
    private JMenu Vizag;
    private JMenuItem menuItem13;
    private JMenuItem menuItem14;
    private JMenuItem menuItem15;
    private JMenuItem menuItem16;
    private JMenu New_Delhi;
    private JMenu New_Delhi_City;
    private JMenuItem menuItem33;
    private JMenuItem menuItem34;
    private JMenuItem menuItem35;
    private JMenuItem menuItem36;
    private JMenu Panipat;
    private JMenuItem menuItem37;
    private JMenuItem menuItem38;
    private JMenuItem menuItem39;
    private JMenuItem menuItem40;
    private JMenu Gurugram;
    private JMenuItem menuItem41;
    private JMenuItem menuItem42;
    private JMenuItem menuItem43;
    private JMenuItem menuItem44;
    private JMenu Faridabad;
    private JMenuItem menuItem45;
    private JMenuItem menuItem46;
    private JMenuItem menuItem47;
    private JMenuItem menuItem48;
    private JMenu Maharashtra;
    private JMenu Mumbai;
    private JMenuItem GingerMumbaiAndheri;
    private JMenuItem IbisMumbaiAirport;
    private JMenuItem TridentNarimanPoint;
    private JMenuItem RoyalOrchidCentralGrazia;
    private JMenu Pune;
    private JMenuItem MintKoregaonPark;
    private JMenuItem TajGateway;
    private JMenuItem HotelMintHighstreet;
    private JMenuItem FourPoints;
    private JMenu Nagpur;
    private JMenuItem LeMeridienNagpur;
    private JMenuItem HotelGangakashi;
    private JMenuItem HotelSiddharthaInn;
    private JMenuItem RadissonBlu;
    private JMenu Aurangabad;
    private JMenuItem Ambassador_Ajanta;
    private JMenuItem VivantaAurangabad;
    private JMenuItem THEONEHOTEL;
    private JMenuItem HotelAtithi;
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
