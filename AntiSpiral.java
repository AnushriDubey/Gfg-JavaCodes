import java.util.ArrayList;
import java.util.Stack;

public class AntiSpiral {
    static Stack<Integer> spirallyTraverse(int mm[][], int r, int c)
    {   Stack<Integer> al = new Stack<>();
        int k =0 , m = r, l = 0, n =c;
        while(k<m && l<n) {
            for(int i=l;i<n;i++) {al.push(mm[k][i]);} // right
            k++;
            for(int i=k;i<m;i++) {al.push(mm[i][n-1]);} // down
            n--;
            if(k < m) {
                for(int i=n-1;i>=l;i--) {al.push(mm[m-1][i]);} // left
                m--;
            }
            if(l < n) {
                for(int i=m-1;i>=k;i--) {al.push(mm[i][l]);} // up
                l++;
            }
        }
        return al;
    }
}
