import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is a simulator of how a normal cpu would do work
 * Author: Arvin Wang
 */
public class CpuSimulator {
    private CpuCore[] cores;
    private Queue<Process> processQueue;

    /**
     * the constructor of the class
     * @param numCores the number of cores needed
     * @param cutoff The number that a core gets to work on a process before it goes back in the queue
     * @param pq The queue of process
     */
    public CpuSimulator(int numCores, int cutoff, Queue<Process> pq) {
        processQueue = pq;
        cores = new CpuCore[numCores];
        for(int i = 0; i < numCores; i++){
            CpuCore newCore = new CpuCore(i, cutoff);
            cores[i] = newCore;
        }
    }

    /**
     * This method runs the simulator
     */
    public void run() {
        while(!processQueue.isEmpty() || !coreIsEmpty()){
            for(int i = 0; i < cores.length; i++){
                cores[i].step(processQueue);
            }
        }
    }

    /**
     * This method checks if each core is still holding a process
     * @return true or false (boolean)
     */
    private boolean coreIsEmpty(){
        for(int i = 0; i < cores.length; i++){
            if(cores[i].getcurrentProcess() != null){
                return false;
            }
        }
        return true;
    }

    /**
     * This calculates the average runtime to complete all the process
     * @param totalProcessor the number of processes there is
     * @return the average runtime to complete the processes
     */
    public double avgTurnaroundtime(int totalProcessor){
        double coreTime = 0;
        for(int i = 0; i < cores.length; i++){
            coreTime += cores[i].getTotalProcessTime();
        }
        return coreTime/totalProcessor;
    }

    /**
     * This is a accessor method that tell us how efficiently we are using the CPU resources.
     * @return the utilization of the cores (double)
     */
    public double getUtilization(){
        double totalProductivity = 0; // The total productive steps
        double cpuTime = cores.length*cores[0].getTime();
        for(int i = 0; i < cores.length; i++){
            totalProductivity += cores[i].getProductivity();
        }
        return totalProductivity/cpuTime;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int temp = 0;
        Queue<Process> newQueue = new Queue<>();
        System.out.println("Please input the # of processes");
        int numProcessor = input.nextInt();
        if(numProcessor < 0){
            throw new NoSuchElementException();
        }
        System.out.println("Please input the # of cores");
        int numCores = input.nextInt();
        if(numCores <= 0){
            throw new NoSuchElementException();
        }
        System.out.println("Please input the cutoff");
        int numCutOff = input.nextInt();
        if(numCutOff <= 0){
            throw new NoSuchElementException();
        }
        while(temp < numProcessor){
            System.out.println("Input the process ID followed by a \",\" then the process size");
            String s = input.next();
            newQueue.enqueue(new Process(s.substring(0, s.indexOf(",")), Integer.parseInt(s.substring(s.indexOf(",")+1))));
            temp++;
        }
        if(numProcessor > 0) {
            CpuSimulator newSimulator = new CpuSimulator(numCores, numCutOff, newQueue);
            newSimulator.run();
            System.out.println(newSimulator.avgTurnaroundtime(numProcessor));
            System.out.println(newSimulator.getUtilization());
        }
    }
}
