package String;

public class KMP {
    static int lps[];
    public static void prefix(String a) {
        lps = new int[a.length()];

        int i=1, len =0;
        while(i<a.length()) {
            if(a.charAt(len)==a.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len==0) {
                    lps[i] = 0;
                    i++;
                }
                else {
                    len = lps[len-1];
                }
            }
        }
    }

    public static boolean stringMatch(String t, String a) {
        int j=0, i=0, e=-1;
        while(i<t.length()) {
            if(t.charAt(i) == a.charAt(j)) {
                i++;
                j++;
            }
            if(j==a.length()) {
                e=i;
                return true;
            }
            else if(i<t.length() && t.charAt(i) != a.charAt(j)) {
                if(j!=0) j = lps[j-1];
                else i++;
            }
        }
        return false;
    }
}
