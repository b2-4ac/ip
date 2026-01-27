package epsilon.commands;

import epsilon.Ui;
import epsilon.Storage;
import epsilon.TaskList;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.printList();
    }
}
