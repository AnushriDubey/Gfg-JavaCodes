import com.sun.deploy.panel.AbstractRadioPropertyGroup;

import java.util.ArrayList;

public class ZigZag {
    public static ArrayList<Integer> zigZagTraversal(int a[][], int r, int c) {
        int m = 0;
        ArrayList<Integer> al = new ArrayList<>();
        while(m < r) {
            for(int i=0;i<c;i++) {al.add(a[m][i]);}
            m++;
            if(m<r) for(int i=c-1;i>=0;i--) {al.add(a[m][i]);}
            m++;
        }
        return al;
    }
    public static void main(String args[]) {
        int r = 3, c = 5;

        int mat[][] = { {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}};

        System.out.println(zigZagTraversal(mat, r , c));
    }
}
