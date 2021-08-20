import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StockSell {
    static int dp[][];
    static int k;
    public static int infiniteTransaction(int a[], int i, int buy) {
        if(i==a.length) return 0;
        else if(buy!=-1 && a[i]>buy+k) return Math.max((a[i]-buy-k)+infiniteTransaction(a,i, -1), infiniteTransaction(a,i+1,buy));
        else if (buy!=-1) return infiniteTransaction(a,i+1,buy);
        else return Math.max(infiniteTransaction(a,i+1,a[i]), infiniteTransaction(a,i+1,buy));
    }

    public static int infiniteTransaction1(int a[], int i, int buy) {
        if(i==a.length) return 0;
        else if(buy!=-1 && a[i]>buy) return Math.max((a[i]-buy)+infiniteTransaction1(a,i, -1), infiniteTransaction1(a,i+1,buy));
        else if (buy!=-1) return infiniteTransaction1(a,i+1,buy);
        else return Math.max(infiniteTransaction1(a,i+1,a[i]), infiniteTransaction1(a,i+1,buy));
    }

    public static int infiniteTransaction2(int a[], int i, int buy) {
        if(i>=a.length) return 0;
        else if(buy!=-1 && a[i]>buy) return Math.max((a[i]-buy)+infiniteTransaction2(a,i+2, -1), infiniteTransaction2(a,i+1,buy));
        else if (buy!=-1) return infiniteTransaction2(a,i+1,buy);
        else return Math.max(infiniteTransaction2(a,i+1,a[i]), infiniteTransaction2(a,i+1,buy));
    }
    public static int infiniteTransactionDp(int a[], int i, int j) {
        if(i==a.length) return 0;
        else if(j!=0 && dp[i][j] !=-1) return dp[i][j];
        else if(j!=0 && a[i-1]>a[j-1]) {
            dp[i][j] = Math.max((a[i-1]-a[j-1])+infiniteTransactionDp(a,i, 0), infiniteTransactionDp(a,i+1,j));
            return dp[i][j];
        }
        else if (j!=0) {
            dp[i][j] = infiniteTransactionDp(a,i+1,j);
            return dp[i][j];
        }
        else {
            dp[i][j] = Math.max(infiniteTransactionDp(a,i+1,i), infiniteTransactionDp(a,i+1,j));
            return dp[i][j];
        }
    }

    public static int twoTransaction(int a[]) {
        int p[] = new int[a.length];
        int res = 0, min =a[0];
        for(int i=1;i<a.length;i++) {
            res = Math.max(res, a[i]-min);
            p[i] = res;
            min = Math.min(min, a[i]);
        }
        res = 0;
        int max =a[a.length-1];
        int msf = Integer.MIN_VALUE;
        for(int i=a.length-1;i>=0;i--) {
            res = Math.max(res, max-a[i]);
            msf = Math.max(msf, p[i]+res);
            max = Math.max(max, a[i]);
        }
        return msf;
    }

    public static int oneTransaction(int a[]) {
        int res = 0, min =a[0];
        for(int i=1;i<a.length;i++) {
            res = Math.max(res, a[i]-min);
            min = Math.min(min, a[i]);
        }
        return res;
    }

    public static int infiniteTrans(int a[]) {
        int sd=0,bd=0,profit=0;
        for(int i=1;i<a.length;i++) {
            if(a[i]>=a[i-1]) sd++;
            else {
                profit += a[sd] - a[bd];
                sd = bd = i;
            }
        }
        profit += a[sd] - a[bd];
        return profit;
    }

    public static int infiniteTransWithFees(int a[]) {
        int bsp=-1*a[0],ssp=0;
        for(int i=1;i<a.length;i++) {
            int tmpSsp = ssp;
            ssp = Math.max(ssp, a[i] - bsp - k);
            bsp = Math.max(bsp, -1*a[i] + tmpSsp);
        }
        return ssp;
    }

    public static int infiniteTrans2(int a[]) {
        int bsp=-1*a[0],ssp=0;
        for(int i=1;i<a.length;i++) {
            int tmpSsp = ssp;
            ssp = Math.max(ssp, a[i] - bsp);
            bsp = Math.max(bsp, -1*a[i] + tmpSsp);
        }
        return ssp;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        dp = new int[n+1][n+1];
        for(int a1[]: dp) Arrays.fill(a1,-1);
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        //k = sc.nextInt();
        System.out.println(infiniteTransaction(a,0,-1));
        System.out.println(infiniteTransactionDp(a,1,0));
        System.out.println(infiniteTransaction2(a,0,-1));
        System.out.println(infiniteTrans(a));
    }
}
