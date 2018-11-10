package com.sharan;


import com.sharan.encryptionAlgorithms.AES128Encyrption;
import com.sharan.ui.hotelView.displaySelectedHotels.ElementsInHotelView;
import com.sharan.ui.hotelView.paymentPage.PaymentPage;
import com.sharan.ui.hotelView.roomBooking.waitingList.waitingList;
import com.sharan.ui.myAccount.ColumnsInMyBooking;
import com.sharan.ui.myAccount.ColumnsInWaitingList;

import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DataBaseController {

    private String databaseUrl="jdbc:sqlite:HotelBooking.db";
    private String TABLE_CREATOR="CREATE TABLE IF NOT EXISTS ";

    private String userTableNAME ="userDatabase";
    private String userTableCOLUMNS ="(FullName TEXT,UserName TEXT NOT NULL PRIMARY KEY,Password TEXT,DOB TEXT,ResidentialAddress TEXT,Email TEXT,Phone TEXT)";
    private String userInsertParameters =" (FullName,UserName,Password,DOB,ResidentialAddress,Email,Phone)";

    private String hotelsTableNAME ="hotelsDatabase";
    private String hotelsTableCOLUMNS ="(UniqueId TEXT,HotelName TEXT,HotelDescription TEXT,State TEXT,City TEXT,Address TEXT," +
            "Standard TEXT DEFAULT NA,StandardPrice TEXT DEFAULT NA,StandardCapacity INTEGER DEFAULT 10,Deluxe TEXT DEFAULT NA,DeluxePrice TEXT DEFAULT NA,DeluxeCapacity INTEGER DEFAULT 10," +
            "Suite TEXT DEFAULT NA,SuitePrice TEXT DEFAULT NA,SuiteCapacity INTEGER DEFAULT 4,HomeImagePath TEXT,StarRating TEXT DEFAULT 1,NumberOfVotes INTEGER DEFAULT 0)";
    private String hotelsInsertParameters=" (UniqueId,HotelName,HotelDescription,State,City,Address,Standard,StandardPrice,StandardCapacity," +
            "Deluxe,DeluxePrice,DeluxeCapacity,Suite,SuitePrice,SuiteCapacity)";

    private String idTableName = "idDatabase";
    private String idTableColoumns = "(UserName TEXT NOT NULL PRIMARY KEY,Aadhar TEXT,PanCard TEXT)";
    private String idInsertParameters="(UserName,Aadhar,PanCard)";


    private String allotmentTableName="allotmentTable";
    private String allotmentTableColumns="(UserName TEXT,State TEXT,City TEXT, CheckIN TEXT,CheckOUT TEXT,NoOfRoomsRequested TEXT DEFAULT NA, " +
            "HotelUniqueId TEXT,AvailabilityStatus TEXT)";
    private String allotmentTableInsertParameters=" (UserName,State,City,CheckIN,CheckOUT,NoOfRoomsRequested)";
    private String availableTableName = "availableTable";
    private String availableTableColoumns = "(UniqueId TEXT,StandardAvailableArray TEXT,DeluxeAvailableArray TEXT,SuitAvailableArray TEXT,LatestBooking TEXT)";
    private String availableInsertParametres = " (UniqueId,StandardAvailableArray,DeluxeAvailableArray,SuitAvailableArray,LatestBooking)";

    private String waitingListTableName = "waitngListTable";
    private String waitingListTableColoumns = "(UserName TEXT NOT NULL PRIMARY KEY,UniqueId TEXT,CheckIn TEXT,CheckOut TEXT,StandardRooms INTEGER,DeluxeRooms INTEGER,SuiteRooms INTEGER,BookingDate TEXT)";
    private String waitListInsertParametres = " (UserName,UniqueId,CheckIn,CheckOut,StandardRooms,DeluxeRooms,SuiteRooms,BookingDate)";

    private String myBookingsTableName="myBookingsTable";
    private String myBookingsTableColumns="(UserName TEXT NOT NULL PRIMARY KEY,HotelName TEXT, BookingId TEXT,BookingStatus TEXT,CheckIn TEXT,CheckOut TEXT," +
            "StandardRooms INTEGER,DeluxeRooms INTEGER,SuiteRooms INTEGER,BookingDate TEXT,TotalPricePaid TEXT,Address TEXT,UniqueId TEXT)";
    private String myBookingParametres = " (UserName,HotelName,BookingId,BookingStatus,CheckIn,CheckOut,StandardRooms,DeluxeRooms,SuiteRooms,BookingDate,TotalPricePaid,Address,UniqueId)";

    private Connection conn=null;
    private Statement statement=null;


    public void initialiseDatabase() {
        try {
            conn=DriverManager.getConnection(databaseUrl);
            statement=conn.createStatement();
            statement.execute(TABLE_CREATOR+ userTableNAME + userTableCOLUMNS);
            statement.execute(TABLE_CREATOR+ hotelsTableNAME + hotelsTableCOLUMNS);
            statement.execute(TABLE_CREATOR+idTableName+idTableColoumns);
            statement.execute(TABLE_CREATOR+allotmentTableName+allotmentTableColumns);
            statement.execute(TABLE_CREATOR+availableTableName+availableTableColoumns);
            statement.execute(TABLE_CREATOR+waitingListTableName+waitingListTableColoumns);
            statement.execute(TABLE_CREATOR+myBookingsTableName+myBookingsTableColumns);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addToWaitList(String userName,String uniqueId,String checkIn,String checkOut,int standardRooms,int deluxeRooms,int suitRooms,String bookedDate)
    {
        try {
            statement.execute("INSERT INTO "+waitingListTableName+waitListInsertParametres+" VALUES('"+userName+"','"+uniqueId+"','"+checkIn+"','"+
                    checkOut+"',"+standardRooms+","+deluxeRooms+","+suitRooms+"'"+bookedDate+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser (String fullName,String userName,String password,String dateOfBirth,String address,String email,String phone) throws SQLException{
        statement.execute("INSERT INTO "+ userTableNAME + userInsertParameters +" VALUES('" +fullName+"','"+userName+"','"
                +password+"','"+dateOfBirth+"','"+address+"','"+email+"','"+phone+"')");
    }

    public void addHotel (String uniqueId,String hotelName,String description,String state,String city,String address,String standard,String stdPrice,String stcapacity
                                        ,String deluxe,String deluxePrice,String delcapacity, String suite,String suitePrice,String suitecapacity,String imagePath) throws SQLException {

        statement.execute("INSERT INTO "+hotelsTableNAME+hotelsInsertParameters+"VALUES('"+uniqueId+"','"+hotelName+"','"+description+"','"+state
                +"','"+city+"','" +address+"','"+standard+"','"+stdPrice+"','"+stcapacity+"','"+deluxe+"','"+deluxePrice+"','"+delcapacity+"','"
                +suite+"','"+suitePrice+"','" +suitecapacity+ "','"+imagePath+"')");
    }
    public void checkAvailable(String userName,String uniqueId,String checkIn,String checkOut,int noOfStandardRooms,int noOfDeluxeRooms,int noOfSuitRooms,int maxStandardRooms,int maxDeluxeRooms,int maxSuitRooms)
    {
        try {
            if(!conn.isClosed())
            {
                int flag =0;
                ArrayList<String> availableList = new ArrayList<>();
                ResultSet rs = statement.executeQuery("SELECT * FROM " + availableTableName);
                System.out.println(rs);
              while (rs.next())
              {
                  String getUniqueId = rs.getString("UniqueId");
                  System.out.println(getUniqueId);
                  if (getUniqueId.equals(uniqueId))
                  {
                      flag = 1;
                  }
              }
                System.out.println("flag = "+flag);
                java.util.Date current=null;
                java.util.Date checkin=null;
                java.util.Date checkout=null;

                java.util.Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = df.format(c);
                System.out.println(formattedDate+"/n"+checkIn+"/n"+checkOut);

                try {
                    current =  df.parse(formattedDate);
                } catch (ParseException e) {

                    e.printStackTrace();
                }
                try {
                    checkin =  df.parse(checkIn);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    checkout =  df.parse(checkOut);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long duration = checkin.getTime()-current.getTime();
                long diffInDaysForCheckIn = TimeUnit.MILLISECONDS.toDays(duration);
                System.out.println("diffInDaysForCheckIn"+diffInDaysForCheckIn);
                long duration1 = checkout.getTime()-current.getTime();
                long diffInDaysForCheckOut = TimeUnit.MILLISECONDS.toDays(duration1);
                System.out.println("diffInDaysForCheckOut"+diffInDaysForCheckOut);
                if(flag ==1) {


                    int x = 0, y = 0, z = 0;
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM " + availableTableName + " WHERE UniqueId='" + uniqueId + "'");
                    String standardAvailableString = resultSet.getString("StandardAvailableArray");
                    String deluxeAvailableString = resultSet.getString("DeluxeAvailableArray");
                    String suitAvailableString = resultSet.getString("SuitAvailableArray");
                    String lastLatestBooking = resultSet.getString("LatestBooking");
                    java.util.Date latestBooking = null;
                    try {
                        latestBooking = df.parse(lastLatestBooking);
                    } catch (ParseException e) {

                        e.printStackTrace();
                    }
                    int[] standardAvailableArray = new int[90];
                    int[] deluxeAvailableArray = new int[90];
                    int[] suitAvailableArray = new int[90];
                    StringBuffer intial = new StringBuffer();
                    int j = 0;
                    for (char i : standardAvailableString.toCharArray()) {
                        if (i == ',') {
                            standardAvailableArray[j] = Integer.parseInt(intial.toString());
                            intial = new StringBuffer();
                            j++;
                        } else {
                            intial.append(i);
                        }
                    }
                    StringBuffer deluxe = new StringBuffer();
                    int k = 0;
                    for (char i : deluxeAvailableString.toCharArray()) {
                        if (i == ',') {
                            deluxeAvailableArray[k] = Integer.parseInt(deluxe.toString());
                            deluxe = new StringBuffer();
                            k++;
                        } else {
                            deluxe.append(i);
                        }
                    }
                    StringBuffer suite = new StringBuffer();
                    int l = 0;
                    for (char i : suitAvailableString.toCharArray()) {
                        if (i == ',') {
                            standardAvailableArray[l] = Integer.parseInt(suite.toString());
                            suite = new StringBuffer();
                            l++;
                        } else {
                            suite.append(i);
                        }
                    }

                    int diffBetweenBookings = (int) TimeUnit.MILLISECONDS.toDays((current.getTime() - latestBooking.getTime()));
                    //pushing the availableArrays to get to current time
                    for (int i = 0; i < 90 - diffBetweenBookings; i++) {
                        standardAvailableArray[i] = standardAvailableArray[i + diffBetweenBookings];
                        deluxeAvailableArray[i] = deluxeAvailableArray[i + diffBetweenBookings];
                        suitAvailableArray[i] = suitAvailableArray[i + diffBetweenBookings];
                    }
                    for (int i = 90 - diffBetweenBookings; i < 90; i++) {
                        standardAvailableArray[i] = 0;
                        deluxeAvailableArray[i] = 0;
                        suitAvailableArray[i] = 0;
                    }

                    for (int i = Integer.parseInt(String.valueOf(diffInDaysForCheckIn)); i < Integer.parseInt(String.valueOf(diffInDaysForCheckOut)); i++) {
                        if (standardAvailableArray[i] < noOfStandardRooms) {
                            x = 1;
                            //JOptionPane.showMessageDialog(null, "Sorry for inconvience,Required number of Standard Rooms are not available");
                            // waitingList waitingList = new waitingList(uniqueId,checkIn,checkOut,noOfDeluxeRooms,noOfDeluxeRooms,noOfSuitRooms);
                        }
                        if (deluxeAvailableArray[i] < noOfDeluxeRooms) {
                            y = 1;
                           // JOptionPane.showMessageDialog(null, "Sorry for inconvience,Required number of Deluxe Rooms are not available");
                        }
                        if (suitAvailableArray[i] < noOfSuitRooms) {
                            z = 1;
                           // JOptionPane.showMessageDialog(null, "Sorry for inconvience,Required number of Suit Rooms are not available");
                        }
                    }
                    if (x == 0 && y == 0 && z == 0) {
                        for (int i = Integer.parseInt(String.valueOf(diffInDaysForCheckIn)); i < Integer.parseInt(String.valueOf(diffInDaysForCheckOut)); i++) {

                            standardAvailableArray[i] = standardAvailableArray[i] - noOfStandardRooms;

                        }

                        for (int i = Integer.parseInt(String.valueOf(diffInDaysForCheckIn)); i < Integer.parseInt(String.valueOf(diffInDaysForCheckOut)); i++) {
                            deluxeAvailableArray[i] = deluxeAvailableArray[i] - noOfDeluxeRooms;
                        }

                        for (int i = Integer.parseInt(String.valueOf(diffInDaysForCheckIn)); i < Integer.parseInt(String.valueOf(diffInDaysForCheckOut)); i++) {
                            suitAvailableArray[i] = suitAvailableArray[i] - noOfSuitRooms;
                        }

                        StringBuffer standardBuilder = new StringBuffer();
                        StringBuffer deluxeBuilder = new StringBuffer();
                        StringBuffer suiteBuilder = new StringBuffer();
                        for (int i = 0; i < 90; i++) {
                            String s = String.valueOf(standardAvailableArray[i]);
                            standardBuilder.append(s + ",");
                        }
                        String updatedStandardAvailableString = standardBuilder.toString();
                        for (int i = 0; i < 90; i++) {
                            String s = String.valueOf(deluxeAvailableArray[i]);
                            deluxeBuilder.append(s + ",");
                        }
                        String updatedDeluxeAvailableString = deluxeBuilder.toString();
                        for (int i = 0; i < 90; i++) {
                            String s = String.valueOf(suitAvailableArray[i]);
                            suiteBuilder.append(s + ",");
                        }
                        String updatedSuiteAvailableString = suiteBuilder.toString();
                        availableList.add(updatedStandardAvailableString);
                        availableList.add(updatedDeluxeAvailableString);
                        availableList.add(updatedSuiteAvailableString);
                        availableList.add(formattedDate);
                        System.out.println("Trying to open Payment Page");
                        PaymentPage paymentPage = new PaymentPage(1,availableList,userName,this,noOfStandardRooms,noOfDeluxeRooms,noOfSuitRooms,uniqueId,checkIn,checkOut);
                        statement.execute("UPDATE " + availableTableName + " SET StandardAvailableArray '" + updatedStandardAvailableString + "' WHERE UniqueId='" + uniqueId + "'");
                        statement.execute("UPDATE " + availableTableName + " SET DeluxeAvailableArray '" + updatedDeluxeAvailableString + "' WHERE UniqueId='" + uniqueId + "'");
                        statement.execute("UPDATE " + availableTableName + " SET SuitAvailableArray '" + updatedSuiteAvailableString + "' WHERE UniqueId='" + uniqueId + "'");
                        statement.execute("UPDATE " + availableTableName + " SET LatestBooking '" + formattedDate + "' WHERE UniqueId='" + uniqueId + "'");

                    }
                    else {
                        waitingList waitingList = new waitingList(uniqueId,checkIn,checkOut,noOfStandardRooms,noOfDeluxeRooms,noOfSuitRooms);
                    }
                }
                else
                {
                    int[] standardAvailableArray = new int[90];
                    int[] deluxeAvailableArray = new int[90];
                    int[] suitAvailableArray = new int[90];
                    for(int i=0;i<90;i++)
                    {
                        standardAvailableArray[i] =  maxStandardRooms;
                    }
                    for(int i=0;i<90;i++)
                    {
                        deluxeAvailableArray[i] = maxDeluxeRooms;
                    }
                    for(int i=0;i<90;i++)
                    {
                        suitAvailableArray[i] = maxSuitRooms;
                    }
                    for (int i=0;i<90;i++)
                    {
                        System.out.print(standardAvailableArray[i]);
                    }
                    System.out.println("\n");
                    for (int i=0;i<90;i++)
                    {
                        System.out.print(deluxeAvailableArray[i]);
                    }
                    System.out.println("\n");
                    for (int i=0;i<90;i++)
                    {
                        System.out.print(suitAvailableArray[i]);
                    }
                    System.out.println("\n");
                    for (int i=Integer.parseInt(String.valueOf(diffInDaysForCheckIn));i<Integer.parseInt(String.valueOf(diffInDaysForCheckOut));i++) {
                        int f;

                        f = standardAvailableArray[i] - noOfStandardRooms;

                        standardAvailableArray[i] = f;
                    }

                    for (int i=Integer.parseInt(String.valueOf(diffInDaysForCheckIn));i<Integer.parseInt(String.valueOf(diffInDaysForCheckOut));i++) {
                        int f;

                        f =deluxeAvailableArray[i] - noOfDeluxeRooms;

                        deluxeAvailableArray[i] = f;
                    }

                    for(int i=Integer.parseInt(String.valueOf(diffInDaysForCheckIn));i<Integer.parseInt(String.valueOf(diffInDaysForCheckOut));i++)
                    {
                        int f;

                        f = suitAvailableArray[i]-noOfSuitRooms;

                        suitAvailableArray[i]=f;
                    }
                    StringBuffer standardBuilder=new StringBuffer();
                    StringBuffer deluxeBuilder=new StringBuffer();
                    StringBuffer suiteBuilder=new StringBuffer();
                    for (int i=0;i<90;i++) {
                        String x = String.valueOf(standardAvailableArray[i]);
                        standardBuilder.append(x + ",");
                    }
                    String standardAvailableString= standardBuilder.toString();
                    for (int i=0;i<90;i++) {
                        String x = String.valueOf(deluxeAvailableArray[i]);
                       deluxeBuilder.append(x + ",");
                    }
                    String deluxeAvailableString= deluxeBuilder.toString();
                    for (int i=0;i<90;i++) {
                        String x = String.valueOf(suitAvailableArray[i]);
                        suiteBuilder.append(x + ",");
                    }
                    String suiteAvailableString= suiteBuilder.toString();
                    availableList.add(standardAvailableString);
                    availableList.add(deluxeAvailableString);
                    availableList.add(suiteAvailableString);
                    availableList.add(formattedDate);
                    PaymentPage paymentPage = new PaymentPage(0,availableList,userName,this,noOfStandardRooms,noOfDeluxeRooms,noOfSuitRooms,uniqueId,checkIn,checkOut);
                System.out.println(standardAvailableString+"','"+
                            deluxeAvailableString+"','"+suiteAvailableString+"','"+formattedDate);
                    statement.execute("INSERT INTO "+ availableTableName+availableInsertParametres+"VALUES('"+uniqueId+"','"+standardAvailableString+"','"+
                            deluxeAvailableString+"','"+suiteAvailableString+"','"+formattedDate+"')");
                    System.out.println("Trying to open Payment Page");

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cancelBooking(String bookingId,String uniqueId,String checkIn,String checkOut,int noOfStandardRooms,int noOfDeluxeRooms,int noOfSuitRooms,String bookingDate) {
        try {
            if (!conn.isClosed()) {
                java.util.Date current=null;
                java.util.Date bookedDate = null;
                java.util.Date checkin=null;
                java.util.Date checkout=null;
                Date lastUpdated = null;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = df.format(c);

                try {
                    current =  df.parse(formattedDate);
                } catch (ParseException e) {

                    e.printStackTrace();
                }
                try {
                    bookedDate =  df.parse(bookingDate);
                } catch (ParseException e) {

                    e.printStackTrace();
                }

                try {
                    checkin =  df.parse(checkIn);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    checkout =  df.parse(checkOut);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                statement.executeQuery("DELETE FROM "+myBookingsTableName+" WHERE BookingId='"+bookingId +"'");


                ResultSet rs = statement.executeQuery("SELECT * FROM " + availableTableName);
                while (rs.next())
                {
                    String getUniqueId = rs.getString("UniqueId");
                    System.out.println(getUniqueId);
                    if (getUniqueId.equals(uniqueId))
                    {
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM "+availableTableName+" WHERE UniqueId='"+ uniqueId + "'");
                        String standardAvailableString = resultSet.getString("StandardAvailableArray");
                        String deluxeAvailableString = resultSet.getString("DeluxeAvailableArray");
                        String suitAvailableString = resultSet.getString("SuitAvailableArray");
                        String lastLatestBooking = resultSet.getString("LatestBooking");
                        java.util.Date latestBooking = null;
                        try {
                            latestBooking = df.parse(lastLatestBooking);
                        } catch (ParseException e) {

                            e.printStackTrace();
                        }
                        int[] standardAvailableArray = new int[90];
                        int[] deluxeAvailableArray = new int[90];
                        int[] suitAvailableArray = new int[90];
                        StringBuffer intial = new StringBuffer();
                        int j = 0;
                        for (char i : standardAvailableString.toCharArray()) {
                            if (i == ',') {
                                standardAvailableArray[j] = Integer.parseInt(intial.toString());
                                intial = new StringBuffer();
                                j++;
                            } else {
                                intial.append(i);
                            }
                        }
                        StringBuffer deluxe = new StringBuffer();
                        int k = 0;
                        for (char i : deluxeAvailableString.toCharArray()) {
                            if (i == ',') {
                                deluxeAvailableArray[k] = Integer.parseInt(deluxe.toString());
                                deluxe = new StringBuffer();
                                k++;
                            } else {
                                deluxe.append(i);
                            }
                        }
                        StringBuffer suite = new StringBuffer();
                        int l = 0;
                        for (char i : suitAvailableString.toCharArray()) {
                            if (i == ',') {
                                standardAvailableArray[l] = Integer.parseInt(suite.toString());
                                suite = new StringBuffer();
                                l++;
                            } else {
                                suite.append(i);
                            }
                        }
                        for (int i = 0; i < 90; i++) {
                            System.out.print(standardAvailableArray[i]);
                        }

                        long duration = checkin.getTime()-latestBooking.getTime();
                        int diffInDaysForCheckIn = (int) TimeUnit.MILLISECONDS.toDays(duration);
                        long duration1 = checkout.getTime()-latestBooking.getTime();
                        int diffInDaysForCheckOut = (int) TimeUnit.MILLISECONDS.toDays(duration1);
                        for (int i = diffInDaysForCheckIn; i < diffInDaysForCheckOut; i++) {

                            standardAvailableArray[i] = standardAvailableArray[i] + noOfStandardRooms;


                        }

                        for (int i = diffInDaysForCheckIn; i < diffInDaysForCheckOut; i++) {
                            deluxeAvailableArray[i] = deluxeAvailableArray[i] + noOfStandardRooms;
                        }

                        for(int i=diffInDaysForCheckIn;i<diffInDaysForCheckOut;i++)
                        {
                            suitAvailableArray[i] = suitAvailableArray[i] + noOfStandardRooms;
                        }
                        StringBuffer standardBuilder=new StringBuffer();
                        StringBuffer deluxeBuilder=new StringBuffer();
                        StringBuffer suiteBuilder=new StringBuffer();
                        for (int i=0;i<90;i++) {
                            String x = String.valueOf(standardAvailableArray[i]);
                            standardBuilder.append(x + ",");
                        }
                        String updatedStandardAvailableString= standardBuilder.toString();
                        for (int i=0;i<90;i++) {
                            String x = String.valueOf(deluxeAvailableArray[i]);
                            deluxeBuilder.append(x + ",");
                        }
                        String updatedDeluxeAvailableString= deluxeBuilder.toString();
                        for (int i=0;i<90;i++) {
                            String x = String.valueOf(suitAvailableArray[i]);
                            suiteBuilder.append(x + ",");
                        }
                        String updatedSuiteAvailableString= suiteBuilder.toString();
                        statement.execute("UPDATE "+availableTableName+ " SET StandardAvailableArray '"+updatedStandardAvailableString+"' WHERE UniqueId='"+uniqueId+"'");
                        statement.execute("UPDATE "+availableTableName+ " SET DeluxeAvailableArray '"+updatedDeluxeAvailableString+"' WHERE UniqueId='"+uniqueId+"'");
                        statement.execute("UPDATE "+availableTableName+ " SET SuitAvailableArray '"+updatedSuiteAvailableString+"' WHERE UniqueId='"+uniqueId+"'");
                        long duration2 = current.getTime()-checkin.getTime();
                        int diffInDaysForCancel= (int) TimeUnit.MILLISECONDS.toDays(duration2);
                        if (diffInDaysForCancel>3)
                        {
                            JOptionPane.showMessageDialog(null,"Successful!,Your Total Money has been Credited!!");
                        }
                        else if (diffInDaysForCancel>=0&&diffInDaysForCancel<=3)
                        {
                            JOptionPane.showMessageDialog(null,"Successful!,50% of  Total Money has been Credited!!");

                        }
                    }

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addRating(String id,int rate) throws SQLException{

        if(!conn.isClosed()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM " + hotelsTableNAME + " WHERE UniqueId='" + id + "'");

            String srate = rs.getString("StarRating");
            String nRate=rs.getString("NumberOfVotes");
            int num=Integer.parseInt(nRate);

            double initialRating = Double.parseDouble(srate);
            num+=1;
            double newRating=((initialRating*(num-1))+(double)rate )/(num);

            String rating=String.valueOf(newRating);
            String newNumberOfVotes=String.valueOf(num);
            statement.execute("UPDATE  "+hotelsTableNAME + " SET StarRating= '"+rating+"' WHERE  UniqueId='"+id+"'");
            statement.execute("UPDATE  "+hotelsTableNAME + " SET NumberOfVotes= "+newNumberOfVotes+" WHERE  UniqueId='"+id+"'");
        }
    }
    public String generateBookingId(String userName)
    {
        StringBuffer bookingId= new StringBuffer();
        for(int i=0;i<3;i++)
        {
            bookingId = bookingId.append(userName.toCharArray()[i]);

        }
        Random rnd = new Random();
        int n = 1000000 + rnd.nextInt(9000000);
        bookingId = bookingId.append(n);
        return bookingId.toString();
    }
    public void addToMyBookings(String userName,String hotelName,String status,String checkIn,String checkOut,int standardRooms,int deluxeRooms,int suiteRooms,String totalPrice,String address,String uniqueId)
    {
       String bookingId = generateBookingId(userName);
        java.util.Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String bookedDate = df.format(c);
        try {
            statement.execute("INSERT INTO "+myBookingsTableName+myBookingParametres+"VALUES ('"+userName+"','"+hotelName+"','"+bookingId+"','"+status+"','"+checkIn+"','"+checkOut+"',"+standardRooms+
                    ","+deluxeRooms+","+suiteRooms+",'"+bookedDate+"','"+totalPrice+"','"+address+"','"+uniqueId+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getRoomPriceFromHotel(String uniqueId) {
        ArrayList<String> list=new ArrayList<>();
        try {
            if (!conn.isClosed()) {
                ResultSet rs=statement.executeQuery("SELECT * FROM "+hotelsTableNAME+" WHERE UniqueId = '"+uniqueId+"'");

                while (rs.next()) {
                    String standardPrice=rs.getString("StandardPrice");
                    String deluxePrice=rs.getString("DeluxePrice");
                    String suitePrice=rs.getString("SuitePrice");

                    list.add(standardPrice);
                    list.add(deluxePrice);
                    list.add(suitePrice);
                }
            }
            return list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public String checkIdForPayment(String userName,String encrptedId) {
        String encryptedAadharFromDataBase;
        String encryptedPanFromDatabase;
        try {
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+idTableName+" WHERE UserName = '"+userName+"'");

            do{
                encryptedAadharFromDataBase= AES128Encyrption.encrypt(resultSet.getString("Aadhar"));
                encryptedPanFromDatabase=AES128Encyrption.encrypt(resultSet.getString("PanCard"));
            }while (resultSet.next());

          if(encryptedAadharFromDataBase.equals(encrptedId)) {
              return "AadharSuccess";
          }else if(encryptedPanFromDatabase.equals(encrptedId)) {
              return "PanSuccess";
          } else {
              return "fail";
          }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addAadharDetailsToTable(String userName,String aadhar,String Pan) {
        try {
            statement.execute("INSERT INTO "+idTableName+idInsertParameters+" VALUES ('"+userName+"','"+aadhar+"','"+Pan+"')");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> parseHotel(String id) {
        ArrayList<String> list=new ArrayList<>();

        try {
            if(!conn.isClosed()) {
                ResultSet rs=statement.executeQuery("SELECT * FROM "+hotelsTableNAME+" WHERE UniqueId = '"+id+"'");

                System.out.println(id);
                while (rs.next()) {

                    String hotelName=rs.getString("HotelName");
                    String hotelDescription=rs.getString("HotelDescription");
                    String hotelAddress=rs.getString("Address");
                    String imagePath=rs.getString("HomeImagePath");
                    int numberOfVotes=rs.getInt("NumberOfVotes");
                    String numOfVotes=String.valueOf(numberOfVotes);


                    list.add(id);
                    list.add(hotelName);
                    list.add(hotelDescription);
                    list.add(hotelAddress);
                    list.add(imagePath);
                    list.add(numOfVotes);
                }

                return list;
            }
        }catch (SQLException e){
            System.out.println("Parsing Error "+e.getMessage());
        }

        return list;

    }



    public double calculateRating(String id) {
        double finalrate=0;
        String srate="5.0";
        try {
            if (!conn.isClosed()) {

                ResultSet rs = statement.executeQuery("SELECT * FROM " + hotelsTableNAME + " WHERE UniqueId='" + id + "'");

                while (rs.next()) {
                    srate = rs.getString("StarRating");

                }
                double rating = Double.parseDouble(srate);




                if((rating>=0) && (rating<=0.25)) {
                    finalrate=0;
                }else if((rating>0.25) && (rating<=0.75)) {
                    finalrate=0.5;
                }else if((rating>0.75) && (rating<=1.25)) {
                    finalrate=1;
                }else if((rating>1.25) && (rating<=1.75)) {
                    finalrate=1.5;
                }else if((rating>1.75) && (rating<=2.25)) {
                    finalrate=2;
                }else if ((rating>2.25) && (rating<=2.75)) {
                    finalrate=2.5;
                }else if((rating>2.75) && (rating<=3.25)) {
                    finalrate=3;
                }else if((rating>3.25) && (rating<=3.75)) {
                    finalrate=3.5;
                }else if((rating>3.75) && (rating<=4.25)) {
                    finalrate=4;
                }else if((rating>4.25) && (rating<=4.75)) {
                    finalrate=4.5;
                }else if((rating>4.75) && (rating<=5)) {
                    finalrate=5;
                }else {
                    finalrate=-1;
                    System.out.println(finalrate);
                }

            } else {
                System.out.println("conn is closed");
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }

        return finalrate;
    }

    public void addAllotmentDetailsToDatabase(String userName,String state,String city,String checkIN,String checkOUT,String noOfRooms) {
        try {
            statement.execute("INSERT INTO "+allotmentTableName+allotmentTableInsertParameters+"VALUES ('"+userName+"','"+state+"','"+city+"','"+
                    checkIN+"','"+checkOUT+"','"+noOfRooms+"')");
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public ArrayList<ColumnsInMyBooking> getMyAccountTableRows(String userName){
        ArrayList<ColumnsInMyBooking> list=new ArrayList<>();
        try {
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+myBookingsTableName +" WHERE UserName = '"+userName+"'");
            while (resultSet.next()) {
                ArrayList<String> rowList=new ArrayList<>();
                rowList.add(resultSet.getString("UserName"));
                rowList.add(resultSet.getString("HotelName"));
                rowList.add(resultSet.getString("BookingId"));
                rowList.add(resultSet.getString("BookingStatus"));
                rowList.add(resultSet.getString("CheckIn"));
                rowList.add(resultSet.getString("CheckOut"));
                rowList.add(resultSet.getString("StandardRooms"));
                rowList.add(resultSet.getString("DeluxeRooms"));
                rowList.add(resultSet.getString("SuiteRooms"));
                rowList.add(resultSet.getString("BookingDate"));
                rowList.add(resultSet.getString("TotalPricePaid"));
                rowList.add(resultSet.getString("UniqueId"));

                ColumnsInMyBooking columnsInMyBooking=new ColumnsInMyBooking(rowList);
                list.add(columnsInMyBooking);
            }


            return list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<ColumnsInWaitingList> getWaitingListTableRows(String userName) {
        ArrayList<ColumnsInWaitingList> list=new ArrayList<>();
        try {
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+waitingListTableName+" WHERE UserName = '"+userName+"'");
            while (resultSet.next()) {

                initialiseDatabase();
                ArrayList<String> parseHotelList=parseHotel(resultSet.getString("UniqueId"));
                String hotelName=parseHotelList.get(1);


                String bookingId=generateBookingId(userName);
                ArrayList<String> rowList=new ArrayList<>();

                rowList.add(userName);
                rowList.add(hotelName);
                rowList.add(bookingId);

                rowList.add(resultSet.getString("CheckIn"));
                rowList.add(resultSet.getString("CheckOut"));
                rowList.add(resultSet.getString("StandardRooms"));
                rowList.add(resultSet.getString("DeluxeRooms"));
                rowList.add(resultSet.getString("SuiteRooms"));
                rowList.add(resultSet.getString("BookingDate"));
                rowList.add(resultSet.getString("UniqueId"));

                ColumnsInWaitingList columnsInWaitingList=new ColumnsInWaitingList(rowList);
                list.add(columnsInWaitingList);

            }


            return list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<ElementsInHotelView> getHotelsBasedOnAllotmentDetails(ArrayList<String> list) {
        ArrayList<ElementsInHotelView> displayList=new ArrayList<>();
        String state=list.get(1);
        String city=list.get(2);
        try {
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+hotelsTableNAME+" WHERE ( State = '"+state+"' "+"AND City = '"+city+"' )");
            while (resultSet.next()) {


                ElementsInHotelView elements=new ElementsInHotelView(resultSet.getString("UniqueId"),resultSet.getString("HotelName"),resultSet.getString("Address"),
                        resultSet.getString("HotelDescription"),resultSet.getString("StandardPrice"),resultSet.getInt("StandardCapacity"),
                        resultSet.getString("DeluxePrice"),resultSet.getInt("DeluxeCapacity"),resultSet.getString("SuitePrice"),resultSet.getInt("SuiteCapacity"),
                        resultSet.getString("HomeImagePath"),resultSet.getString("StarRating"),resultSet.getInt("NumberOfVotes"));

                displayList.add(elements);
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return displayList;

    }
    public ArrayList<String> getPDFdetails(String bookingId) {
        ArrayList<String> list=new ArrayList<>();
        try {
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+myBookingsTableName+" WHERE BookingId = '"+bookingId+"'");
            while (resultSet.next()) {
                list.add(resultSet.getString("UserName"));
                list.add(resultSet.getString("HotelName"));
                list.add(resultSet.getString("BookingId"));
                list.add(resultSet.getString("BookingStatus"));
                list.add(resultSet.getString("CheckIn"));
                list.add(resultSet.getString("CheckOut"));
                list.add(String.valueOf(resultSet.getInt("StandardRooms")));
                list.add(String.valueOf(resultSet.getInt("DeluxeRooms")));
                list.add(String.valueOf(resultSet.getInt("SuiteRooms")));
                list.add(resultSet.getString("BookingDate"));
                list.add(resultSet.getString("TotalPricePaid"));
                list.add(resultSet.getString("Address"));
                return list;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String Verify(String username) {

        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT Password FROM " + userTableNAME + " WHERE UserName = '" +username+ "'" );
                if(resultSet.next()) {
                    return resultSet.getString("Password");
                }else {
                    return "null";
                }

            } else {
                return "Connection is Closed";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Exception";
        }
    }

    public String checkUser(String username){
        int x =0;
        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT UserName FROM userDataBase" );
                while (resultSet.next())
                {
                    String u = resultSet.getString("UserName");
                    if(u.equals(username))

                    {
                        //  JOptionPane.showMessageDialog(null,"UserName Already Exists");
                        x=1;
                    }
                }
                if (x==1)
                {
                    return "s";
                }
                else return "f";

            } else {
                return "f";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return "f";
    }

    public ArrayList<String> getUniversalSearchData() {
        ArrayList<String> list=new ArrayList<>();
        try {
            ResultSet rs=statement.executeQuery("SELECT *  FROM "+hotelsTableNAME);
            while (rs.next()) {
                list.add(rs.getString("HotelName")+","+rs.getString("City")+","+rs.getString("State"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String setUniversalSearchData(String temp[]) {
        String uniqueId;
        boolean exist=false;
        try {
            if(!conn.isClosed()) {

                ResultSet resultSet=statement.executeQuery("SELECT * FROM " + hotelsTableNAME + " WHERE ( (HotelName = '" + temp[0] + "') AND (City = '" + temp[1] +
                        "') AND (State = '" + temp[2] + "') )");

                do {
                    uniqueId=resultSet.getString("UniqueId");
                    return uniqueId;
                }while (resultSet.next());

            }


        }catch (SQLException  e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<String> getIndividualHotelImages(String uniqueId) {
        ArrayList<String> list=new ArrayList<>();
        try {
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+hotelsTableNAME+" WHERE UniqueId = '"+uniqueId+"'");

            do{
                list.add(resultSet.getString("Standard"));
                list.add(resultSet.getString("Deluxe"));
                list.add(resultSet.getString("Suite"));
            }while (resultSet.next());

            return list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void closeDatabaseConnection() {
        try {
            if (!conn.isClosed()) {
                statement.close();
                conn.close();
            } else {
                System.out.println("Error Closing DataBase");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
    public ArrayList<String> getWholeData(String uniqueId)
    {
        ArrayList<String> list = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM"+hotelsTableNAME+" WHERE UniqueId='"+uniqueId+"'");
            do {
                list.add(resultSet.getString("HotelName"));
                list.add(resultSet.getString("Address"));
                list.add(resultSet.getString("Standard"));
                list.add(resultSet.getString("StandardPrice"));
                list.add(String.valueOf(resultSet.getInt("StandardCapacity")));
                list.add(resultSet.getString("Deluxe"));
                list.add(resultSet.getString("DeluxePrice"));
                list.add(String.valueOf(resultSet.getInt("DeluxeCapacity")));
                list.add(resultSet.getString("Suite"));
                list.add(resultSet.getString("SuitePrice"));
                list.add(String.valueOf(resultSet.getInt("SuiteCapacity")));
            }while (resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
