import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerSupportSystem {
    private Queue<String> ticketQueue;
    public CustomerSupportSystem() {
        ticketQueue = new LinkedList<>();
    }
    public void addTicket(String ticket) {
        ticketQueue.add(ticket);
        System.out.println("Ticket added: " + ticket);
    }
    public void processNextTicket() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No tickets to process.");
        } else {
            String processedTicket = ticketQueue.poll();
            System.out.println("Processing ticket: " + processedTicket);
        }
    }
    public void displayPendingTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("Pending Tickets:");
            for (String ticket : ticketQueue) {
                System.out.println(ticket);
            }
        }
    }
    public static void main(String[] args) {
        CustomerSupportSystem supportSystem = new CustomerSupportSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCustomer Support Ticket System Menu:");
            System.out.println("1. Add Ticket");
            System.out.println("2. Process Next Ticket");
            System.out.println("3. Display All Pending Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter ticket description: ");
                    String ticket = scanner.nextLine();
                    supportSystem.addTicket(ticket);
                    break;

                case 2:
                    supportSystem.processNextTicket();
                    break;

                case 3:
                    supportSystem.displayPendingTickets();
                    break;

                case 4:
                    System.out.println("Exiting Customer Support Ticket System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
