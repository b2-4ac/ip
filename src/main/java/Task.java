public class Task {
    private String title;
    private boolean isCompleted;

    public Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    public void toggle() {
        this.isCompleted = !this.isCompleted;
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
