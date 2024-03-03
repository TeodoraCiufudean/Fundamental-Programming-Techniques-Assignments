package model;

/**
 * Represents a Client.
 */
public class Client {
    private int id;
    private String name;
    private int age;
    private String address;

    /**
     * Default constructor for the Client class.
     */
    public Client() {
    }

    /**
     * Constructs a Client object with the specified id, name, age, and address.
     *
     * @param id      The ID of the client.
     * @param name    The name of the client.
     * @param age     The age of the client.
     * @param address The address of the client.
     */
    public Client(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * Returns the ID of the client.
     *
     * @return The ID of the client.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the client.
     *
     * @param id The ID of the client.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the client.
     *
     * @return The name of the client.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the client.
     *
     * @param name The name of the client.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the age of the client.
     *
     * @return The age of the client.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the client.
     *
     * @param age The age of the client.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the address of the client.
     *
     * @return The address of the client.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the client.
     *
     * @param address The address of the client.
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
