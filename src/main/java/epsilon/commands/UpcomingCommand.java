package epsilon.commands;

import java.time.LocalDate;
import java.util.List;

import epsilon.Storage;
import epsilon.TaskList;
import epsilon.Ui;
import epsilon.tasks.Task;

/**
 * Represents a Command which lists all deadlines and events
 * happening within the next week.
 */
public class UpcomingCommand extends Command {
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        LocalDate threshhold = LocalDate.now().plusWeeks(1);
        List<Task> upcomingTasks = list.getTasksBefore(threshhold);
        return ui.showList(upcomingTasks);
    }
}
