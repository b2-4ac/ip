public abstract class Task {
    private String title;
    private boolean isCompleted;

    public Task(String title) throws MissingInputException {
        if (title.trim().equals("")) {
            throw new MissingInputException();
        }
        this.title = title.trim();
        this.isCompleted = false;
    }

    public void mark() {
        this.isCompleted = true;
    }

    public void unmark() {
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        if (this.isCompleted) {
            return "[X] " + this.title;
        } else {
            return "[ ] " + this.title;
        }
    }
}
