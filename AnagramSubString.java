package String;

import java.util.Arrays;
import java.util.HashMap;

public class AnagramSubString {
    public static int cntAnagramSubstring(String s) {
        int n = s.length();
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                String s1 = s.substring(i,j+1);
                char [] a = s1.toCharArray();
                Arrays.sort(a);
                String tmpS = new String(a);
                if(mp.containsKey(tmpS)) {
                    mp.put(tmpS, mp.get(tmpS)+1);
                }
                else mp.put(tmpS,1);
            }
        }
        int cnt = 0;
        for(String key: mp.keySet()) {
            int nn = mp.get(key);
            cnt += (nn * (nn-1))/2;
        }
        return cnt;
     }
    public static void main(String args[]) {
        String s = "kkkk";
        System.out.println(cntAnagramSubstring(s));
    }
}
