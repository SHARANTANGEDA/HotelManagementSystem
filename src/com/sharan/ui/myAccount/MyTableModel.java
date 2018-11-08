package com.sharan.ui.myAccount;

import javax.swing.*;
import java.util.ArrayList;

public class MyTableModel extends javax.swing.table.DefaultTableModel {
    Object[] row = {new JLabel(""), new JLabel(""), new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),new JLabel(""),
            new JLabel(""),new JLabel("")};

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
            "Hotel Name","Booking Id", "Booking Status","CheckIn Date",
                    "CheckOut Date","Number of Standard Rooms","Number of DeluxeRooms"
                            ,"Number Of SuiteRooms","Total Price Paid","Generate PDF"};

    public void createRow(ColumnsInMyBooking myBooking) {
        this.row= new String[]{myBooking.getHotelName(), myBooking.getBookingId(),myBooking.getBookingStatus(),
                myBooking.getCheckIn(),myBooking.getCheckOut(),myBooking.getStandardRooms(),
                myBooking.getDeluxeRooms(), myBooking.getSuiteRooms(),myBooking.getTotalPricePaid(),
                "Generate Ticket"};
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }


    public MyTableModel (ArrayList<ColumnsInMyBooking> list){

        for (Object c:col)
            addColumn(c);

        for(ColumnsInMyBooking columnsInMyBooking:list) {
            createRow(columnsInMyBooking);
            addRow(row);
        }

    }

    @Override

    public Class getColumnClass(int columnIndex) {
        if(columnIndex == 0)return getValueAt(0, columnIndex).getClass();

        else return super.getColumnClass(columnIndex);

    }
}
