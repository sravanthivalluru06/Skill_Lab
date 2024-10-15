public interface GenericStack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}
import java.util.LinkedList;

public class LinkedListStack<T> implements GenericStack<T> {
    private LinkedList<T> list = new LinkedList<>();
    public void push(T item) {
        list.addFirst(item);
    }
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.removeFirst();
    }
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.getFirst();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
public class ArrayStack<T> implements GenericStack<T> {
    private Object[] array;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public ArrayStack() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }
    public void push(T item) {
        if (size == array.length) {
            resize();
        }
        array[size++] = item;
    }
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T item = (T) array[--size];
        array[size] = null; 
        return item;
    }
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return (T) array[size - 1];
    }
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
public class StackTest {
    public static void main(String[] args) {
        System.out.println("Testing LinkedListStack:");
        GenericStack<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(10);
        linkedListStack.push(20);
        System.out.println("Peek: " + linkedListStack.peek()); 
        System.out.println("Pop: " + linkedListStack.pop());   
        System.out.println("Peek after pop: " + linkedListStack.peek()); 
        System.out.println("Is empty: " + linkedListStack.isEmpty());    
        linkedListStack.pop();
        System.out.println("\nTesting ArrayStack:");
        GenericStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("Hello");
        arrayStack.push("World");
        System.out.println("Peek: " + arrayStack.peek()); 
        System.out.println("Pop: " + arrayStack.pop());   
        System.out.println("Peek after pop: " + arrayStack.peek()); 
        System.out.println("Is empty: " + arrayStack.isEmpty());    
        arrayStack.pop();
        System.out.println("Is empty after popping all: " + arrayStack.isEmpty()); 
    }
}
