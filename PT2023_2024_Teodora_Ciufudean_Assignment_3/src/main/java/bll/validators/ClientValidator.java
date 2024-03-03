package bll.validators;

import model.Client;

/**
 * The ClientValidator class is responsible for validating the age of a Client object.
 * It implements the Validator interface with a type parameter of Client.
 */
public class ClientValidator implements Validator<Client> {

    /**
     * The minimum age allowed for a client.
     */
    private static final int MIN_AGE = 10;

    /**
     * The maximum age allowed for a client.
     */
    private static final int MAX_AGE = 90;

    /**
     * Validates the age of a Client object.
     *
     * @param client The Client object to be validated.
     * @throws IllegalArgumentException If the client's age is outside the allowed range.
     */
    public void validate(Client client) {

        if (client.getAge() < MIN_AGE || client.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("The Client Age limit is not respected!");
        }
    }
}

