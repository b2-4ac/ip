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
    public String toString() {
        return "/E/" + super.toString() + "(from: " + start + " to: " + end + ")";
    }
}
