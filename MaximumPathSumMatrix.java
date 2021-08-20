import sun.lwawt.macosx.CSystemTray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximumPathSumMatrix {

    public static int r, c;
    public static int isSafe(int i, int j, int a[][]) {
        if(i>=0 && i<r && j>=0 && j<c) return a[i][j];
        return -1;
    }
    public static int maxSumPath(int a[][], int m , int n) {
        r=a.length; c=a[0].length;
        int res = Integer.MIN_VALUE;
        if(m==1) {
            for(int i=0;i<n;i++) {
                res = Math.max(res, a[0][i]);
            }
            return res;
        }
        for(int i=m-2;i>=0;i--) {
            for(int j=0;j<n;j++) {
                a[i][j] += Math.max( isSafe(i+1,j,a), Math.max(isSafe(i+1,j-1,a),isSafe(i+1,j+1,a)));
            }
        }
        for(int i=0;i<n;i++) {
            res = Math.max(res, a[0][i]);
        }
        return res;
    }

    public static void main(String args[]) {
        int a[][] = { { 10, 10, 2, 0, 20, 4 },
                { 1, 0, 0, 30, 2, 5 },
                { 0, 10, 4, 0, 2, 0 },
                { 1, 0, 2, 20, 0, 4 }
        };
        r=a.length; c=a[0].length;
        System.out.println(maxSumPath(a,r,c));
    }
}
