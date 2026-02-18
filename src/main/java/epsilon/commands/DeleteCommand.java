package epsilon.commands;

import java.util.List;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.response.Response;

/**
 * Represents a command which removes a task when executed.
 */
public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public List<String> execute(TaskList list, Ui ui, Storage storage) {
        try {
            list.deleteTask(index);
            return Response.success("Task removed successfully");
        } catch (IndexOutOfBoundsException e) {
            return Response.error("Task not found :(");
        }
    }
}
