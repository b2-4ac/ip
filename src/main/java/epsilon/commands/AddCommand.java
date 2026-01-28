package epsilon.commands;

import java.util.ArrayList;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

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
     * creation.
     */
    public AddCommand(String type, ArrayList<String> params) {
        this.type = type;
        this.params = params;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        if (this.type.equals("todo")) {
            String title = params.get(0);
            list.addTask(title);
        } else if (type.equals("deadline")) {
            String title = params.get(0);
            String deadline = params.get(1);
            list.addTask(title, deadline);
        } else if (type.equals("event")) {
            String title = params.get(0);
            String start = params.get(1);
            String end = params.get(2);
            list.addTask(title, start, end);
        }
    }
}
