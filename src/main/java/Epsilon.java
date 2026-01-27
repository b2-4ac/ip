import java.util.Scanner;
import java.util.List;

public class Epsilon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String LIST_DATA = "tasks.txt";
        Storage storage = new Storage(LIST_DATA);
        List<String> taskInput = storage.readTasks();
        TaskList list = new TaskList(taskInput);
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Epsilon\nWhat can I do for you?");
        System.out.println("____________________________________________________________");
        String cmd = sc.nextLine();
        while (!cmd.equals("bye")) {
            System.out.println("____________________________________________________________");
            if (cmd.equals("")) {
                System.out.println("No Input Detected :(");
            } else if (cmd.equals("list")) {
                list.printList();
            } else if (cmd.split(" ")[0].equals("mark")) {
                try {
                    int in = Integer.parseInt(cmd.split(" ")[1]) - 1;
                    list.markTask(in);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input :( Please enter the number of the task");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid Input :( Please enter the number of the task");
                }
            } else if (cmd.split(" ")[0].equals("unmark")) {
                try {
                    int in = Integer.parseInt(cmd.split(" ")[1]) - 1;
                    list.unmarkTask(in);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input :( Please enter the number of the task");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid Input :( Please enter the number of the task");
                }
            } else if (cmd.split(" ")[0].equals("delete")) {
                try {
                    int in = Integer.parseInt(cmd.split(" ")[1]) - 1;
                    list.deleteTask(in);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input :( Please enter the number of the task");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid Input :( Please enter the number of the task");
                }
            } else {
                String[] segments = cmd.trim().split(" ");
                String type = segments[0];
                String input = "";
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < segments.length; i++) {
                    sb.append(segments[i]);
                }
                input = sb.toString();
                if (type.equals("todo")) {
                    String title = input;
                    list.addTask(title);
                } else if (type.equals("deadline")) {
                    try {
                        String[] splitInput = input.split("/by");
                        String title = splitInput[0];
                        String deadline = splitInput[1];
                        list.addTask(title, deadline);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("No deadline detected. Use /by to indicate a deadline.");
                    }
                } else if (type.equals("event")) {
                    try {
                        String[] splitInput = input.split("/from");
                        String title = splitInput[0];
                        String second = splitInput[1];
                        String[] splitSecond = second.split("/to");
                        String start = splitSecond[0];
                        String end = splitSecond[1];
                        list.addTask(title, start, end);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Improper event duration. Use /from and /to to indicate duration");
                    }
                } else {
                    System.out.println("Unrecognised Command :( Please try again.");
                }
            }
            System.out.println("____________________________________________________________");
            cmd = sc.nextLine();
        }
        sc.close();
        storage.writeTasks(list.getRawList());
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
