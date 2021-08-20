package String;

import java.util.Arrays;
import java.util.Scanner;

public class LongestRecurringSubSequence {
    public static int LRS(String s, int i, int j, int t[][]) {
        if(i == 0 || j == 0) return 0;
        if(t[i-1][j-1] != -1) return t[i-1][j-1];
        else if(i-1 != j-1 && s.charAt(i-1) == s.charAt(j-1)) {
            //System.out.print(s.charAt(i-1));
            t[i-1][j-1] = 1+LRS(s,i-1,j-1,t);
            return t[i-1][j-1];
        }
        else {
            t[i-1][j-1] = Math.max(LRS(s,i-1,j,t),LRS(s,i,j-1,t));
            return t[i-1][j-1];
        }
    }
    public static int LRSIncre1(String s, int i, int j, int t[][]) {
        //System.out.println(s.charAt(i-1) + " " + i + " " + j);
        if(i == 0 || j == 0) return 0;
        if(t[i][j] != -1) return t[i][j];
        else if(i != j && s.charAt(i-1) == s.charAt(j-1)) {
            //System.out.println("2--> " + s.charAt(i-1) + " " + i + " " + j);
            t[i][j] = 1+LRSIncre1(s,i-1,j-1,t);
            return t[i][j];
        }
        else {
            t[i][j] = Math.max(LRSIncre1(s,i-1,j,t),LRSIncre1(s,i,j-1,t));
            return t[i][j];
        }
    }
    public static StringBuilder getString(int dp[][], String s) {
        int i = s.length(), j = s.length();
        StringBuilder sb = new StringBuilder();
        while (i>0 && j>0) {
            if(i!= j && s.charAt(i-1) == s.charAt(j-1)) {
                sb.append(s.charAt(i-1));
                //System.out.println(i + " " + j +" "+ s.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i][j-1] > dp[i-1][j]) j--;
            else i--;
        }
        return sb;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int dp[][] = new int[n+1][n+1];
            for(int a[]: dp) Arrays.fill(a, -1);
            for(int i=0;i<n+1;i++) {
                dp[i][0] = 0;
                dp[0][i] = 0;
            }
            int dp2[][] = new int[n][n];
            for(int a[]: dp2) Arrays.fill(a, -1);
            //for(int a[]: dp) System.out.println(Arrays.toString(a));
            System.out.println(LRSIncre1(s,n,n,dp));
            System.out.println(getString(dp, s).reverse());
        }

        //System.out.println();
    }
}
