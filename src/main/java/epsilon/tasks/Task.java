package epsilon.tasks;

import epsilon.exceptions.MissingInputException;

/**
 * Abstract Task class used for templating Todos, Deadlines and Events.
 */
public abstract class Task {
    private String title;
    private boolean isCompleted;

    /**
     * Takes in the title of the task to be created in String representation, checking
     * that the input is valid (i.e. it is not blank nor filled with whitespace).
     *
     * @param title Title of the task to be created.
     * @throws MissingInputException Throws this exception if the title provided is empty
     *     or purely whitespace.
     */
    public Task(String title) throws MissingInputException {
        if (title.trim().equals("")) {
            throw new MissingInputException();
        }
        this.title = title.trim();
        this.isCompleted = false;
    }

    /**
     * Returns the title of the current task.
     *
     * @return Title of task.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns if the task has been marked as completed.
     *
     * @return Boolean value depending if the task is complete.
     */
    boolean getIsCompleted() {
        return this.isCompleted;
    }

    /**
     * Marks the current task as complete.
     */
    public void mark() {
        this.isCompleted = true;
    }

    /**
     * Marks the current task as incomplete.
     */
    public void unmark() {
        this.isCompleted = false;
    }

    /**
     * All subclasses of task will have to define this method which
     * provides a String representation of how this task is stored in
     * a text file. Note that this is different from how this task is
     * represented when printed to console (i.e. toString()).
     *
     * @return String representation of task to be stored in a text file.
     */
    public abstract String encode();

    @Override
    public String toString() {
        if (this.isCompleted) {
            return "[X] " + this.title;
        } else {
            return "[ ] " + this.title;
        }
    }
}
