/**
 * @author : Dinuth Dheeraka
 * Project Name: Test-1
 * Created     : 7/11/2022 8:05 PM
 */
package db;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;

    private final Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ijse","root","1234");
    }

    public Connection getConnection(){
        return this.connection;
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return dbConnection==null? dbConnection = new DBConnection() : dbConnection;
    }
}
