package epsilon.commands;

import epsilon.Ui;
import epsilon.Storage;
import epsilon.TaskList;

public class ErrorCommand extends Command {
    private String message;

    public ErrorCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        ui.showError(this.message);
    }
}
