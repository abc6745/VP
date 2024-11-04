import java.util.Scanner;

class PriorityScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int numProcesses = sc.nextInt();

        int[] bt = new int[numProcesses];     
        int[] priority = new int[numProcesses]; 
        int[] wt = new int[numProcesses];     
        int[] tat = new int[numProcesses];    

        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter the burst time for process " + (i + 1) + ": ");
            bt[i] = sc.nextInt();
            System.out.print("Enter the priority for process " + (i + 1) + ": ");
            priority[i] = sc.nextInt();
        }

        for (int i = 0; i < numProcesses - 1; i++) {
            for (int j = i + 1; j < numProcesses; j++) {
                if (priority[i] > priority[j]) { 
                    int tempPriority = priority[i];
                    priority[i] = priority[j];
                    priority[j] = tempPriority;

                    int tempBT = bt[i];
                    bt[i] = bt[j];
                    bt[j] = tempBT;
                }
            }
        }

        wt[0] = 0;

        for (int i = 1; i < numProcesses; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        for (int i = 0; i < numProcesses; i++) {
            tat[i] = wt[i] + bt[i];
        }

        System.out.println("\nOUTPUT");
        System.out.println("Process  Priority  Burst Time  Waiting Time  Turnaround Time");

        int totalWT = 0;
        int totalTAT = 0;

        for (int i = 0; i < numProcesses; i++) {
            System.out.println((i + 1) + "        " + priority[i] + "         " + bt[i] + "           " + wt[i] + "             " + tat[i]);
            totalWT += wt[i];
            totalTAT += tat[i];
        }

        float avgWT = (float) totalWT / numProcesses;
        float avgTAT = (float) totalTAT / numProcesses;

        System.out.println("\nTotal Turnaround Time = " + totalTAT);
        System.out.println("Average Waiting Time = " + avgWT);
        System.out.println("Average Turnaround Time = " + avgTAT);

        sc.close();
    }
}
