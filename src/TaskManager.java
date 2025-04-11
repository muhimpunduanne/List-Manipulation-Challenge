import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


class InvalidTaskException extends Exception {
    public InvalidTaskException(String message) {
        super(message);
    }
}

public class TaskManager {
    private ArrayList<String> tasksArray;
    private LinkedList<String> tasksList;


    public TaskManager() {
        tasksArray = new ArrayList<>();
        tasksList = new LinkedList<>();
    }


    public void addTask(String task) throws InvalidTaskException {
        if (task == null || task.trim().isEmpty()) {
            throw new InvalidTaskException("Task cannot be empty or null!");
        }
        tasksArray.add(task);
        tasksList.add(task);
    }


    public void sortTasks() {
        Collections.sort(tasksArray);
        Collections.sort(tasksList);
    }


    public int searchTask(String task) {
        if (tasksArray.contains(task)) {
            return tasksArray.indexOf(task);
        }
        return -1;
    }


    public boolean removeTask(String task) {
        if (tasksArray.contains(task)) {
            tasksArray.remove(task);
            tasksList.remove(task);
            return true;
        }
        return false; // Task not found
    }


    public String findLongestTask() {
        String longestTask = "";
        for (String task : tasksArray) {
            if (task.length() > longestTask.length()) {
                longestTask = task;
            }
        }
        return longestTask;
    }

    public String getTaskByIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= tasksArray.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return tasksArray.get(index);
    }


    public void displayTasks() {
        System.out.println("Tasks (ArrayList): " + tasksArray);
        System.out.println("Tasks (LinkedList): " + tasksList);
    }
}
