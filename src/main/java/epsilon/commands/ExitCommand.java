package epsilon.commands;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

/**
 * Represents a command that ends the application when executed.
 */
public class ExitCommand extends Command {
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        storage.writeTasks(list.getRawList());
        System.exit(0);
        return ui.farewell();
    }
}
