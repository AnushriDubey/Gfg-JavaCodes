package Tree;

import java.util.Arrays;

public class SelfBalance {
    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node root = null;
    public static Node tree(int a[], int l, int h) {
        if(l<=h) {
            int mid = l + (h-l)/2;
            Node n = new Node(a[mid]);
            if(root == null) root = n;
            n.left =  tree(a,l,mid-1);
            n.right = tree(a,mid+1,h);
            return n;
        }
        return null;
    }
//    public static void preorder(Node root) {
//        if(root == null) return;
//        System.out.print(root.data + " ");
//        preorder(root.left);
//        preorder(root.right);
//    }
static int aa[], y=0;
    public static void preorder(Node root) {
        if(root == null) return;
        aa[y++] = root.data;
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4};
        int n = a.length-1;
        tree(a,0,n);
        aa = new int [n+1];
        preorder(root);
        System.out.println(Arrays.toString(aa));
    }
}
