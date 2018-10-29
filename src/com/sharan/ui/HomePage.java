package com.sharan.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HomePage extends Canvas {
    private int FRAME_WIDTH = 1500;
    private int FRAME_HEIGHT = 750;
    private String stateSelected = "";
    private String citySelected="";
    private JFrame frame = new JFrame("Online Hotel Booking System");
    String states[] = {"Telangana", "Andhra Pradesh", "Maharastra", "Delhi"};
    String selectedCities[]={"Hyderabad","Warangal","KarimNagar","Kammam","Vijayawada", "Guntur","Tirupati","Vizag",
                "Mumbai", "Pune","Nagpur","Aurangabad","New Delhi", "Panipat","Gurugram","Faridabad"};


    public HomePage() {
        initComponents();
    }




    public String getStateSelected() {
        return stateSelected;
    }

    public String getCitySelected() {
        return citySelected;
    }

    public JFrame getFrame() {
        return frame;
    }

    private void StatesActionPerformed(ActionEvent e) {
        stateSelected=States.getItemAt(States.getSelectedIndex()).toString();
    }


    private void CitiesActionPerformed(ActionEvent e) {
        citySelected=Cities.getItemAt(Cities.getSelectedIndex()).toString();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        frame1 = new JFrame();
        Login = new JButton();
        Heading = new JLabel();
        SignUp = new JButton();
        scrollBar = new JScrollBar();
        States = new JComboBox<>();
        Hotels = new JComboBox();
        Search = new JButton();
        Picture = new JLabel();
        Cities = new JComboBox<>();
        menuBar = new JMenuBar();
        Telangana = new JMenu();
        Hyderabad = new JMenu();
        menuItem49 = new JMenuItem();
        menuItem50 = new JMenuItem();
        menuItem51 = new JMenuItem();
        menuItem52 = new JMenuItem();
        Warangal = new JMenu();
        menuItem54 = new JMenuItem();
        menuItem55 = new JMenuItem();
        menuItem56 = new JMenuItem();
        menuItem57 = new JMenuItem();
        Karimnagar = new JMenu();
        menuItem58 = new JMenuItem();
        menuItem59 = new JMenuItem();
        menuItem60 = new JMenuItem();
        menuItem61 = new JMenuItem();
        Kammam = new JMenu();
        menuItem62 = new JMenuItem();
        menuItem63 = new JMenuItem();
        menuItem64 = new JMenuItem();
        menuItem65 = new JMenuItem();
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
        menuItem17 = new JMenuItem();
        menuItem18 = new JMenuItem();
        menuItem19 = new JMenuItem();
        menuItem20 = new JMenuItem();
        Pune = new JMenu();
        menuItem21 = new JMenuItem();
        menuItem22 = new JMenuItem();
        menuItem23 = new JMenuItem();
        menuItem24 = new JMenuItem();
        Nagpur = new JMenu();
        menuItem25 = new JMenuItem();
        menuItem26 = new JMenuItem();
        menuItem27 = new JMenuItem();
        menuItem28 = new JMenuItem();
        Aurangabad = new JMenu();
        menuItem29 = new JMenuItem();
        menuItem30 = new JMenuItem();
        menuItem31 = new JMenuItem();
        menuItem32 = new JMenuItem();
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

        //======== frame1 ========
        {
            frame1.setFont(new Font("Courier New", Font.BOLD, 36));
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame1.setIconImage(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/HomePagePic.jpg")).getImage());
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(null);

            //---- Login ----
            Login.setText("Login");
            Login.setBackground(new Color(0, 255, 29));
            Login.setComponentPopupMenu(null);
            frame1ContentPane.add(Login);
            Login.setBounds(750, 15, 120, 40);

            //---- Heading ----
            Heading.setText("Online Hotel Bookng Portal");
            Heading.setForeground(new Color(254, 0, 27));
            Heading.setFont(new Font("Courier New", Font.BOLD, 33));
            Heading.setBackground(new Color(245, 255, 0));
            Heading.setHorizontalAlignment(SwingConstants.CENTER);
            Heading.setHorizontalTextPosition(SwingConstants.CENTER);
            Heading.setBorder(null);
            frame1ContentPane.add(Heading);
            Heading.setBounds(150, 10, 600, 60);

            //---- SignUp ----
            SignUp.setText("SignUp");
            SignUp.setBackground(new Color(0, 255, 29));
            frame1ContentPane.add(SignUp);
            SignUp.setBounds(875, 15, 120, 40);

            //---- scrollBar ----
            scrollBar.setName("verticalScrollBar");
            scrollBar.setBorder(null);
            frame1ContentPane.add(scrollBar);
            scrollBar.setBounds(1045, 5, 22, 755);

            //---- States ----
            States.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
            States.setModel(new DefaultComboBoxModel<>(new String[] {
                "Telangana",
                "Andhra Pradesh",
                "Maharastra",
                "Delhi"
            }));
            States.addActionListener(e -> StatesActionPerformed(e));
            frame1ContentPane.add(States);
            States.setBounds(0, 620, 230, 39);

            //---- Hotels ----
            Hotels.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
            frame1ContentPane.add(Hotels);
            Hotels.setBounds(540, 620, 245, 39);

            //---- Search ----
            Search.setText("Search");
            Search.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
            frame1ContentPane.add(Search);
            Search.setBounds(840, 625, 125, 45);

            //---- Picture ----
            Picture.setText("text");
            Picture.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/HomePagePic.jpg")));
            frame1ContentPane.add(Picture);
            Picture.setBounds(0, 150, 1045, 430);

            //---- Cities ----
            Cities.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
            Cities.setModel(new DefaultComboBoxModel<>(new String[] {
                "Hyderabad",
                "Warangal",
                "KarimNagar",
                "Kammam",
                "Vijayawada",
                "Guntur",
                "Tirupati",
                "Vizag",
                "Mumbai",
                "Pune",
                "Nagpur",
                "Aurangabad",
                "New Delhi",
                "Panipat",
                "Gurugram",
                "Faridabad"
            }));
            Cities.addActionListener(e -> CitiesActionPerformed(e));
            frame1ContentPane.add(Cities);
            Cities.setBounds(260, 620, 225, 40);

            //======== menuBar ========
            {
                menuBar.setPreferredSize(new Dimension(83, 50));
                menuBar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));

                //======== Telangana ========
                {
                    Telangana.setText("Telangana");
                    Telangana.setPreferredSize(new Dimension(135, 19));
                    Telangana.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));

                    //======== Hyderabad ========
                    {
                        Hyderabad.setText("Hyderabad");
                        Hyderabad.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem49 ----
                        menuItem49.setText("text");
                        Hyderabad.add(menuItem49);

                        //---- menuItem50 ----
                        menuItem50.setText("text");
                        Hyderabad.add(menuItem50);

                        //---- menuItem51 ----
                        menuItem51.setText("text");
                        Hyderabad.add(menuItem51);

                        //---- menuItem52 ----
                        menuItem52.setText("text");
                        Hyderabad.add(menuItem52);
                    }
                    Telangana.add(Hyderabad);

                    //======== Warangal ========
                    {
                        Warangal.setText("Warangal");
                        Warangal.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem54 ----
                        menuItem54.setText("text");
                        Warangal.add(menuItem54);

                        //---- menuItem55 ----
                        menuItem55.setText("text");
                        Warangal.add(menuItem55);

                        //---- menuItem56 ----
                        menuItem56.setText("text");
                        Warangal.add(menuItem56);

                        //---- menuItem57 ----
                        menuItem57.setText("text");
                        Warangal.add(menuItem57);
                    }
                    Telangana.add(Warangal);

                    //======== Karimnagar ========
                    {
                        Karimnagar.setText("Karimnagar");
                        Karimnagar.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem58 ----
                        menuItem58.setText("text");
                        Karimnagar.add(menuItem58);

                        //---- menuItem59 ----
                        menuItem59.setText("text");
                        Karimnagar.add(menuItem59);

                        //---- menuItem60 ----
                        menuItem60.setText("text");
                        Karimnagar.add(menuItem60);

                        //---- menuItem61 ----
                        menuItem61.setText("text");
                        Karimnagar.add(menuItem61);
                    }
                    Telangana.add(Karimnagar);

                    //======== Kammam ========
                    {
                        Kammam.setText("Kammam");
                        Kammam.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem62 ----
                        menuItem62.setText("text");
                        Kammam.add(menuItem62);

                        //---- menuItem63 ----
                        menuItem63.setText("text");
                        Kammam.add(menuItem63);

                        //---- menuItem64 ----
                        menuItem64.setText("text");
                        Kammam.add(menuItem64);

                        //---- menuItem65 ----
                        menuItem65.setText("text");
                        Kammam.add(menuItem65);
                    }
                    Telangana.add(Kammam);
                }
                menuBar.add(Telangana);

                //======== Andhra_Pradesh ========
                {
                    Andhra_Pradesh.setText("Andhra Pradesh");
                    Andhra_Pradesh.setPreferredSize(new Dimension(180, 50));
                    Andhra_Pradesh.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));

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
                    Maharastra.setPreferredSize(new Dimension(135, 50));
                    Maharastra.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));

                    //======== Mumbai ========
                    {
                        Mumbai.setText("Mumbai");
                        Mumbai.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem17 ----
                        menuItem17.setText("text");
                        Mumbai.add(menuItem17);

                        //---- menuItem18 ----
                        menuItem18.setText("text");
                        Mumbai.add(menuItem18);

                        //---- menuItem19 ----
                        menuItem19.setText("text");
                        Mumbai.add(menuItem19);

                        //---- menuItem20 ----
                        menuItem20.setText("text");
                        Mumbai.add(menuItem20);
                    }
                    Maharastra.add(Mumbai);

                    //======== Pune ========
                    {
                        Pune.setText("Pune");
                        Pune.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem21 ----
                        menuItem21.setText("text");
                        Pune.add(menuItem21);

                        //---- menuItem22 ----
                        menuItem22.setText("text");
                        Pune.add(menuItem22);

                        //---- menuItem23 ----
                        menuItem23.setText("text");
                        Pune.add(menuItem23);

                        //---- menuItem24 ----
                        menuItem24.setText("text");
                        Pune.add(menuItem24);
                    }
                    Maharastra.add(Pune);

                    //======== Nagpur ========
                    {
                        Nagpur.setText("Nagpur");
                        Nagpur.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem25 ----
                        menuItem25.setText("text");
                        Nagpur.add(menuItem25);

                        //---- menuItem26 ----
                        menuItem26.setText("text");
                        Nagpur.add(menuItem26);

                        //---- menuItem27 ----
                        menuItem27.setText("text");
                        Nagpur.add(menuItem27);

                        //---- menuItem28 ----
                        menuItem28.setText("text");
                        Nagpur.add(menuItem28);
                    }
                    Maharastra.add(Nagpur);

                    //======== Aurangabad ========
                    {
                        Aurangabad.setText("Aurangabad");
                        Aurangabad.setFont(new Font("Arial", Font.ITALIC, 16));

                        //---- menuItem29 ----
                        menuItem29.setText("text");
                        Aurangabad.add(menuItem29);

                        //---- menuItem30 ----
                        menuItem30.setText("text");
                        Aurangabad.add(menuItem30);

                        //---- menuItem31 ----
                        menuItem31.setText("text");
                        Aurangabad.add(menuItem31);

                        //---- menuItem32 ----
                        menuItem32.setText("text");
                        Aurangabad.add(menuItem32);
                    }
                    Maharastra.add(Aurangabad);
                }
                menuBar.add(Maharastra);

                //======== New_Delhi ========
                {
                    New_Delhi.setText("New Delhi");
                    New_Delhi.setPreferredSize(new Dimension(135, 50));
                    New_Delhi.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));

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
            }
            frame1ContentPane.add(menuBar);
            menuBar.setBounds(0, 100, 1073, menuBar.getPreferredSize().height);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < frame1ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = frame1ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = frame1ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                frame1ContentPane.setMinimumSize(preferredSize);
                frame1ContentPane.setPreferredSize(preferredSize);
            }
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
            frame1.setVisible(true);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame frame1;
    private JButton Login;
    private JLabel Heading;
    private JButton SignUp;
    private JScrollBar scrollBar;
    private JComboBox<String> States;
    private JComboBox Hotels;
    private JButton Search;
    private JLabel Picture;
    private JComboBox<String> Cities;
    private JMenuBar menuBar;
    private JMenu Telangana;
    private JMenu Hyderabad;
    private JMenuItem menuItem49;
    private JMenuItem menuItem50;
    private JMenuItem menuItem51;
    private JMenuItem menuItem52;
    private JMenu Warangal;
    private JMenuItem menuItem54;
    private JMenuItem menuItem55;
    private JMenuItem menuItem56;
    private JMenuItem menuItem57;
    private JMenu Karimnagar;
    private JMenuItem menuItem58;
    private JMenuItem menuItem59;
    private JMenuItem menuItem60;
    private JMenuItem menuItem61;
    private JMenu Kammam;
    private JMenuItem menuItem62;
    private JMenuItem menuItem63;
    private JMenuItem menuItem64;
    private JMenuItem menuItem65;
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
    private JMenuItem menuItem17;
    private JMenuItem menuItem18;
    private JMenuItem menuItem19;
    private JMenuItem menuItem20;
    private JMenu Pune;
    private JMenuItem menuItem21;
    private JMenuItem menuItem22;
    private JMenuItem menuItem23;
    private JMenuItem menuItem24;
    private JMenu Nagpur;
    private JMenuItem menuItem25;
    private JMenuItem menuItem26;
    private JMenuItem menuItem27;
    private JMenuItem menuItem28;
    private JMenu Aurangabad;
    private JMenuItem menuItem29;
    private JMenuItem menuItem30;
    private JMenuItem menuItem31;
    private JMenuItem menuItem32;
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
