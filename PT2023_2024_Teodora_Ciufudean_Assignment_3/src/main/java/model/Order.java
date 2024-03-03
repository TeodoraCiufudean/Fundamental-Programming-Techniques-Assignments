package model;

/**
 * Represents an Order.
 */
public class Order {
    private int orderNo;
    private int idClient;
    private int idProduct;
    private int quantity;

    /**
     * Default constructor for the Order class.
     */
    public Order() {
    }

    /**
     * Constructs an Order object with the specified order number, client ID, product ID, and quantity.
     *
     * @param orderNo   The order number.
     * @param idClient  The ID of the client.
     * @param idProduct The ID of the product.
     * @param quantity  The quantity of the product ordered.
     */
    public Order(int orderNo, int idClient, int idProduct, int quantity) {
        this.orderNo = orderNo;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    /**
     * Returns the order number.
     *
     * @return The order number.
     */
    public int getOrderNo() {
        return orderNo;
    }

    /**
     * Sets the order number.
     *
     * @param orderNo The order number.
     */
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * Returns the ID of the client.
     *
     * @return The ID of the client.
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Sets the ID of the client.
     *
     * @param idClient The ID of the client.
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Returns the ID of the product.
     *
     * @return The ID of the product.
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * Sets the ID of the product.
     *
     * @param idProduct The ID of the product.
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Returns the quantity of the product ordered.
     *
     * @return The quantity of the product ordered.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product ordered.
     *
     * @param quantity The quantity of the product ordered.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
