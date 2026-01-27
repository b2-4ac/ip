package epsilon.commands;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;

public abstract class Command {
    public abstract void execute(TaskList t, Ui u, Storage s);
}
