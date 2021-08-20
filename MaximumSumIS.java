import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumSumIS {
    static Map<String, Integer> mp;
    static  int dp[];
    public static int maxiSum(int a[], int i, int s, int prev){
        if(i>=a.length) return s;
        else{
            if(a[i]> prev) return Math.max(maxiSum(a,i+1,s+a[i],a[i]), maxiSum(a,i+1,s,prev));
            else return maxiSum(a,i+1,s,prev);
        }
    }

    public static int maxiSumDp(int a[], int i, int s, int prev){
        String si = i+"_"+prev;
        if(i>=a.length) return s;
        else if(mp.containsKey(si)) return mp.get(si);
        else{
            if(a[i]> prev) {
                mp.put(si, Math.max(maxiSumDp(a,i+1,s+a[i],a[i]), maxiSumDp(a,i+1,s,prev)));
                return mp.get(si);
            }
            else {
                mp.put(si, maxiSumDp(a,i+1,s,prev));
                return mp.get(si);
            }
        }
    }

    public static int maxiSumDp2(int a[]){
        dp = new int[a.length];
        dp[0] = a[0];
        for(int i=0;i<a.length;i++) dp[i] = a[i];
        for(int i=1;i<a.length; i++) {
            for(int j=0;j<i;j++) {
                if(a[i]>a[j] && dp[i] < dp[j]+a[i]) dp[i] = dp[j]+a[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++) max = Math.max(max, dp[i]);
        return max;
    }

    public static void main(String args[]) {
        //int n = 5, a[] = {1, 101, 2, 3, 100};
        //int a[]= {27, 39, 22, 35, 3, 38, 48, 4, 19};
        int a[]= {44, 42, 38, 21, 15, 22, 13, 27};
        //int n = 3, a[] = {1,2, 3};
        mp = new HashMap<>();
        System.out.println(maxiSum(a,0,0,-1));
        System.out.println(maxiSumDp(a,0,0,-1));
        System.out.println(maxiSumDp2(a));
    }
}
