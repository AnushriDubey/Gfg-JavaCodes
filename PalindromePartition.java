import java.util.Arrays;

public class PalindromePartition {

    public static boolean isPalindrome(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


    public static int ppRec(String s, int i, int j) {
        if(isPalindrome(s,i,j-1) || i>=j) return 0;
        else{
            int min = 505;
            for(int k=i+1;k<j;k++) {
                //System.out.println(k);
                int res = 1 + ppRec(s, i, k) + ppRec(s, k, j);
                min = Math.min(res, min);
            }
            return min;
        }
    }

    static int dp[][];
    public static int ppRecDp(String s, int i, int j) {
        if(isPalindrome(s,i,j-1) || i>=j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        else{
            int min = 505;
            for(int k=i+1;k<j;k++) {
                //System.out.println(k);
                int res = 1 + ppRecDp(s, i, k) + ppRecDp(s, k, j);
                min = Math.min(res, min);
            }
            dp[i][j] = min;
            return min;
        }
    }

    public static void main(String args[]) {
        String s = "ababbbabbababa";
        dp = new int[s.length()+1][s.length()+1];
        for(int aa[]: dp) Arrays.fill(aa, -1);
        System.out.println(ppRec(s, 0, s.length()));
        System.out.println(ppRecDp(s,0,s.length()));
    }
}
