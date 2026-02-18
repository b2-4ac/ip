package epsilon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import epsilon.exceptions.MissingInputException;
import epsilon.tasks.Task;

public class TaskListTest {
    @Test
    public void addTask_standardInput_success() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = new PrintStream(System.out);
        System.setOut(new PrintStream(outContent));

        ArrayList<String> empty = new ArrayList<>();
        TaskList list = new TaskList(empty);

        assertTrue(list.addTask("New Todo"), "addTask should return true for valid Todo");
        assertTrue(list.addTask("New Deadline", "2026-01-29"), "addTask should return true for valid Deadline");
        assertTrue(list.addTask("New Event", "2026-01-29", "2026-01-30"), "addTask should return true for valid Event");

        for (Task task : list.getRawList()) {
            System.out.println(task);
        }

        String expectedOutput = String.format(
            "/T/[ ] New Todo%n"
            + "/D/[ ] New Deadline (by: Jan 29 2026)%n"
            + "/E/[ ] New Event (from: Jan 29 2026 to: Jan 30 2026)%n");
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void addTask_noTitle_exceptionHandled() {
        ArrayList<String> empty = new ArrayList<>();
        TaskList list = new TaskList(empty);

        assertThrows(MissingInputException.class, () -> {
            list.addTask("");
        });

        assertThrows(MissingInputException.class, () -> {
            list.addTask(" ");
        });
    }

    @Test
    public void addTask_badDate_exceptionHandled() {
        ArrayList<String> empty = new ArrayList<>();
        TaskList list = new TaskList(empty);

        assertThrows(DateTimeParseException.class, () -> {
            list.addTask("New Deadline", "no-date");
        });

        assertThrows(DateTimeParseException.class, () -> {
            list.addTask("New Event", "3/1/26", "19/2/26");
        });
    }
}
