package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
   class Node {
       int data;
       Node left = null, right = null;
       public Node(int data) {
           this.data = data;
       }
   }

    public static ArrayList<Integer> inorder(Node n, ArrayList<Integer> al) {
        if(n == null) return al;
        inorder(n.left, al);
        al.add(n.data);
        inorder(n.right, al);
        return al;
    }

    public static ArrayList<Integer> inorderStk(Node n) {
        Stack<Node> stk = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if(n == null) return al;
        Node curr = n;
        while(curr != null || !stk.isEmpty()) {
            while(curr!=null) {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.peek();
            stk.pop();
            al.add(curr.data);
            curr = curr.right;
        }
        return al;
    }


}
