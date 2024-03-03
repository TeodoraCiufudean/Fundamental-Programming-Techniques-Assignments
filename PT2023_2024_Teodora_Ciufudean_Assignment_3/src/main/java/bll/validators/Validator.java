package bll.validators;

/**
 * The Validator interface defines the contract for validation classes.
 * It provides a generic method for validating an object of type T.
 *
 * @param <T> The type of object to be validated.
 */
public interface Validator<T> {

    /**
     * Validates an object of type T.
     *
     * @param t The object to be validated.
     */
    public void validate(T t);
}
