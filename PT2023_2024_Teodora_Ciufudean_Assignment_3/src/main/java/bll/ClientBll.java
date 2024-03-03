package bll;

import bll.validators.ClientValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The ClientBll class represents the business logic layer for managing Client objects.
 * It provides methods to interact with the ClientDAO and perform operations such as finding,
 * inserting, deleting, updating, and retrieving clients.
 */
public class ClientBll {
    //private List<Validator<Client>> validators;
    private Validator<Client> validator;
    private ClientDAO clientDAO;

    /**
     * Constructs a ClientBll object and initializes the ClientValidator and ClientDAO.
     */
    public ClientBll() {
        //validators = new ArrayList<Validator<Client>>();
        //validators.add(new ClientValidator());
        validator = new ClientValidator();
        clientDAO = new ClientDAO();
    }

    /**
     * Finds a Client object by its ID using the ClientDAO.
     *
     * @param id The ID of the client to find.
     * @return The found Client object.
     * @throws NoSuchElementException If the client with the given ID is not found.
     */
    public Client findClientById(int id) {
        Client client = clientDAO.findById(id, "id");
        if (client == null) {
            throw new NoSuchElementException("The client with id = " + id + " was not found!");
        }
        return client;
    }

    /**
     * Inserts a Client object into the data store using the ClientDAO.
     *
     * @param client The Client object to be inserted.
     * @throws IllegalAccessException If the client fails validation.
     */
    public void insertClient(Client client) throws IllegalAccessException {
        //ClientValidator clientValidator = new ClientValidator();
        //clientValidator.validate(client);
        validator.validate(client);
        clientDAO.insert(client);
    }

    /**
     * Deletes a Client object from the data store using the ClientDAO.
     *
     * @param id The ID of the client to be deleted.
     */
    public void deleteClient(int id) {
        clientDAO.delete("id", id);
    }

    /**
     * Updates a Client object in the data store using the ClientDAO.
     *
     * @param client The updated Client object.
     * @param id     The ID of the client to be updated.
     * @throws IllegalAccessException If the client fails validation.
     */
    public void updateClient(Client client, int id) throws IllegalAccessException {
        clientDAO.update(client, id);
    }

    /**
     * Retrieves a list of all Client objects from the data store using the ClientDAO.
     *
     * @return A list of Client objects.
     */
    public List<Client> viewAllClients() {
        return clientDAO.findAll();
    }

    /**
     * Generates a JTable representation of the given list of Client objects using the ClientDAO.
     *
     * @param clients The list of Client objects to be represented as a JTable.
     * @return A JTable representation of the clients.
     */
    public JTable ClientTable(ArrayList<Client> clients) {
        return clientDAO.jTable(clients);
    }
}
