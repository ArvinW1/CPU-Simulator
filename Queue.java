import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This is the queue class. It will create a queue through the utilization of a linked list
 * @param <T> Generic variable
 * Author: Arvin Wang
 */
public class Queue<T> {

    /**
     * The Linked list is used to store that element of the queue
     */
    protected LinkedList<T> list;

    /**
     * The constructor of the class
     */
    public Queue() {
        list = new LinkedList<>();
    }

    /**
     * This method adds an element to the end of the queue
     * @param element Any generic element
     */
    public void enqueue(T element) {
            list.addLast(element);
    }

    /**
     * This method removes the first element of the queue
     * @return the removed element (generic)
     */
    public T dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeFirst();
    }

    /**
     * This method checks if the queue is empty
     * @return true or false depending on if the list is empty (boolean)
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * This method return the first element in the queue
     * @return the first element in the queue (generic)
     */
    public T peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return list.getFirst();
    }

    /**
     * This method will return the first size of the queue
     * @return the size of the queue (int)
     */
    public int length() {
        return list.size();
    }

}