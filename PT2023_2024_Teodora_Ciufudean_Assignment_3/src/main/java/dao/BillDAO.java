package dao;

import connection.ConnectionFactory;
import model.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Data Access Object for handling operations related to the Bill model.
 */
public class BillDAO extends AbstractDAO<Bill> {

    /**
     * Constructs a new BillDAO object.
     */
    public BillDAO() {
        super();
    }

    /**
     * Retrieves a list of all bills from the database.
     *
     * @return A list of Bill objects representing the bills retrieved from the database, or null if an error occurs.
     */
    public List<Bill> find() {
        List<Bill> bills = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append("FROM order_management.");
        sb.append("bill");
        String query = sb.toString();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String clientName = resultSet.getString(2);
                String clientAddress = resultSet.getString(3);
                String productName = resultSet.getString(4);
                int quantity = resultSet.getInt(5);
                Bill bill = new Bill(id, clientName, clientAddress, productName, quantity);
                bills.add(bill);
            }
            return bills;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "bill" + "DAO:find " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
