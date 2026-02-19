package epsilon;

import java.util.ArrayList;

import epsilon.commands.AddCommand;
import epsilon.commands.Command;
import epsilon.commands.DeleteCommand;
import epsilon.commands.ErrorCommand;
import epsilon.commands.ExitCommand;
import epsilon.commands.FindCommand;
import epsilon.commands.ListCommand;
import epsilon.commands.MarkCommand;
import epsilon.commands.UnmarkCommand;
import epsilon.commands.UpcomingCommand;

/**
 * An object used for interpreting and parsing user input into
 * the appropriate commands to execute
 */
public class Parser {
    /**
     * Returns the appropriate Command subtype (e.g. AddCommand, DeleteCommand etc.)
     * to be executed based on the input given, usually provided by the user and read
     * using the Ui class.
     *
     * @param cmd An instruction in the form of a String.
     * @return The proper Command type with the appropriate parameters
     *     for execution.
     */
    public Command parse(String cmd) {
        if (cmd.contains("|")) {
            return new ErrorCommand("Invalid Character Detected. Please avoid using \"|\".");
        }
        
        String[] cmdSplit = cmd.split(" ", 2);
        String inst = cmdSplit[0];
        String rawParams = cmdSplit.length > 1 ? cmdSplit[1] : "";

        switch (inst) {
        case "todo":
            return handleTodo(rawParams);
        case "deadline":
            return handleDeadline(rawParams);
        case "event":
            return handleEvent(rawParams);
        case "list":
            return handleList(rawParams);
        case "mark":
            return handleMark(rawParams);
        case "unmark":
            return handleUnmark(rawParams);
        case "delete":
            return handleDelete(rawParams);
        case "find":
            return handleFind(rawParams);
        case "upcoming":
            return handleUpcoming(rawParams);
        case "bye":
            return handleBye(rawParams);
        default:
            return new ErrorCommand("Unrecognised Command. Please try again.");
        }
    }

    /**
     * Helper method for the main parse method. Takes in
     * parameters and returns an AddCommand object of type
     * Todo.
     *
     * @param rawParams String parameters parsed from user input.
     * @return AddCommand object that adds a Todo task when executed.
     */
    private Command handleTodo(String rawParams) {
        ArrayList<String> params = new ArrayList<>();
        params.add(rawParams);
        return new AddCommand("todo", params);
    }

    /**
     * Helper method for the main parse method. Takes in
     * parameters and returns an AddCommand object of type
     * Deadline.
     *
     * @param rawParams String parameters parsed from user input.
     * @return AddCommand object that adds a Deadline task when executed.
     */
    private Command handleDeadline(String rawParams) {
        ArrayList<String> params = new ArrayList<>();
        try {
            String[] splitParams = rawParams.split("/by");
            String title = splitParams[0];
            String deadline = splitParams[1];
            params.add(title);
            params.add(deadline);
            return new AddCommand("deadline", params);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new ErrorCommand("Improper deadline. Use /by to indicate a deadline.");
        }
    }

    /**
     * Helper method for the main parse method. Takes in
     * parameters and returns an AddCommand object of type
     * Event.
     *
     * @param rawParams String parameters parsed from user input.
     * @return AddCommand object that adds a Event task when executed.
     */
    private Command handleEvent(String rawParams) {
        ArrayList<String> params = new ArrayList<>();
        try {
            String[] splitParams = rawParams.split("/from");
            String title = splitParams[0];
            String second = splitParams[1];
            String[] splitSecond = second.split("/to");
            String start = splitSecond[0];
            String end = splitSecond[1];
            params.add(title);
            params.add(start);
            params.add(end);
            return new AddCommand("event", params);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new ErrorCommand("Improper event duration. Use /from and /to to indicate duration.");
        }
    }

    /**
     * Helper method for the main parse method. Returns a
     * ListCommand.
     *
     * @param rawParams String parameters parsed from user input.
     * @return ListCommand object.
     */
    private Command handleList(String rawParams) {
        if (!rawParams.trim().equals("")) {
            return new ErrorCommand("Unexpected arguments in \'list\' command");
        } else {
            return new ListCommand();
        }
    }

    /**
     * Helper method for the main parse method. Takes in
     * an index from the parameters and returns a
     * MarkCommand object.
     *
     * @param rawParams String parameters parsed from user input.
     * @return MarkCommand object that marks the specified task as
     *     complete when executed.
     */
    private Command handleMark(String rawParams) {
        try {
            int in = Integer.parseInt(rawParams.trim()) - 1;
            return new MarkCommand(in);
        } catch (NumberFormatException e) {
            return new ErrorCommand("Invalid Input :( Please enter the number of the task");
        }
    }

    /**
     * Helper method for the main parse method. Takes in
     * an index from the parameters and returns a
     * UnmarkCommand object.
     *
     * @param rawParams String parameters parsed from user input.
     * @return MarkCommand object that marks the specified task as
     *     incomplete when executed.
     */
    private Command handleUnmark(String rawParams) {
        try {
            int in = Integer.parseInt(rawParams.trim()) - 1;
            return new UnmarkCommand(in);
        } catch (NumberFormatException e) {
            return new ErrorCommand("Invalid Input :( Please enter the number of the task");
        }
    }

    /**
     * Helper method for the main parse method. Takes in
     * an index from the parameters and returns a
     * DeleteCommand object.
     *
     * @param rawParams String parameters parsed from user input.
     * @return DeleteCommand object that deletes the specified task
     *     when executed.
     */
    private Command handleDelete(String rawParams) {
        try {
            int in = Integer.parseInt(rawParams.trim()) - 1;
            return new DeleteCommand(in);
        } catch (NumberFormatException e) {
            return new ErrorCommand("Invalid Input :( Please enter the number of the task");
        }
    }

    /**
     * Helper method for the main parse method. Takes in
     * a search string from the parameters and returns a
     * FindCommand object.
     *
     * @param rawParams String parameters parsed from user input.
     * @return FindCommand object with the parsed search string.
     */
    private Command handleFind(String rawParams) {
        return new FindCommand(rawParams.trim());
    }

    private Command handleUpcoming(String rawParams) {
        if (!rawParams.trim().equals("")) {
            return new ErrorCommand("Unexpected arguments in \'upcoming\' command");
        } else {
            return new UpcomingCommand();
        }
    }

    /**
     * Helper method for the main parse method. Returns an
     * ExitCommand.
     *
     * @param rawParams String parameters parsed from user input.
     * @return ExitCommand that terminates the application when
     *     executed.
     */
    private Command handleBye(String rawParams) {
        if (!rawParams.trim().equals("")) {
            return new ErrorCommand("Unexpected arguments in exit command");
        } else {
            return new ExitCommand();
        }
    }
}
