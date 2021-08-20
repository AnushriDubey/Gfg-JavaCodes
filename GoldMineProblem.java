import java.util.Arrays;

public class GoldMineProblem {

    static int x[] = {-1,0,1};
    static int y[] = {-1,-1,-1};
    static int r,c;
    public static boolean isValid(int k, int i, int j) {
        return i + x[k] >= 0 && i + x[k] < r && j + y[k] >= 0 && j + y[k] < c;
    }
    public static int goldMine(int a[][], int r, int c) {
        for(int j=1;j<c;j++) {
            for(int i=0;i<r;i++) {
                int max = Integer.MIN_VALUE;
                for(int k=0;k<3;k++) {
                    if(isValid(k, i, j)) {
                        max = Math.max(max, a[i+x[k]][j+y[k]]);
                    }
                }
                a[i][j] = a[i][j] + max;
            }
        }
        //for(int aa[]: a) System.out.println(Arrays.toString(aa));
        int max1 = Integer.MIN_VALUE;
        for(int i=0;i<r;i++) max1 = Math.max(max1, a[i][c-1]);
        return max1;
    }
    public static void main(String args[]) {
        int a[][] = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};;
        int n = 4, m = 4;
        r = n; c = m;
        System.out.println(goldMine(a,n,m));
    }
}
