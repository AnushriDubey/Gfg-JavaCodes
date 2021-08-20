import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinationOfPhoneNum {
    static ArrayList<String> al;
    static Map<Character, String> mp;
    public static void letterComb(String s, int i, StringBuilder sb) {
        if(i==s.length()) al.add(sb.toString());
        else {
            String s2 = mp.get(s.charAt(i));
            for(int j=0;j<s2.length();j++) {
                sb.append(s2.charAt(j));
                letterComb(s,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static void main(String args[]) {
        al = new ArrayList<>();
        mp = new HashMap<>();
        mp.put('2',"abc");mp.put('3',"def");mp.put('4',"ghi");mp.put('5',"jkl");
        mp.put('6',"mno");mp.put('7',"pqrs");mp.put('8',"tuv");mp.put('9',"wxyz");
        letterComb("", 0,new StringBuilder());
        System.out.println(al);
    }
}
