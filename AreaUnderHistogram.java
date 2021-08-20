import java.util.Arrays;
import java.util.Stack;

public class AreaUnderHistogram {

    public static int area(int a[]) {
        int mins[][] = new int[2][a.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for(int i=1;i<a.length;i++) {
            while(!stk.isEmpty() && a[stk.peek()] > a[i]) {
                mins[0][stk.peek()] = i;
                stk.pop();
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            mins[0][stk.peek()] = a.length;
            stk.pop();
        }
        stk.push(a.length-1);
        for(int i=a.length-2;i>=0;i--) {
            while(!stk.isEmpty() &&  a[stk.peek()] > a[i]) {
                mins[1][stk.peek()] = i;
                stk.pop();
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            mins[1][stk.peek()] = -1;
            stk.pop();
        }
        for(int aa[]: mins) System.out.println(Arrays.toString(aa));
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++) {
            max = Math.max(max,a[i] *(mins[0][i] - mins[1][i]-1));
        }
        return max;
    }

    public static int twoDArea(int a[][]) {
        int max = area(a[0]);
        for(int i=1;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if(a[i][j]!=0) {
                    a[i][j] = a[i-1][j]+a[i][j];
                }
            }
            max = Math.max(max, area(a[i]));
        }
        return max;
    }

    public static void main(String args[]) {
        int a[] = {6, 2, 5, 4, 5, 1, 6};
        int M[][] = {{0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}};
        //System.out.println(twoDArea(M));
        System.out.println(area(a));
    }
}
