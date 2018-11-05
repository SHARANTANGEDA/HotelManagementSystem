/*
 * Created by JFormDesigner on Tue Oct 30 12:03:37 IST 2018
 */

package com.sharan.ui.home.homePageAfterLogin;

import com.sharan.DataBaseController;
import com.sharan.ui.home.homePage.HomePage;
import com.sharan.ui.hotelView.displaySelectedHotels.DisplaySelectedHotels;
import com.sharan.ui.hotelView.hotelHome.HotelHomePageAfterLogin;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

    private DataBaseController dataBaseController;

    public HomePageAfterLogin(String userName,DataBaseController dataBaseController) {
        this.dataBaseController=dataBaseController;



        initComponents();

        addtoStateComboBox(StateField);



        this.userName=userName;





        AutoCompleteDecorator.decorate(StateField);
        AutoCompleteDecorator.decorate(CityField);
        AutoCompleteDecorator.decorate(Hotels);
        homePageAfterLogin.setVisible(true);

    }

    private void addtoStateComboBox(JComboBox<String> stateField) {
        stateField.addItem("Telangana");
        stateField.addItem("AndhraPradesh");
        stateField.addItem("Maharastra");
        stateField.addItem("NewDelhi");
    }

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
        else if (stateSelected.equalsIgnoreCase("Maharastra")) {
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        checkField.setFormats(dateFormat);
        String unparsedDate=checkField.getDate().toString();

        StringBuilder sb=new StringBuilder();
        String date=unparsedDate.substring(4,7);
        String month=unparsedDate.substring(8,10);
        String year=unparsedDate.substring(24,28);

        sb.append(date);
        sb.append("/");
        sb.append(month);
        sb.append("/");
        sb.append(year);

        return sb.toString();
    }



    private void LogoutActionPerformed(ActionEvent e) {
        homePageAfterLogin.dispose();
        homePageAfterLogin.setVisible(false);
        HomePage homePage=new HomePage(dataBaseController);

    }


    //***************UNIVERSAL SEARCH FIELD*****************


    private void SearchActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    private void HotelsActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    //***************UNIVERSAL SEARCH FIELD*****************


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

        dataBaseController.initialiseDatabase();
        ArrayList<String> list=dataBaseController.parseHotel("Ma_Pu_Mint");
        dataBaseController.closeDatabaseConnection();
        HotelHomePageAfterLogin hotelHomePageAfterLogin=new HotelHomePageAfterLogin(list,dataBaseController);

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



    //*********************SEARCH FIELDS**********************************************




    private void SearchBottomActionPerformed(ActionEvent e) {

        checkInDate=getDate(checkInField);
        checkOutDate=getDate(checkOutField);
        try {
            noOfRooms.commitEdit();
        } catch ( java.text.ParseException exception ) {
            System.out.println(exception.getMessage());
        }
        int value = (Integer) noOfRooms.getValue();
        roomsSelected=String.valueOf(value);

        System.out.println(userName);
        ArrayList<String> list=new ArrayList<>();
        list.add(userName);
        list.add(stateSelected);
        list.add(citySelected);
        list.add(checkInDate);
        list.add(checkOutDate);
        list.add(roomsSelected);


        dataBaseController.initialiseDatabase();
        dataBaseController.addAllotmentDetailsToDatabase(userName,stateSelected,citySelected,checkInDate,checkOutDate,roomsSelected);
        dataBaseController.closeDatabaseConnection();

        homePageAfterLogin.dispose();
        DisplaySelectedHotels displaySelectedHotels=new DisplaySelectedHotels(list,dataBaseController);

    }

    private void StateFieldItemStateChanged(ItemEvent e) {
        stateSelected=e.getItem().toString();
        addtoCityComboBox(CityField);

    }

    private void CityFieldItemStateChanged(ItemEvent e) {
        citySelected=e.getItem().toString();
    }






    //*********************SEARCH FIELDS**********************************************



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        homePageAfterLogin = new JFrame();
        applicationName = new JLabel();
        menuBar1 = new JMenuBar();
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
        separator2 = new JSeparator();
        profile = new JMenu();
        Logout = new JMenuItem();
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
        label6 = new JLabel();
        noOfRooms = new JSpinner();

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

                //---- separator1 ----
                separator1.setMaximumSize(new Dimension(400, 50));
                separator1.setBackground(Color.darkGray);
                menuBar1.add(separator1);

                //---- Hotels ----
                Hotels.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
                Hotels.setToolTipText("Search for Hotels");
                Hotels.setMaximumSize(new Dimension(500, 50));
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

                //---- separator2 ----
                separator2.setMaximumSize(new Dimension(400, 50));
                separator2.setBackground(Color.darkGray);
                menuBar1.add(separator2);

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
            SearchBottom.addActionListener(e -> SearchBottomActionPerformed(e));

            //---- label6 ----
            label6.setText("No of Rooms:");
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));

            //---- noOfRooms ----
            noOfRooms.setFont(noOfRooms.getFont().deriveFont(noOfRooms.getFont().getSize() + 4f));

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
                        .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup()
                            .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(applicationName, GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE)
                                    .addComponent(menuBar1, GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE)
                                    .addComponent(homePagePhoto, GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE)))
                            .addGroup(homePageAfterLoginContentPaneLayout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(noOfRooms, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
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
                        .addGap(26, 26, 26)
                        .addGroup(homePageAfterLoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addComponent(noOfRooms, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(36, Short.MAX_VALUE))
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
    private JSeparator separator2;
    private JMenu profile;
    private JMenuItem Logout;
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
    private JLabel label6;
    private JSpinner noOfRooms;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
