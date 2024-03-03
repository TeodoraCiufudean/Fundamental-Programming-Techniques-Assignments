package model;

/**
 * Represents a Bill.
 */
public record Bill(int no, String clientName, String clientAddress, String productName, int quantity) {

    /**
     * Returns a string representation of the Bill object.
     *
     * @return The string representation of the Bill.
     */
    @Override
    public String toString() {
        String s = "Bill " + no + "\n" +
                "Client name: " + clientName + "\n" +
                "Client address: " + clientAddress + "\n" +
                "Product: " + productName + "\n" +
                "Quantity: " + quantity + "\n\n";
        s = s + "----------------------------------------------------------------------------------------------------- ";
        return s;
    }
}

