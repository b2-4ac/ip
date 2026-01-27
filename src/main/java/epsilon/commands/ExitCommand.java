package epsilon.commands;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        storage.writeTasks(list.getRawList());
        ui.farewell();
        System.exit(0);
    }
}
