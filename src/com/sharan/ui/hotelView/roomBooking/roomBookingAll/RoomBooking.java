/*
 * Created by JFormDesigner on Tue Oct 30 16:49:05 IST 2018
 */

package com.sharan.ui.hotelView.roomBooking.roomBookingAll;

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
public class RoomBooking {

    private String userName;
    private DataBaseController dataBaseController;

    private String hotelName;
    private String standardRoomsPrice;
    private String deluxeRoomsPrice;
    private String suitRoomsPrice;
    private String maxnoofStandardRooms;
    private String maxnoofDeluxeRooms;
    private String maxnoOfSuitRooms;
    private String uniqueId;
    private String checkIn;
    private String checkOut;

    private String standardImagePath;
    private String deluxeImagePath;
    private String suiteImagePath;

    SpinnerModel standard ;
    SpinnerModel deluxe;
    SpinnerModel suite;
    public RoomBooking(ArrayList<String> list,DataBaseController dataBaseController) {
        this.hotelName = list.get(0);
        this.standardRoomsPrice = list.get(1);
        this.deluxeRoomsPrice = list.get(2);
        this.suitRoomsPrice = list.get(3);
        this.uniqueId = list.get(4);
        this.checkIn = list.get(5);
        this.checkOut = list.get(6);
        this.maxnoofStandardRooms=list.get(7);
        this.maxnoofDeluxeRooms=list.get(8);
        this.maxnoOfSuitRooms=list.get(9);
        this.userName=list.get(10);
        this.dataBaseController=dataBaseController;

        dataBaseController.initialiseDatabase();
        ArrayList<String> imagesOfRoomType=dataBaseController.getIndividualHotelImages(uniqueId);
        dataBaseController.closeDatabaseConnection();

        standardImagePath=imagesOfRoomType.get(0);
        deluxeImagePath=imagesOfRoomType.get(1);
        suiteImagePath=imagesOfRoomType.get(2);
       standard = new SpinnerNumberModel(0,0,Integer.parseInt(maxnoofStandardRooms),1);
         deluxe = new SpinnerNumberModel(0,0,Integer.parseInt(maxnoofDeluxeRooms),1);
        suite = new SpinnerNumberModel(0,0,Integer.parseInt(maxnoOfSuitRooms),1);



        initComponents();


        try {
            suiteFieid.commitEdit();
            standardField.commitEdit();
            deluxeField.commitEdit();
            spinner1.commitEdit();
        }catch (ParseException e) {
            e.printStackTrace();
        }
        suiteFieid.setModel(suite);
        standardField.setModel(standard);
        deluxeField.setModel(deluxe);
        hotelTitle.setText(hotelName);
        standardPicture.setIcon(new ImageIcon(getClass().getResource(standardImagePath)));
        deluxePicture.setIcon(new ImageIcon(getClass().getResource(deluxeImagePath)));
        suitePicture.setIcon(new ImageIcon(getClass().getResource(suiteImagePath)));
        roomBooking.setVisible(true);
        roomBooking.setIconImage(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/hotel.png")).getImage());


    }


    private void bookNowActionPerformed(ActionEvent e) {
        int noofStandardRooms = (Integer)standardField.getValue();
        int noofDeluxeRooms = (Integer)deluxeField.getValue();
        int noOfSuiteRooms = (Integer)suiteFieid.getValue();
        int noOfPeople = (Integer)spinner1.getValue();
        int maxAvailable = (noofStandardRooms*2)+(noofDeluxeRooms)*3+(noOfSuiteRooms)*4;
        if(noOfPeople>maxAvailable)
        {
            JOptionPane.showMessageDialog(null,"Sorry,Cannot Accomidate Selected Number in the Selcted Rooms,Please Select More!!");
        }
        else {
        DataBaseController dataBaseController = new DataBaseController();
        dataBaseController.initialiseDatabase();
        System.out.println(uniqueId);
        dataBaseController.checkAvailable(userName,uniqueId,checkIn,checkOut,noofStandardRooms,noofDeluxeRooms,noOfSuiteRooms,Integer.parseInt(maxnoofStandardRooms),
                Integer.parseInt(maxnoofDeluxeRooms),Integer.parseInt(maxnoOfSuitRooms));
        roomBooking.dispose();
        dataBaseController.closeDatabaseConnection();}
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        roomBooking = new JFrame();
        hotelTitle = new JLabel();
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
        bookNow = new JButton();
        label1 = new JLabel();
        spinner1 = new JSpinner();

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

                    //---- bookNow ----
                    bookNow.setText("BOOK NOW");
                    bookNow.setFont(new Font("Arial", Font.BOLD, 20));
                    bookNow.setForeground(Color.white);
                    bookNow.setBackground(new Color(153, 0, 0));
                    bookNow.setActionCommand("Book Now");
                    bookNow.addActionListener(e -> bookNowActionPerformed(e));

                    //---- label1 ----
                    label1.setText("Select Number of People");
                    label1.setFont(new Font("Dialog", Font.BOLD, 20));

                    //---- spinner1 ----
                    spinner1.setFont(new Font("Dialog", Font.BOLD, 19));

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(suitePicture, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 758, Short.MAX_VALUE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(deluxePicture, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 758, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(standardPicture, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 190, Short.MAX_VALUE)
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addGroup(panel1Layout.createSequentialGroup()
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 611, Short.MAX_VALUE)
                                                        .addComponent(bookNow, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panel1Layout.createSequentialGroup()
                                                        .addGap(0, 403, Short.MAX_VALUE)
                                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(42, 42, 42)
                                                .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)))
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(standardField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deluxeField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(suiteFieid, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 361, Short.MAX_VALUE))
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
                                            .addComponent(standardField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(deluxePicture, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(deluxeField, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                        .addGap(131, 131, 131)))
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(suitePicture, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(147, 147, 147)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(suiteFieid, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spinner1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addComponent(bookNow, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                    );
                }
                scrollPane1.setViewportView(panel1);
            }

            GroupLayout roomBookingContentPaneLayout = new GroupLayout(roomBookingContentPane);
            roomBookingContentPane.setLayout(roomBookingContentPaneLayout);
            roomBookingContentPaneLayout.setHorizontalGroup(
                roomBookingContentPaneLayout.createParallelGroup()
                    .addComponent(hotelTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roomBookingContentPaneLayout.createSequentialGroup()
                        .addComponent(scrollPane1)
                        .addContainerGap())
            );
            roomBookingContentPaneLayout.setVerticalGroup(
                roomBookingContentPaneLayout.createParallelGroup()
                    .addGroup(roomBookingContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hotelTitle, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1)
                        .addContainerGap())
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
    private JButton bookNow;
    private JLabel label1;
    private JSpinner spinner1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
