
import java.util.Scanner;

public class Fifo {
    public static void fifo(int[] pages, int n, int size) {
        if (size <= 0) {
            System.out.println("Number of frames must be greater than 0.");
            return;
        }

        int[] frame = new int[size];
        int pageHit = 0;
        int pageFault = 0;
        int index = 0;

        
        for (int i = 0; i < size; i++) {
            frame[i] = -1;
        }

        
        for (int i = 0; i < n; i++) {
            boolean found = false;
            
            for (int j = 0; j < size; j++) {
                if (frame[j] == pages[i]) {
                    found = true;
                    pageHit++;
                    break;
                }
            }

            
            if (!found) {
                frame[index] = pages[i];
                index = (index + 1) % size;
                pageFault++;
            }
        }

    
        System.out.println("Page Faults: " + pageFault);
        System.out.println("Page Hits: " + pageHit);
        float hitRatio = ((float) pageHit / n) * 100;
        float faultRatio = ((float) pageFault / n) * 100;
        System.out.println("Hit Ratio: " + hitRatio + "%");
        System.out.println("Fault Ratio: " + faultRatio + "%");
    }

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

        fifo(pages, n, size);
        sc.close();
    }
};
