public class StringSearch {

public static void main(String args[]) {
    String s = "this is anu shri dubey";
    String s1 = "this", s2 = "is";
    int st1 = s.indexOf(s1), st2 = s.indexOf(s2);
    int end1 = st1+s1.length();
    System.out.println(Math.abs(st2 - end1) + " " + st1 + " " + st2);
}

}
