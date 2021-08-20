import java.util.Arrays;

public class KnapSackWithDuplicateItem {

    static int dp[][];
    public static int ksDp(int val[], int wt[], int i, int w) {
        if(i >= wt.length || w == 0) return 0;
        else if(dp[i][w] != -1) return dp[i][w];
        else if(wt[i] <= w) {
            dp[i][w] = Math.max(val[i] + ksDp(val, wt, i, w-wt[i]), ksDp(val, wt, i+1, w));
            return dp[i][w];
        }
        else {
            dp[i][w] = ksDp(val, wt, i+1, w);
            return dp[i][w];
        }
    }

    public static int ksRec(int val[], int wt[], int i, int w) {
        if(i >= wt.length || w == 0) return 0;
        else if(wt[i] <= w) return Math.max(val[i] + ksRec(val, wt, i, w-wt[i]), ksRec(val, wt, i+1, w));
        else return ksRec(val, wt, i+1, w);
    }
    public static void main(String args[]){
        //int n = 2, w = 3, val[] = {1, 1}, wt[] = {2, 1};
        int n = 4, w = 8, val[] = {1, 4, 5, 7}, wt[] = {1, 3, 4, 5};
        dp = new int[n+1][w+1];
        for(int a[]: dp) Arrays.fill(a,-1);
        System.out.println(ksRec(val,wt,0,w));
        System.out.println(ksDp(val,wt,0,w));
    }
}
