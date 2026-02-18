package epsilon.commands;

import java.util.List;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.response.Response;

/**
 * Represents a command which marks a specified task as uncompleted when executed.
 */
public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public List<String> execute(TaskList list, Ui ui, Storage storage) {
        try {
            list.unmarkTask(index);
            return Response.success("Task has been reset. Get it done soon!");
        } catch (IndexOutOfBoundsException e) {
            return Response.error("Task not found.");
        }
    }
}
