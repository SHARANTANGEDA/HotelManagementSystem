package com.sharan.ui.myAccount.customTableProperties.tableModels;

import com.sharan.ui.myAccount.ColumnsInWaitingList;

import javax.swing.*;
import java.util.ArrayList;

public class WaitingListTableModel extends javax.swing.table.DefaultTableModel {
    Object[] row = {new JLabel(""),new JLabel(""), new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),
            new JLabel(""),new JButton("")};

//    JLabel l1=new JLabel();
//    JLabel l2=new JLabel();
//    JLabel l3=new JLabel();
//    JLabel l4=new JLabel();
//    JLabel l5=new JLabel();
//    JLabel l6=new JLabel();
//    JLabel l7=new JLabel();
//    JLabel l8=new JLabel();
//    JLabel l9=new JLabel();
//    JLabel l10=new JLabel();

    Object[] col = new String[]{
            "Hotel Name","Booking Date","Booking Id","CheckIn Date",
            "CheckOut Date","Number of Standard Rooms","Number of DeluxeRooms"
            ,"Number Of SuiteRooms","Cancel Booking","Check Status"};

    public void createRow(ColumnsInWaitingList myBooking) {
        this.row= new String[]{myBooking.getHotelName(),myBooking.getBookingDate(), myBooking.getBookingId(),
                myBooking.getCheckIn(),myBooking.getCheckOut(),myBooking.getStandardRooms(),
                myBooking.getDeluxeRooms(), myBooking.getSuiteRooms(),"Cancel Booking","Refresh"};
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }


    public WaitingListTableModel (ArrayList<ColumnsInWaitingList> list){

        for (Object c:col)
            addColumn(c);

        for(ColumnsInWaitingList columnsInWaitingList:list) {
            createRow(columnsInWaitingList);
            addRow(row);
        }

    }

    @Override

    public Class getColumnClass(int columnIndex) {
//        if(columnIndex == 0)return getValueAt(0, columnIndex).getClass();
//
//        else
            return super.getColumnClass(columnIndex);

    }
}
