//// Java program for implementation of RR scheduling
//
//public class RR
//{
//    // Method to find the waiting time for all
//    // processes
//    static void findWaitingTime(int processes[], int n,
//                                int bt[], int wt[], int quantum)
//    {
//        // Make a copy of burst times bt[] to store remaining
//        // burst times.
//        int rem_bt[] = new int[n];
//        for (int i = 0 ; i < n ; i++)
//            rem_bt[i] =  bt[i];
//
//        int t = 0; // Current time
//
//        // Keep traversing processes in round robin manner
//        // until all of them are not done.
//        while(true)
//        {
//            boolean done = true;
//
//            // Traverse all processes one by one repeatedly
//            for (int i = 0 ; i < n; i++)
//            {
//                // If burst time of a process is greater than 0
//                // then only need to process further
//                if (rem_bt[i] > 0)
//                {
//                    done = false; // There is a pending process
//
//                    if (rem_bt[i] > quantum)
//                    {
//                        // Increase the value of t i.e. shows
//                        // how much time a process has been processed
//                        t += quantum;
//
//                        // Decrease the burst_time of current process
//                        // by quantum
//                        rem_bt[i] -= quantum;
//                    }
//
//                    // If burst time is smaller than or equal to
//                    // quantum. Last cycle for this process
//                    else
//                    {
//                        // Increase the value of t i.e. shows
//                        // how much time a process has been processed
//                        t = t + rem_bt[i];
//
//                        // Waiting time is current time minus time
//                        // used by this process
//                        wt[i] = t - bt[i];
//
//                        // As the process gets fully executed
//                        // make its remaining burst time = 0
//                        rem_bt[i] = 0;
//                    }
//                }
//            }
//
//            // If all processes are done
//            if (done == true)
//                break;
//        }
//    }
//
//    // Method to calculate turn around time
//    static void findTurnAroundTime(int processes[], int n,
//                                   int bt[], int wt[], int tat[])
//    {
//        // calculating turnaround time by adding
//        // bt[i] + wt[i]
//        for (int i = 0; i < n ; i++)
//            tat[i] = bt[i] + wt[i];
//    }
//
//    // Method to calculate average time
//    static void findavgTime(int processes[], int n, int bt[],
//                            int quantum)
//    {
//        int wt[] = new int[n], tat[] = new int[n];
//        int total_wt = 0, total_tat = 0;
//
//        // Function to find waiting time of all processes
//        findWaitingTime(processes, n, bt, wt, quantum);
//
//        // Function to find turn around time for all processes
//        findTurnAroundTime(processes, n, bt, wt, tat);
//
//        // Display processes along with all details
//        System.out.println("Processes " + " Burst time " +
//                " Waiting time " + " Turn around time");
//
//        // Calculate total waiting time and total turn
//        // around time
//        for (int i=0; i<n; i++)
//        {
//            total_wt = total_wt + wt[i];
//            total_tat = total_tat + tat[i];
//            System.out.println(" " + (i+1) + "\t\t" + bt[i] +"\t " +
//                    wt[i] +"\t\t " + tat[i]);
//        }
//
//        System.out.println("Average waiting time = " +
//                (float)total_wt / (float)n);
//        System.out.println("Average turn around time = " +
//                (float)total_tat / (float)n);
//    }
//
//    // Driver Method
//    public static void main(String[] args)
//    {
//        // process id's
//        int processes[] = { 1, 2, 3,4,5};
//        int n = processes.length;
//
//        // Burst time of all processes
//        int burst_time[] = {5,9,7,2,4};
//
//        // Time quantum
//        int quantum = 2;
//        findavgTime(processes, n, burst_time, quantum);
//    }
//}



//--------------------------------------------------------------------------------------------------

//JAVA Program for implementing
//Round Robin Algorithm
// code by Sparsh_cbs
import java.util.*;

class RoundRobin{
    private static Scanner inp = new Scanner(System.in);
    //Driver Code
    public static void main(String[] args){
        int n,tq, timer = 0, maxProccessIndex = 0;
        float avgWait = 0, avgTT = 0;
        System.out.print("\nEnter value of  time quantum :->  ");
        tq = inp.nextInt();
        System.out.print("\nEnter Total number of processess :->  ");
        n = inp.nextInt();
        int arrival[] = new int[n];
        int burst[] = new int[n];
        int wait[] = new int[n];
        int turn[] = new int[n];
        int queue[] = new int[n];
        int temp_burst[] = new int[n];
        boolean complete[] = new boolean[n];

        System.out.print("\nEnter the arrival time of the processess :->  ");
        for(int i = 0; i < n; i++)
            arrival[i] = inp.nextInt();

        System.out.print("\nEnter the burst time of the processess :->  ");
        for(int i = 0; i < n; i++){
            burst[i] = inp.nextInt();
            temp_burst[i] = burst[i];
        }

        for(int i = 0; i < n; i++){
            complete[i] = false;
            queue[i] = 0;
        }
        while(timer < arrival[0])
            timer++;
        queue[0] = 1;

        while(true){
            boolean flag = true;
            for(int i = 0; i < n; i++){
                if(temp_burst[i] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag)
                break;

            for(int i = 0; (i < n) && (queue[i] != 0); i++){
                int ctr = 0;
                while((ctr < tq) && (temp_burst[queue[0]-1] > 0)){
                    temp_burst[queue[0]-1] -= 1;
                    timer += 1;
                    ctr++;


                    checkNewArrival(timer, arrival, n, maxProccessIndex, queue);
                }
                if((temp_burst[queue[0]-1] == 0) && (complete[queue[0]-1] == false)){
                    turn[queue[0]-1] = timer;        //turn currently stores exit times
                    complete[queue[0]-1] = true;
                }


                boolean idle = true;
                if(queue[n-1] == 0){
                    for(int k = 0; k < n && queue[k] != 0; k++){
                        if(complete[queue[k]-1] == false){
                            idle = false;
                        }
                    }
                }
                else
                    idle = false;

                if(idle){
                    timer++;
                    checkNewArrival(timer, arrival, n, maxProccessIndex, queue);
                }


                queueMaintainence(queue,n);
            }
        }

        for(int i = 0; i < n; i++){
            turn[i] = turn[i] - arrival[i];
            wait[i] = turn[i] - burst[i];
        }

        System.out.print("\nProgram No.\tArrival Time\t  Burst Time \t  Wait Time \t  TurnAround Time"
                + "\n");
        for(int i = 0; i < n; i++){
            System.out.print(i+1+"\t\t\t\t"+arrival[i]+"\t\t\t\t"+burst[i]
                    +"\t\t\t\t"+wait[i]+"\t\t\t\t"+turn[i]+ "\n");
        }
        for(int i =0; i< n; i++){
            avgWait += wait[i];
            avgTT += turn[i];
        }
        System.out.print("\nAverage wait time : "+(avgWait/n)
                +"\nAverage Turn Around Time : "+(avgTT/n));
    }
    public static void queueUpdation(int queue[],int timer,int arrival[],int n, int maxProccessIndex){
        int zeroIndex = -1;
        for(int i = 0; i < n; i++){
            if(queue[i] == 0){
                zeroIndex = i;
                break;
            }
        }
        if(zeroIndex == -1)
            return;
        queue[zeroIndex] = maxProccessIndex + 1;
    }

    public static void checkNewArrival(int timer, int arrival[], int n, int maxProccessIndex,int queue[]){
        if(timer <= arrival[n-1]){
            boolean newArrival = false;
            for(int j = (maxProccessIndex+1); j < n; j++){
                if(arrival[j] <= timer){
                    if(maxProccessIndex < j){
                        maxProccessIndex = j;
                        newArrival = true;
                    }
                }
            }
            if(newArrival)    //adds the index of the arriving process(if any)
                queueUpdation(queue,timer,arrival,n, maxProccessIndex);
        }
    }

    public static void queueMaintainence(int queue[], int n){

        for(int i = 0; (i < n-1) && (queue[i+1] != 0) ; i++){
            int temp = queue[i];
            queue[i] = queue[i+1];
            queue[i+1] = temp;
        }
    }
}