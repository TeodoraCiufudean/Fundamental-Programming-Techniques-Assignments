package bll;

import bll.validators.OrderValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Client;
import model.Order;
import model.Product;
import presentation.OrderView;

import javax.swing.*;
import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

/**
 * The OrderBll class represents the business logic layer for managing Order objects.
 * It provides methods to interact with the OrderDAO and perform operations such as inserting orders,
 * retrieving orders, and generating a JTable representation of orders.
 */
public class OrderBll {
    private Validator<Order> validator;
    private OrderDAO orderDAO;
    private ProductDAO productDAO;

    /**
     * Constructs an OrderBll object and initializes the OrderValidator, OrderDAO, and ProductDAO.
     */
    public OrderBll() {
        validator = new OrderValidator();
        orderDAO = new OrderDAO();
        productDAO = new ProductDAO();
    }

    /**
     * Inserts an Order object into the data store using the OrderDAO.
     * Also validates the order and updates the stock of the associated product.
     *
     * @param order The Order object to be inserted.
     * @throws IllegalAccessException If the order fails validation.
     * @throws IllegalArgumentException If the client or product associated with the order is not found.
     */
    public void insertOrder(Order order) throws IllegalAccessException {
        Client client = new ClientDAO().findById(order.getIdClient(), "id");
        Product product = new ProductDAO().findById(order.getIdProduct(), "id");
        if (client == null || product == null) {
            throw new IllegalArgumentException("The order cannot be made");
        }
        validator.validate(order);
        product.setStock(product.getStock() - order.getQuantity());
        orderDAO.insert(order);
        productDAO.update(product, product.getId());
    }

    /**
     * Retrieves a list of all Order objects from the data store using the OrderDAO.
     *
     * @return A list of Order objects.
     */
    public List<Order> viewAllOrders() {
        return orderDAO.findAll();
    }

    /**
     * Generates a JTable representation of the given list of Order objects using the OrderDAO.
     *
     * @param orders The list of Order objects to be represented as a JTable.
     * @return A JTable representation of the orders.
     */
    public JTable OrderTable(ArrayList<Order> orders) {
        return orderDAO.jTable(orders);
    }
}
