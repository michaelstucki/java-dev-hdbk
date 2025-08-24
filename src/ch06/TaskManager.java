package ch06;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private static final String FILE_NAME = "tasks.ser";
    public void addTask(Task task) { tasks.add(task); }
    public void viewTasks() { tasks.forEach(System.out::println); }
    public void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
    public void loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (List<Task>) ois.readObject();
            System.out.println("Tasks loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved tasks found.");
        }
    }
}
