package String;

import com.sun.org.apache.xml.internal.resolver.readers.SAXCatalogParser;

import java.util.Scanner;

public class LongestPalindrome {
        public static int expandAroundCentre(String s, int l,int r) {
                if(s.length() == 0 || l>r) return 0;
                while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                        l--;
                        r++;
                }
                return r - l -1;
        }

        public static String LPSS(String s) {
                if(s.length() == 0) return "";
                int len = 0, left = -1, right = -1;
                for(int i=0;i<s.length();i++) {
                        int len1 = expandAroundCentre(s,i,i);
                        int len2 = expandAroundCentre(s,i, i+1);
                        if(Math.max(len1,len2) > len) {
                                len = Math.max(len1, len2);
                                left = i - ((len-1)/2);
                                right = i + len/2;
                        }
                }
                return s.substring(left, right+1);
        }
        public static void main(String args[]) {
                Scanner sc = new Scanner(System.in);
                int t = sc.nextInt();
                while(t-- > 0) {
                        String s = sc.next();
                        System.out.println(LPSS(s));
                }
        }
}
