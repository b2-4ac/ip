package epsilon.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import epsilon.exceptions.MissingInputException;

public class Deadline extends Task {
    private LocalDate deadline;

    public Deadline(String title, String deadline) throws MissingInputException, DateTimeParseException {
        super(title);
        if (deadline.trim().equals("")) {
            throw new MissingInputException();
        }
        this.deadline = LocalDate.parse(deadline.trim());
    }

    @Override
    public String encode() {
        if (super.getIsCompleted()) {
            return "D | " + "1" + " | " + super.getTitle() + " | "
                    + this.deadline.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            return "D | " + "0" + " | " + super.getTitle() + " | "
                    + this.deadline.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }

    @Override
    public String toString() {
        return "/D/" + super.toString() + " (by: "
                + this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
