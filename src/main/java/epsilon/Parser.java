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
        String[] cmdSplit = cmd.split(" ");
        String inst = cmdSplit[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < cmdSplit.length; i++) {
            sb.append(cmdSplit[i] + " ");
        }
        String rawParams = sb.toString();

        if (inst.equals("todo")) {
            ArrayList<String> params = new ArrayList<>();
            params.add(rawParams);
            return new AddCommand("todo", params);
        } else if (inst.equals("deadline")) {
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
        } else if (inst.equals("event")) {
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
        } else if (inst.equals("list")) {
            if (!rawParams.trim().equals("")) {
                return new ErrorCommand("Unexpected arguments in \'list\' command");
            } else {
                return new ListCommand();
            }
        } else if (inst.equals("mark")) {
            try {
                int in = Integer.parseInt(rawParams.trim()) - 1;
                return new MarkCommand(in);
            } catch (NumberFormatException e) {
                return new ErrorCommand("Invalid Input :( Please enter the number of the task");
            }
        } else if (inst.equals("unmark")) {
            try {
                int in = Integer.parseInt(rawParams.trim()) - 1;
                return new UnmarkCommand(in);
            } catch (NumberFormatException e) {
                return new ErrorCommand("Invalid Input :( Please enter the number of the task");
            }
        } else if (inst.equals("delete")) {
            try {
                int in = Integer.parseInt(rawParams.trim()) - 1;
                return new DeleteCommand(in);
            } catch (NumberFormatException e) {
                return new ErrorCommand("Invalid Input :( Please enter the number of the task");
            }
        } else if (inst.equals("find")) {
            return new FindCommand(rawParams.trim());
        } else if (inst.equals("bye")) {
            if (!rawParams.trim().equals("")) {
                return new ErrorCommand("Unexpected arguments in exit command");
            } else {
                return new ExitCommand();
            }
        } else {
            return new ErrorCommand("Unrecognised Command. Please try again.");
        }
    }
}
