public class Event extends Task {
    private String start;
    private String end;

    public Event(String title, String start, String end) throws MissingInputException {
        super(title);
        if (start.trim().equals("") || end.trim().equals("")) {
            throw new MissingInputException();
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public String encode() {
        if (super.getIsCompleted()) {
            return "E | " + "1" + " | " + super.getTitle() + " | " + this.start + " | " + this.end;
        } else {
            return "E | " + "0" + " | " + super.getTitle() + " | " + this.start + " | " + this.end;
        }
    }


    @Override
    public String toString() {
        return "/E/" + super.toString() + " (from: " + start + " to: " + end + ")";
    }
}
