
import java.util.ArrayList;

public class UniquePrefix {
    static class TrieNode{
        char data;
        int content;
        boolean isEnd;
        TrieNode []child;
        TrieNode(char d) {
            this.data = d;
            this.content = 1;
            this.child = new TrieNode[26];
            this.isEnd = false;
        }

    }
    static class TrieNode2{
        char data;
        int content;
        boolean isEnd;
        TrieNode2 []child;
        TrieNode2(char d) {
            this.data = d;
            this.content = 1;
            this.child = new TrieNode2[2];
            this.isEnd = false;
        }
    }
    static TrieNode2 root2;
    static TrieNode root;
    static ArrayList<String> al = new ArrayList<>();
    static ArrayList<String> al2 = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void insert(String s) {
        int len = s.length();
        TrieNode tmp = root;
        for(int i=0;i<len;i++) {
            int index = s.charAt(i) - 'a';
            if(tmp.child[index] == null) tmp.child[index] = new TrieNode(s.charAt(i));
            else tmp.child[index].content += 1;
            tmp = tmp.child[index];
        }
        tmp.isEnd = true;
    }



    public static void prefixes(TrieNode root, String s){
        for(int i=0;i<26;i++) {
            if(root.child[i] != null && root.child[i].content > 1) {
                prefixes(root.child[i], s+root.child[i].data);
            }
            else if(root.child[i] != null && root.child[i].content == 1){
                al2.add(s+root.child[i].data);
            }
        }

    }

    public static void prefixesModify(TrieNode root, String s){
        for(int i=0;i<26;i++) {
            if(root.child[i] != null && !root.child[i].isEnd) {
                prefixesModify(root.child[i], s+root.child[i].data);
            }
            else if(root.child[i] != null && root.child[i].isEnd){
                sb.append(s+root.child[i].data + " ");
                prefixesModify(root.child[i], s+root.child[i].data);
            }
        }

    }


    public static void searchModify(String s) {
        int len = s.length();
        TrieNode tmp = root;
        for(int i=0;i<len;i++) {
            int index = s.charAt(i) - 'a';
            if(tmp.child[index] == null) return;
            tmp = tmp.child[index];
        }
        if(tmp.isEnd) sb.append(s + " ");
        prefixesModify(tmp, s+ "");
    }

    public static boolean searchModify2(String s) {
        int len = s.length();
        TrieNode2 tmp = root2;
        for(int i=0;i<len;i++) {
            int index = s.charAt(i) - '0';
            if(tmp.child[index] == null) return false;
            tmp = tmp.child[index];
        }
        return true;
    }

    public static void insert2(String s) {
        int len = s.length();
        TrieNode2 tmp = root2;
        for(int i=0;i<len;i++) {
            int index = s.charAt(i) - '0';
            if(tmp.child[index] == null) tmp.child[index] = new TrieNode2(s.charAt(i));
            tmp = tmp.child[index];
        }
        tmp.isEnd = true;
    }

    public static boolean search(TrieNode r1, String s, int i, String s1) {
        if(i < s.length() && r1.child[s.charAt(i)-'a'] != null && r1.child[s.charAt(i)-'a'].isEnd) {
            al.add(s1 + s.charAt(i));
            if(i+1 >= s.length()) return true;
            return search(root, s, i+1, "");
        }
        else if(i < s.length() &&  r1.child[s.charAt(i)-'a'] != null){
            return search(r1.child[s.charAt(i)-'a'], s, i+1, s1 + s.charAt(i));
        }
        else return false;
    }

    public static void main(String args[]) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        String arr1[] = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango"};
        String arr2[] = {"dypijgkmifhf", "dypfkgj", "dyplgnojhlh", "dypmgk", "dypfmjlgmgghg", "dypiiknlo", "dyphhjilnh", "dypnohl", "dypkiigmfhnhk", "dypkfml", "dypnhggllokn", "dypkfi", "dyponmh", "dypjhih", "dypfkjghfoij", "dypjhm", "dypomjmmo", "dyplokffgjkigk", "dypknimnlgffkol", "dypohhlghkh", "dypmhg", "dypokill", "dypkom", "dyplfknkmjh", "dypljjomggmo", "dypnglkligl", "dypgkkokfmhojk"};
        root = new TrieNode('0');
        //for(String s: arr2) insert(s);
        //prefixes(root, "");
        //System.out.println(search(root,"ilikesamsung", 0, ""));
        String s1 = "dypmhg";
//        for(int i=1;i<s1.length()+1;i++) {
//            //al2 = new ArrayList<>();
//            String s2 = s1.substring(0, i);
//            //System.out.println(s2);
//            searchModify(s2);
//            if(sb.length()>1) System.out.println(sb);
//            else System.out.println(0);
//            sb = new StringBuilder();
//        }
        //System.out.println(al);
        //System.out.println(al2);
        int a[][] = {{1, 1, 0, 1},{1, 0, 0, 1},{1, 1, 0, 1}};
        int r =3, c=4;
        root2 = new TrieNode2('a');
        for(int i=0;i<r;i++){
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int j=0;j<c;j++) {
                sb1.append(a[i][j]);
                sb2.append(a[i][j] + " ");
            }
            if(!searchModify2(sb1.toString())) {
                insert2(sb1.toString());
                sb.append(sb2 + " $");
            }
        }
        System.out.println(sb);
    }
}
