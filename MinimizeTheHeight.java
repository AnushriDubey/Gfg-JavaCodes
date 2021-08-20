import java.util.Arrays;

public class MinimizeTheHeight {
    public static int minHeight(int a[], int n, int k) {
        if(n==1) return 0;
        Arrays.sort(a);
        int ans = a[n-1] - a[0];
        int small = a[0] + k;
        int big = a[n-1] - k;
        if(big < small) {
            int t = small;
            small = big;
            big = t;
        }
        for(int i=1;i<n-1;i++) {
            int eS = a[i] - k;
            int eB = a[i] + k;
            if(eS>= small || eB <= big) continue;
            if(big - eS <= eB - small) small = eS;
            else big = eB;
        }
        return Math.min(ans, big - small);
    }
    public static void main(String args[]) {
        int k = 3, n = 5;
        int a[] = {3, 9, 12, 16, 20};
        System.out.println(minHeight(a, n,k));
    }
}
