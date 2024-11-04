import java.util.Scanner;

class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int numProcesses = sc.nextInt();

        int[] bt = new int[numProcesses];   // Burst Time
        int[] wt = new int[numProcesses];   // Waiting Time
        int[] tat = new int[numProcesses];  // Turnaround Time

        // Input burst time for each process
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter the burst time for process " + (i + 1) + ": ");
            bt[i] = sc.nextInt();
        }

        // Sort burst times (Selection Sort) without process IDs
        for (int i = 0; i < numProcesses - 1; i++) {
            for (int j = i + 1; j < numProcesses; j++) {
                if (bt[i] > bt[j]) {
                    // Swap burst times
                    int tempBT = bt[i];
                    bt[i] = bt[j];
                    bt[j] = tempBT;
                }
            }
        }

        // First process has no waiting time
        wt[0] = 0;

        // Calculate waiting time for each process
        for (int i = 1; i < numProcesses; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        // Calculate turnaround time for each process
        for (int i = 0; i < numProcesses; i++) {
            tat[i] = wt[i] + bt[i];
        }

        System.out.println("\nOUTPUT");
        System.out.println("Process  Burst Time  Waiting Time  Turnaround Time");

        int totalWT = 0;
        int totalTAT = 0;

        // Display the results and calculate total waiting and turnaround times
        for (int i = 0; i < numProcesses; i++) {
            System.out.println((i + 1) + "        " + bt[i] + "           " + wt[i] + "             " + tat[i]);
            totalWT += wt[i];
            totalTAT += tat[i];
        }

        // Calculate average waiting time and turnaround time
        float avgWT = (float) totalWT / numProcesses;
        float avgTAT = (float) totalTAT / numProcesses;

        System.out.println("\nTotal Turnaround Time = " + totalTAT);
        System.out.println("Average Waiting Time = " + avgWT);
        System.out.println("Average Turnaround Time = " + avgTAT);

        sc.close();
    }
}
