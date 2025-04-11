 //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
 public class Main {
     public static void main(String[] args) {
         TaskManager manager = new TaskManager();

         try {

             manager.addTask("Complete homework");
             manager.addTask("Go shopping");
             manager.addTask("Attend meeting");


             manager.addTask("");
         } catch (InvalidTaskException e) {
             System.out.println("Error: " + e.getMessage());
         } finally {
             System.out.println("Operation logged: Adding tasks.");
         }


         manager.displayTasks();


         System.out.println("Sorting tasks...");
         manager.sortTasks();
         manager.displayTasks();


         String search = "Go shopping";
         int index = manager.searchTask(search);
         if (index != -1) {
             System.out.println("Task found at index: " + index);
         } else {
             System.out.println("Task not found: " + search);
         }


         System.out.println("Removing task: Go shopping");
         if (manager.removeTask(search)) {
             System.out.println("Task removed successfully.");
         } else {
             System.out.println("Task not found.");
         }
         manager.displayTasks();


         System.out.println("Longest task: " + manager.findLongestTask());


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
