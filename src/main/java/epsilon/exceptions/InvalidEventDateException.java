package epsilon.exceptions;

/**
 * Represents an exception that is thrown when an Event task's end
 * date is before its start date.
 */
public class InvalidEventDateException extends Exception {
    public InvalidEventDateException() {
        super();
    }
}
