package bll.validators;

import model.Order;
import model.Product;

/**
 * The OrderValidator class is responsible for validating an Order object.
 * It implements the Validator interface with a type parameter of Order.
 */
public class OrderValidator implements Validator<Order> {

    /**
     * Validates the quantity of an Order.
     *
     * @param order The Order object to be validated.
     * @throws IllegalArgumentException If the order's quantity is less than 1.
     */
    public void validate(Order order) {
        if (order.getQuantity() < 1) {
            throw new IllegalArgumentException("The Order Quantity limit is not respected!");
        }
    }
}

