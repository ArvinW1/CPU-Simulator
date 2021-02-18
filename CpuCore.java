/**
 * The CpuCore class that makes an cpuCore and makes it work on process
 * Author: Arvin Wang
 */
public class CpuCore {

    //ID of the Core
    private int coreID;
    // Keeps track of the run time to finish a process
    private int time;
    // Keeps track of the total Runtime of the core
    private int totalProcessTime;
    // Keeps track of the productive steps
    private int productivity;
    // Maximum number of steps working on the same process
    private int cutOff;
    // Keep track of how many times the process has been worked
    private int cutOffTracker;
    // Current Process it's working on
    private Process currentProcess;

    /**
     * The constructor class
     * @param name The name of the core as a number
     * @param cut Tells the cpu the maximum number of steps on the same process
     */
    public CpuCore(int name, int cut) {
        coreID = name;
        currentProcess = null;
        cutOff = cut;
        cutOffTracker = 0;
        time = 0;
        totalProcessTime = 0;
        productivity = 0;
    }

    /**
     * This method is what calls the core to do work and keeps track of the time
     * @param P an process
     */
    public void step(Queue<Process> P) {
        time++;
        if(currentProcess == null){ // No process
            claimProcess(P);
        } // maximum number of steps working on the same process met
        else if (cutOffTracker == cutOff) {
            P.enqueue(currentProcess);
            currentProcess = null;
            cutOffTracker = 0;
        } else{ // Core working on the process
            cutOffTracker++;
            productivity++;
            doWork();
        }
    }

    /**
     * This method makes the core to pick up an process
     * @param P An process
     */
    private void claimProcess(Queue<Process> P) {
        if(!P.isEmpty()) {
            currentProcess = P.dequeue();
        }
    }

    /**
     * This method calls the doWork in the process class and print out the statement the process is finished
     */
    private void doWork() {
        currentProcess.doWork();
        if(currentProcess.getCounter() == currentProcess.getProcessSize()) { // Prints out the process
            System.out.println(coreID + " , " + currentProcess.getName() + " , " + time);
            currentProcess = null;
            cutOffTracker = 0;
            totalProcessTime += time;
        }
    }

    /**
     * Accessor Method
     * @return the realTime
     */
    public int getTime(){
        return time;
    }

    /**
     * Accessor method
     * @return the current process (process)
     */
    public Process getcurrentProcess(){
        return currentProcess;
    }

    /**
     * Accessor method
     * @return the sum of time of all the time that the core
     * took to finish each process (int)
     */
    public int getTotalProcessTime(){
        return totalProcessTime;
    }

    /**
     * Accessor method
     * @return the total time that that work spent working on processes (int)
     */
    public int getProductivity(){
        return productivity;
    }

}