package epsilon;

import java.util.List;

import epsilon.tasks.Task;

/**
 * The class responsible for formatting program output.
 */
public class Ui {

    /**
     * Returns standard welcome message on application start.
     */
    public String welcome() {
        return "Hello! I'm Epsilon\nYour trusty task companion!";
    }

    /**
     * Returns standard farewell message on application close.
     *
     * @return String containing farewell message.
     */
    public String farewell() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Takes in a list of Tasks and formats all tasks into a readable
     * String to be output.
     *
     * @param list ArrayList of tasks to be printed.
     * @return String format of the tasks specified.
     */
    public String showList(List<Task> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append((i + 1) + ". " + list.get(i) + "\n");
        }
        return sb.toString();
    }
}
