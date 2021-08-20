import java.util.Arrays;

public class MinimumPathSum {

    static int x[][] = {{-1,0},{0,-1}};
    static int a[][], row, col;
    static int mem[][];
    static int isValid(int i, int j) {
        if(i>=0 && j>= 0 && i<row && j<col) return a[i][j];
        return Integer.MAX_VALUE;
    }
    public static int recMinSum(int a[][], int i, int j) {
        if(i==0 && j==0) return a[i][j];
        if(isValid(i,j) == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else {
            return a[i][j] + Math.min(recMinSum(a,i-1,j), recMinSum(a,i,j-1));
        }
    }


    public static int minSum(int a[][], int i, int j) {
        if(i-1==0 && j-1==0) return a[i-1][j-1];
        if(mem[i][j] != -1) return mem[i][j];
        if(isValid(i-1,j-1) == Integer.MAX_VALUE) {
            mem[i][j] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        else {
            mem[i][j] = a[i-1][j-1] + Math.min(minSum(a,i-1,j), minSum(a,i,j-1));
            return mem[i][j];
        }
    }

    public static void main(String args[]) {
        int b[][] = {{1,3,1},{1,5,1},{4,2,1}};
        int b1[][] = {{1,2,3},{4,5,6}};
        a = b;row = a.length;col = a[0].length;
        mem = new int[row+1][col+1];
        for(int aa[]: mem) Arrays.fill(aa,-1);
        System.out.println(recMinSum(a,row-1,col-1));
        System.out.println(minSum(a,row,col));
    }
}
