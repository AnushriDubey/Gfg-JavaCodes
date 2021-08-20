import java.util.Arrays;

public class MaximumDifference {


    public static int maxDiff(String a) {
        int ss[][] = new int[3][a.length()];
        if(a.charAt(0)-'0' == 0) {
            ss[1][0] += 1;
        }
        else{
            ss[0][0] += 1;
        }
        ss[2][0] = ss[1][0] - ss[0][0];
        for(int i=1;i<a.length();i++) {
            if(a.charAt(i)-'0' == 0) {
                ss[1][i] =ss[1][i-1] + 1;
            }
            else{
                ss[0][i] =ss[0][i-1] + 1;
            }
            ss[2][i] = ss[1][i] - ss[0][i];
        }
        int max = 0, min = a.length()+1;
        for(int i=0;i<a.length();i++) {
            max = Math.max(max, ss[2][i]);
            min = Math.min(min, ss[2][i]);
        }
        System.out.println(max + " " + min);
        if(max == 0) return -1;
        for(int aa[]: ss) System.out.println(Arrays.toString(aa));
        return max-min;
    }

    public static void main(String args[]){
        String s = "011111010011";
        System.out.println(maxDiff(s));

    }
}
