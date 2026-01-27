package epsilon;

import java.util.Scanner;

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
}
