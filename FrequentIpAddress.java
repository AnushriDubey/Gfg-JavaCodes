import java.util.*;

public class FrequentIpAddress {

    static TreeMap<String, Integer> tp;

    public static void main(String args[]) {
        String ss[] = {"123", "333", "556", "123"};
        tp = new TreeMap();
        tp.put(ss[0], 1);
        for(int i=1;i<ss.length;i++) {
            if(tp.containsKey(ss[i])){
                tp.put(ss[i], tp.get(ss[i])+1);
            }
            else tp.put(ss[i], 1);
        }
        System.out.println(tp);
    }
}
