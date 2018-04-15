package ch.mizye.objectdrawer;

import java.sql.*;

public class CDatabase {
    private static String dbURL = "jdbc:derby:src/ch/mizye/objectdrawer/DBObject";

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public CDatabase() {

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

    //Add, Select and delete
    private boolean addFile(String name) {
        int i = 0;
        createConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT max(FILEID) FROM APP.TFILE");
            rs = stmt.executeQuery();

            while(rs.next()) {
                i = rs.getInt(1) + 1;
            }

            PreparedStatement ps = con.prepareStatement("INSERT INTO APP.TFILE(FILEID, FILENAME) VALUES (?, ?)");
            ps.setInt(1, i);
            ps.setString(2, name);

            int r = ps.executeUpdate();

            if (r <= 0) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return true;
    }

    private void setFileName(String name) {

    }

    private void deleteFile(String name) {

    }

    private void addLayout(String name) {

    }

    private void addObject() {

    }

/*
    private void insertData(String s) {

        int i = 0;
        createConnection();

        try {

            PreparedStatement stmt = con.prepareStatement("SELECT max(FILEID) FROM APP.TFILE");
            rs = stmt.executeQuery();


            while(rs.next()) {
                i = rs.getInt(1) + 1;
            }

            PreparedStatement ps = con.prepareStatement("INSERT INTO APP.TFILE(FILEID, FILENAME) VALUES (?, ?)");
            ps.setInt(1, i);
            ps.setString(2, s);

            int r = ps.executeUpdate();

            if(r > 0) {
                System.out.println("Data Inserted");
            } else {
                System.out.println("Something happened");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
*/
    private void selectData() {

        createConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM APP.TFILE");
            rs = stmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt("FileID") + ", " + rs.getString("FileName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

    }


}
