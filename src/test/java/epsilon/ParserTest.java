package epsilon;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import epsilon.commands.AddCommand;
import epsilon.commands.DeleteCommand;
import epsilon.commands.ErrorCommand;
import epsilon.commands.ExitCommand;
import epsilon.commands.ListCommand;
import epsilon.commands.MarkCommand;
import epsilon.commands.UnmarkCommand;
import epsilon.exceptions.MissingInputException;

public class ParserTest {
    @Test
    public void parse_standardInput_success() throws MissingInputException {
        Parser parser = new Parser();

        assertInstanceOf(AddCommand.class, parser.parse("todo New Todo"));
        assertInstanceOf(AddCommand.class, parser.parse("deadline New Deadline /by 2026-01-29"));
        assertInstanceOf(AddCommand.class, parser.parse("event New Event /from 2026-01-29 /to 2026-01-30"));
        assertInstanceOf(ListCommand.class, parser.parse("list"));
        assertInstanceOf(MarkCommand.class, parser.parse("mark 1"));
        assertInstanceOf(UnmarkCommand.class, parser.parse("unmark 1"));
        assertInstanceOf(DeleteCommand.class, parser.parse("delete 1"));
        assertInstanceOf(ExitCommand.class, parser.parse("bye"));
    }

    @Test
    public void parse_improperFormat_errorCommand() {
        Parser parser = new Parser();

        assertInstanceOf(ErrorCommand.class, parser.parse("deadline New Deadline"));
        assertInstanceOf(ErrorCommand.class, parser.parse("event New Event"));
        assertInstanceOf(ErrorCommand.class, parser.parse("event New Event /from"));
        assertInstanceOf(ErrorCommand.class, parser.parse("event New Event /to"));
    }

    @Test
    public void parse_extraInfo_errorCommand() {
        Parser parser = new Parser();

        assertInstanceOf(ErrorCommand.class, parser.parse("list 5"));
        assertInstanceOf(ErrorCommand.class, parser.parse("bye forever"));
    }

    @Test
    public void parse_badIndex_errorCommand() {
        Parser parser = new Parser();

        assertInstanceOf(ErrorCommand.class, parser.parse("mark all"));
        assertInstanceOf(ErrorCommand.class, parser.parse("unmark them"));
        assertInstanceOf(ErrorCommand.class, parser.parse("delete him"));
    }
}
