package dao;

import connection.ConnectionFactory;
import model.Client;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data Access Object for handling operations related to the Order model.
 */
public class OrderDAO extends AbstractDAO<Order> {

    /**
     * Constructs a new OrderDAO object.
     */
    public OrderDAO() {
        super();
    }

}

