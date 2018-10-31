package com.sharan;


import java.sql.*;

public class DataBaseController {

    private String databaseUrl="jdbc:sqlite:HotelBooking.db";
    private String TABLE_CREATOR="CREATE TABLE IF NOT EXISTS ";

    private String userTableNAME ="userDatabase";
    private String userTableCOLUMNS ="(UserName TEXT NOT NULL PRIMARY KEY,Password TEXT,DOB TEXT,ResidentialAddress TEXT,Email TEXT,IdCard TEXT)";
    private String userInsertParameters ="(UserName,Password,DOB,ResidentialAddress,Email,IdCard)";

    private String hotelsTableNAME ="hotelsDatabase";
    private String hotelsTableCOLUMNS ="(UniqueId TEXT,State TEXT,City TEXT," +
            "Non_AC_Room TEXT DEFAULT NA,AC_Room TEXT DEFAULT NA,Suite TEXT DEFAULT NA,StarRating TEXT DEFAULT 1,NumberOfVotes INTEGER DEFAULT 0)";
    private String hotelsInsertParameters="(UniqueId,State,City,Non_AC_Room,AC_Room,Suite)";

    private int numberOfRatingsForAHotel;


    private Connection conn=null;
    private Statement statement=null;


    public void initialiseDatabase() {
        try {
            conn=DriverManager.getConnection(databaseUrl);
            statement=conn.createStatement();
            statement.execute(TABLE_CREATOR+ userTableNAME + userTableCOLUMNS);
            statement.execute(TABLE_CREATOR+ hotelsTableNAME + hotelsTableCOLUMNS);

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addUser (String userName,String password,String dateOfBirth,String address,String email,String idCard) throws SQLException{
        statement.execute("INSERT INTO "+ userTableNAME + userInsertParameters +" VALUES('" +userName+"','"+password+"','"
                                                        +dateOfBirth+"','"+address+"','"+email+"','"+idCard+"')");
    }

    public void addHotel (String uniqueId,String state,String city,String non_ac,String ac,String suite) throws SQLException {
        statement.execute("INSERT INTO "+hotelsTableNAME+hotelsInsertParameters+"VALUES('"+uniqueId+"','"+state+"','"+city+"','"
                                            +non_ac+"','"+ac+"','"+suite+"'"+")");
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
