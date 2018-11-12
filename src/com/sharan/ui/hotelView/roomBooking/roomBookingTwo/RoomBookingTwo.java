/*
 * Created by JFormDesigner on Thu Nov 08 09:43:15 IST 2018
 */

package com.sharan.ui.hotelView.roomBooking.roomBookingTwo;

import com.sharan.DataBaseController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * @author SAI SHARAN
 */
public class RoomBookingTwo {
    private String userName;
    private DataBaseController dataBaseController;

    private String hotelName;
    private String standardRoomsPrice;
    private String deluxeRoomsPrice;
    private String suitRoomsPrice;
    private String noofStandardRooms;
    private String noofDeluxeRooms;
    private String noOfSuiteRooms;
    private String uniqueId;
    private String checkIn;
    private String checkOut;

    private String roomTypeImage1;
    private String roomTypeImage2;

    private SpinnerModel roomType1;
    private SpinnerModel roomType2;

    public RoomBookingTwo(ArrayList<String> list, DataBaseController dataBaseController) {

        this.hotelName = list.get(0);
        this.standardRoomsPrice = list.get(1);
        this.deluxeRoomsPrice = list.get(2);
        this.suitRoomsPrice = list.get(3);
        this.uniqueId = list.get(4);
        this.checkIn = list.get(5);
        this.checkOut = list.get(6);
        this.noofStandardRooms=list.get(7);
        this.noofDeluxeRooms=list.get(8);
        this.noOfSuiteRooms =list.get(9);
        this.userName=list.get(10);
        this.dataBaseController=dataBaseController;

        dataBaseController.initialiseDatabase();
        ArrayList<String> imagesOfRoomType=dataBaseController.getIndividualHotelImages(uniqueId);
        dataBaseController.closeDatabaseConnection();


        initComponents();

        hotelTitle.setText(hotelName);
        try {
            enterField1.commitEdit();
            enterField2.commitEdit();

        }catch (ParseException e) {
            e.printStackTrace();
        }



        if(imagesOfRoomType.get(0).equalsIgnoreCase("NA")) {
            roomTypeImage1=imagesOfRoomType.get(1);
            roomTypeImage2=imagesOfRoomType.get(2);



            roomType1Label.setText("Select Number of Deluxe Rooms: ");
            roomType2Label.setText("Select Number of Suite Rooms: ");
            roomType1=new SpinnerNumberModel(0,0,Integer.parseInt(noofDeluxeRooms),1);
            roomType2=new SpinnerNumberModel(0,0,Integer.parseInt(noOfSuiteRooms),1);
            picture1.setIcon(new ImageIcon(getClass().getResource(roomTypeImage1)));
            picture2.setIcon(new ImageIcon(getClass().getResource(roomTypeImage2)));
        }else if(imagesOfRoomType.get(1).equalsIgnoreCase("NA")) {
            roomTypeImage1=imagesOfRoomType.get(0);
            roomTypeImage2=imagesOfRoomType.get(2);



            roomType2Label.setText("Select Number of Suite Rooms: ");
            roomType1Label.setText("Select Number of Standard Rooms: ");
            roomType1=new SpinnerNumberModel(0,0,Integer.parseInt(noofStandardRooms),1);
            roomType2=new SpinnerNumberModel(0,0,Integer.parseInt(noOfSuiteRooms),1);
            picture1.setIcon(new ImageIcon(getClass().getResource(roomTypeImage1)));
            picture2.setIcon(new ImageIcon(getClass().getResource(roomTypeImage2)));
        }else if(imagesOfRoomType.get(2).equalsIgnoreCase("NA")) {
            roomTypeImage1=imagesOfRoomType.get(0);
            roomTypeImage2=imagesOfRoomType.get(1);



            roomType2Label.setText("Select Number of Deluxe Rooms: ");
            roomType1Label.setText("Select Number of Standard Rooms: ");
            roomType1=new SpinnerNumberModel(0,0,Integer.parseInt(noofStandardRooms),1);
            roomType2=new SpinnerNumberModel(0,0,Integer.parseInt(noofDeluxeRooms),1);
            picture1.setIcon(new ImageIcon(getClass().getResource(roomTypeImage1)));
            picture2.setIcon(new ImageIcon(getClass().getResource(roomTypeImage2)));
        }
        enterField2.setModel(roomType2);
        enterField1.setModel(roomType1);

        roomBookingTwo.setVisible(true);
        roomBookingTwo.setIconImage(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/hotel.png")).getImage());

    }

    private void bookNowActionPerformed(ActionEvent e) {
        int reqnoofStandardRooms=0;
        int reqnoofDeluxeRooms=0;
        int reqnoOfSuiteRooms=0;
        if(noOfSuiteRooms.equals("0"))
        {
            reqnoofStandardRooms = (Integer)enterField1.getValue();
            reqnoofDeluxeRooms = (Integer)enterField2.getValue();
            reqnoOfSuiteRooms =0;
        }
        if (noofDeluxeRooms.equals("0"))
        {
            reqnoofStandardRooms = (Integer)enterField1.getValue();
            reqnoofDeluxeRooms =0 ;
            reqnoOfSuiteRooms =(Integer)enterField2.getValue();
        }
        if(noofStandardRooms.equals("0"))
        {
            reqnoofStandardRooms = 0;
            reqnoofDeluxeRooms =(Integer)enterField1.getValue() ;
            reqnoOfSuiteRooms =(Integer)enterField2.getValue();
        }
        dataBaseController.initialiseDatabase();
        dataBaseController.checkAvailable(userName,uniqueId,checkIn,checkOut,reqnoofStandardRooms,reqnoofDeluxeRooms,reqnoOfSuiteRooms,Integer.parseInt(noofStandardRooms),Integer.parseInt(noofStandardRooms),Integer.parseInt(noOfSuiteRooms));
        dataBaseController.closeDatabaseConnection();
        roomBookingTwo.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        roomBookingTwo = new JDialog();
        hotelTitle = new JLabel();
        bookNow = new JButton();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        enterField2 = new JSpinner();
        enterField1 = new JSpinner();
        roomType2Label = new JLabel();
        roomType1Label = new JLabel();
        picture1 = new JLabel();
        picture2 = new JLabel();

        //======== roomBookingTwo ========
        {
            Container roomBookingTwoContentPane = roomBookingTwo.getContentPane();

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
                    panel1.setBackground(Color.white);

                    // JFormDesigner evaluation mark
                    panel1.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                    //---- enterField2 ----
                    enterField2.setFont(new Font("Arial", Font.BOLD, 24));

                    //---- enterField1 ----
                    enterField1.setFont(new Font("Arial", Font.BOLD, 24));

                    //---- roomType2Label ----
                    roomType2Label.setText("Select Number of Deluxe Rooms:");
                    roomType2Label.setFont(new Font("Arial", Font.BOLD, 18));

                    //---- roomType1Label ----
                    roomType1Label.setText("Select Number of Standard Rooms:");
                    roomType1Label.setFont(new Font("Arial", Font.BOLD, 18));

                    //---- picture1 ----
                    picture1.setBorder(LineBorder.createBlackLineBorder());
                    picture1.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePic.png")));
                    picture1.setHorizontalAlignment(SwingConstants.CENTER);

                    //---- picture2 ----
                    picture2.setBorder(LineBorder.createBlackLineBorder());
                    picture2.setHorizontalAlignment(SwingConstants.CENTER);
                    picture2.setIcon(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/profilePic.png")));

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(picture1, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(35, 838, Short.MAX_VALUE)
                                                .addComponent(enterField2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addGroup(panel1Layout.createSequentialGroup()
                                                        .addComponent(roomType2Label, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 430, Short.MAX_VALUE))
                                                    .addGroup(panel1Layout.createSequentialGroup()
                                                        .addComponent(roomType1Label, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                                                        .addComponent(enterField1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(picture2, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(150, 150, 150))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(picture1, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(enterField1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(roomType1Label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(picture2, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(158, 158, 158)
                                                .addComponent(enterField2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(259, Short.MAX_VALUE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(roomType2Label, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addGap(409, 409, 409))))
                    );
                }
                scrollPane1.setViewportView(panel1);
            }

            GroupLayout roomBookingTwoContentPaneLayout = new GroupLayout(roomBookingTwoContentPane);
            roomBookingTwoContentPane.setLayout(roomBookingTwoContentPaneLayout);
            roomBookingTwoContentPaneLayout.setHorizontalGroup(
                roomBookingTwoContentPaneLayout.createParallelGroup()
                    .addGroup(roomBookingTwoContentPaneLayout.createSequentialGroup()
                        .addGap(587, 587, 587)
                        .addComponent(bookNow, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomBookingTwoContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roomBookingTwoContentPaneLayout.createParallelGroup()
                            .addGroup(roomBookingTwoContentPaneLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1343, GroupLayout.PREFERRED_SIZE))
                            .addComponent(hotelTitle, GroupLayout.PREFERRED_SIZE, 1343, GroupLayout.PREFERRED_SIZE)))
            );
            roomBookingTwoContentPaneLayout.setVerticalGroup(
                roomBookingTwoContentPaneLayout.createParallelGroup()
                    .addGroup(roomBookingTwoContentPaneLayout.createSequentialGroup()
                        .addComponent(hotelTitle, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 725, GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(bookNow, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            roomBookingTwo.pack();
            roomBookingTwo.setLocationRelativeTo(roomBookingTwo.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JDialog roomBookingTwo;
    private JLabel hotelTitle;
    private JButton bookNow;
    private JScrollPane scrollPane1;
    private JPanel panel1;
    private JSpinner enterField2;
    private JSpinner enterField1;
    private JLabel roomType2Label;
    private JLabel roomType1Label;
    private JLabel picture1;
    private JLabel picture2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
