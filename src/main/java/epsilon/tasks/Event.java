package epsilon.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import epsilon.exceptions.InvalidEventDateException;
import epsilon.exceptions.MissingInputException;

/**
 * A task with a duration (i.e. Start and End)
 */
public class Event extends TimedTask {
    private LocalDate start;
    private LocalDate end;

    /**
     * Passes the title to the parent Task constructor. Checks if the start and end
     * parameters provided are present and parses them into LocalDate objects.
     *
     * @param title Title of event.
     * @param start Date of start of event in yyyy-mm-dd format.
     * @param end Date of end of event in yyyy-mm-dd format.
     * @throws MissingInputException Throws exception if title, start or end are blank.
     * @throws DateTimeParseException Throws exception if start or end are in the wrong format.
     */
    public Event(String title, String start, String end)
            throws MissingInputException, DateTimeParseException, InvalidEventDateException {
        super(title);
        if (start.trim().equals("") || end.trim().equals("")) {
            throw new MissingInputException();
        }
        LocalDate s = LocalDate.parse(start.trim());
        LocalDate e = LocalDate.parse(end.trim());

        if (e.isBefore(s)) {
            throw new InvalidEventDateException();
        }
        this.start = s;
        this.end = e;
    }

    @Override
    public LocalDate getCriticalDate() {
        return this.start;
    }

    @Override
    public String encode() {
        if (super.getIsCompleted()) {
            return "E | " + "1" + " | " + super.getTitle() + " | "
                    + this.start.format(DateTimeFormatter.ISO_LOCAL_DATE) + " | "
                    + this.end.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            return "E | " + "0" + " | " + super.getTitle() + " | "
                    + this.start.format(DateTimeFormatter.ISO_LOCAL_DATE) + " | "
                    + this.end.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }

    @Override
    public String toString() {
        return "/E/" + super.toString() + " (from: "
                + this.start.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " to: "
                + this.end.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
