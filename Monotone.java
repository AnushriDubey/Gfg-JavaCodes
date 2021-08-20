public class Monotone {


    public static int countInvert(String s, int i) {
        System.out.println(s + " " + i);
        if(i==s.length()) return 0;
        if(i!=0) {
            if(s.charAt(i) == s.charAt(i-1)) return countInvert(s,i+1);
            else {
                StringBuilder s1 = new StringBuilder(s);
                if(s.charAt(i) == '0') s1.setCharAt(i,'1');
                else s1.setCharAt(i,'0');
                return Math.min(1+countInvert(s1.toString(),i+1), countInvert(s,i+1));
            }
        }
        else {
            StringBuilder s1 = new StringBuilder(s);
            if(s.charAt(i) == '0') s1.setCharAt(i,'1');
            else s1.setCharAt(i,'0');
            return Math.min(1+countInvert(s1.toString(),i+1), countInvert(s,i+1));
        }
    }
    public static void main(String args[]) {
        String s = "00110";
        System.out.println(countInvert(s,0));
    }
}
