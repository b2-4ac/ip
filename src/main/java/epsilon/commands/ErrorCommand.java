package epsilon.commands;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

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
