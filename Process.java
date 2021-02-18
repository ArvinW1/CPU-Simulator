/**
 * This is a process class that creates a new process
 * Author: Arvin Wang
 */
public class Process {

    private String newProcess;
    private int processSize;
    // Keeps track of how much work is done
    private int counter;

    /**
     * The constructor of the class
     * @param s The name of the process
     * @param size The size of the processor
     */
    public Process(String s, int size) {
        newProcess = s;
        processSize = size;
    }

    /**
     * This method increments counter to keep track of the work done
     */
    public void doWork() {
            counter++;
    }

    /**
     * An accessor method to get the size of the processor
     * @return the size of the process
     */
    public int getProcessSize(){
        return processSize;
    }

    /**
     * An accessor method to get the name of the processor
     * @return the name of the process
     */
    public String getName(){
        return newProcess;
    }

    /**
     * An accessor method to get the counter
     * @return the counter or the work done on the process
     */
    public int getCounter(){
        return counter;
    }

}