public class Todo extends Task {

    public Todo(String title) throws MissingInputException {
        super(title);
    }

    @Override
    public String toString() {
        return "/T/" + super.toString();
    }
}
