package com.sharan;


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
            "Standard TEXT DEFAULT NA,StandardCapacity INTEGER DEFAULT 10,Deluxe TEXT DEFAULT NA,DeluxeCapacity INTEGER DEFAULT 10," +
            "Suite TEXT DEFAULT NA,SuiteCapacity INTEGER DEFAULT 4,HomeImagePath TEXT,StarRating TEXT DEFAULT 1,NumberOfVotes INTEGER DEFAULT 0)";
    private String hotelsInsertParameters=" (UniqueId,HotelName,HotelDescription,State,City,Address,Standard,StandardCapacity," +
            "Deluxe,DelxeCapacity,Suite,SuiteCapacity)";

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

    public void addHotel (String uniqueId,String hotelName,String description,String state,String city,String address,String standard,String stcapacity
                                        ,String deluxe,String delcapacity, String suite,String suitecapacity,String imagePath) throws SQLException {

        statement.execute("INSERT INTO "+hotelsTableNAME+hotelsInsertParameters+"VALUES('"+uniqueId+"','"+hotelName+"','"+description+"','"+state+"','"+city+"','"
                                            +address+"','"+standard+"','"+stcapacity+"','"+deluxe+"','"+delcapacity+"','"+suite+"','"+suitecapacity+
                                            "','"+imagePath+"')");
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
                String hotelName=rs.getString("HotelName");
                String hotelDescription=rs.getString("HotelDescription");
                String hotelAddress=rs.getString("Address");
                String imagePath=rs.getString("HomeImagePath");


                list.add(id);
                list.add(hotelName);
                list.add(hotelDescription);
                list.add(hotelAddress);
                list.add(imagePath);
            }
        }catch (SQLException e){
            System.out.println("Parsing Error"+e.getMessage());
        }

        return list;

    }

    public double calculateRating(String id) {
        double finalrate=0;

        try {
            if (!conn.isClosed()) {
                ResultSet rs = statement.executeQuery("SELECT * FROM " + hotelsTableNAME + " WHERE UniqueId='" + id + "'");

                String srate = rs.getString("StarRating");

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

    public void addAllotmentDetailsToDatabase(ArrayList<String> list) {
        try {
            statement.execute("INSERT INTO "+allotmentTableName+allotmentTableInsertParameters+"VALUES ('"+list.get(0)+"','"+list.get(1)+"','"+list.get(2)+"','"+
                    list.get(3)+"','"+list.get(4)+"')");
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String Verify(String username) {

        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT Password FROM " + userTableNAME + " WHERE UserName = '" +username+ "'" );
                System.out.println(username);
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
                System.out.println(username);
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
        }
    }

}
