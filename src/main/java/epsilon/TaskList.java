package epsilon;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import epsilon.exceptions.MissingInputException;
import epsilon.tasks.Deadline;
import epsilon.tasks.Event;
import epsilon.tasks.Task;
import epsilon.tasks.Todo;

/**
 * Represents an ArrayList of Task objects along with various
 * operations that can be performed on the list (e.g. Adding Tasks)
 */

public class TaskList {
    private ArrayList<Task> list;

    /**
     * Takes in a list of Strings as input and converts each line into a
     * Task object that is stored in its own ArrayList object.
     *
     * @param input List of Strings, typically read from a local .txt file.
     */
    public TaskList(List<String> input) {
        this.list = new ArrayList<>();
        try {
            for (String rawTask : input) {
                String[] split = rawTask.split("\\|");
                if (split[0].trim().equals("T")) {
                    String title = split[2];
                    Todo newTodo = new Todo(title);
                    if (split[1].trim().equals("1")) {
                        newTodo.mark();
                    }
                    this.list.add(newTodo);
                } else if (split[0].trim().equals("D")) {
                    String title = split[2];
                    String deadline = split[3];
                    Deadline newDeadline = new Deadline(title, deadline);
                    if (split[1].trim().equals("1")) {
                        newDeadline.mark();
                    }
                    this.list.add(newDeadline);
                } else if (split[0].trim().equals("E")) {
                    String title = split[2];
                    String start = split[3];
                    String end = split[4];
                    Event newEvent = new Event(title, start, end);
                    if (split[1].trim().equals("1")) {
                        newEvent.mark();
                    }
                    this.list.add(newEvent);
                }
            }
        } catch (MissingInputException e) {
            System.out.println("Error in Data: Missing Input");
        } catch (DateTimeParseException e) {
            System.out.println("Error in Data: Invalid Date");
        }
    }

    /**
     * Returns the ArrayList object being enapsulated by the TaskList.
     *
     * @return Java ArrayList object.
     */
    public ArrayList<Task> getRawList() {
        return this.list;
    }

    /**
     * Prints the entire list of stored tasks to the console in String
     * representation.
     */
    public void printList() {
        if (this.list.size() == 0) {
            System.out.println("No tasks yet.");
        } else {
            for (int i = 0; i < this.list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    /**
     * Takes in an index, usually supplied by an end user, and marks the
     * task specified at that index as complete.
     *
     * @param idx Integer index indicating which task to mark as complete.
     */
    public String markTask(int idx) {
        try {
            this.list.get(idx).mark();
            return "Task marked as completed. Good Job!";
        } catch (IndexOutOfBoundsException e) {
            return "Task not found in list :(";
        }
    }

    /**
     * Takes in an index, usually supplied by an end user, and marks the
     * task specified at that index as incomplete.
     *
     * @param idx Integer index indicating which task to mark as incomplete
     */
    public String unmarkTask(int idx) {
        try {
            this.list.get(idx).unmark();
            return "Task has been reset. Get it done soon!";
        } catch (IndexOutOfBoundsException e) {
            return "Task not found in list :(";
        }
    }

    /**
     * Takes in an index, usually supplied by an end user, and removes the
     * task specified at that index as incomplete.
     *
     * @param idx Integer index indicating which task to delete.
     */
    public String deleteTask(int idx) {
        try {
            this.list.remove(idx);
            return "Task removed successfully.";
        } catch (IndexOutOfBoundsException e) {
            return "Task not found in list :(";
        }
    }

    /**
     * Overloaded addTask method which changes the type of Task object
     * to be created based on the number of parameters provided to the
     * method. One parameter creates a Todo. Two parameters create a Deadline.
     * Three parameters create an Event.
     *
     * @param title Title of the Todo task.
     */
    public String addTask(String title) {
        try {
            Todo newTask = new Todo(title);
            this.list.add(newTask);
            return "Added new To Do: " + title;
        } catch (MissingInputException e) {
            return "Oops! Some information is missing :(";
        }
    }

    /**
     * Overloaded addTask method which changes the type of Task object
     * to be created based on the number of parameters provided to the
     * method. One parameter creates a Todo. Two parameters create a Deadline.
     * Three parameters create an Event.
     *
     * @param title Title of the Deadline task.
     * @param deadline String representation of the date of the deadline in yyyy-mm-dd
     *     format.
     */
    public String addTask(String title, String deadline) {
        try {
            Deadline newTask = new Deadline(title, deadline);
            this.list.add(newTask);
            return "Added new Deadline: " + title;
        } catch (MissingInputException e) {
            return "Oops! Some information is missing :(";
        } catch (DateTimeParseException e) {
            return "Please enter the deadline in a yyyy-mm-dd format";
        }
    }

    /**
     * Overloaded addTask method which changes the type of Task object
     * to be created based on the number of parameters provided to the
     * method. One parameter creates a Todo. Two parameters create a Deadline.
     * Three parameters create an Event.
     *
     * @param title Title of the Deadline task.
     * @param start String representation of the date of the start of the event
     *     in yyyy-mm-dd format.
     * @param end String representation of the date of the start of the event
     *     in yyyy-mm-dd format.
     */
    public String addTask(String title, String start, String end) {
        try {
            Event newTask = new Event(title, start, end);
            this.list.add(newTask);
            return "Added new Event: " + title;
        } catch (MissingInputException e) {
            return "Oops! Some information is missing :(";
        } catch (DateTimeParseException e) {
            return "Please enter the deadline in a yyyy-mm-dd format";
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
        for (Task task : list) {
            if (task.getTitle().contains(searchString)) {
                res.add(task);
            }
        }
        return res;
    }
}
