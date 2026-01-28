package epsilon.commands;

import java.util.ArrayList;

import epsilon.tasks.Task;
import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        ArrayList<Task> l = list.getRawList();
        ui.showList(l);
    }
}
