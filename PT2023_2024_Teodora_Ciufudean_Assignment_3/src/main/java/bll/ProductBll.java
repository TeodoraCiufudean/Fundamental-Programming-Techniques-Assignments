package bll;

import bll.validators.ProductValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The ProductBll class represents the business logic layer for managing Product objects.
 * It provides methods to interact with the ProductDAO and perform operations such as finding,
 * inserting, deleting, updating, and retrieving products.
 */
public class ProductBll {
    //private List<Validator<Product>> validators;
    private Validator<Product> validator;
    private ProductDAO productDAO;

    /**
     * Constructs a ProductBll object and initializes the ProductValidator and ProductDAO.
     */
    public ProductBll() {
        //validators = new ArrayList<Validator<Product>>();
        //validators.add(new ProductValidator());
        validator = new ProductValidator();
        productDAO = new ProductDAO();
    }

    /**
     * Finds a Product object by its ID using the ProductDAO.
     *
     * @param id The ID of the product to find.
     * @return The found Product object.
     * @throws NoSuchElementException If the product with the given ID is not found.
     */
    public Product findProductById(int id) {
        Product product = productDAO.findById(id, "id");
        if (product == null) {
            throw new NoSuchElementException("The product with id = " + id + " was not found!");
        }
        return product;
    }

    /**
     * Inserts a Product object into the data store using the ProductDAO.
     *
     * @param product The Product object to be inserted.
     * @throws IllegalAccessException If the product fails validation.
     */
    public void insertProduct(Product product) throws IllegalAccessException {
        //ProductValidator productValidator = new ProductValidator();
        //productValidator.validate(product);
        validator.validate(product);
        productDAO.insert(product);
    }

    /**
     * Deletes a Product object from the data store using the ProductDAO.
     *
     * @param id The ID of the product to be deleted.
     */
    public void deleteProduct(int id) {
        productDAO.delete("id", id);
    }

    /**
     * Updates a Product object in the data store using the ProductDAO.
     *
     * @param product The updated Product object.
     * @param id      The ID of the product to be updated.
     * @throws IllegalAccessException If the product fails validation.
     */
    public void updateProduct(Product product, int id) throws IllegalAccessException {
        productDAO.update(product, id);
    }

    /**
     * Retrieves a list of all Product objects from the data store using the ProductDAO.
     *
     * @return A list of Product objects.
     */
    public List<Product> viewAllProducts() {
        return productDAO.findAll();
    }

    /**
     * Generates a JTable representation of the given list of Product objects using the ProductDAO.
     *
     * @param products The list of Product objects to be represented as a JTable.
     * @return A JTable representation of the products.
     */
    public JTable ProductTable(ArrayList<Product> products) {
        return productDAO.jTable(products);
    }
}
