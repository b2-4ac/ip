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
