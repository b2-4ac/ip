package epsilon.commands;

import java.util.ArrayList;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.tasks.Task;

/**
 * Represents a command that filters through the existing list of tasks and
 * returns only the tasks that contain the specified String when executed.
 */
public class FindCommand extends Command {
    private String searchString;

    public FindCommand(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        ArrayList<Task> result = list.findTasks(this.searchString);
        return ui.showList(result);
    }
}
