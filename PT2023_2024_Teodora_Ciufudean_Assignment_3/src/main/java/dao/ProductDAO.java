package dao;
import connection.ConnectionFactory;
import model.Client;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data Access Object for handling operations related to the Product model.
 */
public class ProductDAO extends AbstractDAO<Product> {

    /**
     * Constructs a new ProductDAO object.
     */
    public ProductDAO() {
        super();
    }
}



