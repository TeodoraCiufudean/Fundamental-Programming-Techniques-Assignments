package model;

/**
 * Represents a Product.
 */
public class Product {
    private int id;
    private String name;
    private int stock;

    /**
     * Default constructor for the Product class.
     */
    public Product() {
    }

    /**
     * Constructs a Product object with the specified ID, name, and stock.
     *
     * @param id    The ID of the product.
     * @param name  The name of the product.
     * @param stock The stock quantity of the product.
     */
    public Product(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    /**
     * Returns the ID of the product.
     *
     * @return The ID of the product.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     *
     * @param id The ID of the product.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the stock quantity of the product.
     *
     * @return The stock quantity of the product.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity of the product.
     *
     * @param stock The stock quantity of the product.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
