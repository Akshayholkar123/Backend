package com.ninza.hrm.api.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.mysql.jdbc.Driver;

public class DataBaseUtility {

    private Connection con;
    private ProFileUtility fLib = new ProFileUtility();

    public void getDbConnection(String url, String username, String password) throws SQLException {
        try {
            DriverManager.registerDriver(new Driver());
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this exception
            throw e; // Re-throw the exception after logging it
        }
    }

    public void connectToDB() throws Throwable {
        try {
            String DBURL = fLib.getDataFromPropertiesFile("DBURL");
            String DBUSERNAME = fLib.getDataFromPropertiesFile("DBUSN");
            String DBPASSWORD = fLib.getDataFromPropertiesFile("DBpass");
            getDbConnection(DBURL, DBUSERNAME, DBPASSWORD);
        } catch (Throwable e) {
            e.printStackTrace(); // Consider logging this exception
            throw e; // Re-throw the exception after logging it
        }
    }

    public void closeDB() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Consider logging this exception
            }
        }
    }

    public ResultSet executeQuery(String query) throws Throwable {
        ResultSet result = null;
        try (Statement stat = con.createStatement()) {
            result = stat.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this exception
            throw e; // Re-throw the exception after logging it
        }
        return result;
    }

    public int executeNonSelectQuery(String query) throws Throwable {
        int result = 0;
        try (Statement stat = con.createStatement()) {
            result = stat.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this exception
            throw e; // Re-throw the exception after logging it
        }
        return result;
    }

    public boolean verifyDbData(String query, int columnNo, String expectedData) throws Throwable {
        boolean flag = false;
        try (Connection con = DriverManager.getConnection(
                fLib.getDataFromPropertiesFile("DBURL"),
                fLib.getDataFromPropertiesFile("DBUSN"),
                fLib.getDataFromPropertiesFile("DBpass"));
             Statement stat = con.createStatement();
             ResultSet result = stat.executeQuery(query)) {

            while (result.next()) {
                String actData = result.getString(columnNo);
                if (actData.equalsIgnoreCase(expectedData)) {
                    System.out.println(expectedData + " is available in DB");
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println(expectedData + " is available in DB");
            } else {
                System.out.println(expectedData + " is not available in DB");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this exception
            throw e; // Re-throw the exception after logging it
        }
        return flag;
    }
}
