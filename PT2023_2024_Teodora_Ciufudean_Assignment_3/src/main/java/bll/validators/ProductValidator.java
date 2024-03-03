package bll.validators;

import model.Client;
import model.Product;

/**
 * The ProductValidator class is responsible for validating a Product object.
 * It implements the Validator interface with a type parameter of Product.
 */
public class ProductValidator implements Validator<Product> {

    /**
     * Validates the stock of a Product.
     *
     * @param product The Product object to be validated.
     * @throws IllegalArgumentException If the product's stock is less than or equal to 0.
     */
    public void validate(Product product) {
        if (product.getStock() <= 0) {
            throw new IllegalArgumentException("The Product Stock limit is not respected!");
        }
    }
}

