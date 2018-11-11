/*
 * Created by JFormDesigner on Wed Nov 07 16:39:22 IST 2018
 */

package com.sharan.ui.hotelView.fillOutFields;

import com.sharan.DataBaseController;
import com.sharan.ui.hotelView.hotelHomeAfterLogin.HotelHomeAfterLogin;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * @author SAI SHARAN
 */
public class FillOutFieldsToViewHotelIndividual {

    private String checkInDate;
    private String checkOutDate;
    private DataBaseController dataBaseController;
    private String uniqueId;
    private String userName;
    private String state;
    private String city;
    private String hotelName;
    private JButton toBeClicked;
    private ArrayList<String> list;
    private ArrayList<String> argList;



    public FillOutFieldsToViewHotelIndividual(String userName, String uniqueId, String hotel, JButton toBeClicked, DataBaseController dataBaseController) {
        this.dataBaseController=dataBaseController;
        this.uniqueId=uniqueId;
        String temp[]=hotel.split(",");
        hotelName=temp[0];
        city=temp[1];
        state=temp[2];
        this.userName=userName;
        this.toBeClicked=toBeClicked;

        initComponents();
        fillTheseToContinue.setVisible(true);
        fillTheseToContinue.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        checkInField.setFormats(dateFormat);
        checkOutField.setFormats(dateFormat);
    }

    private String getDate(JXDatePicker checkField) {

        String unparsedDate=checkField.getDate().toString();

        String date=unparsedDate.substring(4,7);
        String month=unparsedDate.substring(8,10);
        String year=unparsedDate.substring(24,28);

        StringBuilder sb=new StringBuilder();
        sb.append(date);
        sb.append("/");
        sb.append(month);
        sb.append("/");
        sb.append(year);

        return sb.toString();
    }

    private void hotelViewActionPerformed(ActionEvent e) {
        checkInDate = getDate(checkInField);
        checkOutDate = getDate(checkOutField);
        java.util.Date current = null;
        java.util.Date checkin = null;
        java.util.Date checkout = null;

        java.util.Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c);


        try {
            current = df.parse(formattedDate);
        } catch (ParseException p) {

            p.printStackTrace();
        }
        try {
            checkin = df.parse(checkInDate);
        } catch (ParseException p) {
            p.printStackTrace();
        }
        try {
            checkout = df.parse(checkOutDate);
        } catch (ParseException p) {
            p.printStackTrace();
        }
        long duration = checkin.getTime() - current.getTime();
        long diffInDaysForCheckIn = TimeUnit.MILLISECONDS.toDays(duration);
        long duration1 = checkout.getTime() - current.getTime();
        long diffInDaysForCheckOut = TimeUnit.MILLISECONDS.toDays(duration1);
        if (diffInDaysForCheckIn <= 0) {
            JOptionPane.showMessageDialog(null, "Please Enter Valid CheckIn Date");
        } else if (diffInDaysForCheckOut <= 0) {
            JOptionPane.showMessageDialog(null, "Please Enter Valid CheckOut Date");
        } else if (diffInDaysForCheckIn >= diffInDaysForCheckOut) {
            JOptionPane.showMessageDialog(null, "Please Enter Valid CheckIn and CheckOut Dates");
        } else if (diffInDaysForCheckIn > 90 || diffInDaysForCheckOut > 90) {
            JOptionPane.showMessageDialog(null, "Sorry Bookings are not yet Opened!!!");
        } else {
            ArrayList<String> list = new ArrayList<>();
            dataBaseController.initialiseDatabase();
            ArrayList<String> parseHotel=dataBaseController.parseHotel(uniqueId);
            dataBaseController.closeDatabaseConnection();
            list.add(uniqueId);
            list.add(parseHotel.get(1));
            list.add(parseHotel.get(2));
            list.add(parseHotel.get(3));
            list.add(parseHotel.get(4));
            list.add(parseHotel.get(5));
            list.add(checkInDate);
            list.add(checkOutDate);
            list.add(userName);
            list.add(city);
            list.add(state);
            list.add(userName);


            HotelHomeAfterLogin hotelHomeAfterLogin = new HotelHomeAfterLogin(list, dataBaseController);

        }
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - SAI SHARAN
        fillTheseToContinue = new JDialog();
        label2 = new JLabel();
        checkInField = new JXDatePicker();
        label3 = new JLabel();
        checkOutField = new JXDatePicker();
        applicationName = new JLabel();
        hotelView = new JButton();

        //======== fillTheseToContinue ========
        {
            Container fillTheseToContinueContentPane = fillTheseToContinue.getContentPane();

            //---- label2 ----
            label2.setText("From:");
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));

            //---- checkInField ----
            checkInField.setFont(checkInField.getFont().deriveFont(checkInField.getFont().getSize() + 6f));
            checkInField.setToolTipText("CheckIN");
            checkInField.setInheritsPopupMenu(true);
            checkInField.setOpaque(true);

            //---- label3 ----
            label3.setText("To:");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));

            //---- checkOutField ----
            checkOutField.setFont(checkOutField.getFont().deriveFont(checkOutField.getFont().getSize() + 6f));
            checkOutField.setToolTipText("CheckOut");

            //---- applicationName ----
            applicationName.setText("Check-In and Check-Out to view selected Hotel:");
            applicationName.setHorizontalAlignment(SwingConstants.CENTER);
            applicationName.setFont(new Font("Dialog", Font.BOLD, 26));
            applicationName.setBackground(new Color(255, 204, 0));
            applicationName.setOpaque(true);

            //---- hotelView ----
            hotelView.setText("View Hotel");
            hotelView.setBackground(new Color(204, 0, 0));
            hotelView.setForeground(Color.white);
            hotelView.setFont(new Font("FreeSans", Font.BOLD, 20));
            hotelView.addActionListener(e -> hotelViewActionPerformed(e));

            GroupLayout fillTheseToContinueContentPaneLayout = new GroupLayout(fillTheseToContinueContentPane);
            fillTheseToContinueContentPane.setLayout(fillTheseToContinueContentPaneLayout);
            fillTheseToContinueContentPaneLayout.setHorizontalGroup(
                fillTheseToContinueContentPaneLayout.createParallelGroup()
                    .addGroup(fillTheseToContinueContentPaneLayout.createSequentialGroup()
                        .addGroup(fillTheseToContinueContentPaneLayout.createParallelGroup()
                            .addGroup(fillTheseToContinueContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(applicationName, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE))
                            .addGroup(fillTheseToContinueContentPaneLayout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(label2)
                                .addGap(18, 18, 18)
                                .addComponent(checkInField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkOutField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(fillTheseToContinueContentPaneLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(hotelView, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            fillTheseToContinueContentPaneLayout.setVerticalGroup(
                fillTheseToContinueContentPaneLayout.createParallelGroup()
                    .addGroup(fillTheseToContinueContentPaneLayout.createSequentialGroup()
                        .addComponent(applicationName, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addGroup(fillTheseToContinueContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(checkInField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkOutField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addComponent(hotelView, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
            );
            fillTheseToContinue.pack();
            fillTheseToContinue.setLocationRelativeTo(fillTheseToContinue.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - SAI SHARAN
    private JDialog fillTheseToContinue;
    private JLabel label2;
    private JXDatePicker checkInField;
    private JLabel label3;
    private JXDatePicker checkOutField;
    private JLabel applicationName;
    private JButton hotelView;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
