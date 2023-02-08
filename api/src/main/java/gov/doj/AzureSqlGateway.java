package gov.doj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AzureSqlGateway implements PersistenceGateway {
    // jdbc:sqlserver://boss-acms-dev.database.windows.net:1433;
    // database=boss-dev;
    // encrypt=true;
    // trustServerCertificate=false;
    // hostNameInCertificate=*.database.windows.net;
    // loginTimeout=30;
    // Authentication=ActiveDirectoryIntegrated
    public void connect() {
        String connectionUrl =
                "";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP 10 Title, FirstName, LastName from SalesLT.Customer";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
