package epsilon;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import epsilon.tasks.Task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    @Test
    public void addTask_standardInput_success() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = new PrintStream(System.out);
        System.setOut(new PrintStream(outContent));

        ArrayList<String> empty = new ArrayList<>();
        TaskList list = new TaskList(empty);

        list.addTask("New Todo");
        list.addTask("New Deadline", "2026-01-29");
        list.addTask("New Event", "2026-01-29", "2026-01-30");
        
        for (Task task : list.getRawList()) {
            System.out.println(task);
        }

        String expectedOutput = String.format(
            "Added new To Do: New Todo%n"
            +"Added new Deadline: New Deadline%n"
            +"Added new Event: New Event%n"
            +"/T/[ ] New Todo%n"
            +"/D/[ ] New Deadline (by: Jan 29 2026)%n"
            +"/E/[ ] New Event (from: Jan 29 2026 to: Jan 30 2026)%n");
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void addTask_noTitle_exceptionHandled() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = new PrintStream(System.out);
        System.setOut(new PrintStream(outContent));

        ArrayList<String> empty = new ArrayList<>();
        TaskList list = new TaskList(empty);

        list.addTask("");
        list.addTask("", "2026-01-29");
        list.addTask(" ", "2026-01-29", "2026-01-30");

        String expectedOutput = String.format(
            "Oops! Some information is missing :(%n"
            +"Oops! Some information is missing :(%n"
            +"Oops! Some information is missing :(%n");
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void addTask_badDate_exceptionHandled() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = new PrintStream(System.out);
        System.setOut(new PrintStream(outContent));

        ArrayList<String> empty = new ArrayList<>();
        TaskList list = new TaskList(empty);

        list.addTask("New Deadline", "no-date");
        list.addTask("New Event", "3/1/26", "19/2/26");

        String expectedOutput = String.format(
            "Please enter the deadline in a yyyy-mm-dd format%n"
            +"Please enter the deadline in a yyyy-mm-dd format%n");
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }
}
