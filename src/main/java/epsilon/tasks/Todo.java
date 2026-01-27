package epsilon.tasks;

import epsilon.exceptions.MissingInputException;

public class Todo extends Task {

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
