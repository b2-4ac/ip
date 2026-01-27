package epsilon.commands;

import epsilon.Ui;
import epsilon.Storage;
import epsilon.TaskList;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.unmarkTask(index);
    }
}
