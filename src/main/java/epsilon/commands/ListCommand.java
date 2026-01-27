package epsilon.commands;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.printList();
    }
}
