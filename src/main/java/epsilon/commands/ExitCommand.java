package epsilon.commands;

import epsilon.Ui;
import epsilon.Storage;
import epsilon.TaskList;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        storage.writeTasks(list.getRawList());
        ui.farewell();
        System.exit(0);
    }
}
