package epsilon.commands;

import epsilon.Ui;
import epsilon.Storage;
import epsilon.TaskList;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.deleteTask(index);
    }
}
