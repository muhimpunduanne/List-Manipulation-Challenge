 //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
 public class Main {
     public static void main(String[] args) {
         TaskManager manager = new TaskManager();

         try {
             // Test valid input: Adding tasks
             manager.addTask("Complete homework");
             manager.addTask("Go shopping");
             manager.addTask("Attend meeting");

             // Test invalid input: Adding empty task
             manager.addTask(""); // This will throw an exception
         } catch (InvalidTaskException e) {
             System.out.println("Error: " + e.getMessage());
         } finally {
             System.out.println("Operation logged: Adding tasks.");
         }

         // Display tasks
         manager.displayTasks();

         // Sort tasks
         System.out.println("Sorting tasks...");
         manager.sortTasks();
         manager.displayTasks();

         // Search for a specific task
         String search = "Go shopping";
         int index = manager.searchTask(search);
         if (index != -1) {
             System.out.println("Task found at index: " + index);
         } else {
             System.out.println("Task not found: " + search);
         }

         // Remove a task
         System.out.println("Removing task: Go shopping");
         if (manager.removeTask(search)) {
             System.out.println("Task removed successfully.");
         } else {
             System.out.println("Task not found.");
         }
         manager.displayTasks();

         // Find the longest task
         System.out.println("Longest task: " + manager.findLongestTask());

         // Retrieve a task by index
         try {
             System.out.println("Task at index 1: " + manager.getTaskByIndex(1));
             System.out.println("Task at index 10: " + manager.getTaskByIndex(10)); // Invalid index
         } catch (IndexOutOfBoundsException e) {
             System.out.println("Error: " + e.getMessage());
         } finally {
             System.out.println("Operation logged: Retrieving task by index.");
         }
     }
 }
