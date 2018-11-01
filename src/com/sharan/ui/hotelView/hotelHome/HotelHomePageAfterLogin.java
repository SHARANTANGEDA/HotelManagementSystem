/*
 * Created by JFormDesigner on Tue Oct 30 16:38:35 IST 2018
 */

package com.sharan.ui.hotelView.hotelHome;

import com.sharan.DataBaseController;
import com.sharan.ui.hotelView.hotelHome.beforeLogin.HotelHomePageBeforeLogin;
import com.sharan.ui.hotelView.hotelHome.rating.Rating;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author SAI SHARAN
 */
public class HotelHomePageAfterLogin {
    private String uniqueId;
    private DataBaseController dataBaseController;
    private double rate;
    private String starRatingPath;


    private String hotelName;
    private String description;
    private String address;
    private String hotelMainImagePath;
    private ArrayList<String> list;


//    String uniqueId,String hotelName,String description,String address,String hotelMainImagePath,
    public HotelHomePageAfterLogin(ArrayList<String> list, DataBaseController dataBaseController) {

        this.list=list;

        this.uniqueId=list.get(0);
        this.dataBaseController=dataBaseController;
        this.hotelName=list.get(1);
        this.description=list.get(2);
        this.address=list.get(3);
        this.hotelMainImagePath=list.get(4);
        initComponents();
    }




    private void LogoutActionPerformed(ActionEvent e) {
        dataBaseController.initialiseDatabase();
        HotelHomePageBeforeLogin beforeLogin=new HotelHomePageBeforeLogin(uniqueId,dataBaseController);
        dataBaseController.closeDatabaseConnection();
    }

    private void Star_RatingActionPerformed(ActionEvent e)  {

            dataBaseController.initialiseDatabase();
            Rating rating=new Rating(uniqueId,dataBaseController);
            dataBaseController.closeDatabaseConnection();
            dataBaseController.initialiseDatabase();
            rate=dataBaseController.calculateRating(uniqueId);

            String rateString=String.valueOf(rate);
            starRatingPath="/com/sharan/ui/pictures/stars/"+rateString+".jpg";
            System.out.println(rate);
        System.out.println(starRatingPath);
            dataBaseController.closeDatabaseConnection();

    }

    private void checkAvailabilityActionPerformed(ActionEvent e) {
        // TODO add your code here
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        HotelHomeFrame = new JFrame();
        menuBar1 = new JMenuBar();
        profile = new JMenu();
        Logout = new JMenuItem();
        Heading = new JLabel();
        scrollBar = new JScrollBar();
        menuItem1 = new JMenuItem();
        scrollPane1 = new JScrollPane();
        DescriptionField = new JTextArea();
        Star_Rating = new JButton();
        label1 = new JLabel();
        checkAvailability = new JButton();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== HotelHomeFrame ========
        {
            HotelHomeFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            HotelHomeFrame.setVisible(true);
            Container HotelHomeFrameContentPane = HotelHomeFrame.getContentPane();

            //======== menuBar1 ========
            {
                menuBar1.setAutoscrolls(true);

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

            //---- Heading ----
            Heading.setText(hotelName);
            Heading.setForeground(new Color(254, 0, 27));
            Heading.setFont(new Font("Courier New", Font.BOLD, 33));
            Heading.setBackground(new Color(245, 255, 0));
            Heading.setHorizontalAlignment(SwingConstants.CENTER);
            Heading.setHorizontalTextPosition(SwingConstants.CENTER);
            Heading.setBorder(null);
            Heading.setOpaque(true);
            Heading.setAutoscrolls(true);

            //---- scrollBar ----
            scrollBar.setName("verticalScrollBar");
            scrollBar.setBorder(null);
            scrollBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

            //---- menuItem1 ----
//            menuItem1.setText("---IMAGE HERE---");
            menuItem1.setIcon(new ImageIcon(getClass().getResource(hotelMainImagePath)));
            menuItem1.setBorder(LineBorder.createBlackLineBorder());
            menuItem1.setHorizontalAlignment(SwingConstants.CENTER);
            menuItem1.setHorizontalTextPosition(SwingConstants.CENTER);
            menuItem1.setAutoscrolls(true);

            //======== scrollPane1 ========
            {

                //---- DescriptionField ----

                DescriptionField.setText(description);
                scrollPane1.setViewportView(DescriptionField);
            }

            //---- Star_Rating ----
            Star_Rating.setText("Rate your Experience");
            Star_Rating.setHorizontalAlignment(SwingConstants.CENTER);
            Star_Rating.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
            Star_Rating.setInheritsPopupMenu(true);
            Star_Rating.addActionListener(e -> Star_RatingActionPerformed(e));

            //---- label1 ----
            label1.setText("text");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/stars/5.0.jpg")));

            //---- checkAvailability ----
            checkAvailability.setText("Check Availability");
            checkAvailability.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
            checkAvailability.setForeground(new Color(238, 238, 238));
            checkAvailability.setBackground(new Color(177, 0, 0));
            checkAvailability.addActionListener(e -> checkAvailabilityActionPerformed(e));

            //======== scrollPane2 ========
            {
                textArea1.setText(address);
                scrollPane2.setViewportView(textArea1);
            }



            GroupLayout HotelHomeFrameContentPaneLayout = new GroupLayout(HotelHomeFrameContentPane);
            HotelHomeFrameContentPane.setLayout(HotelHomeFrameContentPaneLayout);
            HotelHomeFrameContentPaneLayout.setHorizontalGroup(
                HotelHomeFrameContentPaneLayout.createParallelGroup()
                    .addGroup(HotelHomeFrameContentPaneLayout.createSequentialGroup()
                        .addGroup(HotelHomeFrameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(HotelHomeFrameContentPaneLayout.createSequentialGroup()
                                .addGap(975, 975, 975)
                                .addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                            .addGroup(HotelHomeFrameContentPaneLayout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(Heading, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE))
                            .addGroup(HotelHomeFrameContentPaneLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(menuItem1, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addGroup(HotelHomeFrameContentPaneLayout.createParallelGroup()
                                    .addGroup(HotelHomeFrameContentPaneLayout.createSequentialGroup()
                                        .addGroup(HotelHomeFrameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Star_Rating, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(checkAvailability, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(scrollPane1)
                                    .addGroup(HotelHomeFrameContentPaneLayout.createSequentialGroup()
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 30, Short.MAX_VALUE)
                        .addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
            );
            HotelHomeFrameContentPaneLayout.setVerticalGroup(
                HotelHomeFrameContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, HotelHomeFrameContentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(HotelHomeFrameContentPaneLayout.createParallelGroup()
                            .addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 724, GroupLayout.PREFERRED_SIZE)
                            .addGroup(HotelHomeFrameContentPaneLayout.createSequentialGroup()
                                .addComponent(Heading, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(HotelHomeFrameContentPaneLayout.createParallelGroup()
                                    .addGroup(HotelHomeFrameContentPaneLayout.createSequentialGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(HotelHomeFrameContentPaneLayout.createParallelGroup()
                                            .addGroup(HotelHomeFrameContentPaneLayout.createSequentialGroup()
                                                .addComponent(Star_Rating, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label1))
                                            .addComponent(checkAvailability, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(menuItem1, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            HotelHomeFrame.pack();
            HotelHomeFrame.setLocationRelativeTo(HotelHomeFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame HotelHomeFrame;
    private JMenuBar menuBar1;
    private JMenu profile;
    private JMenuItem Logout;
    private JLabel Heading;
    private JScrollBar scrollBar;
    private JMenuItem menuItem1;
    private JScrollPane scrollPane1;
    private JTextArea DescriptionField;
    private JButton Star_Rating;
    private JLabel label1;
    private JButton checkAvailability;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
