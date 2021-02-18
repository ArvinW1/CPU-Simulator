import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * This is a stack class. It will create a stack through the utilization of a linked list.
 * @param <T> Generic variable
 * Author: Arvin Wang
 */
public class Stack<T> {

    /**
     * The linked list is use to store the element of the stack
     */
    protected LinkedList<T> list;

    /**
     * The constructor of the stack class
     */
    public Stack() {
        list = new LinkedList<T>();
    }

    /**
     *This method adds an element to the top of the stack
     * @param element Any generic element
     */
    public void push(T element) {
        list.addLast(element);
    }

    /**
     * This method removes the top element of the stack
     * @return the removed element (Generic)
     */
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return list.removeLast(); // returns the removed element
    }

    /**
     * This method looks at the element on the top of the stack
     * @return The element on top of the stack (generic)
     */
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return list.getLast(); // returns the element on top
    }

    /**
     * This method checks if the stack is empty
     * @return true or false depending on if the stack if empty (boolean)
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * This method looks for the size of the stack
     * @return the size of the stack
     */
    public int length() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.getLast().toString();
    }
}