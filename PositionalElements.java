import sun.tools.jstat.Scale;

import java.util.HashSet;
import java.util.Scanner;

public class PositionalElements {

    public static int positional(int a[][], int m, int n) {
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<m;i++) {
            String s = "", s1 = "";
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for(int j =0;j<n;j++) {
                if(a[i][j] > max) {
                    max = a[i][j];
                    s = i + "_" + j;
                }
                if(a[i][j] < min) {
                    min = a[i][j];
                    s1 = i + "_" + j;
                }
            }
            if(!s.equals("")) hs.add(s);
            if(!s1.equals("")) hs.add(s1);
        }

        for(int i=0;i<n;i++) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            String s = "", s1 = "";
            for(int j =0;j<m;j++) {
                if(a[j][i] > max) {
                    //System.out.println("max " + i + " " + j + " val "+ a[j][i]);
                    max = a[j][i];
                    s = j + "_" + i;
                }
                if(a[j][i] < min) {
                    //System.out.println("min " + i + " " + j + " val "+ a[j][i]);
                    min = a[j][i];
                    s1 = j + "_" +i;
                }
            }
            if(!s.equals("")) hs.add(s);
            if(!s1.equals("")) hs.add(s1);
        }
        //System.out.println(hs);
        return hs.size();
    }
    public static void main(String args[]) {
        //Scanner sc = new Scanner(System.out.println();)
        int a[][]= { { 1, 3, 4 }, { 5, 2, 9 }, { 8, 7, 6 } };
        System.out.println(positional(a,3,3));
    }
}
