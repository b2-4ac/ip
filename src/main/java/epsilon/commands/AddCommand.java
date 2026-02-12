package epsilon.commands;

import java.util.ArrayList;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

/**
 * Represents a command which adds a task to the list when executed.
 */
public class AddCommand extends Command {
    private String type;
    private ArrayList<String> params;

    /**
     * Called after the Parser has parsed user input and determined
     * which type of Task is to be created. Along with a list of parameters
     * provided by the user.
     *
     * @param type Type of task to be created.
     * @param params ArrayList of parameters provided by user input for Task object
     *        creation.
     */
    public AddCommand(String type, ArrayList<String> params) {
        this.type = type;
        this.params = params;
    }

    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        String title = params.get(0);
        switch (this.type) {
        case "todo":
            assert params.size() == 1 : "Todo needs a title";
            return list.addTask(title);
        case "deadline":
            assert params.size() == 2 : "Deadline needs a title and a deadline";
            String deadline = params.get(1);
            return list.addTask(title, deadline);
        case "event":
            assert params.size() == 3 : "Event needs a title, start and end date";
            String start = params.get(1);
            String end = params.get(2);
            return list.addTask(title, start, end);
        default:
            return "Unknown Task Type detected";
        }
    }
}
