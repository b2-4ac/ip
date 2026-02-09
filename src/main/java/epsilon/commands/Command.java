package epsilon.commands;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

/**
 * Template for Command instructions to be run by Epsilon
 */
public abstract class Command {
    /**
     * All Command objects must specify this execute() function which
     * performs an operation on the provided TaskList, Ui and/or Storage
     * objects provided.
     *
     * @param t TaskList object which holds a List of Task objects.
     * @param u Ui object which handles what the user sees and receives input.
     * @param s Storage object used for interacting with local hard disk storage files.
     */
    public abstract String execute(TaskList t, Ui u, Storage s);
}
