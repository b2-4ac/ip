import java.util.List;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

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

    public ArrayList<Task> getRawList() {
        return this.list;
    }

    public void printList() {
        if (this.list.size() == 0) {
            System.out.println("No tasks yet.");
        } else {
            for (int i = 0; i < this.list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    public void markTask(int idx) {
        try {
            this.list.get(idx).mark();
            System.out.println("Task marked as completed. Good Job!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Task not found in list :(");
        }       
    }

    public void unmarkTask(int idx) {
        try {
            this.list.get(idx).unmark();
            System.out.println("Task has been reset. Get it done soon!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Task not found in list :(");
        }
    }

    public void deleteTask(int idx) {
        try {
            this.list.remove(idx);
            System.out.println("Task removed successfully.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Task not found in list :(");
        }
    }

    public void addTask(String title) {
        try {
            Todo newTask = new Todo(title);
            this.list.add(newTask);
            System.out.println("Added new To Do: " + title);
        } catch (MissingInputException e) {
            System.out.println("Oops! Some information is missing :(");
        }
    }

    public void addTask(String title, String deadline) {
        try {
            Deadline newTask = new Deadline(title, deadline);
            this.list.add(newTask);
            System.out.println("Added new Deadline: " + title);
        } catch (MissingInputException e) {
            System.out.println("Oops! Some information is missing :(");
        } catch (DateTimeParseException e) {
            System.out.println("Please enter the deadline in a yyyy-mm-dd format");
        }
    }

    public void addTask(String title, String start, String end) {
        try {
            Event newTask = new Event(title, start, end);
            this.list.add(newTask);
            System.out.println("Added new Event: " + title);
        } catch (MissingInputException e) {
            System.out.println("Oops! Some information is missing :(");
        } catch (DateTimeParseException e) {
            System.out.println("Please enter the deadline in a yyyy-mm-dd format");
        }
    }
}
