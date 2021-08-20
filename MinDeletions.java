import java.util.*;

public class MinDeletions {

    public static int minDelete(String s) {
        TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
        int a[] = new int[26];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<s.length();i++) {
            a[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++) {
            if(a[i] > 0) {
                if(tm.containsKey(a[i])) {
                    tm.put(a[i], tm.get(a[i]) + 1);
                }
                else tm.put(a[i],1);
            }
        }
        int max = tm.firstKey();
        while(max != 0) {
            if(!tm.containsKey(max)) q.add(max);
            max--;
        }
        System.out.println(tm);
        System.out.println(q);
        int cnt = 0;
        for(Map.Entry<Integer, Integer> e: tm.entrySet()) {
            if(e.getValue() > 1) {
                int value = e.getValue();
                while(value > 1) {
                    while (!q.isEmpty() && q.peek() > e.getKey()) q.poll();
                    if(!q.isEmpty()) {
                        int newLen = q.poll();
                        cnt += (e.getKey() - newLen);
                        //tm.put(newLen, 1);
                    }
                    else cnt += e.getKey();
                    value--;
                }
                //tm.put(e.getKey(), 1);
            }
        }
        return cnt;
    }

    public static void main(String args[]) {
        String s = "accdcdadddbaadbc";
        System.out.println(minDelete(s));
    }
}
