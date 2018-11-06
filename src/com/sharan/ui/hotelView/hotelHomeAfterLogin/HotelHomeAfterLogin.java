/*
 * Created by JFormDesigner on Sat Nov 03 16:09:05 IST 2018
 */

package com.sharan.ui.hotelView.hotelHomeAfterLogin;

import com.sharan.DataBaseController;
import com.sharan.ui.hotelView.hotelHome.beforeLogin.HotelHomePageBeforeLogin;
import com.sharan.ui.hotelView.hotelHome.rating.Rating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import static com.sharan.Main.starUpdate;

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
    private JButton ratingConfirm;


    public HotelHomeAfterLogin(ArrayList<String> list, DataBaseController dataBaseController) {

        this.list=list;

        this.uniqueId=list.get(0);
        this.dataBaseController=dataBaseController;
        this.hotelName=list.get(1);
        this.description=list.get(2);
        this.address=list.get(3);
        this.hotelMainImagePath=list.get(4);
        this.numberOfVotes=list.get(5);

        dataBaseController.initialiseDatabase();
        rate=dataBaseController.calculateRating(uniqueId);
        String rateString=String.valueOf(rate);
        starRatingPath="/com/sharan/ui/pictures/stars/"+rateString+".jpg";
        dataBaseController.closeDatabaseConnection();

        initComponents();
        addToUniversalHotelSearch();
        hotelPhoto.setIcon(new ImageIcon(getClass().getResource(hotelMainImagePath)));
        ratingLabel.setIcon(new ImageIcon(getClass().getResource(starRatingPath)));
        contactDetails.setText(address);
        hotelDetails.setText(description);
        Title.setText(hotelName);
        numberOfRatings.setText(numberOfVotes+" people rated this");

        individualHotelHome.setVisible(true);

    }

    private void addToUniversalHotelSearch() {
        dataBaseController.initialiseDatabase();
        ArrayList<String> list=dataBaseController.getUniversalSearchData();
        dataBaseController.closeDatabaseConnection();
        for(String str:list) {
            Hotels.addItem(str);
        }
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

    private void HotelsItemStateChanged(ItemEvent e) {
            dataBaseController.initialiseDatabase();
            ArrayList<String> list=dataBaseController.getUniversalSearchData();
            dataBaseController.closeDatabaseConnection();
            for(String str:list) {
                Hotels.addItem(str);
            }
    }


//********ButtonFields****************************************
    private void LogoutFieldActionPerformed(ActionEvent e) {
        dataBaseController.initialiseDatabase();
        HotelHomePageBeforeLogin beforeLogin=new HotelHomePageBeforeLogin(list,dataBaseController);
        dataBaseController.closeDatabaseConnection();
    }

    private void rateYourExperienceActionPerformed(ActionEvent e) {
        starUpdate=1;
        dataBaseController.initialiseDatabase();
        Rating rating=new Rating(uniqueId,dataBaseController,rateYourExperience);
        rate=dataBaseController.calculateRating(uniqueId);

        String rateString=String.valueOf(rate);
        starRatingPath="/com/sharan/ui/pictures/stars/"+rateString+".jpg";
        ratingLabel.setIcon(new ImageIcon(getClass().getResource(starRatingPath)));
        System.out.println(rate);
        System.out.println(starRatingPath);
        dataBaseController.closeDatabaseConnection();
    }

    private void checkAvailabilityActionPerformed(ActionEvent e) {
        // TODO add your code here
    }



//********ButtonFields****************************************

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        individualHotelHome = new JFrame();
        menuBar = new JMenuBar();
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
        separator1 = new JSeparator();
        Hotels = new JComboBox();
        Search = new JButton();
        menu2 = new JMenu();
        myAccountField = new JMenuItem();
        LogoutField = new JMenuItem();
        separator3 = new JSeparator();
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
            Container individualHotelHomeContentPane = individualHotelHome.getContentPane();

            //======== menuBar ========
            {
                menuBar.setPreferredSize(new Dimension(83, 50));
                menuBar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
                menuBar.setBackground(Color.darkGray);
                menuBar.setForeground(new Color(238, 238, 238));

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
                menuBar.add(Telangana);

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
                menuBar.add(Andhra_Pradesh);

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
                menuBar.add(Maharastra);

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
                menuBar.add(New_Delhi);

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

                //---- separator3 ----
                separator3.setMaximumSize(new Dimension(150, 32767));
                menuBar.add(separator3);
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
    private JSeparator separator1;
    private JComboBox Hotels;
    private JButton Search;
    private JMenu menu2;
    private JMenuItem myAccountField;
    private JMenuItem LogoutField;
    private JSeparator separator3;
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
