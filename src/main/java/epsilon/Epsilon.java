package epsilon;

import java.util.List;

import epsilon.commands.Command;

public class Epsilon {
    private Ui ui;
    private Storage storage;
    private Parser parser;
    private TaskList list;

    public Epsilon(String listPath) {
        this.ui = new Ui();
        this.storage = new Storage(listPath);
        List<String> taskInput = storage.readTasks();
        this.list = new TaskList(taskInput);
        this.parser = new Parser();
    }

    public static void main(String[] args) {
        new Epsilon("tasks.txt").run();
    }

    public void run() {
        ui.welcome();
        String cmd = ui.readCommand();
        while (true) {
            ui.line();
            Command c = parser.parse(cmd);
            c.execute(list, ui, storage);
            ui.line();
            cmd = ui.readCommand();
        }
    }
}
