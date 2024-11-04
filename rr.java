import java.util.Scanner;

public class rr {
    public static void main(String args[]) {
        int n, i, qt, count = 0, temp, sq = 0;
        int bt[], wt[], tat[], rem_bt[];
        float awt = 0, atat = 0;
        
        Scanner s = new Scanner(System.in);
        
        
        System.out.print("Enter the number of processes (maximum 10) = ");
        n = s.nextInt();
        
        
        bt = new int[n];
        wt = new int[n];
        tat = new int[n];
        rem_bt = new int[n];
        
        
        System.out.print("Enter the burst time of the processes:\n");
        for (i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + " = ");
            bt[i] = s.nextInt();
            rem_bt[i] = bt[i]; 
        }
        
        
        System.out.print("Enter the quantum time: ");
        qt = s.nextInt();
        
        
        while (true) {
            for (i = 0, count = 0; i < n; i++) {
                temp = qt;
                
                if (rem_bt[i] == 0) {
                    count++; 
                    continue;
                }
                
                if (rem_bt[i] > qt) {
                    rem_bt[i] -= qt; 
                } else {
                    temp = rem_bt[i]; 
                    rem_bt[i] = 0;    
                }
                
                sq += temp;       
                tat[i] = sq;     
            }
            
            if (n == count) {
                
                break;
            }
        }
        

        System.out.print("--------------------------------------------------------------------------------\n");
        System.out.print("Process\t Burst Time\t Turnaround Time\t Waiting Time\n");
        System.out.print("--------------------------------------------------------------------------------\n");
        
        for (i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];   
            awt += wt[i];            
            atat += tat[i];           
            
            System.out.println("P" + (i + 1) + "\t " + bt[i] + "\t\t " + tat[i] + "\t\t " + wt[i]);
        }
        
        
        awt = awt / n;
        atat = atat / n;
        
        
        System.out.println("\nAverage Waiting Time = " + awt);
        System.out.println("Average Turnaround Time = " + atat);
        
        s.close();  
    }
}

