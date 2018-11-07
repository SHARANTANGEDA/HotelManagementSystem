package com.sharan;


import com.sharan.ui.hotelView.displaySelectedHotels.ElementsInHotelView;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseController {

    private String databaseUrl="jdbc:sqlite:HotelBooking.db";
    private String TABLE_CREATOR="CREATE TABLE IF NOT EXISTS ";

    private String userTableNAME ="userDatabase";
    private String userTableCOLUMNS ="(UserName TEXT NOT NULL PRIMARY KEY,Password TEXT,DOB TEXT,ResidentialAddress TEXT,Email TEXT,IdCard TEXT,Phone TEXT)";
    private String userInsertParameters =" (UserName,Password,DOB,ResidentialAddress,Email,IdCard,Phone)";

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


        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addUser (String userName,String password,String dateOfBirth,String address,String email,String idCard,String phone) throws SQLException{
        statement.execute("INSERT INTO "+ userTableNAME + userInsertParameters +" VALUES('" +userName+"','"+password+"','"
                +dateOfBirth+"','"+address+"','"+email+"','"+idCard+"','"+phone+"')");
    }

    public void addHotel (String uniqueId,String hotelName,String description,String state,String city,String address,String standard,String stdPrice,String stcapacity
                                        ,String deluxe,String deluxePrice,String delcapacity, String suite,String suitePrice,String suitecapacity,String imagePath) throws SQLException {

        statement.execute("INSERT INTO "+hotelsTableNAME+hotelsInsertParameters+"VALUES('"+uniqueId+"','"+hotelName+"','"+description+"','"+state
                +"','"+city+"','" +address+"','"+standard+"','"+stdPrice+"','"+stcapacity+"','"+deluxe+"','"+deluxePrice+"','"+delcapacity+"','"
                +suite+"','"+suitePrice+"','" +suitecapacity+ "','"+imagePath+"')");
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


                ElementsInHotelView elements=new ElementsInHotelView(resultSet.getString("UniqueId"),resultSet.getString("HotelName"),
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
