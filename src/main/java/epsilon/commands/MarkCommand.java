package epsilon.commands;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.markTask(index);
    }
}
