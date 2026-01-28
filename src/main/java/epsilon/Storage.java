package epsilon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import epsilon.tasks.Task;

/**
 * A storage object used to interact with the hard disk copy
 * of the task list.
 */
public class Storage {
    private Path filePath;

    /**
     * Takes in a file path in String representation and converts it into a Path
     * object to be used for read and write operations.
     * 
     * @param pathString File path in String representation.
     */
    public Storage(String pathString) {
        this.filePath = Paths.get(pathString);
    }

    /**
     * Returns a List object with Strings as lines read from
     * the file path specified during this Storage object's
     * instantiation.
     * 
     * @return List of lines of text as Strings.
     */
    public List<String> readTasks() {
        List<String> rawTasks = new ArrayList<>();
        try {
            if (Files.notExists(this.filePath)) {
                Files.createFile(this.filePath);
            }
            rawTasks = Files.readAllLines(this.filePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return rawTasks;
    }

    /**
     * Converts a list of Task objects into a String representation
     * before storing them into the file path specified during this
     * Storage object's instantiation.
     * 
     * @param taskList A List of Task objects to be converted into
     * Strings and written.
     */
    public void writeTasks(List<Task> taskList) {
        ArrayList<String> toWrite = new ArrayList<>();
        for (Task task : taskList) {
            toWrite.add(task.encode());
        }

        try {
            Files.write(this.filePath, toWrite);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
