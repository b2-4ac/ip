package epsilon.commands;

import epsilon.Ui;
import epsilon.Storage;
import epsilon.TaskList;

public abstract class Command {
    public abstract void execute(TaskList t, Ui u, Storage s);
}
