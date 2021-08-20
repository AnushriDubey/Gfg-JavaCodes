package Tree;

import java.util.ArrayList;

public class LeftViewTree {

    class Node {
        int data;
        BoundaryTraversal.Node left, right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static ArrayList<Integer> al;
    public static void printLeft(BoundaryTraversal.Node root) {
        if(root == null) return ;
        al.add(root.data);
        if(root.left != null) {
            printLeft(root.left);
        }
        else if(root.right != null) {
            printLeft(root.right);
        }
    }

    public static void main(String args[]) {

    }
}
