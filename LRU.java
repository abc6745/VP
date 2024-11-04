import java.util.Scanner;

public class LRU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Number of pages must be greater than 0.");
            sc.close();
            return;
        }

        int[] pages = new int[n];
        System.out.println("Enter the page reference sequence: ");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter number of frames: ");
        int size = sc.nextInt();
        if (size <= 0) {
            System.out.println("Number of frames must be greater than 0.");
            sc.close();
            return;
        }
        int[] frame = new int[size];    
        int[] lastUsed = new int[size];
        int pageHit = 0;                
        int pageFault = 0;              

        for (int i = 0; i < size; i++) {
            frame[i] = -1;  
            lastUsed[i] = 0; 
        }

        
        for (int i = 0; i < n; i++) {
            int currentPage = pages[i];
            boolean found = false;  
            int oldestIndex = 0;    

            for (int j = 0; j < size; j++) {
                if (frame[j] == currentPage) {
                    found = true;
                    pageHit++;
                    lastUsed[j] = i; 
                    break;
                }
            }

        
            if (!found) {
                pageFault++;

                
                for (int j = 1; j < size; j++) {
                    if (lastUsed[j] < lastUsed[oldestIndex]) {
                        oldestIndex = j;
                    }
                }

                
                frame[oldestIndex] = currentPage;
                lastUsed[oldestIndex] = i; 
            }
        }

        
        System.out.println("Page Faults: " + pageFault);
        System.out.println("Page Hits: " + pageHit);

        
        float hitRatio = ((float) pageHit / n) * 100;
        float faultRatio = ((float) pageFault / n) * 100;
        System.out.println("Hit Ratio: " + hitRatio + "%");
        System.out.println("Fault Ratio: " + faultRatio + "%");

        sc.close();
    }
}
