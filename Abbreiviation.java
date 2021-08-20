import java.util.HashSet;

public class Abbreiviation {
    static HashSet<String> hs = new HashSet<>();
    static String ss;
    public static void abbRec(StringBuilder s, int i){
        if(i==0) {
            hs.add(s.toString());
            return;
        }
        else {
            int res = 1;
            StringBuilder s1 = new StringBuilder(s);
            if(i<s1.length() && !(s1.charAt(i)>=97 && s1.charAt(i)<=122)) res += (s1.charAt(i) - '0');
            s1.setCharAt(i-1, (char) (res+'0'));
            if(i<s1.length() && !(s1.charAt(i)>=97 && s1.charAt(i)<=122)) s1.deleteCharAt(i);
            abbRec(s1, i-1);
            abbRec(s, i-1);
        }
    }


    public static void abbRec2(StringBuilder s, int i) {
        if(i==ss.length()) {
            hs.add(s.toString());
            return;
        }
        else {
            int res = 1;
            StringBuilder s1 = new StringBuilder(s);
            if(s1.length()>0 && !(s1.charAt(s1.length()-1)>=97 && s1.charAt(s1.length()-1)<=122)) {
                res += (s1.charAt(s1.length()-1) - '0');
                s1.setCharAt(s1.length()-1, (char) (res+'0'));
            }
            else s1.append(res);
            abbRec2(s1, i+1);
            abbRec2(s.append(ss.charAt(i)), i+1);

        }
    }

    public static void abbRec3(StringBuilder s, int i, int k) {
        if(i==ss.length()){
            if(k!=0) s.append(k);
            hs.add(s.toString());
            return;
        }
        abbRec3(new StringBuilder(s), i+1, k+1);
        StringBuilder s1 = new StringBuilder(s);
        if(k!=0) s1.append(k);
        s1.append(ss.charAt(i));
        abbRec3(s1, i+1, 0);
    }

    public static void main(String args[]) {
        String s = "pep";
        ss = s;
        int s1 = "123".charAt(2) - '0' + 1;
        abbRec(new StringBuilder(s),s.length());
        System.out.println(hs);
        System.out.println(hs.size());
        System.out.println((char) (s1+'0'));
        hs = new HashSet<>();
        abbRec2(new StringBuilder(), 0);
        System.out.println(hs);
        hs = new HashSet<>();
        abbRec3(new StringBuilder(), 0,0);
        System.out.println(hs);

    }
}
