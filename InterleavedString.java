public class InterleavedString {

    static String s1, s2, s3;
    public static boolean isInterleaved(String a, String b, String c) {
        if(a.length() + b.length() != c.length()) return false;
        int i, j=0, k=0;
        for(i=0;i<c.length();i++) {
            if(j < a.length() && c.charAt(i) == a.charAt(j)) j++;
            else if(k<b.length() && c.charAt(i) == b.charAt(k)) k++;
            else {
                System.out.println(c.charAt(i) + " " + i + " " + j + " " + k);
                return false;
            }
        }

        return i==c.length() && j == a.length() && k == b.length();
    }


    public static boolean isInterleavedRec(int i, int j, int k) {
        if(i >= s3.length()) return i==s3.length() && j == s1.length() && k == s2.length();
        else if(j< s1.length() && s3.charAt(i) == s1.charAt(j) && k < s2.length() && s3.charAt(i) == s2.charAt(k)) {
            return isInterleavedRec(i+1, j+1, k) || isInterleavedRec(i+1, j, k+1);
        }
        else if(j< s1.length() && s3.charAt(i) == s1.charAt(j)) return isInterleavedRec(i+1, j+1, k);
        else if (k < s2.length() && s3.charAt(i) == s2.charAt(k)) return isInterleavedRec(i+1,j,k+1);
        else return false;
    }

    public static void main(String args[]) {
        //String a = "aab", b = "axy", c = "aaxaby";
        String a = "YX", b = "X", c = "XXY";
        s1 = a;
        s2 = b;s3=c;
        //System.out.println(isInterleaved(a,b,c));
        System.out.println(isInterleavedRec(0,0,0));
    }
}
