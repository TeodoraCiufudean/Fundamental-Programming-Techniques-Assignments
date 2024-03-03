package dao;

import dao.AbstractDAO;
import model.Client;

/**
 * Data Access Object for handling operations related to the Client model.
 */
public class ClientDAO extends AbstractDAO<Client> {

    /**
     * Constructs a new ClientDAO object.
     */
    public ClientDAO() {
        super();
    }
}





/*package dao;

import connection.ConnectionFactory;
import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (name,age,address)"
            + " VALUES (?,?,?)";
    private final static String findStatementString = "SELECT * FROM client where id = ?";
    private final static String deleteStatementString = "DELETE FROM client where id = ?";
    private final static String updateStatementString = "UPDATE name FROM client where id = ?";
    private final static String showAllStatementString = "SELECT * FROM client";

    public static Client findById(int idClient) {
        Client toReturn = null;
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setInt(1, idClient);
            rs = findStatement.executeQuery();
            rs.next();
            String name = rs.getString("name");
            String address = rs.getString("address");
            int age = rs.getInt("age");
            toReturn = new Client(idClient, name, age, address);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    public static int insert(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, client.getName());
            insertStatement.setInt(2, client.getAge());
            insertStatement.setString(3, client.getAddress());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    public static void deleteById(int idClient) {
        //Client toReturn = null;
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        //ResultSet rs = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString);
            deleteStatement.setInt(1, idClient);
            deleteStatement.executeUpdate();
            //rs.next();
            //String name = rs.getString("name");
            //String address = rs.getString("address");
            //int age = rs.getInt("age");
            //toReturn = new Client(idClient, name, age, address);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:deleteById " + e.getMessage());
        } finally {
            //ConnectionFactory.close(rs);
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        //return toReturn;
    }

    public static void updateName (int idClient, String name){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString);
            updateStatement.setInt(1,idClient);
            updateStatement.setString(2,name);
            updateStatement.executeUpdate();
        }catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:updateName " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static List<Client> showAll (){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement showAllStatement = null;
        ResultSet rs = null;
        List<Client> clientsList = new ArrayList<Client>();
        try{
            showAllStatement = dbConnection.prepareStatement(showAllStatementString);
            rs = showAllStatement.executeQuery();
            while(rs.next()){
                Client client = new Client(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("address"));
                clientsList.add(client);
            }
        }catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:updateName " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(showAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return clientsList;
    }
}*/
