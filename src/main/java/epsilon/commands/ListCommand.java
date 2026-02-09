package epsilon.commands;

import java.util.ArrayList;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.tasks.Task;

/**
 * Represents a command which prints all tasks currently in the list when executed.
 */
public class ListCommand extends Command {
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        ArrayList<Task> l = list.getRawList();
        return ui.showList(l);
    }
}
