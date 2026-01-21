import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;

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
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i));
                }

            } else if (cmd.split(" ")[0].equals("mark")) {
                list.get(Integer.parseInt(cmd.split(" ")[1]) - 1).mark();
                System.out.println("Task marked as completed. Good Job!");

            } else if (cmd.split(" ")[0].equals("unmark")) {
                list.get(Integer.parseInt(cmd.split(" ")[1]) - 1).unmark();
                System.out.println("Task has been reset. Get it done soon!");

            } else {
                StringBuilder titleBuilder = new StringBuilder();
                String[] cmdSplit = cmd.split(" ");
                String type = cmdSplit[0];
                String title = "";
                if (type.equals("todo")) {
                    for (int i = 1; i < cmdSplit.length; i++) {
                        titleBuilder.append(cmdSplit[i] + " ");
                    }
                    title = titleBuilder.toString();
                    Todo newTodo = new Todo(title);
                    list.add(newTodo);

                } else if (type.equals("deadline")) {
                    boolean hasDeadline = false;
                    int i = 1;
                    while (i < cmdSplit.length) {
                        if (cmdSplit[i].equals("/by")) {
                            title = titleBuilder.toString();
                            hasDeadline = true;
                            break;
                        } else {
                            titleBuilder.append(cmdSplit[i] + " ");
                        }
                        i++;
                    }
                    String deadline = "";
                    if (hasDeadline) {
                        StringBuilder deadlineBuilder = new StringBuilder();
                        i++;
                        while (i < cmdSplit.length) {
                            deadlineBuilder.append(cmdSplit[i] + " ");
                            i++;
                        }
                        deadline = deadlineBuilder.toString();
                        Deadline newDeadline = new Deadline(title, deadline);
                        list.add(newDeadline);
                    } else {
                        System.out.println("No deadline detected :(. Use /by to indicate a deadline");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    }
                    
                } else if (type.equals("event")) {
                    boolean hasStart = false;
                    boolean hasEnd = false;
                    int i = 1;
                    title = "";
                    while (i < cmdSplit.length) {
                        if (cmdSplit[i].equals("/from")) {
                            title = titleBuilder.toString();
                            hasStart = true;
                            break;
                        } else {
                            titleBuilder.append(cmdSplit[i] + " ");
                        }
                        i++;
                    }
                    String start = "";
                    String end = "";
                    if (hasStart) {
                        StringBuilder startBuilder = new StringBuilder();
                        i++;
                        while (i < cmdSplit.length) {
                            if (cmdSplit[i].equals("/to")) {
                                hasEnd = true;
                                break;
                            }
                            startBuilder.append(cmdSplit[i] + " ");
                            i++;
                        }
                        start = startBuilder.toString();
                        if (hasEnd) {
                            StringBuilder endBuilder = new StringBuilder();
                            i++;
                            while (i < cmdSplit.length) {
                                endBuilder.append(cmdSplit[i] + " ");
                                i++;
                            }
                            end = endBuilder.toString();
                        } else {
                            System.out.println("No end date detected :(. Use /to to indicate a deadline");
                            System.out.println("____________________________________________________________");
                            cmd = sc.nextLine();
                            continue;
                        }
                    } else {
                        System.out.println("No start date detected :(. Use /from to indicate a deadline");
                        System.out.println("____________________________________________________________");
                        cmd = sc.nextLine();
                        continue;
                    }
                    Event newEvent = new Event(title, start, end);
                    list.add(newEvent);
                } else {
                    System.out.println("Unrecognised Command :(. Please try again.");
                    System.out.println("____________________________________________________________");
                    cmd = sc.nextLine();
                    continue;
                }
                System.out.println("Added new " + type + ": " + title);
            }
            System.out.println("____________________________________________________________");
            cmd = sc.nextLine();
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
