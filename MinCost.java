import java.util.Arrays;

public class MinCost {


    static int dp[][];
    public static int minCostDp(int a[], int w) {
        dp = new int [a.length+1][w+1];
        for(int i=0;i<a.length+1;i++) dp[i][0] = 0;
        for(int i=1;i<w+1;i++) dp[0][i]= Integer.MAX_VALUE;
        for(int i=1;i<=a.length;i++) {
            for(int j=1;j<=w;j++) {
                if(i <= j) {
                    int t = dp[i][j-i];
                    if(a[i-1] == Integer.MAX_VALUE) t = Integer.MAX_VALUE;
                    if(t != Integer.MAX_VALUE && a[i-1] != Integer.MAX_VALUE) t = t + a[i-1];
                    dp[i][j] = Math.min(t, dp[i-1][j]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        //for (int aa[]: dp) System.out.println(Arrays.toString(aa));
        return dp[a.length][w];
    }
    public static int minCost(int a[], int i, int w){
        if(w==0) return 0;
        if(w <= 0 || i >= a.length) return Integer.MAX_VALUE;
        if(i+1 <= w) {
            int t = minCost(a,i, w - (i+1));
            if(t != Integer.MAX_VALUE && a[i] != Integer.MAX_VALUE) t = t + a[i];
            return Math.min(t, minCost(a,i+1,w));
        }
        else if(w==0) return 0;
        else return Integer.MAX_VALUE;
    }

    public static int minCostRec(int a[], int i, int w) {
        if(w !=0 && i == a.length) return Integer.MAX_VALUE;
        else if(w==0 || i == a.length) return 0;
        else if(w >= (i+1) && a[i] != -1) {
            int t = minCostRec(a, i+1, w-i-1);
            if(t != Integer.MAX_VALUE) t += a[i];
            return Math.min(t, minCostRec(a, i+1, w));
        }
        else return minCostRec(a,i+1,w);

    }


    public static int minCostRecDp(int a[], int i, int w) {
        if(w !=0 && i == a.length) return Integer.MAX_VALUE;
        else if(w==0 || i == a.length) return 0;
        else if(dp[i][w] != -1) return dp[i][w];
        else if(w >= (i+1) && a[i] != -1) {
            int t = minCostRecDp(a, i+1, w-i-1);
            if(t != Integer.MAX_VALUE) t += a[i];
            dp[i][w] = Math.min(t, minCostRecDp(a, i+1, w));
            return dp[i][w];
        }
        else {
            dp[i][w] = minCostRecDp(a,i+1,w);
            return dp[i][w];
        }

    }
    public static void main(String args[]) {
        int n = 6, a[] = {16, 19, 6, 3, 12, 10}, w = 15;
        //int n = 10, a[] = {6, 7, 10, 7, -1, 1, 11, 7, -1, 15} ,w = 13;
        //16, 19, 6, 3, 12, 10
        //10, 10, 5, 17, -1, 13, 19, 9, 15
        //8, 17, 1, 9, -1, 9, 3, 20, 10
//        10 13
//        6, 7, 10, 7, -1, 1, 11, 7, -1, 15
        //for(int i=0;i<n;i++) if(a[i] == -1) a[i] = Integer.MAX_VALUE;
        //System.out.println(Arrays.toString(a));
        //System.out.println(minCost(a, 0,w));
        int t = minCostDp(a,w);
        if(t == Integer.MAX_VALUE || t == 0) t = -1;
        //System.out.println(t);
        System.out.println(minCostRec(a,0,w));
        dp = new int [a.length+1][w+1];
        for(int a1[]: dp) Arrays.fill(a1,-1);
        System.out.println(minCostRecDp(a,0,w));
    }
}
