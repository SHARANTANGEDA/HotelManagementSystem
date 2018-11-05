/*
 * Created by JFormDesigner on Sat Nov 03 21:40:23 IST 2018
 */

package com.sharan.ui.hotelView.displaySelectedHotels;

import com.sharan.DataBaseController;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author SAI SHARAN
 */
public class DisplaySelectedHotels {

    private String state;
    private String city;
    private String checkIN;
    private String checkOUT;
    private String noOfRooms;
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
//
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
        this.city=list.get(2);
        this.checkIN=list.get(3);
        this.checkOUT=list.get(4);
        this.noOfRooms=list.get(5);
        this.dataBaseController=dataBaseController;


        initComponents();

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

        {//hotel1************************************************************************************
            ElementsInHotelView elements = displayList.get(0);
            hotelPhoto1.setIcon(new ImageIcon(getClass().getResource(elements.getImagePath())));
            hotelName1.setText(elements.getHotelName());

            if (Integer.parseInt(noOfRooms) > elements.getStandardRoomCapacity()) {
                priceStandard1.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getStandardRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceStandard1.setText(totalPriceString);
            }

            if (Integer.parseInt(noOfRooms) > elements.getDeluxeRoomCapacity()) {
                priceDeluxe1.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getDeluxeRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceDeluxe1.setText(totalPriceString);
            }


            if (Integer.parseInt(noOfRooms) > elements.getSuiteRoomCapacity()) {
                priceSuite1.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getSuiteRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceSuite1.setText(totalPriceString);
            }

            hotelRating1.setText("ToBeAddedLater");
            ratingBracket1.setText("Rating(" + String.valueOf(elements.getNumberOfVotes()) + ")");
            //hotel1************************************************************************************
        }


        {
            //hotel2************************************************************************************
            ElementsInHotelView elements = displayList.get(1);
            hotelPhoto2.setIcon(new ImageIcon(getClass().getResource(elements.getImagePath())));
            hotelName2.setText(elements.getHotelName());

            if (Integer.parseInt(noOfRooms) > elements.getStandardRoomCapacity()) {
                priceStandard2.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getStandardRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceStandard2.setText(totalPriceString);
            }

            if (Integer.parseInt(noOfRooms) > elements.getDeluxeRoomCapacity()) {
                priceDeluxe2.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getDeluxeRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceDeluxe2.setText(totalPriceString);
            }


            if (Integer.parseInt(noOfRooms) > elements.getSuiteRoomCapacity()) {
                priceSuite2.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getSuiteRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceSuite2.setText(totalPriceString);
            }

            hotelRating2.setText("ToBeAddedLater");
            ratingBracket2.setText("Rating(" + String.valueOf(elements.getNumberOfVotes()) + ")");
            //hotel2************************************************************************************
        }

        {
            //hotel3************************************************************************************
            ElementsInHotelView elements = displayList.get(2);
            hotelPhoto3.setIcon(new ImageIcon(getClass().getResource(elements.getImagePath())));
            hotelName3.setText(elements.getHotelName());

            if (Integer.parseInt(noOfRooms) > elements.getStandardRoomCapacity()) {
                priceStandard3.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getStandardRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceStandard3.setText(totalPriceString);
            }

            if (Integer.parseInt(noOfRooms) > elements.getDeluxeRoomCapacity()) {
                priceDeluxe3.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getDeluxeRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceDeluxe3.setText(totalPriceString);
            }


            if (Integer.parseInt(noOfRooms) > elements.getSuiteRoomCapacity()) {
                priceSuite3.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getSuiteRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceSuite3.setText(totalPriceString);
            }

            hotelRating3.setText("ToBeAddedLater");
            ratingBracket3.setText("Rating(" + String.valueOf(elements.getNumberOfVotes()) + ")");
            //hotel3************************************************************************************
        }

        {
            //hotel4************************************************************************************
            ElementsInHotelView elements = displayList.get(3);
            hotelPhoto4.setIcon(new ImageIcon(getClass().getResource(elements.getImagePath())));
            hotelName4.setText(elements.getHotelName());

            if (Integer.parseInt(noOfRooms) > elements.getStandardRoomCapacity()) {
                priceStandard4.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getStandardRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceStandard4.setText(totalPriceString);
            }

            if (Integer.parseInt(noOfRooms) > elements.getDeluxeRoomCapacity()) {
                priceDeluxe4.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getDeluxeRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceDeluxe4.setText(totalPriceString);
            }


            if (Integer.parseInt(noOfRooms) > elements.getSuiteRoomCapacity()) {
                priceSuite4.setText("Not Enough Rooms Available");
            } else {
                int totalPrice = (Integer.parseInt(noOfRooms)) * (Integer.parseInt(elements.getSuiteRoomPrice()));
                String totalPriceString = String.valueOf(totalPrice);
                priceSuite4.setText(totalPriceString);
            }

            hotelRating4.setText("ToBeAddedLater");
            ratingBracket4.setText("Rating(" + String.valueOf(elements.getNumberOfVotes()) + ")");
            //hotel4************************************************************************************
        }



        displayTable.setVisible(true);
        AutoCompleteDecorator.decorate(Hotels);


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

    private void SearchActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void LogoutActionPerformed(ActionEvent e) {
        // TODO add your code here
    }



//
//private void addRowsToTable(JTable table) {
//        table.
//}

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
        Maharastra = new JMenu();
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
        hotelPanel2 = new JPanel();
        hotelPhoto2 = new JLabel();
        hotelName2 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        priceStandard2 = new JLabel();
        priceDeluxe2 = new JLabel();
        priceSuite2 = new JLabel();
        hotelRating2 = new JLabel();
        ratingBracket2 = new JLabel();
        scrollPane3 = new JScrollPane();
        description2 = new JTextPane();
        bookNow2 = new JButton();
        hotelPanel3 = new JPanel();
        hotelPhoto3 = new JLabel();
        hotelName3 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        priceStandard3 = new JLabel();
        priceDeluxe3 = new JLabel();
        priceSuite3 = new JLabel();
        hotelRating3 = new JLabel();
        ratingBracket3 = new JLabel();
        scrollPane4 = new JScrollPane();
        description3 = new JTextPane();
        bookNow3 = new JButton();
        hotelPanel4 = new JPanel();
        hotelPhoto4 = new JLabel();
        hotelName4 = new JLabel();
        label21 = new JLabel();
        label22 = new JLabel();
        label23 = new JLabel();
        priceStandard4 = new JLabel();
        priceDeluxe4 = new JLabel();
        priceSuite4 = new JLabel();
        hotelRating4 = new JLabel();
        ratingBracket4 = new JLabel();
        scrollPane5 = new JScrollPane();
        textPane4 = new JTextPane();
        bookNow4 = new JButton();

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

                //======== Maharastra ========
                {
                    Maharastra.setText("Maharastra");
                    Maharastra.setPreferredSize(new Dimension(110, 50));
                    Maharastra.setFont(new Font("Arial", Font.BOLD, 18));
                    Maharastra.setForeground(new Color(238, 238, 238));

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
                    Maharastra.add(Mumbai);

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
                    Maharastra.add(Pune);

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
                    Maharastra.add(Nagpur);

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
                    Maharastra.add(Aurangabad);
                }
                menuBar1.add(Maharastra);

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
                separator1.setMaximumSize(new Dimension(400, 50));
                separator1.setBackground(Color.darkGray);
                menuBar1.add(separator1);

                //======== profile ========
                {
                    profile.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                    //---- myAccount ----
                    myAccount.setText("text");
                    profile.add(myAccount);

                    //---- Logout ----
                    Logout.setText("Logout");
                    Logout.setFont(new Font("Arial", Font.PLAIN, 18));
                    Logout.addActionListener(e -> LogoutActionPerformed(e));
                    profile.add(Logout);
                }
                menuBar1.add(profile);
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
                        hotelRating1.setText("_Rating here__");

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
                                            .addGroup(hotelPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(label9, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                                .addComponent(label10, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(hotelPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(priceDeluxe1)
                                                .addComponent(priceStandard1, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                .addComponent(priceSuite1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(hotelPanel1Layout.createSequentialGroup()
                                            .addGroup(hotelPanel1Layout.createParallelGroup()
                                                .addComponent(hotelRating1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(hotelPanel1Layout.createSequentialGroup()
                                                    .addGap(27, 27, 27)
                                                    .addComponent(ratingBracket1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bookNow1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(27, 27, 27)
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
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addGroup(hotelPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label9)
                                                .addComponent(priceStandard1))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(hotelPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label10)
                                                .addComponent(priceDeluxe1))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(hotelPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label11)
                                                .addComponent(priceSuite1))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                            .addGroup(hotelPanel1Layout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                                    .addComponent(ratingBracket1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(hotelRating1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel1Layout.createSequentialGroup()
                                                    .addComponent(bookNow1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(37, 37, 37))))
                                        .addComponent(hotelPhoto1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
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

                        //---- label13 ----
                        label13.setText("standard");
                        label13.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label14 ----
                        label14.setText("deluxe");
                        label14.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label15 ----
                        label15.setText("suite");
                        label15.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceStandard2 ----
                        priceStandard2.setText("text");
                        priceStandard2.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceDeluxe2 ----
                        priceDeluxe2.setText("text");
                        priceDeluxe2.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceSuite2 ----
                        priceSuite2.setText("text");
                        priceSuite2.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- hotelRating2 ----
                        hotelRating2.setText("_Rating here__");

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

                        GroupLayout hotelPanel2Layout = new GroupLayout(hotelPanel2);
                        hotelPanel2.setLayout(hotelPanel2Layout);
                        hotelPanel2Layout.setHorizontalGroup(
                            hotelPanel2Layout.createParallelGroup()
                                .addGroup(hotelPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(hotelPhoto2, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(hotelPanel2Layout.createParallelGroup()
                                        .addGroup(hotelPanel2Layout.createSequentialGroup()
                                            .addGroup(hotelPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(label13, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                                .addComponent(label14, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(hotelPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(priceDeluxe2)
                                                .addComponent(priceStandard2, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                .addComponent(priceSuite2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(hotelPanel2Layout.createSequentialGroup()
                                            .addGroup(hotelPanel2Layout.createParallelGroup()
                                                .addComponent(hotelRating2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(hotelPanel2Layout.createSequentialGroup()
                                                    .addGap(27, 27, 27)
                                                    .addComponent(ratingBracket2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bookNow2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
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
                                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel2Layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addGroup(hotelPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label13)
                                                .addComponent(priceStandard2))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(hotelPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label14)
                                                .addComponent(priceDeluxe2))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(hotelPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label15)
                                                .addComponent(priceSuite2))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                            .addGroup(hotelPanel2Layout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel2Layout.createSequentialGroup()
                                                    .addComponent(ratingBracket2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(hotelRating2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel2Layout.createSequentialGroup()
                                                    .addComponent(bookNow2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(37, 37, 37))))
                                        .addComponent(hotelPhoto2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
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

                        //---- label17 ----
                        label17.setText("standard");
                        label17.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label18 ----
                        label18.setText("deluxe");
                        label18.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label19 ----
                        label19.setText("suite");
                        label19.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceStandard3 ----
                        priceStandard3.setText("text");
                        priceStandard3.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceDeluxe3 ----
                        priceDeluxe3.setText("text");
                        priceDeluxe3.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceSuite3 ----
                        priceSuite3.setText("text");
                        priceSuite3.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- hotelRating3 ----
                        hotelRating3.setText("_Rating here__");

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

                        GroupLayout hotelPanel3Layout = new GroupLayout(hotelPanel3);
                        hotelPanel3.setLayout(hotelPanel3Layout);
                        hotelPanel3Layout.setHorizontalGroup(
                            hotelPanel3Layout.createParallelGroup()
                                .addGroup(hotelPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(hotelPhoto3, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(hotelPanel3Layout.createParallelGroup()
                                        .addGroup(hotelPanel3Layout.createSequentialGroup()
                                            .addGroup(hotelPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(label17, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                                .addComponent(label18, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(hotelPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(priceDeluxe3)
                                                .addComponent(priceStandard3, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                .addComponent(priceSuite3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(hotelPanel3Layout.createSequentialGroup()
                                            .addGroup(hotelPanel3Layout.createParallelGroup()
                                                .addComponent(hotelRating3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(hotelPanel3Layout.createSequentialGroup()
                                                    .addGap(27, 27, 27)
                                                    .addComponent(ratingBracket3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bookNow3, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(27, 27, 27)
                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30))
                                .addComponent(hotelName3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanel3Layout.setVerticalGroup(
                            hotelPanel3Layout.createParallelGroup()
                                .addGroup(hotelPanel3Layout.createSequentialGroup()
                                    .addContainerGap(12, Short.MAX_VALUE)
                                    .addComponent(hotelName3)
                                    .addGroup(hotelPanel3Layout.createParallelGroup()
                                        .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addGroup(hotelPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label17)
                                                .addComponent(priceStandard3))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(hotelPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label18)
                                                .addComponent(priceDeluxe3))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(hotelPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label19)
                                                .addComponent(priceSuite3))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                            .addGroup(hotelPanel3Layout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                                    .addComponent(ratingBracket3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(hotelRating3, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel3Layout.createSequentialGroup()
                                                    .addComponent(bookNow3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(37, 37, 37))))
                                        .addComponent(hotelPhoto3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
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

                        //---- label21 ----
                        label21.setText("standard");
                        label21.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label22 ----
                        label22.setText("deluxe");
                        label22.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- label23 ----
                        label23.setText("suite");
                        label23.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceStandard4 ----
                        priceStandard4.setText("text");
                        priceStandard4.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceDeluxe4 ----
                        priceDeluxe4.setText("text");
                        priceDeluxe4.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- priceSuite4 ----
                        priceSuite4.setText("text");
                        priceSuite4.setFont(new Font("Droid Sans Mono", Font.BOLD, 20));

                        //---- hotelRating4 ----
                        hotelRating4.setText("_Rating here__");

                        //---- ratingBracket4 ----
                        ratingBracket4.setText("Rating");
                        ratingBracket4.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 22));

                        //======== scrollPane5 ========
                        {

                            //---- textPane4 ----
                            textPane4.setBackground(new Color(238, 238, 238));
                            scrollPane5.setViewportView(textPane4);
                        }

                        //---- bookNow4 ----
                        bookNow4.setText("Book Now");
                        bookNow4.setFont(new Font("Droid Sans Mono Slashed", Font.BOLD, 24));
                        bookNow4.setBackground(new Color(153, 0, 0));
                        bookNow4.setForeground(new Color(238, 238, 238));

                        GroupLayout hotelPanel4Layout = new GroupLayout(hotelPanel4);
                        hotelPanel4.setLayout(hotelPanel4Layout);
                        hotelPanel4Layout.setHorizontalGroup(
                            hotelPanel4Layout.createParallelGroup()
                                .addGroup(hotelPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(hotelPhoto4, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(hotelPanel4Layout.createParallelGroup()
                                        .addGroup(hotelPanel4Layout.createSequentialGroup()
                                            .addGroup(hotelPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(label21, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                                .addComponent(label22, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label23, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(hotelPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(priceDeluxe4)
                                                .addComponent(priceStandard4, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                .addComponent(priceSuite4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(hotelPanel4Layout.createSequentialGroup()
                                            .addGroup(hotelPanel4Layout.createParallelGroup()
                                                .addComponent(hotelRating4, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(hotelPanel4Layout.createSequentialGroup()
                                                    .addGap(27, 27, 27)
                                                    .addComponent(ratingBracket4, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bookNow4, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(27, 27, 27)
                                    .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30))
                                .addComponent(hotelName4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        hotelPanel4Layout.setVerticalGroup(
                            hotelPanel4Layout.createParallelGroup()
                                .addGroup(hotelPanel4Layout.createSequentialGroup()
                                    .addContainerGap(12, Short.MAX_VALUE)
                                    .addComponent(hotelName4)
                                    .addGroup(hotelPanel4Layout.createParallelGroup()
                                        .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addGroup(hotelPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label21)
                                                .addComponent(priceStandard4))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(hotelPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label22)
                                                .addComponent(priceDeluxe4))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(hotelPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label23)
                                                .addComponent(priceSuite4))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                            .addGroup(hotelPanel4Layout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                                    .addComponent(ratingBracket4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(hotelRating4, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, hotelPanel4Layout.createSequentialGroup()
                                                    .addComponent(bookNow4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(37, 37, 37))))
                                        .addComponent(hotelPhoto4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
                        );
                    }

                    GroupLayout homePanelLayout = new GroupLayout(homePanel);
                    homePanel.setLayout(homePanelLayout);
                    homePanelLayout.setHorizontalGroup(
                        homePanelLayout.createParallelGroup()
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(homePanelLayout.createParallelGroup()
                                    .addComponent(hotelPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hotelPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hotelPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hotelPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                    );
                    homePanelLayout.setVerticalGroup(
                        homePanelLayout.createParallelGroup()
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hotelPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hotelPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hotelPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(hotelPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(82, Short.MAX_VALUE))
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
    private JMenu Maharastra;
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
    private JPanel hotelPanel2;
    private JLabel hotelPhoto2;
    private JLabel hotelName2;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel priceStandard2;
    private JLabel priceDeluxe2;
    private JLabel priceSuite2;
    private JLabel hotelRating2;
    private JLabel ratingBracket2;
    private JScrollPane scrollPane3;
    private JTextPane description2;
    private JButton bookNow2;
    private JPanel hotelPanel3;
    private JLabel hotelPhoto3;
    private JLabel hotelName3;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel priceStandard3;
    private JLabel priceDeluxe3;
    private JLabel priceSuite3;
    private JLabel hotelRating3;
    private JLabel ratingBracket3;
    private JScrollPane scrollPane4;
    private JTextPane description3;
    private JButton bookNow3;
    private JPanel hotelPanel4;
    private JLabel hotelPhoto4;
    private JLabel hotelName4;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JLabel priceStandard4;
    private JLabel priceDeluxe4;
    private JLabel priceSuite4;
    private JLabel hotelRating4;
    private JLabel ratingBracket4;
    private JScrollPane scrollPane5;
    private JTextPane textPane4;
    private JButton bookNow4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
