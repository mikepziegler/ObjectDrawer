package ch.mizye.objectdrawer;

import java.sql.*;

public class CDatabase {

    private static String dbURL = "jdbc:derby:src/ch/mizye/objectdrawer/DBObject";


    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public CDatabase() {

        insertData("hihih");

        selectData();

    }

    private void createConnection() {
        try {
            Class.forName( "org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection(dbURL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertData(String s) {

        createConnection();

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO APP.TFILE(FILENAME) VALUES (?)");
            ps.setString(1, s);

            int r = ps.executeUpdate();

            if(r > 0)
            {
                System.out.println("Data Inserted");
            }
            else
            {
                System.out.println("Something happened");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

    }

    private void selectData() {

        createConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM APP.TFILE");
            rs = stmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("FileID") + ", " + rs.getString("FileName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

    }


}
