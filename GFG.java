import java.util.*;
import java.lang.*;
import java.io.*;


class Pair{
    int f,l;
    Pair(int f, int l) {
        this.f = f;
        this.l = l;
    }
}
class GFG {
    public static void main (String[] args) {
        HashMap<Integer, Pair> hm = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int min = Integer.MAX_VALUE;
        while(t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int maxIndex = -1, mSize = Integer.MAX_VALUE;
            boolean flag = false;
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
                if(i==0) b[i] = a[i];
                else b[i] = b[i-1] + a[i];
                if(b[i] > x && !flag) { maxIndex = i;
                    flag = true;
                }
            }
            //System.out.println(Arrays.toString(b));
            //System.out.println(maxIndex);
            for(int i= maxIndex;i<n;i++) {
                mSize = Math.min(mSize, i+1);
                for(int j = i-1;j>=0;j--) {
                    int diff = b[i] - b[j];
                    if(diff > x) {
                        mSize = Math.min(mSize, i-j);
                        //System.out.println(i + " " + j);
                        break;
                    }
                }


            }
            System.out.println(mSize);

        }
    }
}
