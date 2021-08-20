package String;

import java.util.Stack;

public class MinSwapBracketBalancing {

    public static int bracketBalance1(String s) {
        int open[] = new int[s.length()];
        int j =0;
        for(int i=0;i<s.length();i++) if(s.charAt(i) == '[') open[j++] = i;
        char ar[] = s.toCharArray();
        int sum = 0, cnt =0, idx = 0;
        for(int i=0;i<s.length();i++) {
            if(ar[i] == '[') {
                cnt++;
                idx += 1;
            }
            else if(ar[i] == ']'){
                cnt--;
            }
            if(cnt < 0) {
                sum += open[idx] - i;
                char t = ar[i];
                ar[i] = ar[open[idx]];
                ar[open[idx]] = t;
                cnt = 1;
                idx += 1;
            }
        }
        return sum;
    }

    public static int bracketBalance2(String s) {
        char ar[] = s.toCharArray();
        int sum = 0, OCnt =0,CCnt = 0, mismatch = 0;
        for(int i=0;i<s.length();i++) {
            if(ar[i] == '[') {
                OCnt++;
                if(mismatch>0) {
                    sum = sum + mismatch;
                    mismatch--;
                }
            }
            else if(ar[i] == ']'){
                CCnt++;
                mismatch = CCnt - OCnt;
            }
        }
        return sum;
    }


    public static void main(String args[]) {
        String s = "]][[";
        System.out.println(bracketBalance2(s));
        //System.out.println(bracketBalance1(s));
    }

}
