class Consumer extends Thread {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        try {
            for (int i = 0; i < 10; i++) { 
                buffer.take();
                Thread.sleep((int) (Math.random() * 1000)); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
class MessagingApp {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5); 

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
class Producer extends Thread {
    private final SharedBuffer buffer;
    private final Random random = new Random();

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        try {
            for (int i = 0; i < 10; i++) { 
                String message = "Message " + i;
                buffer.put(message);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
class SharedBuffer {
    private final Queue<String> buffer;
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.buffer = new LinkedList<>();
        this.capacity = capacity;
    }
    public synchronized void put(String message) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait(); 
        }
        buffer.add(message);
        System.out.println("Produced: " + message);
        notifyAll(); 
    }
    public synchronized String take() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); 
        }
        String message = buffer.poll();
        System.out.println("Consumed: " + message);
        notifyAll(); 
        return message;
    }
}
