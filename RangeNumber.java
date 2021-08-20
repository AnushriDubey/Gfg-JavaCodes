import sun.tools.jstat.Scale;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class RangeNumber {
    public static boolean digitChk(int x, int res) {
        HashSet<Integer> hs = new HashSet<>();
        while(x > 0) {
            hs.add(x%10);
            x = x/10;
        }
        //System.out.println(hs);
        while (res > 0){
            if(hs.contains(res%10)) return true;
            res = res/10;
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int q = sc.nextInt();
            int cnt = 0;
            for(int i=x;i<y+1;i++) {
                int res = i*q;
                //System.out.println( i + " " + res + " " + digitChk(i,res));
                if (!digitChk(i,res)) cnt += 1;
            }
            System.out.println(cnt);
        }
    }
}
