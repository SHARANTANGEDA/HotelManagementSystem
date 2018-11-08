/*
 * Created by JFormDesigner on Tue Oct 30 16:49:05 IST 2018
 */

package com.sharan.ui.hotelView.roomBooking.roomBookingAll;

import com.sharan.DataBaseController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author SAI SHARAN
 */
public class RoomBooking {

    private String userName;
    private DataBaseController dataBaseController;

    private String hotelName;
    private String standardRoomsPrice;
    private String deluxeRoomsPrice;
    private String suitRoomsPrice;
    private String noofStandardRooms;
    private String noofDeluxeRooms;
    private String noOfSuitRooms;
    private String uniqueId;
    private String checkIn;
    private String checkOut;

    private String standardImagePath;
    private String deluxeImagePath;
    private String suiteImagePath;

//    SpinnerModel standard = new SpinnerNumberModel(0,0,Integer.parseInt(noofStandardRooms),1);
//    SpinnerModel deluxe = new SpinnerNumberModel(0,0,Integer.parseInt(noofDeluxeRooms),1);
//    SpinnerModel suit = new SpinnerNumberModel(0,0,Integer.parseInt(noOfSuitRooms),1);
    public RoomBooking(ArrayList<String> list,DataBaseController dataBaseController) {
        this.hotelName = list.get(0);
        this.standardRoomsPrice = list.get(1);
        this.deluxeRoomsPrice = list.get(2);
        this.suitRoomsPrice = list.get(3);
        this.uniqueId = list.get(4);
        this.checkIn = list.get(5);
        this.checkOut = list.get(6);
        this.noofStandardRooms=list.get(7);
        this.noofDeluxeRooms=list.get(8);
        this.noOfSuitRooms=list.get(9);
        this.userName=list.get(10);
        this.dataBaseController=dataBaseController;

        dataBaseController.initialiseDatabase();
        ArrayList<String> imagesOfRoomType=dataBaseController.getIndividualHotelImages(uniqueId);
        dataBaseController.closeDatabaseConnection();

        standardImagePath=imagesOfRoomType.get(0);
        deluxeImagePath=imagesOfRoomType.get(1);
        suiteImagePath=imagesOfRoomType.get(2);


        initComponents();

        hotelTitle.setText(hotelName);
        standardPicture.setIcon(new ImageIcon(getClass().getResource(standardImagePath)));
        deluxePicture.setIcon(new ImageIcon(getClass().getResource(deluxeImagePath)));
        suitePicture.setIcon(new ImageIcon(getClass().getResource(suiteImagePath)));
        roomBooking.setVisible(true);

    }


    private void bookNowActionPerformed(ActionEvent e) {
        // TODO add your code here
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        roomBooking = new JFrame();
        hotelTitle = new JLabel();
        bookNow = new JButton();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        suiteFieid = new JSpinner();
        standardField = new JSpinner();
        deluxeField = new JSpinner();
        label3 = new JLabel();
        label4 = new JLabel();
        label2 = new JLabel();
        standardPicture = new JLabel();
        deluxePicture = new JLabel();
        suitePicture = new JLabel();

        //======== roomBooking ========
        {
            roomBooking.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container roomBookingContentPane = roomBooking.getContentPane();

            //---- hotelTitle ----
            hotelTitle.setText("HOTEL NAME");
            hotelTitle.setFont(new Font("Arial Black", Font.BOLD, 20));
            hotelTitle.setHorizontalAlignment(SwingConstants.CENTER);
            hotelTitle.setBackground(new Color(255, 204, 0));
            hotelTitle.setOpaque(true);

            //---- bookNow ----
            bookNow.setText("BOOK NOW");
            bookNow.setFont(new Font("Arial", Font.BOLD, 20));
            bookNow.setForeground(Color.white);
            bookNow.setBackground(new Color(153, 0, 0));
            bookNow.setActionCommand("Book Now");
            bookNow.addActionListener(e -> bookNowActionPerformed(e));

            //======== scrollPane1 ========
            {

                //======== panel1 ========
                {

                    // JFormDesigner evaluation mark
                    panel1.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                    //---- suiteFieid ----
                    suiteFieid.setFont(new Font("Arial", Font.BOLD, 24));

                    //---- standardField ----
                    standardField.setFont(new Font("Arial", Font.BOLD, 24));

                    //---- deluxeField ----
                    deluxeField.setFont(new Font("Arial", Font.BOLD, 24));

                    //---- label3 ----
                    label3.setText("Select Number of Deluxe Rooms:");
                    label3.setFont(new Font("Arial", Font.BOLD, 18));

                    //---- label4 ----
                    label4.setText("Select Number of Suite Rooms:");
                    label4.setFont(new Font("Arial", Font.BOLD, 18));

                    //---- label2 ----
                    label2.setText("Select Number of Standard Rooms:");
                    label2.setFont(new Font("Arial", Font.BOLD, 18));

                    //---- standardPicture ----
                    standardPicture.setBorder(LineBorder.createBlackLineBorder());
                    standardPicture.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePic.png")));
                    standardPicture.setHorizontalAlignment(SwingConstants.CENTER);

                    //---- deluxePicture ----
                    deluxePicture.setBorder(LineBorder.createBlackLineBorder());
                    deluxePicture.setHorizontalAlignment(SwingConstants.CENTER);
                    deluxePicture.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePic.png")));

                    //---- suitePicture ----
                    suitePicture.setBorder(LineBorder.createBlackLineBorder());
                    suitePicture.setHorizontalAlignment(SwingConstants.CENTER);
                    suitePicture.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePic.png")));

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(deluxePicture, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(suitePicture, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(standardPicture, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                        .addGap(142, 142, 142)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                                                .addComponent(suiteFieid, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                                                .addComponent(deluxeField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                                                .addComponent(standardField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))))
                                .addGap(150, 150, 150))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(standardPicture, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(standardField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(deluxePicture, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(deluxeField, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                                        .addGap(123, 123, 123)))
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(suitePicture, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(146, 146, 146)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(suiteFieid, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(114, Short.MAX_VALUE))
                    );
                }
                scrollPane1.setViewportView(panel1);
            }

            GroupLayout roomBookingContentPaneLayout = new GroupLayout(roomBookingContentPane);
            roomBookingContentPane.setLayout(roomBookingContentPaneLayout);
            roomBookingContentPaneLayout.setHorizontalGroup(
                roomBookingContentPaneLayout.createParallelGroup()
                    .addComponent(hotelTitle, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1367, Short.MAX_VALUE)
                    .addGroup(roomBookingContentPaneLayout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(bookNow, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(632, Short.MAX_VALUE))
            );
            roomBookingContentPaneLayout.setVerticalGroup(
                roomBookingContentPaneLayout.createParallelGroup()
                    .addGroup(roomBookingContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hotelTitle, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 702, GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(bookNow, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
            );
            roomBooking.pack();
            roomBooking.setLocationRelativeTo(roomBooking.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JFrame roomBooking;
    private JLabel hotelTitle;
    private JButton bookNow;
    private JScrollPane scrollPane1;
    private JPanel panel1;
    private JSpinner suiteFieid;
    private JSpinner standardField;
    private JSpinner deluxeField;
    private JLabel label3;
    private JLabel label4;
    private JLabel label2;
    private JLabel standardPicture;
    private JLabel deluxePicture;
    private JLabel suitePicture;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
