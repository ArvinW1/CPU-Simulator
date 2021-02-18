import java.util.EmptyStackException;

/**
 * This class keep track of the minimum of the stack with the implementation of the stack class.
 * @param <T> A Generic Variable
 * Author: Arvin Wang
 */
public class MinStack<T extends Comparable<T>> extends Stack<T> {

    /**
     * This stack keeps track of all the minimums in the other stack
     */
    private Stack<T> minimums;// keeps track of all the minimums in the stack
    /**
     * A normal stack
     */
    private Stack<T> newStack;

    public MinStack() {
        // TODO
        // set up empty min
        minimums = new Stack();
        newStack = new Stack();
    }

    /**
     * Accessor Method to get the minimum of the stack
     * @return the minimum of the stack (Generic)
     */
    public T getMin() {
        // TODO
        // return the minimum element of the stack in O(1) time
        if(minimums.isEmpty()){
            throw new EmptyStackException();
        }
        return minimums.peek();
    }

    /**
     * This method adds an element to the the top of the stack and check if the new
     * element is smaller than the previous minimum
     * @param element Any generic element
     */
    public void push(T element){
        if(minimums.isEmpty()){
            minimums.push(element);
        }else if(minimums.peek().compareTo(element) >= 0){
            minimums.push(element);
        }
        newStack.push(element);
    }

    /**
     * This method remove the element on the top of the stack
     * This method also checks if the minimum of the stack is removed
     * if it is then finds the next smallest value of the stack
     * @return the removed element (generic)
     */
    public T pop(){
        if(newStack.isEmpty()){
            throw new EmptyStackException();
        }
        else if(newStack.peek().equals(minimums.peek())){
            minimums.pop();
        }
        return newStack.pop();
    }
}