public class LongestAlternatingSS {


    public static int longestAltSS(int a[], int i, boolean flag, int prev) {
        if(i >= a.length) return 0;
        else if(!flag && prev < a[i]) return Math.max(1 + longestAltSS(a, i+1, true, a[i]), longestAltSS(a, i+1, false, prev));
        else if(flag && prev > a[i]) return Math.max(1 + longestAltSS(a, i+1, false, a[i]), longestAltSS(a, i+1, true, prev));
        else return longestAltSS(a, i+1, flag, prev);
    }

    static int dp[][];
    public static int longAltSS2(int a[]) {
        dp = new int[a.length][2];
        int res = 0;
        for(int i=0;i<a.length;i++) dp[i][0] = dp[i][1] = 1;
        for(int i=1;i<a.length;i++) {
            for(int j=0;j<i;j++) {
                if(a[i] > a[j]) dp[i][0] = Math.max(dp[i][0], dp[j][1]+1);
                else if(a[j] > a[i]) dp[i][1] = Math.max(dp[i][1], dp[j][0] +1);
                res = Math.max(dp[i][0], dp[i][1]);
            }
        }
        return res;
    }

    public static int longAltDp(int a[]) {
        int inc = 1, dec = 1;
        for(int i=1;i<a.length;i++) {
            if(a[i] > a[i-1]) inc = dec+1;
            else if(a[i]<a[i-1]) dec = inc+1;
        }
        return Math.max(inc, dec);
    }

    public static void main(String args[]) {
        int a[] = {1,17,5,10,13,15,10,5,16,8};
        //int a[] = {5, 16, 11, 9, 15, 12, 6, 9, 6, 10};
        System.out.println(Math.max(longestAltSS(a,0,false, Integer.MIN_VALUE), longestAltSS(a,0,true, Integer.MAX_VALUE)));
        System.out.println(longAltSS2(a));
        System.out.println(longAltDp(a));

    }
}
