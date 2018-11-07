/*
 * Created by JFormDesigner on Tue Oct 30 16:49:05 IST 2018
 */

package com.sharan.ui.hotelView.roomBooking;

import com.sharan.DataBaseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author SAI SHARAN
 */
public class RoomBooking extends JFrame {
    String hotelName;
    String standardRoomsPrice;
    String deluxeRoomsPrice;
    String suitRoomsPrice;
    String noofStandardRooms;
    String noofDeluxeRooms;
    String noOfSuitRooms;
    String uniqueId;
    String checkIn;
    String checkOut;
    SpinnerModel standard = new SpinnerNumberModel(0,0,Integer.parseInt(noofStandardRooms),1);
    SpinnerModel deluxe = new SpinnerNumberModel(0,0,Integer.parseInt(noofDeluxeRooms),1);
    SpinnerModel suit = new SpinnerNumberModel(0,0,Integer.parseInt(noOfSuitRooms),1);
    public RoomBooking(String hotelName,String standardRoomsPrice,String deluxeRoomsPrice,String suitRoomsPrice,String uniqueId,String checkIn,String checkOut) {
        this.hotelName = hotelName;
        this.deluxeRoomsPrice = deluxeRoomsPrice;
        this.standardRoomsPrice = standardRoomsPrice;
        this.suitRoomsPrice = suitRoomsPrice;
        this.uniqueId = uniqueId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        DataBaseController dataBaseController = new DataBaseController();
        ArrayList<String>list =dataBaseController.parseHotel(uniqueId);
        noofStandardRooms = list.get(6);
        noofDeluxeRooms = list.get(5);
        noOfSuitRooms = list.get(7);
        initComponents();
    }

    private void bookActionPerformed(ActionEvent e) {
        DataBaseController dataBaseController = new DataBaseController();
        dataBaseController.initialiseDatabase();

    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN

        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        spinner1 = new JSpinner();
        spinner2 = new JSpinner();
        spinner3 = new JSpinner();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("                   HOTEL NAME");

        //---- label2 ----
        label2.setText("SELECT NUMBER OF NORMAL ROOMS");

        //---- label3 ----
        label3.setText("SELECT NUMBER OF DELUXE ROOMS");

        //---- label4 ----
        label4.setText("SELECT NUMBER OF SUIT ROOMS");

        //---- button1 ----
        button1.setText("BOOK NOW");
        button1.addActionListener(e -> button1ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(196, 196, 196)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
                            .addGap(88, 88, 88)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinner2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinner3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(247, 247, 247)
                            .addComponent(button1)))
                    .addContainerGap(143, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinner2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinner3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(61, 61, 61)
                    .addComponent(button1)
                    .addContainerGap(75, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ajith
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
