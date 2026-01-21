import java.util.Scanner;
import java.util.ArrayList;

public class Epsilon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Epsilon\nWhat can I do for you?");
        System.out.println("____________________________________________________________");
        String cmd = sc.nextLine();
        while (!cmd.equals("bye")) {
            if (cmd.equals("")) {
                System.out.println("____________________________________________________________");
                System.out.println("No Input Detected :(");
                System.out.println("____________________________________________________________");
            } else if (cmd.equals("list")) {
                System.out.println("____________________________________________________________");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i));
                }
                System.out.println("____________________________________________________________");
            } else if (cmd.split(" ")[0].equals("mark")) {
                list.get(Integer.parseInt(cmd.split(" ")[1]) - 1).mark();
                System.out.println("____________________________________________________________");
                System.out.println("Task marked as completed. Good Job!");
                System.out.println("____________________________________________________________");
            } else if (cmd.split(" ")[0].equals("unmark")) {
                list.get(Integer.parseInt(cmd.split(" ")[1]) - 1).unmark();
                System.out.println("____________________________________________________________");
                System.out.println("Task has been reset. Get it done soon!");
                System.out.println("____________________________________________________________");
            } else {
                Task newTask = new Task(cmd);
                list.add(newTask);
                System.out.println("____________________________________________________________");
                System.out.println("added: " + cmd);
                System.out.println("____________________________________________________________");
            }
            cmd = sc.nextLine();
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
