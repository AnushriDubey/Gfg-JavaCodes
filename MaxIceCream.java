import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxIceCream {

    static int dp[][];
    static Map<String, Integer> mp;
    public static int itemCnt(int a[], int n, int c) {
        if(n==a.length || c==0) return 0;
        else if(a[n] <= c) return Math.max(1+itemCnt(a,n+1,c-a[n]), itemCnt(a,n+1,c));
        else return 0;
    }

    public static int itemCntRec(int a[], int n, int c) {
        if(n==a.length+1 || c==0) return 0;
        if(dp[n][c] != -1) {
            //System.out.println(n + " " + c);
            return dp[n][c];
        }
        else if(a[n-1] <= c) {
            dp[n][c] = Math.max(1 + itemCntRec(a, n + 1, c - a[n-1]), itemCntRec(a, n + 1, c));
            return dp[n][c];
        }
        else {
            dp[n][c] = 0;
            return 0;
        }
    }

    public static int itemCntMap(int a[], int n, int c) {
        String s = n+"_"+c;
        if(n==a.length || c==0) return 0;
        if(mp.containsKey(s)) {
            return mp.get(s);
        }
        else if(a[n] <= c) {
            mp.put(s, Math.max(1 + itemCntMap(a, n + 1, c - a[n]), itemCntMap(a, n + 1, c)));
            return mp.get(s);
        }
        else {
            mp.put(s,0);
            return 0;
        }
    }


    public static void main(String args[]) {
        int a[] = {1,6,3,1,2,5};
        int coin = 20;
        Arrays.sort(a);
        dp = new int[a.length+1][coin+1];
        for(int aa[]: dp) Arrays.fill(aa,-1);
        System.out.println(itemCnt(a,0,coin));
        System.out.println(itemCntRec(a,1,coin));
        mp = new HashMap<>();
        System.out.println(itemCntMap(a,0,coin));
    }
}
