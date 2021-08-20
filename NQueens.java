import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Check<T> {

}
public class NQueens {

    static boolean col[];
    static boolean revD[];
    static boolean fwdD[];
    public static void nQn(int a[][], int r, String asf) {
        if(r==a.length) {
            System.out.println(asf);
            return;
        }
        for(int i=0;i<a.length;i++) {
            if(!col[i] && !revD[r+i] && !fwdD[r-i+a.length-1]) {
                col[i] = true;
                revD[r+i] = true;
                fwdD[r-i+a.length-1] = true;
                a[r][i]=1;
                nQn(a,r+1, asf +" - "+ r + " " + i);
                a[r][i] = 0;
                col[i] = false;
                revD[r+i] = false;
                ArrayList<String> al = new ArrayList<>();
                List<? extends Number> al2 = new ArrayList<Integer>();
                //al2.add(new Integer());
                fwdD[r-i+a.length-1] = false;
            }
        }
    }
    public static void main(String args[]) {
        int n = 5;
        col = new boolean[n];
        revD = new boolean[2*n-1];
        fwdD = new boolean[2*n-1];
        int a[][] = new int[n][n];
        nQn(a,0, "");
        //for(int a1[]: a) System.out.println(Arrays.toString(a1));
    }
}
