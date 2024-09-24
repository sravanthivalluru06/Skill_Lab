class TaskManagementSystem {
    private ArrayList<String> taskList;
    public TaskManagementSystem() {
        taskList = new ArrayList<>();
    }
    public void addTask(String task) {
        taskList.add(task);
        System.out.println("Task added: " + task);
    }
    public void updateTask(int position, String newTaskDescription) {
        if (position >= 0 && position < taskList.size()) {
            taskList.set(position, newTaskDescription);
            System.out.println("Task updated at position " + position + ": " + newTaskDescription);
        } else {
            System.out.println("Invalid position!");
        }
    }

    public void removeTask(int position) {
        if (position >= 0 && position < taskList.size()) {
            String removedTask = taskList.remove(position);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid position!");
        }
    }

    public <taskList> void displayTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Task List:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        }
    }
    public static void main(String[] args) {
        TaskManagementSystem taskSystem = new TaskManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask Management System Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    taskSystem.addTask(task);
                    break;

                case 2:
                    System.out.print("Enter task position to update: ");
                    int updatePosition = scanner.nextInt() - 1;  // Convert to zero-index
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new task description: ");
                    String newDescription = scanner.nextLine();
                    taskSystem.updateTask(updatePosition, newDescription);
                    break;

                case 3:
                    System.out.print("Enter task position to remove: ");
                    int removePosition = scanner.nextInt() - 1;  // Convert to zero-index
                    taskSystem.removeTask(removePosition);
                    break;

                case 4:
                    taskSystem.displayTasks();
                    break;

                case 5:
                    System.out.println("Exiting Task Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
