
import java.util.ArrayList;

public class BoundaryTraversal {

    class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static ArrayList<Integer> al;
    public static void printLeft(Node root) {
        if(root == null) return ;
        al.add(root.data);
        if(root.left != null) {
            printLeft(root.left);
        }
        else if(root.right != null) {
            printLeft(root.right);
        }
    }

    public static void printRight(Node root) {
        if(root == null) return ;
        al.add(root.data);
        if(root.right != null) {
            printRight(root.right);
        }
        else if(root.left != null) {
            printRight(root.left);
        }
    }

    public static void printLeaves(Node root) {
        if (root == null) return;
        if(root.left == null && root.right == null) al.add(root.data);
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public static void main(String args[]) {
        al = new ArrayList<>();
        //if ()
        //al.add()
    }
}

