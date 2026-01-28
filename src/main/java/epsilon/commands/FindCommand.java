package epsilon.commands;

import java.util.ArrayList;

import epsilon.TaskList;
import epsilon.Ui;
import epsilon.Storage;
import epsilon.tasks.Task;

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
