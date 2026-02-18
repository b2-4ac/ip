package epsilon.commands;

import java.util.List;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.response.Response;

/**
 * Represents a command which marks a specified task as completed when executed.
 */
public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public List<String> execute(TaskList list, Ui ui, Storage storage) {
        try {
            list.markTask(index);
            return Response.success("Task marked as Completed. Good Job!");
        } catch (IndexOutOfBoundsException e) {
            return Response.error("Task not found :(");
        }
    }
}
