package epsilon.commands;

import java.util.ArrayList;
import java.util.List;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.response.Response;
import epsilon.tasks.Task;

/**
 * Represents a command which prints all tasks currently in the list when executed.
 */
public class ListCommand extends Command {
    @Override
    public List<String> execute(TaskList list, Ui ui, Storage storage) {
        ArrayList<Task> fullList = list.getRawList();
        if (fullList.size() == 0) {
            return Response.error("No Tasks Found.");
        }
        return Response.success(ui.showList(fullList));
    }
}
