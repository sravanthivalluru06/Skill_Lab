import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListApp {
    private List<String> taskList;
    public ToDoListApp() {
        taskList = new ArrayList<>();
    }
    public void addTask(String task) {
        taskList.add(task);
        System.out.println("Task added: " + task);
    }
    public void updateTask(int index, String newTaskDescription) {
        if (index >= 0 && index < taskList.size()) {
            taskList.set(index, newTaskDescription);
            System.out.println("Task updated at index " + index + ": " + newTaskDescription);
        } else {
            System.out.println("Invalid index!");
        }
    }
    public void removeTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            String removedTask = taskList.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void displayTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        }
    }
    public static void main(String[] args) {
        ToDoListApp toDoListApp = new ToDoListApp();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    toDoListApp.addTask(task);
                    break;

                case 2:
                    System.out.print("Enter task index to update: ");
                    int updateIndex = scanner.nextInt() - 1;  
                    scanner.nextLine();  
                    System.out.print("Enter new task description: ");
                    String newDescription = scanner.nextLine();
                    toDoListApp.updateTask(updateIndex, newDescription);
                    break;

                case 3:
                    System.out.print("Enter task index to remove: ");
                    int removeIndex = scanner.nextInt() - 1;  
                    toDoListApp.removeTask(removeIndex);
                    break;

                case 4:
                    toDoListApp.displayTasks();
                    break;

                case 5:
                    System.out.println("Exiting To-Do List Application.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
