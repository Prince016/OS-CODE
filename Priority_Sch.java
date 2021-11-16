//////
//////// Java implementation for Priority Scheduling with
////////Different Arrival Time priority scheduling
//////import java.util.*;
//////
///////// Data Structure
//////class Process {
//////    int at, bt, pri, pno;
//////    Process(int pno, int at, int bt, int pri)
//////    {
//////        this.pno = pno;
//////        this.pri = pri;
//////        this.at = at;
//////        this.bt = bt;
//////    }
//////}
//////
///////// Gantt chart structure
//////class GChart {
//////    // process number, start time, complete time,
//////    // turn around time, waiting time
//////    int pno, stime, ctime, wtime, ttime;
//////}
//////
//////// user define comparative method (first arrival first serve,
//////// if arrival time same then heigh priority first)
//////class MyComparator implements Comparator {
//////
//////    public int compare(Object o1, Object o2)
//////    {
//////
//////        Process p1 = (Process)o1;
//////        Process p2 = (Process)o2;
//////        if (p1.at < p2.at)
//////            return (-1);
//////
//////        else if (p1.at == p2.at && p1.pri > p2.pri)
//////            return (-1);
//////
//////        else
//////            return (1);
//////    }
//////}
//////
//////
//////// class to find Gantt chart
//////class FindGantChart {
//////    void findGc(LinkedList queue)
//////    {
//////
//////        // initial time = 0
//////        int time = 0;
//////
//////        // priority Queue sort data according
//////        // to arrival time or priority (ready queue)
//////        TreeSet prique = new TreeSet(new MyComparator());
//////
//////        // link list for store processes data
//////        LinkedList result = new LinkedList();
//////
//////        // process in ready queue from new state queue
//////        while (queue.size() > 0)
//////            prique.add((Process)queue.removeFirst());
//////
//////        Iterator it = prique.iterator();
//////
//////        // time set to according to first process
//////        time = ((Process)prique.first()).at;
//////
//////        // scheduling process
//////        while (it.hasNext()) {
//////
//////            // dispatcher dispatch the
//////            // process ready to running state
//////            Process obj = (Process)it.next();
//////
//////            GChart gc1 = new GChart();
//////            gc1.pno = obj.pno;
//////            gc1.stime = time;
//////            time += obj.bt;
//////            gc1.ctime = time;
//////            gc1.ttime = gc1.ctime - obj.at;
//////            gc1.wtime = gc1.ttime - obj.bt;
//////
//////            /// store the exxtreted process
//////            result.add(gc1);
//////        }
//////
//////
//////        // create object of output class and call method
//////        new ResultOutput(result);
//////    }
//////
//////    private class ResultOutput {
//////        public ResultOutput(LinkedList result) {
//////        }
//////    }
//////}
////
////
////
////
////import java.util.*;
////class priority
////{
////    public static void main(String args[])
////    {
////        Scanner in=new Scanner(System.in);//create a object to get the user input
////
////        System.out.println("Enter the number of process: ");//how many process you have to enter
////        int num=in.nextInt();
////
////        //assign one array to get the burst time for the each process
////
////
////        int B[]=new int[num];
////
////
////        for(int i=0;i<num;i++)
////        {
////            System.out.println("Enter the Burst time for "+(i+1)+": ");
////            B[i]=in.nextInt();
////        }
////
////        //assign another array to get the priority for the each process
////
////        int P[]=new int[num];
////
////        for(int i=0;i<num;i++)
////        {
////            System.out.println("Enter the Priority value time for "+(i+1)+": ");
////            P[i]=in.nextInt();
////        }
////
////        //here we considered as lower priority value as higher priority process
////
////        //assign one array to save the priority values again.
////        //because here we have to sorting (ascending) the first priority array to findout
////        //the process order to finish their tasks..
////
////        //after we will check the each sorting process to the original array to identify the
////        //process numer;;
////
////        int P1[]=new int[num];
////
////        //define the priority values there
////
////        for(int i=0;i<num;i++)
////        {
////            P1[i]=P[i];
////        }
////
////        //now sort the P array to order the process based on their priority value
////
////        //use bubble sorting
////
////        for(int i=0;i<num;i++)
////        {
////            for(int j=0;j<num-1;j++)
////            {
////                if(P[j]>P[j+1])
////                {
////                    int tem=P[j];
////                    P[j]=P[j+1];
////                    P[j+1]=tem;
////                }
////            }
////        }
////
////        //now check the sorting array and original array
////
////        //before assign some variables
////
////        //this is for adding the waiting in every step;
////
////        int wait=0;//initial value is 0;
////
////        //this is for store the waiting for each process
////
////        int wait_time[]=new int[num];
////
////        //this is for get the total waiting time for all processess
////
////        float total=0;
////
////        int k=0;
////
////        System.out.println("Process\t\tBurst time\twaiting time");
////
////        for(int i=0;i<num;i++)
////        {
////            for(int j=0;j<num;j++)
////            {
////                if(P[i]==P1[j])
////                {
////                    System.out.println("p"+(j+1)+"\t\t"+B[j]+"\t\t\t"+wait);
////                    wait_time[k]=wait;
////                    total+=wait;
////                    wait+=B[j];
////                }
////            }
////        }
////
////        System.out.println("The average waiting time is: "+(total/num));
////    }
////}
//
//
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//class Process {
//    int pid;
//    int bt;
//    int priority;
//
//    Process(int pid, int bt, int priority) {
//        this.pid = pid;
//        this.bt = bt;
//        this.priority = priority;
//    }
//
//    public int prior() {
//        return priority;
//    }
//}
//
//class PrioritySchedule {
//    public void findWaitingTime(Process proc[], int n, int wt[]) {
//
//        wt[0] = 0;
//
//        for (int i = 1; i < n; i++)
//            wt[i] = proc[i - 1].bt + wt[i - 1];
//    }
//
//    public void findTurnAroundTime(Process proc[], int n, int wt[], int tat[]) {
//
//        for (int i = 0; i < n; i++)
//            tat[i] = proc[i].bt + wt[i];
//    }
//
//    public void findavgTime(Process proc[], int n) {
//        int wt[] = new int[n], tat[] = new int[n], total_wt = 0, total_tat = 0;
//
//        findWaitingTime(proc, n, wt);
//
//        findTurnAroundTime(proc, n, wt, tat);
//
//        System.out.print("\nProcesses   Burst time   Waiting time   Turn around time   Priority\n");
//
//        for (int i = 0; i < n; i++) {
//            total_wt = total_wt + wt[i];
//            total_tat = total_tat + tat[i];
//            System.out.print("\t" + proc[i].pid + "\t\t\t" + proc[i].bt + "\t\t\t " + wt[i] + "\t\t\t\t\t" + tat[i] + "\t\t\t  "
//                    + proc[i].priority + "\n");
//        }
//
//        System.out.print("\nAverage waiting time = " + (float) total_wt / (float) n);
//        System.out.print("\nAverage turn around time = " + (float) total_tat / (float) n);
//    }
//
//    public void priorityScheduling(Process proc[], int n) {
//
//        Arrays.sort(proc, new Comparator<Process>() {
//            @Override
//            public int compare(Process a, Process b) {
//                return b.prior() - a.prior();
//            }
//        });
//        System.out.print("Order in which processes gets executed \n");
//        for (int i = 0; i < n; i++)
//            System.out.print(proc[i].pid + " ");
//
//        findavgTime(proc, n);
//    }
//
//    public static void main(String[] args) {
//        PrioritySchedule ob = new PrioritySchedule();
//        int n = 3;
//        Process proc[] = new Process[n];
//        proc[0] = new Process(1, 10, 2);
//        proc[1] = new Process(2, 5, 0);
//        proc[2] = new Process(3, 8, 1);
//        System.out.print("Non-Preemptive Priority Scheduling\n");
//        ob.priorityScheduling(proc, n);
//    }
//}


import java.util.*;
class priority
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);//create a object to get the user input

        System.out.println("Enter the number of process: ");//how many process you have to enter
        int num=in.nextInt();

        //assign one array to get the burst time for the each process


        int B[]=new int[num];


        for(int i=0;i<num;i++)
        {
            System.out.println("Enter the Burst time for "+(i+1)+": ");
            B[i]=in.nextInt();
        }

        //assign another array to get the priority for the each process

        int P[]=new int[num];

        for(int i=0;i<num;i++)
        {
            System.out.println("Enter the Priority value time for "+(i+1)+": ");
            P[i]=in.nextInt();
        }

        //here we considered as lower priority value as higher priority process

        //assign one array to save the priority values again.
        //because here we have to sorting (ascending) the first priority array to findout
        //the process order to finish their tasks..

        //after we will check the each sorting process to the original array to identify the
        //process numer;;

        int P1[]=new int[num];

        //define the priority values there

        for(int i=0;i<num;i++)
        {
            P1[i]=P[i];
        }

        //now sort the P array to order the process based on their priority value

        //use bubble sorting

        for(int i=0;i<num;i++)
        {
            for(int j=0;j<num-1;j++)
            {
                if(P[j]>P[j+1])
                {
                    int tem=P[j];
                    P[j]=P[j+1];
                    P[j+1]=tem;
                }
            }
        }

        //now check the sorting array and original array

        //before assign some variables

        //this is for adding the waiting in every step;

        int wait=0;//initial value is 0;

        //this is for store the waiting for each process

        int wait_time[]=new int[num];

        //this is for get the total waiting time for all processess

        float total=0;

        int k=0;

        System.out.println("Process\t\tBurst time\twaiting time");

        for(int i=0;i<num;i++)
        {
            for(int j=0;j<num;j++)
            {
                if(P[i]==P1[j])
                {
                    System.out.println("p"+(j+1)+"\t\t\t"+B[j]+"\t\t\t\t"+wait);
                    wait_time[k]=wait;
                    total+=wait;
                    wait+=B[j];
                }
            }
        }

        System.out.println("The average waiting time is: "+(total/num));
    }
}