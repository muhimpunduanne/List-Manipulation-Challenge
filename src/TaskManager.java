import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

// Custom Exception
class InvalidTaskException extends Exception {
    public InvalidTaskException(String message) {
        super(message);
    }
}

public class TaskManager {
    private ArrayList<String> tasksArray;
    private LinkedList<String> tasksList;

    // Constructor
    public TaskManager() {
        tasksArray = new ArrayList<>();
        tasksList = new LinkedList<>();
    }

    // Method to add a task
    public void addTask(String task) throws InvalidTaskException {
        if (task == null || task.trim().isEmpty()) {
            throw new InvalidTaskException("Task cannot be empty or null!");
        }
        tasksArray.add(task);
        tasksList.add(task);
    }

    // Method to sort tasks
    public void sortTasks() {
        Collections.sort(tasksArray);
        Collections.sort(tasksList);
    }

    // Method to search for a specific task
    public int searchTask(String task) {
        if (tasksArray.contains(task)) {
            return tasksArray.indexOf(task);
        }
        return -1; // Task not found
    }

    // Method to remove a task
    public boolean removeTask(String task) {
        if (tasksArray.contains(task)) {
            tasksArray.remove(task);
            tasksList.remove(task);
            return true;
        }
        return false; // Task not found
    }

    // Method to find the longest task
    public String findLongestTask() {
        String longestTask = "";
        for (String task : tasksArray) {
            if (task.length() > longestTask.length()) {
                longestTask = task;
            }
        }
        return longestTask;
    }

    // Method to retrieve a task by index
    public String getTaskByIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= tasksArray.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return tasksArray.get(index);
    }

    // Display tasks
    public void displayTasks() {
        System.out.println("Tasks (ArrayList): " + tasksArray);
        System.out.println("Tasks (LinkedList): " + tasksList);
    }
}
