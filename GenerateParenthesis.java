import java.util.*;

public class GenerateParenthesis {

    static Map<Integer, ArrayList<String>> mp;

    public static void strGen(int j, int i, ArrayList<String> al) {
        for(int k=0;k<mp.get(i-j-1).size();k++) {
            String str = "(" + mp.get(i-j-1).get(k) + ")";
            for(int m=0;m<mp.get(j).size();m++) {
                String s2 =  str + mp.get(j).get(m);
                al.add(s2);
            }
        }
    }
    public static void generate(int n) {
        mp.put(0, new ArrayList<>(Arrays.asList("")));
        mp.put(1, new ArrayList<>(
            Arrays.asList("()")));

        for(int i=2;i<=n;i++) {
            ArrayList<String> al = new ArrayList<>();
            for(int j=0;j<i;j++) {
                strGen(j,i, al);
            }
            mp.put(i, al);
        }
    }
    public static void main(String args[]) {
        mp = new HashMap<>();
        generate(3);
        System.out.println(mp);
        System.out.println(mp.get(3));
    }
}
