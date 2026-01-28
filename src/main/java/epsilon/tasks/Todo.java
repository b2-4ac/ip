package epsilon.tasks;

import epsilon.exceptions.MissingInputException;

/**
 * Represents a Task without a deadline or a duration.
 */
public class Todo extends Task {

    /**
     * Passes the title into the Task constructor.
     *
     * @param title Title of Todo.
     * @throws MissingInputException Throws exception if the title is blank.
     */
    public Todo(String title) throws MissingInputException {
        super(title);
    }

    @Override
    public String encode() {
        if (super.getIsCompleted()) {
            return "T | " + "1" + " | " + super.getTitle();
        } else {
            return "T | " + "0" + " | " + super.getTitle();
        }
    }

    @Override
    public String toString() {
        return "/T/" + super.toString();
    }
}
