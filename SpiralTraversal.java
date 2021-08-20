import java.util.ArrayList;

public class SpiralTraversal {
    static ArrayList<Integer> spirallyTraverse(int mm[][], int r, int c)
    {   ArrayList<Integer> al = new ArrayList<>();
        int k =0 , m = r, l = 0, n =c;
        while(k<m && l<n) {
            for(int i=l;i<n;i++) {al.add((Integer) mm[k][i]);} // right
            k++;
            for(int i=k;i<m;i++) {al.add((Integer) mm[i][n-1]);} // down
            n--;
            if(k < m) {
                for(int i=n-1;i>=l;i--) {al.add((Integer) mm[m-1][i]);} // left
                m--;
            }
            if(l < n) {
                for(int i=m-1;i>=k;i--) {al.add((Integer) mm[i][l]);} // up
                l++;
            }
        }
        return al;
    }
}
