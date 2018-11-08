package com.sharan;


import com.sharan.ui.hotelView.displaySelectedHotels.ElementsInHotelView;

import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
//    private String idInsertParametres = "(UserName,Aadhar,PanCard)";


    private String allotmentTableName="allotmentTable";
    private String allotmentTableColumns="(UserName TEXT,State TEXT,City TEXT, CheckIN TEXT,CheckOUT TEXT,NoOfRoomsRequested TEXT DEFAULT NA, " +
            "HotelUniqueId TEXT,AvailabilityStatus TEXT)";
    private String allotmentTableInsertParameters=" (UserName,State,City,CheckIN,CheckOUT,NoOfRoomsRequested)";
    private String availableTableName = "availableTable";
    private String availableTableColoumns = "(UniqueId TEXT,StandardAvailableArray TEXT,DeluxeAvailableArray TEXT,SuitAvailableArray TEXT,LatestBooking TEXT)";
    private String availableInsertParametres = " (UniqueId,StandardAvailableArray,DeluxeAvailableArray,SuitAvailableArray,LatestBooking)";

    private String waitingListTableName = "waitngListTable";
    private String waitingListTableColoumns = "(UserName TEXT NOT NULL PRIMARY KEY,UniqueId TEXT,CheckIn TEXT,CheckOut TEXT,StandardRooms INTEGER,DeluxeRooms INTEGER,SuitRooms INTEGER,BookingDate TEXT)";
    private String waitListInsertParametres = " (UserName,UniqueId,CheckIn,CheckOut,StandardRooms,DeluxeRooms,SuitRooms,BookingDate)";
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
    public void checkAvailable(String uniqueId,String checkIn,String checkOut,int noOfStandardRooms,int noOfDeluxeRooms,int noOfSuitRooms,int maxStandardRooms,int maxDeluxeRooms,int maxSuitRooms)
    {
        try {
            if(!conn.isClosed())
            {
                int flag =0;
                ResultSet rs = statement.executeQuery("SELECT UniqueId FROM " + availableTableName);
                for (int i=0;i<rs.getFetchSize();i++)
                {
                    if(rs.getString(i).equals(uniqueId))
                    {
                        flag =1;
                    }
                }
                Date current=null;
                Date checkin=null;
                Date checkout=null;

                Date c = (Date) Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = df.format(c);

                try {
                    current = (Date) df.parse(formattedDate);
                } catch (ParseException e) {

                    e.printStackTrace();
                }
                try {
                    checkin = (Date) df.parse(checkIn);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    checkout = (Date) df.parse(checkOut);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long duration = checkin.getTime()-current.getTime();
                long diffInDaysForCheckIn = TimeUnit.MILLISECONDS.toDays(duration);
                long duration1 = checkout.getTime()-current.getTime();
                long diffInDaysForCheckOut = TimeUnit.MILLISECONDS.toDays(duration1);
                if(flag ==1)
                {


                    int x=0,y=0,z=0;
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM "+availableTableName+" WHERE UniqueId='"+ uniqueId + "'");
                    char[] standardAvailableArray= resultSet.getString("StandardAvailableArray").toCharArray();
                    char[] deluxeAvailableArray = resultSet.getString("DeluxeAvailableArray").toCharArray();
                    char[] suitAvailableArray = resultSet.getString("SuitAvailableArray").toCharArray();
                    String lastLatestBooking = resultSet.getString("LatestBooking");
                    Date latestBooking = null;
                    try {
                        latestBooking = (Date) df.parse(lastLatestBooking);
                    } catch (ParseException e) {

                        e.printStackTrace();
                    }
                    int diffBetweenBookings = (int) (current.getTime()-latestBooking.getTime());
                    //pushing the availableArrays to get to current time
                    for (int i=0;i<90-diffBetweenBookings;i++)
                    {
                        standardAvailableArray[i] = standardAvailableArray[i+diffBetweenBookings];
                        deluxeAvailableArray[i]  = deluxeAvailableArray[i+diffBetweenBookings];
                        suitAvailableArray[i] = suitAvailableArray[i+diffBetweenBookings];
                    }
                    for (int j=90-diffBetweenBookings;j<90;j++)
                    {
                        standardAvailableArray[j]=0;
                        deluxeAvailableArray[j]=0;
                        suitAvailableArray[j]=0;
                    }

                    for(int i=Integer.parseInt(String.valueOf(diffInDaysForCheckIn));i<Integer.parseInt(String.valueOf(diffInDaysForCheckOut));i++)
                    {
                        if(standardAvailableArray[i]<noOfStandardRooms)
                        {
                            x=1;
                            //JOptionPane.showMessageDialog(null,"Sorry for inconvience,Required number of Standard Rooms are not available");
                           // waitingList waitingList = new waitingList(uniqueId,checkIn,checkOut,noOfDeluxeRooms,noOfDeluxeRooms,noOfSuitRooms);
                        }
                        if(deluxeAvailableArray[i]<noOfDeluxeRooms)
                        {
                            y=1;
                            JOptionPane.showMessageDialog(null,"Sorry for inconvience,Required number of Deluxe Rooms are not available");
                        }
                        if (suitAvailableArray[i]<noOfSuitRooms)
                        {
                            z=1;
                            JOptionPane.showMessageDialog(null,"Sorry for inconvience,Required number of Suit Rooms are not available");
                        }
                    }
                    if (x==0&&y==0&&z==0) {
                        for (int i=Integer.parseInt(String.valueOf(diffInDaysForCheckIn));i<Integer.parseInt(String.valueOf(diffInDaysForCheckOut));i++) {
                            int f;
                            char o;
                            f = Character.getNumericValue(standardAvailableArray[i]) - noOfStandardRooms;
                            o = (char) (f + '0');
                            standardAvailableArray[i] = o;
                        }

                        for (int i=Integer.parseInt(String.valueOf(diffInDaysForCheckIn));i<Integer.parseInt(String.valueOf(diffInDaysForCheckOut));i++) {
                            int f;
                            char o;
                            f = Character.getNumericValue(deluxeAvailableArray[i]) - noOfStandardRooms;
                            o = (char) (f + '0');
                            deluxeAvailableArray[i] = o;
                        }

                        for(int i=Integer.parseInt(String.valueOf(diffInDaysForCheckIn));i<Integer.parseInt(String.valueOf(diffInDaysForCheckOut));i++)
                        {
                            int f;
                            char o;
                            f = Character.getNumericValue(suitAvailableArray[i])-noOfStandardRooms;
                            o = (char)(f+'0');
                            suitAvailableArray[i]=o;
                        }
                    }
                    statement.execute("UPDATE "+availableTableName+ " SET StandardAvailableArray '"+standardAvailableArray+"' WHERE UniqueId='"+uniqueId+"'");
                    statement.execute("UPDATE "+availableTableName+ " SET DeluxeAvailableArray '"+deluxeAvailableArray+"' WHERE UniqueId='"+uniqueId+"'");
                    statement.execute("UPDATE "+availableTableName+ " SET SuitAvailableArray '"+suitAvailableArray+"' WHERE UniqueId='"+uniqueId+"'");
                    statement.execute("UPDATE "+availableTableName+" SET LatestBooking '"+formattedDate+"' WHERE UniqueId='"+uniqueId+"'");
                }
                else
                {
                    char[] standardAvailableArray = new char[90];
                    char[] deluxeAvailableArray = new char[90];
                    char[] suitAvailableArray = new char[90];
                    for(int i=0;i<90;i++)
                    {
                        standardAvailableArray[i] = (char) (maxStandardRooms+'o');
                    }
                    for(int i=0;i<90;i++)
                    {
                        deluxeAvailableArray[i] = (char) (maxDeluxeRooms+'o');
                    }
                    for(int i=0;i<90;i++)
                    {
                        suitAvailableArray[i] = (char) (maxSuitRooms+'o');
                    }
                    for (int i=Integer.parseInt(String.valueOf(diffInDaysForCheckIn));i<Integer.parseInt(String.valueOf(diffInDaysForCheckOut));i++) {
                        int f;
                        char o;
                        f = Character.getNumericValue(standardAvailableArray[i]) - noOfStandardRooms;
                        o = (char) (f + '0');
                        standardAvailableArray[i] = o;
                    }

                    for (int i=Integer.parseInt(String.valueOf(diffInDaysForCheckIn));i<Integer.parseInt(String.valueOf(diffInDaysForCheckOut));i++) {
                        int f;
                        char o;
                        f = Character.getNumericValue(deluxeAvailableArray[i]) - noOfDeluxeRooms;
                        o = (char) (f + '0');
                        deluxeAvailableArray[i] = o;
                    }

                    for(int i=Integer.parseInt(String.valueOf(diffInDaysForCheckIn));i<Integer.parseInt(String.valueOf(diffInDaysForCheckOut));i++)
                    {
                        int f;
                        char o;
                        f = Character.getNumericValue(suitAvailableArray[i])-noOfSuitRooms;
                        o = (char)(f+'0');
                        suitAvailableArray[i]=o;
                    }
                    statement.execute("INSERT INTO "+ availableTableName+availableInsertParametres+"VALUES('"+uniqueId+"','"+standardAvailableArray.toString()+"','"+
                            deluxeAvailableArray.toString()+"','"+suitAvailableArray.toString()+"','"+formattedDate+"')");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cancelBooking(String uniqueId,String checkIn,String checkOut,int noOfStandardRooms,int noOfDeluxeRooms,int noOfSuitRooms,String bookingDate) {
        try {
            if (!conn.isClosed()) {
                Date current=null;
                Date bookedDate = null;
                Date checkin=null;
                Date checkout=null;
                Date lastUpdated = null;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date c = (Date) Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = df.format(c);
                //SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    current = (Date) df.parse(formattedDate);
                } catch (ParseException e) {

                    e.printStackTrace();
                }
                try {
                    bookedDate = (Date) df.parse(bookingDate);
                } catch (ParseException e) {

                    e.printStackTrace();
                }

                try {
                    checkin = (Date) df.parse(checkIn);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    checkout = (Date) df.parse(checkOut);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                ResultSet rs = statement.executeQuery("SELECT UniqueId FROM " + availableTableName);
                for (int j = 0; j < rs.getFetchSize(); j++) {
                    if (rs.getString(j).equals(uniqueId)) {
                        int x=0,y=0,z=0;
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM "+availableTableName+" WHERE UniqueId='"+ uniqueId + "'");
                        char[] standardAvailableArray= resultSet.getString("StandardAvailableArray").toCharArray();
                        char[] deluxeAvailableArray = resultSet.getString("DeluxeAvailableArray").toCharArray();
                        char[] suitAvailableArray = resultSet.getString("SuitAvailableArray").toCharArray();
                        String latestBookedDate = resultSet.getString("LatestBooking");
                        try {
                            lastUpdated = (Date) df.parse(latestBookedDate);
                        } catch (ParseException e) {

                            e.printStackTrace();
                        }
                        long duration = checkin.getTime()-lastUpdated.getTime();
                        int diffInDaysForCheckIn = (int) TimeUnit.MILLISECONDS.toDays(duration);
                        long duration1 = checkout.getTime()-lastUpdated.getTime();
                        int diffInDaysForCheckOut = (int) TimeUnit.MILLISECONDS.toDays(duration1);
                        for (int i = diffInDaysForCheckIn; i < diffInDaysForCheckOut; i++) {
                            int f;
                            char o;
                            f = Character.getNumericValue(standardAvailableArray[i]) + noOfStandardRooms;
                            o = (char) (f + '0');
                            standardAvailableArray[i] = o;
                        }

                        for (int i = diffInDaysForCheckIn; i < diffInDaysForCheckOut; i++) {
                            int f;
                            char o;
                            f = Character.getNumericValue(deluxeAvailableArray[i]) + noOfDeluxeRooms;
                            o = (char) (f + '0');
                            deluxeAvailableArray[i] = o;
                        }

                        for(int i=diffInDaysForCheckIn;i<diffInDaysForCheckOut;i++)
                        {
                            int f;
                            char o;
                            f = Character.getNumericValue(suitAvailableArray[i])+noOfSuitRooms;
                            o = (char)(f+'0');
                            suitAvailableArray[i]=o;
                        }
                        statement.execute("UPDATE "+availableTableName+ " SET StandardAvailableArray '"+standardAvailableArray+"' WHERE UniqueId='"+uniqueId+"'");
                        statement.execute("UPDATE "+availableTableName+ " SET DeluxeAvailableArray '"+deluxeAvailableArray+"' WHERE UniqueId='"+uniqueId+"'");
                        statement.execute("UPDATE "+availableTableName+ " SET SuitAvailableArray '"+suitAvailableArray+"' WHERE UniqueId='"+uniqueId+"'");
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

}
