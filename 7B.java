import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class GenericPriorityQueue {
    private List<T> heap;
    private Comparator<? super T> comparator;

    public GenericPriorityQueue(Comparator<? super T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public void add(T element) {
        heap.add(element);
        siftUp(heap.size() - 1);
    }

    public T remove() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        T result = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            siftDown(0);
        }
        return result;
    }

    public T peek() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void siftUp(int index) {
        T element = heap.get(index);
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T parent = heap.get(parentIndex);
            if (comparator.compare(element, parent) <= 0) {
                break;
            }
            heap.set(index, parent);
            index = parentIndex;
        }
        heap.set(index, element);
    }

    private void siftDown(int index) {
        T element = heap.get(index);
        int half = heap.size() / 2;
        while (index < half) {
            int childIndex = 2 * index + 1;
            T child = heap.get(childIndex);
            int rightIndex = childIndex + 1;
            if (rightIndex < heap.size() && comparator.compare(child, heap.get(rightIndex)) < 0) {
                childIndex = rightIndex;
                child = heap.get(childIndex);
            }
            if (comparator.compare(element, child) >= 0) {
                break;
            }
            heap.set(index, child);
            index = childIndex;
        }
        heap.set(index, element);
    }
}
import java.util.Comparator;

public class PriorityQueueTest {
    public static void main(String[] args) {
        System.out.println("Testing PriorityQueue with Integers:");
        GenericPriorityQueue<Integer> intQueue = new GenericPriorityQueue<>(Comparator.naturalOrder());
        intQueue.add(5);
        intQueue.add(1);
        intQueue.add(3);
        intQueue.add(7);
        
        while (!intQueue.isEmpty()) {
            System.out.println(intQueue.remove());
        }
        System.out.println("\nTesting PriorityQueue with Doubles:");
        GenericPriorityQueue<Double> doubleQueue = new GenericPriorityQueue<>(Comparator.naturalOrder());
        doubleQueue.add(3.14);
        doubleQueue.add(1.59);
        doubleQueue.add(2.65);
        doubleQueue.add(5.89);
        
        while (!doubleQueue.isEmpty()) {
            System.out.println(doubleQueue.remove());
        }
        System.out.println("\nTesting PriorityQueue with Strings:");
        GenericPriorityQueue<String> stringQueue = new GenericPriorityQueue<>(Comparator.naturalOrder());
        stringQueue.add("apple");
        stringQueue.add("banana");
        stringQueue.add("cherry");
        stringQueue.add("date");
        
        while (!stringQueue.isEmpty()) {
            System.out.println(stringQueue.remove());
        }
    }
}
