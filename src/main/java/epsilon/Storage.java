package epsilon;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import epsilon.tasks.Task;

public class Storage {
    private Path filePath;

    public Storage(String pathString) {
        this.filePath = Paths.get(pathString);
    }

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
