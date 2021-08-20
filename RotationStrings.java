package String;

import java.util.Arrays;

public class RotationStrings {
    public static int dpSS(String a, String b) {
        int n = a.length(), m = b.length();
        int t[][] = new int[n+1][m+1];
        for(int i=0;i<n;i++) t[i][0] = 0;
        for(int i=0;i<m;i++) t[0][i] = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) t[i][j] =t[i-1][j-1] + 1;
                else t[i][j] = 0;
                max = Math.max(max, t[i][j]);
            }
        }
        for(int [] a2: t) System.out.println(Arrays.toString(a2));
        return max;
    }
    public static int memorizeSS(String a, String b, int i, int j, int t[][], int res) {
        if(i == 0 || j == 0) return res;
        if(t[i-1][j-1] != -1) return t[i-1][j-1];
        else if(a.charAt(i-1) == b.charAt(j-1)) {t[i-1][j-1] = memorizeSS(a,b,i-1,j-1, t,res+1);
        //System.out.println(a.charAt(i-1) + " " + b.charAt(j-1) + " " + t[i-1][j-1]  + " " + i + " " + j + " " + res);
        return t[i-1][j-1];
        }
        else {
            t[i-1][j-1] = Math.max(res, Math.max(memorizeSS(a,b,i-1,j,t, 0), memorizeSS(a,b,i,j-1,t, 0)));
            return t[i-1][j-1];
        }
    }
    public static int recursiveSS(String a, String b, int i, int j, int res) {
        if(i == 0 || j == 0) return res;
        else if(a.charAt(i-1) == b.charAt(j-1)) return recursiveSS(a,b,i-1,j-1, res+1);
        else return Math.max(res, Math.max(recursiveSS(a,b,i-1,j, 0), recursiveSS(a,b,i,j-1, 0)));
    }
    public static void main(String args[]) {
        String a = "ABACDABACD";
        String b = "CDABA";
        int t[][] = new int[a.length()][b.length()];
        for(int [] a2: t)Arrays.fill(a2, -1);
        System.out.println(memorizeSS(a,b,a.length(), b.length(), t, 0));
        for(int [] a2: t) System.out.println(Arrays.toString(a2));
        System.out.println(dpSS(b,a));
        //for(int [] a2: t) System.out.println(Arrays.toString(a2));
    }
}
