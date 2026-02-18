package epsilon.commands;

import java.util.List;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.response.Response;

/**
 * Represents a command that is only created in the event of user error.
 */
public class ErrorCommand extends Command {
    private String message;

    public ErrorCommand(String message) {
        this.message = message;
    }

    @Override
    public List<String> execute(TaskList list, Ui ui, Storage storage) {
        return Response.error(this.message);
    }
}
