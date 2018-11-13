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
public class WaitingList extends JFrame {
    String uniqueId;
    String checkIn;
    String checkOut;
    int noOfStandardRooms;
    int noOfDeluxeRooms;
    int noOfSuitRooms;
    String bookedDate;
    String userName;
    DataBaseController dataBaseController;

    public WaitingList(String uniqueId, String checkIn, String checkOut, int noOfStandardRooms, int noOfDeluxeRooms, int noOfSuitRooms, DataBaseController dataBaseController) {
        this.uniqueId = uniqueId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.noOfStandardRooms = noOfStandardRooms;
        this.noOfDeluxeRooms = noOfDeluxeRooms;
        this.noOfSuitRooms = noOfSuitRooms;
        this.dataBaseController = dataBaseController;
        TextFileController textFileController=new TextFileController();
        userName=textFileController.readFile();
        Date c =  Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       bookedDate = df.format(c);
        initComponents();
        waitingListDialog.setVisible(true);
        waitingListDialog.setIconImage(new ImageIcon(getClass().getResource("/com/sharan/ui/pictures/hotel.png")).getImage());

        waitingListDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void button1ActionPerformed(ActionEvent e) {

        dataBaseController.initialiseDatabase();
        String existance = dataBaseController.checkWaitList(userName,uniqueId,checkIn,checkOut,noOfStandardRooms,noOfDeluxeRooms,noOfSuitRooms,bookedDate);
        if(existance.equals("no")) {
            dataBaseController.addToWaitList(userName, uniqueId, checkIn, checkOut, noOfStandardRooms, noOfDeluxeRooms, noOfSuitRooms, bookedDate);
        }
        dataBaseController.closeDatabaseConnection();
        JOptionPane.showMessageDialog(null,"Thank You for joining WaitingList,We will contact you sooner!!!");
        waitingListDialog.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ajith
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
                                .addGap(180, 180, 180)
                                .addComponent(button1)))
                        .addContainerGap(92, Short.MAX_VALUE))
            );
            waitingListDialogContentPaneLayout.setVerticalGroup(
                waitingListDialogContentPaneLayout.createParallelGroup()
                    .addGroup(waitingListDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button1)
                        .addContainerGap(70, Short.MAX_VALUE))
            );
            waitingListDialog.pack();
            waitingListDialog.setLocationRelativeTo(waitingListDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ajith
    private JDialog waitingListDialog;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
