package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringPermutation {
    public static void swap(StringBuilder sb, int i, int j) {
        if(i == j) return;
        char c = sb.charAt(i);
        char d = sb.charAt(j);
        sb.setCharAt(i,d);
        sb.setCharAt(j,c);
    }
    public static void permutation(StringBuilder sb, int l, int r, ArrayList<String> al) {
        if(l >= r) al.add(sb.toString());
        else {
            for(int i=l;i<=r;i++) {
               swap(sb,l,i);
               permutation(sb,l+1,r,al);
               swap(sb,i,l);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String s = sc.next();
            ArrayList<String> al = new ArrayList<>();
            permutation(new StringBuilder(s), 0, s.length()-1, al);
            Collections.sort(al);
            for(String ss: al) System.out.print(ss + " ");
            System.out.println();
        }
    }
}
