public class Deadline extends Task{
    private String deadline;

    public Deadline(String title, String deadline) throws MissingInputException{
        super(title);
        if (deadline.trim().equals("")) {
            throw new MissingInputException();
        }
        this.deadline = deadline.trim();
    }

    @Override
    public String encode() {
        if (super.getIsCompleted()) {
            return "D | " + "1" + " | " + super.getTitle() + " | " + this.deadline;
        } else {
            return "D | " + "0" + " | " + super.getTitle() + " | " + this.deadline;
        }
    }


    @Override
    public String toString() {
        return "/D/" + super.toString() + " (by: " + this.deadline + ")";
    }
}
