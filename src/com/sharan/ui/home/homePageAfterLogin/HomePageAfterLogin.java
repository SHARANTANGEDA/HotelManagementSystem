/*
 * Created by JFormDesigner on Tue Oct 30 12:03:37 IST 2018
 */

package com.sharan.ui.home.homePageAfterLogin;

import com.sharan.DataBaseController;
import com.sharan.ui.home.homePage.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        Hotel_Hyderabad_1 = new JMenuItem();
        Hotel_Hyderabad_2 = new JMenuItem();
        Hotel_Hyderabad_3 = new JMenuItem();
        Hotel_Hyderabad_4 = new JMenuItem();
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

                        //---- Hotel_Hyderabad_1 ----
                        Hotel_Hyderabad_1.setText("text");
                        Hotel_Hyderabad_1.addActionListener(e -> Hotel_Hyderabad_1ActionPerformed(e));
                        Hyderabad.add(Hotel_Hyderabad_1);

                        //---- Hotel_Hyderabad_2 ----
                        Hotel_Hyderabad_2.setText("text");
                        Hyderabad.add(Hotel_Hyderabad_2);

                        //---- Hotel_Hyderabad_3 ----
                        Hotel_Hyderabad_3.setText("text");
                        Hyderabad.add(Hotel_Hyderabad_3);

                        //---- Hotel_Hyderabad_4 ----
                        Hotel_Hyderabad_4.setText("text");
                        Hyderabad.add(Hotel_Hyderabad_4);
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
    private JMenuItem Hotel_Hyderabad_1;
    private JMenuItem Hotel_Hyderabad_2;
    private JMenuItem Hotel_Hyderabad_3;
    private JMenuItem Hotel_Hyderabad_4;
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
    private JSeparator separator1;
    private JComboBox Hotels;
    private JButton Search;
    private JMenuBar menuBar1;
    private JMenu profile;
    private JMenuItem Logout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
