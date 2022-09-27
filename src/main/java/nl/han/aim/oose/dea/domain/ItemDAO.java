package nl.han.aim.oose.dea.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public List<Item> findAll() {
        List<Item> foundItems = new ArrayList<>();

        // Get Connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test-db?serverTimezone=UTC&user=root&password=password&allowPublicKeyRetrieval=true&useSSL=false");
            System.out.println("Connection with db: " + myConnection.getMetaData().getDatabaseProductName());

            // Run query
            ResultSet resultSet = myConnection.prepareStatement("SELECT * FROM Items").executeQuery();
            System.out.println("!!!");

            while(resultSet.next()) {
                String sku = resultSet.getString(1);
                String category = resultSet.getString(2);
                String title = resultSet.getString(3);
                foundItems.add(new Item(sku, category, title));
            }
        }

        catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return
        return foundItems;
    }
}
