package epsilon.commands;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

/**
 * Represents a command that is only created in the event of user error.
 */
public class ErrorCommand extends Command {
    private String message;

    public ErrorCommand(String message) {
        this.message = message;
    }

    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        return this.message;
    }
}
