import java.util.LinkedList;
import java.util.Queue;

class BoundedBuffer {
    private final Queue<String> buffer;
    private final int capacity;

    public BoundedBuffer(int capacity) {
        this.buffer = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void put(String item) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait(); 
        }
        buffer.add(item);
        System.out.println("Produced: " + item);
        notifyAll(); 
    }

    public synchronized String take() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); 
        }
        String item = buffer.poll();
        System.out.println("Consumed: " + item);
        notifyAll(); 
        return item;
    }
}

class BoundedBufferApp {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer(10); 

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

class Consumer extends Thread {
    private final BoundedBuffer buffer;

    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        try {
            for (int i = 0; i < 20; i++) { 
                buffer.take();
                Thread.sleep((int) (Math.random() * 1000)); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
class Producer extends Thread {
    private final BoundedBuffer buffer;
    private final Random random = new Random();

    public Producer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 0; i < 20; i++) { 
                String item = "Item " + i;
                buffer.put(item);
                Thread.sleep(random.nextInt(500)); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}