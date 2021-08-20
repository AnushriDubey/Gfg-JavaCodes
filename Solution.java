package String;

import java.util.Arrays;

public class Solution {
    public static int LPSS(String s1, String s2, int m, int n, int t[][], int res) {
        if(m == 0 || n== 0) return res;
        else if(t[m-1][n-1] != -1) return t[m-1][n-1];
        else if(s1.charAt(m-1) == s2.charAt(n-1)) {
            t[m-1][n-1] = LPSS(s1,s2, m-1, n-1, t, res+1);
            return t[m-1][n-1];
        }
        else {
            t[m-1][n-1] = Math.max(res, Math.max(LPSS(s1,s2, m, n-1, t, 0), LPSS(s1,s2, m-1, n, t, 0)));
            return t[m-1][n-1];
        }
    }
    public static String LPSSS(String s1, String s2, int t[][], int m, int n) {
        int f = -1, l = -1, max = Integer.MIN_VALUE;
        for(int i=1;i<m+1;i++) {
            for(int j=0;j<n+1;j++) {
                if(s1.charAt(m-1) == s2.charAt(n-1)) {
                    t[m][n] = 1+t[m-1][n-1];
                    if(t[m][n] > max) {
                        max = t[m][n];
                        f = m;l =n;
                    }
                }
                else t[m][n] = 0;
            }
        }
        StringBuilder s = new StringBuilder();
        while(f !=0 && l!=0 && s1.charAt(f-1) == s2.charAt(l-1)) {
            s.append(s1.charAt(f-1));
            f--;l--;
        }
        return s.reverse().toString();
    }

    public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        int t[][] = new int[s.length()][s.length()];
        for(int [] a2 : t)Arrays.fill(a2, -1);
        System.out.println(LPSS(s,s1,s.length(),s1.length(),t,0));
        for(int [] a2 : t) System.out.println(Arrays.toString(a2));
        return  s;
    }

    public static void main(String args[]) {
        longestPalindrome("aaaabbaa");
    }
}
