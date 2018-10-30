package com.sharan;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseController {

    private String databaseUrl="jdbc:sqlite:HotelBooking.db";
    private String TABLE_CREATOR="CREATE TABLE IF NOT EXISTS ";

    private String userTableNAME ="userDatabase";
    private String userTableCOLUMNS ="(UserName TEXT NOT NULL PRIMARY KEY,Password TEXT,DOB TEXT,ResidentialAddress TEXT,Email TEXT,IdCard TEXT)";
    private String userInsertParameters ="(UserName,Password,DOB,ResidentialAddress,Email,IdCard)";

    private String hotelsTableNAME ="hotelsDatabase";
    private String hotelsTableCOLUMNS ="(UniqueId TEXT,State TEXT,City TEXT," +
            "Non_AC_Room TEXT DEFAULT NA,AC_Room TEXT DEFAULT NA,Suite TEXT DEFAULT NA,StarRating INTEGER DEFAULT 1)";
    private String hotelsInsertParameters="(UniqueId,State,City,Non_AC_Room,AC_Room,Suite,StarRating)";


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

    public void addHotel (String uniqueId,String state,String city,String non_ac,String ac,String suite,int starRating) throws SQLException {
        statement.execute("INSERT INTO "+hotelsTableNAME+hotelsInsertParameters+"VALUES('"+uniqueId+"','"+state+"','"+city+"','"
                                            +non_ac+"','"+ac+"','"+suite+"','"+starRating+"')");
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
