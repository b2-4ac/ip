package epsilon;

import java.util.ArrayList;
import java.util.Scanner;

import epsilon.tasks.Task;

public class Ui {
    private Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void welcome() {
        line();
        System.out.println("Hello! I'm Epsilon\nWhat can I do for you?");
        line();
    }

    public void farewell() {
        line();
        System.out.println("Bye. Hope to see you again soon!");
        line();
        this.sc.close();
    }

    public void line() {
        System.out.println("____________________________________________________________");
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void showList(ArrayList<Task> list) {
        if (list.size() == 0) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}
