import java.util.Scanner;

public class Kadanes {
    public static int sumSubArray(int a[], int n) {
        int sum= a[0], best = a[0];
        for(int i=1;i<n;i++) {
            sum = Math.max(sum+a[i], a[i]);
            best = Math.max(sum, best);
        }
        return best;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        if(n==1) System.out.println(a[0]);
        else System.out.println(sumSubArray(a,n));
    }
}
