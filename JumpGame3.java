public class JumpGame3 {


    public static boolean jumpGame3(int a[], int i) {
        if(i>=a.length || i<0) return false;
        else if(a[i] == 0) return true;
        else return jumpGame3(a,i+a[i]) || jumpGame3(a, i-a[i]);
    }

    static int dp[];
    public static boolean jumpGame3Dp(int a[], int i) {
        if(i>=a.length || i<0) return false;
        else if(dp[i] ==1) return false;
        else if(a[i] == 0) return true;
        else {
            boolean t1, t2;
            if(i+a[i] < a.length && i+a[i]>= 0 && dp[i] == 1) t1 = false;
            else t1 = jumpGame3Dp(a,i+a[i]);
            if(i-a[i] < a.length && i-a[i]>= 0 && dp[i] == 1) t2 = false;
            else t2 = jumpGame3Dp(a,i-a[i]);
            boolean t = t1 || t2;
            if(!t) dp[i] = 1;
            return t;
        }
    }
    static int dp2[];
    static boolean dp3[];
    public static boolean jumpGame3Dp2(int a[], int i) {
        if(i>=a.length || i<0) return false;
        else if(dp2[i] ==1) return dp3[i];
        else if(a[i] == 0) return true;
        else {
            boolean t1 = false, t2 = false;
            if(i+a[i] < a.length && i+a[i] >= 0 && a[i+a[i]] == 0)  t1 = true;
            if(i-a[i] < a.length && i-a[i] >= 0 && a[i-a[i]] == 0)  t2 = true;
            dp2[i] = 1;
            dp3[i] =  t1 || t2;
            boolean t = jumpGame3Dp2(a,i+a[i]) || jumpGame3Dp2(a,i-a[i]);
            return t;
        }
    }
    
    public static void main(String args[]) {
        int a[] = {4,2,3,0,3,1,2};
        dp = new int[a.length];
        dp2 = new int[a.length];
        dp3 = new boolean[a.length];
        int start = 5;
        System.out.println(jumpGame3Dp2(a,start));
    }
}
