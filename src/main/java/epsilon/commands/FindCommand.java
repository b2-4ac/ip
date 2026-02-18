package epsilon.commands;

import java.util.ArrayList;
import java.util.List;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.response.Response;
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
    public List<String> execute(TaskList list, Ui ui, Storage storage) {
        ArrayList<Task> searchResult = list.findTasks(this.searchString);
        if (searchResult.size() == 0) {
            return Response.error("No tasks found.");
        }
        return Response.success(ui.showList(searchResult));
    }
}
