package epsilon.commands;

import java.util.ArrayList;

import epsilon.tasks.Task;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.Storage;

public class FindCommand extends Command {
    private String searchString;

    public FindCommand(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        ArrayList<Task> result = list.findTasks(this.searchString);
        ui.showList(result);
    }
}
