package String;
import java.util.*;

public class PrintAllSubsequences {
    public static void printSubSequence(String s, int i, StringBuilder sb) {
        if(i == s.length()) System.out.print(sb + " ");
        else {
            //System.out.println(i + " " + sb);
            printSubSequence(s,i+1, new StringBuilder(sb).append(s.charAt(i)));
            //System.out.println("2 --> " + i + " " + sb);
            printSubSequence(s,i+1,new StringBuilder(sb));


        }
    }

    public static void printAllSubSequence(String s, int i, StringBuilder sb) {
        if(i == s.length()) System.out.print(sb + " ");
        else {
            sb.append(s.charAt(i));
            printAllSubSequence(s,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
            printAllSubSequence(s,i+1,sb);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            //int n = sc.nextInt();
            String s = sc.next();
            //printSubSequence(s,0,new StringBuilder());
            printAllSubSequence(s,0,new StringBuilder());
            System.out.println();
        }
    }
}
