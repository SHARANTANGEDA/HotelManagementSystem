/*
 * Created by JFormDesigner on Tue Nov 06 20:21:32 IST 2018
 */

package com.sharan.ui.hotelView.roomBooking.waitingList;

import com.sharan.DataBaseController;
import com.sharan.fileHandler.TextFileController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Ajith
 */
public class waitingList extends JFrame {
    String uniqueId;
    String checkIn;
    String checkOut;
    int noOfStandardRooms;
    int noOfDeluxeRooms;
    int noOfSuitRooms;
    String bookedDate;
    String userName;

    public waitingList(String uniqueId,String checkIn,String checkOut,int noOfStandardRooms,int noOfDeluxeRooms,int noOfSuitRooms) {
        this.uniqueId = uniqueId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.noOfStandardRooms = noOfStandardRooms;
        this.noOfDeluxeRooms = noOfDeluxeRooms;
        this.noOfSuitRooms = noOfSuitRooms;
        TextFileController textFileController=new TextFileController();
        userName=textFileController.readFile();
        Date c = (Date) Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       bookedDate = df.format(c);
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        DataBaseController dataBaseController = new DataBaseController();
        dataBaseController.initialiseDatabase();
        dataBaseController.addToWaitList(userName,uniqueId,checkIn,checkOut,noOfStandardRooms,noOfDeluxeRooms,noOfSuitRooms,bookedDate);
        dataBaseController.closeDatabaseConnection();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ajith
        dialog1 = new JDialog();
        label1 = new JLabel();
        button1 = new JButton();

        //======== dialog1 ========
        {
            Container dialog1ContentPane = dialog1.getContentPane();

            //---- label1 ----
            label1.setText("Sorry for inconvenience ,Would you like to join waiting list?");

            //---- button1 ----
            button1.setText("Join Waiting List");
            button1.addActionListener(e -> button1ActionPerformed(e));

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1))
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(button1)))
                        .addContainerGap(13, Short.MAX_VALUE))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(button1)
                        .addContainerGap(61, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ajith
    private JDialog dialog1;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
