import java.util.Arrays;
import java.util.Scanner;

public class ArrangeAmplifier {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int max = Integer.MIN_VALUE, countOne = 0;
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
                max = Math.max(max, a[i]);
                if(a[i] == 1) countOne += 1;
            }
            Arrays.sort(a);
            if(max <=3) {
                for(int i=0;i<n;i++) {
                    System.out.print(a[i] + " ");
                }
            }
            else {
                for(int i=0;i<countOne;i++) System.out.print(1 + " ");
                for(int i=n-1;i>=countOne;i--) {
                    if(a[i] != 1) System.out.print(a[i] + " ");
                    else break;
                }
            }
            System.out.println();
        }
    }
}
