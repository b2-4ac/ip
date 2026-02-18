package epsilon.commands;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.exceptions.MissingInputException;
import epsilon.response.Response;

/**
 * Represents a command which adds a task to the list when executed.
 */
public class AddCommand extends Command {
    private final String type;
    private final List<String> params;

    /**
     * Constructs an AddCommand object with the specified type of task
     * and relevant parameters.
     *
     * @param type String object containing the type of task to add.
     * @param params ArrayList of Strings containing the relevant parameters
     *     if any.
     */
    public AddCommand(String type, ArrayList<String> params) {
        this.type = type;
        this.params = params;
    }

    @Override
    public List<String> execute(TaskList list, Ui ui, Storage storage) {
        try {
            switch (type) {
            case "todo":
                return handleTodo(list);
            case "deadline":
                return handleDeadline(list);
            case "event":
                return handleEvent(list);
            default:
                return Response.error("Unknown Task Type detected");
            }
        } catch (MissingInputException e) {
            return Response.error("Oops! Some information is missing! :(");
        } catch (DateTimeParseException e) {
            return Response.error("Please enter the dates in YYYY-MM-DD format!");
        }
    }

    /* -------------------- Handlers for each task type -------------------- */

    private List<String> handleTodo(TaskList list) throws MissingInputException {
        assert params.size() == 1 : "Todo requires exactly 1 parameter";
        String title = params.get(0);

        return list.addTask(title)
                ? Response.success("Added new To Do: " + title)
                : Response.error("Too Many Parameters!");
    }

    private List<String> handleDeadline(TaskList list) throws MissingInputException {
        assert params.size() == 2 : "Deadline requires a title and a deadline";
        String title = params.get(0);
        String deadline = params.get(1);

        return list.addTask(title, deadline)
                ? Response.success("Added new Deadline: " + title)
                : Response.error("Too Many Parameters!");
    }

    private List<String> handleEvent(TaskList list) throws MissingInputException {
        assert params.size() == 3 : "Event requires title, start date, end date";
        String title = params.get(0);
        String start = params.get(1);
        String end = params.get(2);

        return list.addTask(title, start, end)
                ? Response.success("Added new Event: " + title)
                : Response.error("Too Many Parameters!");
    }
}
