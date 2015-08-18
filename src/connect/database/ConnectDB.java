package connect.database;

/**
 * Created by busra on 18.08.2015.
 */

import java.sql.*;


public class ConnectDB {
    public void connect() {
        String URL = "jdbc:mysql://localhost:3306/";
        String dbName = "bd_database";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "123456";
        Connection conn = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(URL + dbName, userName, password);
            statement = conn.createStatement();
            result = statement.executeQuery("select * from contacts");

            System.out.println("Name:" + "\t " +"Surname"
                    + "\t" + "MobilePhone" + "\t" + "e-mail" + "\n");

            while (result.next()) {
//                String id = result.getString("id");
                String firstName = result.getString("FirstName");
                String lastName = result.getString("LastName");
                String phoneNumber = result.getString("PhoneNum");
                String e_mail = result.getString("e_mail");
                System.out.println(firstName + "\t " +lastName
                        + "\t" + phoneNumber + "\t" +  e_mail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

