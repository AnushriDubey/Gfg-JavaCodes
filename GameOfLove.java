import java.util.Arrays;

public class GameOfLove {

    static int b[][],  row,  col;
    public static int liveCnt(int i, int j) {
        int a[][] = {{0,-1},{0,1},{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1}};
        int cnt = 0;
        for(int k=0;k<a.length;k++) {
            int r = i+a[k][0], c = j+a[k][1];
            if(r >= 0 && r < row && c >= 0 && c < col && b[r][c] == 1) cnt += 1;
        }
        return cnt;
    }
    public static void nextGen() {
        int res [][] = new int[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                int live = liveCnt(i,j);
                System.out.println(i + " " + j + " " + live);
                if(b[i][j]==0 && live == 3) res[i][j] = 1;
                else if(b[i][j] == 1 && (live < 2 || live > 3)) res[i][j] = 0;
                else res[i][j] = b[i][j];
            }
        }
        //for(int aa[]: res) System.out.println(Arrays.toString(aa));
    }

    public static void main(String args[]) {
        int a[][] = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        b = new int[a.length][a[0].length];
        b = a;
        row = b.length;
        col = b[0].length;
        nextGen();

    }
}
