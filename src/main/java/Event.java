import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDate start;
    private LocalDate end;

    public Event(String title, String start, String end) throws MissingInputException {
        super(title);
        if (start.trim().equals("") || end.trim().equals("")) {
            throw new MissingInputException();
        }
        this.start = LocalDate.parse(start.trim());
        this.end = LocalDate.parse(end.trim());
    }

    @Override
    public String encode() {
        if (super.getIsCompleted()) {
            return "E | " + "1" + " | " + super.getTitle() + " | " + this.start.format(DateTimeFormatter.ISO_LOCAL_DATE) + " | " + this.end.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            return "E | " + "0" + " | " + super.getTitle() + " | " + this.start.format(DateTimeFormatter.ISO_LOCAL_DATE) + " | " + this.end.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }


    @Override
    public String toString() {
        return "/E/" + super.toString() + " (from: " + this.start.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " to: " + this.end.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
