/*
 * Created by JFormDesigner on Tue Oct 30 12:03:37 IST 2018
 */

package com.sharan.ui.home.homePageAfterLogin;

import com.sharan.DataBaseController;
import com.sharan.ui.home.homePage.HomePage;
import com.sharan.ui.hotelView.hotelHome.HotelHomePageAfterLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author SAI SHARAN
 */
public class HomePageAfterLogin {
    private DataBaseController dataBaseController;

    public HomePageAfterLogin(DataBaseController dataBaseController) {
        this.dataBaseController=dataBaseController;
        initComponents();
    }



    private void LoginActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void SignUpActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void LogoutActionPerformed(ActionEvent e) {
        homePageAfterLogin.dispose();
        homePageAfterLogin.setVisible(false);
        HomePage homePage=new HomePage(dataBaseController);

    }

    private void Hotel_Hyderabad_1ActionPerformed(ActionEvent e) {
        // TODO add your code here
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

        ArrayList<String> list=dataBaseController.parseHotel("");

        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(list,dataBaseController);

//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Mu_Ginger","Ginger Mumbai Andheri","room type-\n" +
//                "standard : 2474\n" +
//                "deluxe   : 5219\n" +
//                "suite    : 6176",
//                "address:\n" +
//                        "Rajashree Sahu Marg, Andheri East, Mumbai, Maharashtra 400069",
//                "/com/sharan/ui/pictures/Maharashtra/Mumbai/Ginger/Ma_Mu_GingerA.jpg",
//                dataBaseController
//        );
    }

    private void IbisMumbaiAirportActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Mu_Ibis","Ibis Mumbai","room type-\n" +
//                "standard :6199\n" +
//                "deluxe   :6699",
//                "address:\n" +
//                        "F77, Western Express Hwy, Navpada, Vile Parle East, Vile Parle, Mumbai, Maharashtra 400099 ",
//                "/com/sharan/ui/pictures/Maharashtra/Mumbai/Ibis/Ma_Mu_IbisA.jpg"
//                ,dataBaseController
//        );
    }

    private void TridentNarimanPointActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Mu_Trident","Trident Hotel","room type-\n" +
//                "standard :11875\n" +
//                "suite    :21625","address:\n" +
//                "CR 2 Nariman Point, Netaji Subhash Chandra Bose Road, Mumbai, Maharashtra 400021\n",
//                "/com/sharan/ui/pictures/Maharashtra/Mumbai/Trident/Ma_Mu_TridentA.jpg",
//                dataBaseController
//        );
    }

    private void RoyalOrchidCentralGraziaActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin = new HotelHomePageAfterLogin(
//                "Ma_Mu_Royal","Royal Orchid Central","room type-\n" +
//                "standard :4979\n" +
//                "deluxe   :5134\n" +
//                "suite    :6125","address:\n" +
//                "Plot No. 67, Palm Beach Road, Sector 19, Vashi, Near Truck Terminal, Navi Mumbai, Maharashtra 400705",
//                "/com/sharan/ui/pictures/Maharashtra/Mumbai/Royal Orchard/Ma_Mu_RoyalA.jpg",dataBaseController
//        );
    }

    private void MintKoregaonParkActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Pu_Mint","Mint Koregaon Park","room type- (all include a/c, have complimentary breakfast, and have free hi-speed wifi)\n" +
//                "standard : rs 1981      (Code: A)\n" +
//                "deluxe   : rs 2228      (Code: B)\n" +
//                "suite    : rs 2807\t(Code: C)\n","address:\n" +
//                "Plot Nos 11 Lane Nos 1 | Near Osho International Resort & Commune, Koregaon Park, Pune 411001, India",
//                "/com/sharan/ui/pictures/Maharashtra/Pune/Mint Koregaon Park/Ma_Pu_MintA.jpg",
//                dataBaseController
//        );
    }

    private void TajGatewayActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Pu_Taj","Taj Gateway","room type-\n" +
//                "standard : rs 5825\n" +
//                "suite    : rs 7025","address:\n" +
//                "Xion Complex, Wakad Road, Hinjewadi, Pune, Maharashtra 411057",
//                "/com/sharan/ui/pictures/Maharashtra/Pune/Taj Gateway/Ma_Pu_TajA.jpg",
//                dataBaseController
//        );
    }

    private void HotelMintHighstreetActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Pu_High","Hotel Mint Highstreet","room type-\n" +
//                "standard : rs 1199\n" +
//                "deluxe   : rs 1620\n","address:\n" +
//                "Plot No. 37 and 40, Survey Number.33, Hissa No. 1 / 4, Taluka Haveli, Balewadi, Pune 411045",
//                "/com/sharan/ui/pictures/Maharashtra/Pune/Hotel Mint Highstreet/Ma_Pu_HighA.jpg",dataBaseController
//        );
    }

    private void FourPointsActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Pu_Four","Four Points","room type-\n" +
//                "standard: rs 5875\n" +
//                "deluxe  : rs 6500\n" +
//                "suite   : rs 7500","address:\n" +
//                "5th Mile Stone, Nagar Rd, Pune, Maharashtra 411014",
//                "/com/sharan/ui/pictures/Maharashtra/Pune/Four Points/Ma_Pu_FourA.jpg",
//                dataBaseController
//        );
    }

    private void LeMeridienNagpurActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Na_Mer","Le Meridien","room type-\n" +
//                "standard : 6999\n" +
//                "deluxe   : 7999\n" +
//                "suite    : 8999","address:\n" +
//                "Wardha Road, Flyover, Mihan, Opp, Nagpur, Maharashtra 441108",
//                "/com/sharan/ui/pictures/Maharashtra/Nagpur/Meridien/Ma_Na_MerA.jpg",dataBaseController);

    }

    private void HotelGangakashiActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Na_Gang","Hotel Gangakashi","room type-\n" +
//                "standard :2409\n" +
//                "deluxe   :3408\n" +
//                "suite    :3763","address:\n" +
//                "Hotel Gangakashi, Right Beside Cinemax (Enternity Mall), variety square, Sitabuldi Nagpur - 440012",
//                "/com/sharan/ui/pictures/Maharashtra/Nagpur/Gangakashi/Ma_Na_GangA.jpg",dataBaseController
//        );
    }

    private void HotelSiddharthaInnActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Na_Sid","Hotel Siddhartha Inn","room type-\n" +
//                "standard : 984\n" +
//                "deluxe   : 1000"
//                ,"address:\n" +
//                "90, Central Avenue,Near Agrasen Square,Gandhibagh, Nagpur",
//                "/com/sharan/ui/pictures/Maharashtra/Nagpur/Siddhartha/Ma_Na_SidA.jpg",
//                dataBaseController
//        );
    }

    private void RadissonBluActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Na_Blu","Radisson Blu","room type-\n" +
//                "standard :4876\n" +
//                "deluxe   :6825\n" +
//                "suite    :12995\n",
//                "address:\n" +
//                        "Enrico Heights, 7, Wardha Rd, Nagpur, Maharashtra 440015",
//                "/com/sharan/ui/pictures/Maharashtra/Nagpur/Radisson/Ma_Na_BluA.jpg",
//                dataBaseController
//        );
    }

    private void Ambassador_AjantaActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin homePageAfterLogin=new HotelHomePageAfterLogin("Ma_Au_Ajanta",
//                "Ambassador Ajanta",
//                "room type-\n" +
//                        "standard :3370\n" +
//                        "deluxe   :3883\n" +
//                        "suite    :6910",
//                "address:\n" +
//                        "Jalna Road, CIDCO,Aurangabad-431 003",
//                "/com/sharan/ui/pictures/Maharashtra/Aurangabad/Ajanta/Ma_Au_AjantaA.jpg",dataBaseController);
    }

    private void VivantaAurangabadActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Au_Vivan","Vivanta Aurangabad","room type-\n" +
//                "standard :7095\n" +
//                "deluxe   :8350\n" +
//                "suite    :10500","address:\n" +
//                "8 N 12, Dr. Rafiq Zakaria Marg, Rauza Bagh",
//                "/com/sharan/ui/pictures/Maharashtra/Aurangabad/Vivanta/Ma_Au_VivanA.jpg",
//                dataBaseController
//        );
    }

    private void THEONEHOTELActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Au_One","The One Hotel","room type-\n" +
//                "standard :7095\n" +
//                "deluxe   :8350\n" +
//                "suite    :10500",
//                "address:\n" +
//                        "8 N 12, Dr. Rafiq Zakaria Marg, Rauza Bagh",
//                "/com/sharan/ui/pictures/Maharashtra/Aurangabad/One/Ma_Au_OneA.jpg",
//                dataBaseController
//        );
    }

    private void HotelAtithiActionPerformed(ActionEvent e) {
//        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(
//                "Ma_Au_Athithi","Hotel Atithi","room type-\n" +
//                "standard :2262\n" +
//                "deluxe   :3744\n" +
//                "suite    :4900","address:\n" +
//                "P-3, Jalna Road, Seven Hills, Town Center, Aurangabad, Maharashtra 431001",
//                "/com/sharan/ui/pictures/Maharashtra/Aurangabad/Athithi/Ma_Au_AthithiA.jpg",dataBaseController
//
//        );
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        homePageAfterLogin = new JFrame();
        Heading = new JLabel();
        scrollBar = new JScrollBar();
        splitPane1 = new JSplitPane();
        Picture = new JLabel();
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
        menuBar1 = new JMenuBar();
        profile = new JMenu();
        Logout = new JMenuItem();

        //======== homePageAfterLogin ========
        {
            homePageAfterLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            homePageAfterLogin.setVisible(true);
            Container homePageAfterLoginContentPane = homePageAfterLogin.getContentPane();

            //---- Heading ----
            Heading.setText("Online Hotel Bookng Portal");
            Heading.setForeground(new Color(254, 0, 27));
            Heading.setFont(new Font("Courier New", Font.BOLD, 33));
            Heading.setBackground(new Color(245, 255, 0));
            Heading.setHorizontalAlignment(SwingConstants.CENTER);
            Heading.setHorizontalTextPosition(SwingConstants.CENTER);
            Heading.setBorder(null);
            Heading.setOpaque(true);

            //---- scrollBar ----
            scrollBar.setName("verticalScrollBar");
            scrollBar.setBorder(null);
            scrollBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

            //======== splitPane1 ========
            {
                splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);

                //---- Picture ----
                Picture.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/HomePagePic.jpg")));
                splitPane1.setTopComponent(Picture);
            }

            //======== menuBar ========
            {
                menuBar.setPreferredSize(new Dimension(83, 50));
                menuBar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
                menuBar.setBackground(new Color(51, 255, 0));

                //======== Telangana ========
                {
                    Telangana.setText("Telangana");
                    Telangana.setPreferredSize(new Dimension(100, 19));
                    Telangana.setFont(new Font("Arial", Font.BOLD, 18));

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
                menuBar.add(Hotels);

                //---- Search ----
                Search.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
                Search.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/findSmall.png")));
                Search.setText("Search");
                menuBar.add(Search);
            }

            //======== menuBar1 ========
            {

                //======== profile ========
                {
                    profile.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePicSmall.png")));

                    //---- Logout ----
                    Logout.setText("Logout");
                    Logout.setFont(new Font("Arial", Font.PLAIN, 18));
                    Logout.addActionListener(e -> LogoutActionPerformed(e));
                    profile.add(Logout);
                }
                menuBar1.add(profile);
            }

            GroupLayout homePageAfterLoginContentPaneLayout = new GroupLayout(homePageAfterLoginContentPane);
            homePageAfterLoginContentPane.setLayout(homePageAfterLoginContentPaneLayout);
            homePageAfterLoginContentPaneLayout.setHorizontalGroup(
                homePageAfterLoginContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, homePageAfterLoginContentPaneLayout.createSequentialGroup()
                        .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup()
                            .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup()
                                    .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                        .addGap(189, 189, 189)
                                        .addComponent(Heading, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 1078, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(splitPane1, GroupLayout.PREFERRED_SIZE, 1087, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(GroupLayout.Alignment.TRAILING, homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
            );
            homePageAfterLoginContentPaneLayout.setVerticalGroup(
                homePageAfterLoginContentPaneLayout.createParallelGroup()
                    .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup()
                            .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                .addComponent(Heading, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(splitPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160))
                            .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                .addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 741, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
            );
            homePageAfterLogin.pack();
            homePageAfterLogin.setLocationRelativeTo(homePageAfterLogin.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame homePageAfterLogin;
    private JLabel Heading;
    private JScrollBar scrollBar;
    private JSplitPane splitPane1;
    private JLabel Picture;
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
    private JMenuBar menuBar1;
    private JMenu profile;
    private JMenuItem Logout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
