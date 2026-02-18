package epsilon.commands;

import java.util.List;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.response.Response;

/**
 * Represents a command that ends the application when executed.
 */
public class ExitCommand extends Command {
    @Override
    public List<String> execute(TaskList list, Ui ui, Storage storage) {
        storage.writeTasks(list.getRawList());
        System.exit(0);
        return Response.success(ui.farewell());
    }
}
