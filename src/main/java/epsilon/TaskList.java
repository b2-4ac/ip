package epsilon;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import epsilon.exceptions.MissingInputException;
import epsilon.exceptions.UnknownInputException;
import epsilon.tasks.Deadline;
import epsilon.tasks.Event;
import epsilon.tasks.Task;
import epsilon.tasks.TimedTask;
import epsilon.tasks.Todo;

/**
 * Represents an ArrayList of Task objects along with various
 * operations that can be performed on the list (e.g. Adding Tasks)
 */

public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Takes in a list of Strings as input and converts each line into a
     * Task object that is stored in its own ArrayList object.
     *
     * @param input List of Strings, typically read from a local .txt file.
     */
    public TaskList(List<String> input) {
        this.tasks = new ArrayList<>();
        try {
            for (String rawTask : input) {
                assert rawTask.contains("\\|") : "Task Information should be split using |";
                this.tasks.add(parseTask(rawTask));
            }
        } catch (MissingInputException e) {
            System.out.println("Error in Data: Missing Input");
        } catch (UnknownInputException e) {
            System.out.println("Error in Data: Unrecognised Input Detected");
        } catch (DateTimeParseException e) {
            System.out.println("Error in Data: Invalid Date");
        }
    }

    private Task parseTask(String rawTask) throws MissingInputException, UnknownInputException {
        String[] split = rawTask.split("\\|");

        String type = split[0].trim();
        boolean isDone = split[1].trim().equals("1");
        String title = split[2];

        switch (type) {
        case "T":
            Todo newTodo = new Todo(title);
            if (isDone) {
                newTodo.mark();
            }
            return newTodo;
        case "D":
            Deadline newDeadline = new Deadline(title, split[3]);
            if (isDone) {
                newDeadline.mark();
            }
            return newDeadline;
        case "E":
            Event newEvent = new Event(title, split[3], split[4]);
            if (isDone) {
                newEvent.mark();
            }
            return newEvent;
        default:
            throw new UnknownInputException();
        }
    }

    /**
     * Returns the ArrayList object being enapsulated by the TaskList.
     *
     * @return Java ArrayList object.
     */
    public ArrayList<Task> getRawList() {
        return this.tasks;
    }

    /**
     * Prints the entire list of stored tasks to the console in String
     * representation.
     */
    public void printList() {
        if (this.tasks.size() == 0) {
            System.out.println("No tasks yet.");
        } else {
            for (int i = 0; i < this.tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    /**
     * Takes in an index, usually supplied by an end user, and marks the
     * task specified at that index as complete.
     *
     * @param idx Integer index indicating which task to mark as complete.
     */
    public void markTask(int idx) throws IndexOutOfBoundsException {
        this.tasks.get(idx).mark();
    }

    /**
     * Takes in an index, usually supplied by an end user, and marks the
     * task specified at that index as incomplete.
     *
     * @param idx Integer index indicating which task to mark as incomplete
     */
    public void unmarkTask(int idx) throws IndexOutOfBoundsException {
        this.tasks.get(idx).unmark();
    }

    /**
     * Takes in an index, usually supplied by an end user, and removes the
     * task specified at that index as incomplete.
     *
     * @param idx Integer index indicating which task to delete.
     */
    public void deleteTask(int idx) throws IndexOutOfBoundsException {
        this.tasks.remove(idx);
    }

    /**
     * Takes in a title and possibly some dates depending on the
     * requested type of task to be added. Adds the specified
     * type of task along with the details into the current
     * task list.
     *
     * @param title Required title of the task to be added.
     * @param dates String of dates (from 0-2) depending on the type
     *     of task to be created.
     * @return Returns true if a task has been added successfully.
     *     Returns false if bad input is detected.
     */
    public boolean addTask(String title, String... dates) throws MissingInputException, DateTimeParseException {
        switch (dates.length) {
        case 0:
            Todo newTodo = new Todo(title);
            this.tasks.add(newTodo);
            return true;
        case 1:
            Deadline newDeadline = new Deadline(title, dates[0]);
            this.tasks.add(newDeadline);
            return true;
        case 2:
            Event newEvent = new Event(title, dates[0], dates[1]);
            this.tasks.add(newEvent);
            return true;
        default:
            return false;
        }
    }

    /**
     * Takes in a String from the user and filters through the existing tasks.
     * Returns only tasks that contain the specified String.
     *
     * @param searchString String to search for by the user.
     * @return Returns a list of tasks that contain the specified String.
     */
    public ArrayList<Task> findTasks(String searchString) {
        ArrayList<Task> res = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTitle().contains(searchString)) {
                res.add(task);
            }
        }
        return res;
    }

    public ArrayList<Task> getTasksBefore(LocalDate threshold) {
        ArrayList<Task> tasksBeforeThreshold = new ArrayList<>();
        for (Task task : tasks) {
            if (task instanceof TimedTask) {
                LocalDate criticalDate = ((TimedTask) task).getCriticalDate();
                if (criticalDate.isBefore(threshold)) {
                    tasksBeforeThreshold.add(task);
                }
            }
        }
        return tasksBeforeThreshold;
    }
}
