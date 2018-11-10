/*
 * Created by JFormDesigner on Tue Nov 06 20:21:32 IST 2018
 */

package com.sharan.ui.hotelView.roomBooking.waitingList;

import com.sharan.DataBaseController;
import com.sharan.fileHandler.TextFileController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        Date c =  Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       bookedDate = df.format(c);
        initComponents();
        waitingListDialog.setVisible(true);
        waitingListDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void button1ActionPerformed(ActionEvent e) {
        DataBaseController dataBaseController = new DataBaseController();
        dataBaseController.initialiseDatabase();
        dataBaseController.addToWaitList(userName,uniqueId,checkIn,checkOut,noOfStandardRooms,noOfDeluxeRooms,noOfSuitRooms,bookedDate);
        dataBaseController.closeDatabaseConnection();
        JOptionPane.showMessageDialog(null,"Thank You for joining waitingList,We will contact you sooner!!!");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        waitingListDialog = new JDialog();
        label1 = new JLabel();
        button1 = new JButton();

        //======== waitingListDialog ========
        {
            waitingListDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container waitingListDialogContentPane = waitingListDialog.getContentPane();

            //---- label1 ----
            label1.setText("Sorry for inconvenience ,Would you like to join waiting list?");

            //---- button1 ----
            button1.setText("Join Waiting List");
            button1.setFont(new Font("Arial", Font.BOLD, 18));
            button1.setForeground(Color.white);
            button1.setBackground(new Color(204, 0, 0));
            button1.addActionListener(e -> button1ActionPerformed(e));

            GroupLayout waitingListDialogContentPaneLayout = new GroupLayout(waitingListDialogContentPane);
            waitingListDialogContentPane.setLayout(waitingListDialogContentPaneLayout);
            waitingListDialogContentPaneLayout.setHorizontalGroup(
                waitingListDialogContentPaneLayout.createParallelGroup()
                    .addGroup(waitingListDialogContentPaneLayout.createSequentialGroup()
                        .addGroup(waitingListDialogContentPaneLayout.createParallelGroup()
                            .addGroup(waitingListDialogContentPaneLayout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(label1))
                            .addGroup(waitingListDialogContentPaneLayout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(button1)))
                        .addContainerGap(157, Short.MAX_VALUE))
            );
            waitingListDialogContentPaneLayout.setVerticalGroup(
                waitingListDialogContentPaneLayout.createParallelGroup()
                    .addGroup(waitingListDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(button1)
                        .addGap(63, 63, 63))
            );
            waitingListDialog.pack();
            waitingListDialog.setLocationRelativeTo(waitingListDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JDialog waitingListDialog;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
