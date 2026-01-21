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
            System.out.println("____________________________________________________________");
            if (cmd.equals("")) {
                System.out.println("No Input Detected :(");

            } else if (cmd.equals("list")) {
                if (list.size() == 0) {
                    System.out.println("No tasks yet.");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i));
                    }
                }

            } else if (cmd.split(" ")[0].equals("mark")) {
                try {
                    int in = Integer.parseInt(cmd.split(" ")[1]) - 1;
                    list.get(in).mark();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input :( Please enter the number of the task");
                    System.out.println("____________________________________________________________");
                    cmd = sc.nextLine();
                    continue;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Task not found in list :(");
                    System.out.println("____________________________________________________________");
                    cmd = sc.nextLine();
                    continue;
                }
                System.out.println("Task marked as completed. Good Job!");

            } else if (cmd.split(" ")[0].equals("unmark")) {
                try {
                    int in = Integer.parseInt(cmd.split(" ")[1]) - 1;
                    list.get(in).unmark();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input :( Please enter the number of the task");
                    System.out.println("____________________________________________________________");
                    cmd = sc.nextLine();
                    continue;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Task not found in list :(");
                    System.out.println("____________________________________________________________");
                    cmd = sc.nextLine();
                    continue;
                }
                System.out.println("Task has been reset. Get it done soon!");

            } else if (cmd.split(" ")[0].equals("delete")) {
                try {
                    int in = Integer.parseInt(cmd.split(" ")[1]) - 1;
                    list.remove(in);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input :( Please enter the number of the task");
                    System.out.println("____________________________________________________________");
                    cmd = sc.nextLine();
                    continue;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Task not found in list :(");
                    System.out.println("____________________________________________________________");
                    cmd = sc.nextLine();
                    continue;
                }
                System.out.println("Task removed successfully.");
            } else {
                int indexOfSpace = cmd.indexOf(' ');
                if (indexOfSpace == -1) {
                    System.out.println("Unrecognised Command :( Please try again.");
                    System.out.println("____________________________________________________________");
                    cmd = sc.nextLine();
                    continue;
                }
                String type = cmd.substring(0, indexOfSpace);
                String input = cmd.substring(indexOfSpace + 1);
                if (type.equals("todo")) {
                    try {
                        String title = input;
                        Todo newTodo = new Todo(title);
                        list.add(newTodo);
                        System.out.println("Added new To Do: " + title);
                    } catch (MissingInputException e) {
                        System.out.println("No Title Detected :(");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    }

                } else if (type.equals("deadline")) {
                    if (!input.contains("/by")) {
                        System.out.println("No deadline detected :( Use /by to indicate a deadline");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    }
                    String[] splitInput = input.split("/by");
                    if (splitInput.length == 1) {
                        System.out.println("No deadline detected :( Please try again.");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    }
                    String title = splitInput[0];
                    String deadline = splitInput[1];

                    try {
                        Deadline newDeadline = new Deadline(title, deadline);
                        list.add(newDeadline);
                        System.out.println("Added new Deadline: " + title);
                    } catch (MissingInputException e) {
                        System.out.println("Oops! Some information is missing :(");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    } 

                } else if (type.equals("event")) {
                    if (!input.contains("/from")) {
                        System.out.println("Missing start date :( Use /from to indicate a start");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    }

                    String[] splitInput = input.split("/from");
                    if (splitInput.length == 1) {
                        System.out.println("Missing start date :( Use /from to indicate a start");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    }

                    String title = splitInput[0];
                    String second = splitInput[1];
                    if (!second.contains("/to")) {
                        System.out.println("Missing end date :( Use /to to indicate an end");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    }

                    String[] splitSecond = second.split("to");
                    if (splitSecond.length == 1) {
                        System.out.println("Missing end date :( Use /to to indicate an end");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    }
                    String start = splitSecond[0];
                    String end = splitSecond[1];

                    try {
                        Event newEvent = new Event(title, start, end);
                        list.add(newEvent);
                        System.out.println("Added new Event: " + title);
                    } catch (MissingInputException e) {
                        System.out.println("Oops! Some information is missing :(");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    }
                    
                } else {
                    System.out.println("Unrecognised Command :( Please try again.");
                    System.out.println("____________________________________________________________");
                    cmd = sc.nextLine();
                    continue;
                }
            }
            System.out.println("____________________________________________________________");
            cmd = sc.nextLine();
        }

        sc.close();
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
