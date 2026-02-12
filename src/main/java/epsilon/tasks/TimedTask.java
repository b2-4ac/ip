package epsilon.tasks;

import java.time.LocalDate;

import epsilon.exceptions.MissingInputException;

/**
 * Represents a Task that holds a time aspect, whether it
 * is a deadline or a start/end time.
 */
public abstract class TimedTask extends Task {

    public TimedTask(String title) throws MissingInputException {
        super(title);
    }

    /**
     * Returns the relevant critical date information of a given
     * task.
     *
     * @return LocalDate object that holds the relevant
     *     date information for the given task type.
     */
    public abstract LocalDate getCriticalDate();
}
