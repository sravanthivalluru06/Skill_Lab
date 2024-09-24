class TaskManagementSystem {
    private List<String> tasks;

    public TaskManagementSystem() {
        tasks = new ArrayList<>();
    }
    public void addTask(String task) {
        tasks.add(task);
    }
    public void updateTask(int index, String newDescription) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newDescription);
        } else {
            System.out.println("Invalid task index.");
        }
    }
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }
    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        system.addTask("Complete homework");
        system.addTask("Buy groceries");
        system.addTask("Call the plumber");

        System.out.println("Tasks:");
        system.displayTasks();

        system.updateTask(1, "Buy groceries and cook dinner");
        system.removeTask(0);

        System.out.println("\nUpdated Tasks:");
        system.displayTasks();
    }
}
import java.util.ArrayList;
import java.util.List;

public class ToDoListApplication {
    private List<String> tasks;

    public ToDoListApplication() {
        tasks = new ArrayList<>();
    }
    public void addTask(String task) {
        tasks.add(task);
    }
    public void updateTask(int index, String newDescription) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newDescription);
        } else {
            System.out.println("Invalid task index.");
        }
    }
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }
    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        ToDoListApplication toDoList = new ToDoListApplication();
        toDoList.addTask("Finish project report");
        toDoList.addTask("Prepare presentation");
        toDoList.addTask("Send emails");

        System.out.println("To-Do List:");
        toDoList.displayTasks();

        toDoList.updateTask(0, "Finish project report and send it");
        toDoList.removeTask(1);

        System.out.println("\nUpdated To-Do List:");
        toDoList.displayTasks();
    }
}
import java.util.LinkedList;
import java.util.Queue;

public class CustomerSupportTicketSystem {
    private Queue<String> tickets;

    public CustomerSupportTicketSystem() {
        tickets = new LinkedList<>();
    }
    public void addTicket(String ticket) {
        tickets.add(ticket);
    }
    public String processTicket() {
        return tickets.poll(); 
    }
    public void displayTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            for (String ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

    public static void main(String[] args) {
        CustomerSupportTicketSystem system = new CustomerSupportTicketSystem();
        system.addTicket("Issue with login");
        system.addTicket("Payment not processed");
        system.addTicket("Account locked");

        System.out.println("Pending Tickets:");
        system.displayTickets();

        System.out.println("\nProcessing Ticket: " + system.processTicket());

        System.out.println("\nRemaining Tickets:");
        system.displayTickets();
    }
}
import java.util.ArrayDeque;
import java.util.Deque;

public class BrowsingHistory {
    private Deque<String> history;
    private String currentPage;

    public BrowsingHistory() {
        history = new ArrayDeque<>();
        currentPage = null;
    }
    public void visitPage(String page) {
        if (currentPage != null) {
            history.push(currentPage);
        }
        currentPage = page;
    }
    public String goBack() {
        if (history.isEmpty()) {
            return "No previous page.";
        }
        currentPage = history.pop();
        return currentPage;
    }
    public String goForward(String page) {
        visitPage(page);
        return currentPage;
    }
    public String getCurrentPage() {
        return currentPage != null ? currentPage : "No page visited.";
    }

    public static void main(String[] args) {
        BrowsingHistory browser = new BrowsingHistory();
        browser.visitPage("home.html");
        browser.visitPage("about.html");
        browser.visitPage("contact.html");

        System.out.println("Current Page: " + browser.getCurrentPage());
        System.out.println("Going Back: " + browser.goBack());
        System.out.println("Current Page: " + browser.getCurrentPage());
        System.out.println("Going Back: " + browser.goBack());
        System.out.println("Current Page: " + browser.getCurrentPage());
    }
}
import java.util.LinkedList;

public class MusicPlaylist {
    private LinkedList<String> playlist;

    public MusicPlaylist() {
        playlist = new LinkedList<>();
    }
    public void addSong(String song) {
        playlist.add(song);
    }
    public void removeSong(String song) {
        playlist.remove(song);
    }
    public void moveSong(String song, int newPosition) {
        if (playlist.remove(song)) {
            if (newPosition < 0 || newPosition >= playlist.size()) {
                playlist.addLast(song);
            } else {
                playlist.add(newPosition, song);
            }
        }
    }
    public void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }

    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        playlist.addSong("Song C");

        System.out.println("Initial Playlist:");
        playlist.displayPlaylist();

        playlist.moveSong("Song C", 0);
        playlist.removeSong("Song B");

        System.out.println("\nUpdated Playlist:");
        playlist.displayPlaylist();
    }
}
